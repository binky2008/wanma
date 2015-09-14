package com.best.btr.wanma.user.dao;

import com.best.btr.wanma.user.entiy.User;
import com.jinhe.tss.framework.persistence.IDao;
 
public interface UserDao extends IDao<User> {
	
	User getEntityById(Long id);
	
}
