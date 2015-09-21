package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.service.CustomerService;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/8/31.
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao dao;

    @Override
    public Customer getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<Customer> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public Customer create(Customer entity) {
        return dao.create(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return (Customer) dao.update(entity);
    }

    @Override
    public Customer delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(CustomerSO so) {
        String hql = " from Customer o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }

    @Override
    public String generateCode(String siteCode) {

        return siteCode ;
    }
}
