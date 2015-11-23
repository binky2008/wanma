package com.best.btr.wanma.system.service;

import com.best.btr.wanma.system.AccountSO;
import com.best.btr.wanma.system.entity.Account;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
 
public interface AccountService {

	Account getEntityById(Long id);
	
	Account create(Account entity);
	
	Account update(Account entity);
	
	Account delete(Long id);
	
	PageInfo search(AccountSO so);
}

