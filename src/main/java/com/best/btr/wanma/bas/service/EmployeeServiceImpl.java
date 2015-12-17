package com.best.btr.wanma.bas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.EmployeeDao;
import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.best.btr.wanma.system.entity.Site;
import com.best.btr.wanma.system.service.SystemService;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import com.jinhe.tss.um.entity.Group;
import com.jinhe.tss.um.entity.GroupUser;
import com.jinhe.tss.um.entity.User;
import com.jinhe.tss.util.InfoEncoder;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired private EmployeeDao dao;
    @Autowired private SystemService systemService;

    public Employee getEntityById(Long id) {
        return dao.getEntity(id);
    }
    
    public List<?> getEmployeesBySite(Long siteId) {
    	String hql = " from Employee o where o.ownerSite.id = ? ";
        return dao.getEntities(hql, siteId);
    }
  
    public Employee create(Employee entity) {
    	// 检查账号是否已经存在
    	List<?> list = dao.getEntities("from Employee o where o.code = ?", entity.getCode());
    	if(list.size() > 0) {
    		throw new BusinessException("相同手机号的员工记录已经存在。");
    	}
    	
    	entity.setRegisterDate(new Date());
    	entity = dao.create(entity);
    	
    	// TODO 调用邮件接口，开通电子邮件 135xxxxxxxx@btrbi.com
    	try {
    		// 注册成功后设置Eamil到员工信息里
//    		entity.setEmail(entity.getCode() + "@btr.163.com");
    	} catch(Exception e) {
    		// 调用出错不影响后面的注册步骤
    	}
    	
    	Site site = entity.getOwnerSite();
    	Group fbGroup = systemService.getGroupBySite(site); // 找到当前登录站点对应的“分拨”组（um_Group里）
    	
    	// 同时注册一个登陆账号User
    	User user = new User();
    	user.setLoginName(entity.getCode());
    	user.setUserName(entity.getName() + "-" + site.getName());
    	user.setAddress( site.getParentName() + "，" + (fbGroup != null ? fbGroup.getName() : "") );
    	
    	user.setEmail(entity.getEmail());
    	user.setPassword( InfoEncoder.string2MD5(entity.getPassword()) );
    	user.setTelephone(entity.getPhone() == null ? entity.getCode() : entity.getPhone());
    	user.setFromUserId(entity.getId().toString());

    	Group group = (Group) systemService.getEntity(Group.class, 267L); // 统一放到 “万马网点” 这个组下
    	
    	dao.createObject(user);
    	dao.createObject(new GroupUser(user.getId(), group.getId()));
    	
		return entity;
    }

    public Employee update(Employee entity) {
    	String hql = " from User o where o.fromUserId=? ";
    	List<?> list = dao.getEntities( hql, entity.getId().toString() );
    	if( !list.isEmpty() ) {
    		User user = (User) list.get(0);
    		user.setUserName(entity.getName());
        	String password = entity.getPassword();
        	if(password != null && password.length() < 30) {
        		user.setPassword( InfoEncoder.string2MD5(password) );
        	}
        	
        	Param state = entity.getState();
        	if( "停用".equals(state.getText()) ) {
        		user.setDisabled(1);
        	}
			
        	user.setTelephone(entity.getPhone() == null ? entity.getCode() : entity.getPhone());
        	
        	dao.update(user);
        	
        	entity.setEmail(user.getEmail());
    	}
    	
        return (Employee) dao.update(entity);
    }

    public Employee delete(Long id) {
    	// 删除前需要先删除User表的记录。
    	String hql = "from User o where o.fromUserId=?";
    	List<?> list = dao.getEntities(hql, id.toString());
    	dao.deleteAll(list);
    	
        return dao.deleteById(id);
    }

    public PageInfo search(EmployeeSO so) {
        String hql = " from Employee o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
