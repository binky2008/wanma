package com.best.btr.wanma.bas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.service.CustomerService;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;

/**
 * @author Created by Lu on 15/8/31.
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerDao dao;

    public Customer getEntityById(Long id) {
        return dao.getEntity(id);
    }

    public Customer create(Customer entity) {
    	// 检查客户号号是否已经存在
    	List<?> list = dao.getEntities("from Customer o where o.code = ?", entity.getCode());
    	if(list.size() > 0) {
    		throw new BusinessException("相同客户号的客户记录已经存在。");
    	}
    	
        return dao.create(entity);
    }

    public Customer update(Customer entity) {
        return (Customer) dao.update(entity);
    }

    public Customer delete(Long id) {
        return dao.deleteById(id);
    }

    public PageInfo search(CustomerSO so) {
        String hql = " from Customer o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }

    public String generateCode(Long siteId) {
        return dao.getCustomerCode(siteId);
    }
}
