package com.best.btr.wanma.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.system.UserSO;
import com.best.btr.wanma.system.dao.UserDao;
import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
 
@Service("UserService")
public class UserServiceImpl implements UserService {
    
    @Autowired private UserDao dao;

	public User getEntityById(Long id) {
		return dao.getEntityById(id);
	}

	public User create(User entity) {
		return dao.create(entity);
	}
	
	public User update(User entity) {
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

