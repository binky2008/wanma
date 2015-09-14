package com.best.btr.wanma.system.service;

import com.best.btr.wanma.system.UserSO;
import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
 
public interface UserService {

	User getEntityById(Long id);
	
	User create(User entity);
	
	User update(User entity);
	
	User delete(Long id);
	
	PageInfo search(UserSO so);
}

