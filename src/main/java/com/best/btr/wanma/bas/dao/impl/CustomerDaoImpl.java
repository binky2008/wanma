package com.best.btr.wanma.bas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.framework.persistence.BaseDao;

/**
 * @author Created by Lu on 15/8/31.
 */
@Repository("CustomerDao")
public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {

    public CustomerDaoImpl() {
        super(Customer.class);
    }
    
    public String getCustomerCode(Long siteId) {
    	String siteCode = ((Site)getEntity(Site.class, siteId)).getCode();
        Integer seqNo = getMaxSeqNo(siteId);
        if(seqNo < 10) {
        	return siteCode + "00" + seqNo;
        }
        if(seqNo < 100) {
        	return siteCode + "0" + seqNo;
        }
        return siteCode + seqNo;
    }
    
    public Integer getMaxSeqNo(Long siteId) {
    	String hql = "select max(o.seqNo) from Customer o where o.ownerSite.id = ?";
        List<?> list = getEntities(hql, siteId); 
        Integer seqNo = (!list.isEmpty() && list.get(0) != null) ? (Integer) list.get(0) + 1 : 1;
    
        return seqNo;
    }
}
