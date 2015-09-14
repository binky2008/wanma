package com.best.btr.wanma.system.dao;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.persistence.BaseDao;

@Repository("UserDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	public UserDaoImpl() {
        super(User.class);
    }

	public User getEntityById(Long id) {
		return super.getEntity(id);
	}

}