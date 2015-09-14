package com.best.btr.wanma.user.service;

import com.best.btr.wanma.user.UserSO;
import com.best.btr.wanma.user.entiy.User;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
 
public interface UserService {

	User getEntityById(Long id);
	
	User create(User entity);
	
	User update(User entity);
	
	User delete(Long id);
	
	PageInfo search(UserSO so);
}

