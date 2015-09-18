package com.best.btr.wanma.bas.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.EmployeeDao;
import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.service.EmployeeService;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.best.btr.wanma.system.ParamsUtil;
import com.best.btr.wanma.system.dao.UserDao;
import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import com.jinhe.tss.util.InfoEncoder;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired private EmployeeDao dao;
    @Autowired private UserDao userDao;

    public Employee getEntityById(Long id) {
        return dao.getEntityById(id);
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
    		entity.setEmail(entity.getCode() + "@btrbi.com");
    	} catch(Exception e) {
    		// 调用出错不影响后面的注册步骤
    	}
    	
    	// 同时注册一个登陆账号User
    	User user = new User();
    	user.setLoginName(entity.getCode());
    	user.setUserName(entity.getName());
    	user.setEmail(entity.getEmail());
    	user.setPassword( InfoEncoder.string2MD5(entity.getPassword()) );
    	user.setState(entity.getState());
    	user.setTelephone(entity.getPhone());
    	user.setMobile(entity.getCode());
    	user.setUserType(ParamsUtil.getParamItem("UserType", "实操用户"));
    	user.setEmployee(entity);
    	userDao.create(user);
    	
    	// TODO 按员工的岗位信息给其对应的用户设置角色
        
		return entity;
    }

    public Employee update(Employee entity) {
    	String hql = "from User o where o.employee.id=?";
    	List<?> list = dao.getEntities(hql, entity.getId());
    	if(!list.isEmpty()) {
    		User user = (User) list.get(0);
    		user.setUserName(entity.getName());
        	String password = entity.getPassword();
        	if(password != null && password.length() < 30) {
        		user.setPassword( InfoEncoder.string2MD5(password) );
        	}
        	user.setState(entity.getState());
        	user.setTelephone(entity.getPhone());
        	user.setMobile(entity.getCode());
        	
        	userDao.update(user);
        	
        	entity.setEmail(user.getEmail());
        	
        	// TODO 按员工的岗位信息给其对应的用户设置角色
    	}
    	
        return (Employee) dao.update(entity);
    }

    public Employee delete(Long id) {
    	// User表有外键关联到本表，删除前需要先删除User表的记录。
    	String hql = "from User o where o.employee.id=?";
    	List<?> list = dao.getEntities(hql, id);
    	dao.deleteAll(list);
    	
        return dao.deleteById(id);
    }

    public PageInfo search(EmployeeSO so) {
        String hql = " from Employee o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
