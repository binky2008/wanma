package com.best.btr.wanma.system.dao;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.system.entity.Account;
import com.jinhe.tss.framework.persistence.BaseDao;

@Repository("AccountDao")
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

	public AccountDaoImpl() {
        super(Account.class);
    }

	public Account getEntityById(Long id) {
		return super.getEntity(id);
	}

}