package com.best.btr.wanma.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.system.UserSO;
import com.best.btr.wanma.system.dao.UserDao;
import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import com.jinhe.tss.util.InfoEncoder;
 
@Service("UserService")
public class UserServiceImpl implements UserService {
    
    @Autowired private UserDao dao;

	public User getEntityById(Long id) {
		return dao.getEntityById(id);
	}

	public User create(User entity) {
		// 检查账号是否已经存在
    	List<?> list = dao.getEntities("from User o where o.loginName = ?", entity.getLoginName());
    	if(list.size() > 0) {
    		throw new BusinessException("相同登陆账号的用户已经存在。");
    	}
    	
		return dao.create(entity);
	}
	
	public User update(User entity) {
		// 判断是否修改了密码
		User old = dao.getEntity(entity.getId());
		if( !old.getPassword().equals(entity.getPassword()) ) {
			String newPWD = InfoEncoder.string2MD5(entity.getPassword()) ;
			entity.setPassword(newPWD);
		}
		
		return (User) dao.update(entity);
	}
	
	public User delete(Long id) {
		return dao.deleteById(id);
	}
 
    public PageInfo search(UserSO so) {
        String hql = " from User o  where 1=1 " + so.toConditionString();
 
        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}

