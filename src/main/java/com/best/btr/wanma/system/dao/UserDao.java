package com.best.btr.wanma.system.dao;

import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.persistence.IDao;
 
public interface UserDao extends IDao<User> {
	
	User getEntityById(Long id);
	
}
