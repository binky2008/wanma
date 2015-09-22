package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.Customer;
import com.jinhe.tss.framework.persistence.IDao;

/**
 * @author Created by Lu on 15/8/31.
 */
public interface CustomerDao extends IDao<Customer> {

	String getCustomerCode(Long siteId);
	
}
