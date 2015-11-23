package com.best.btr.wanma.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.system.AccountSO;
import com.best.btr.wanma.system.dao.AccountDao;
import com.best.btr.wanma.system.entity.Account;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import com.jinhe.tss.util.InfoEncoder;
 
@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    
    @Autowired private AccountDao dao;

	public Account getEntityById(Long id) {
		return dao.getEntityById(id);
	}

	public Account create(Account entity) {
		// 检查账号是否已经存在
    	List<?> list = dao.getEntities("from Account o where o.loginName = ?", entity.getLoginName());
    	if(list.size() > 0) {
    		throw new BusinessException("相同登陆账号的用户已经存在。");
    	}
    	
		return dao.create(entity);
	}
	
	public Account update(Account entity) {
		// 判断是否修改了密码
		Account old = dao.getEntity(entity.getId());
		if( !old.getPassword().equals(entity.getPassword()) ) {
			String newPWD = InfoEncoder.string2MD5(entity.getPassword()) ;
			entity.setPassword(newPWD);
		}
		
		return (Account) dao.update(entity);
	}
	
	public Account delete(Long id) {
		return dao.deleteById(id);
	}
 
    public PageInfo search(AccountSO so) {
        String hql = " from Account o  where 1=1 " + so.toConditionString();
 
        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}

