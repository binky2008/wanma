package com.best.btr.wanma.system.dao;

import com.best.btr.wanma.system.entity.Account;
import com.jinhe.tss.framework.persistence.IDao;
 
public interface AccountDao extends IDao<Account> {
	
	Account getEntityById(Long id);
	
}
