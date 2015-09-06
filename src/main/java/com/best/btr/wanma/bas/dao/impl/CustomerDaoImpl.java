package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/8/31.
 */
@Repository("CustomerDao")
public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {

    public CustomerDaoImpl() {
        super(Customer.class);
    }

    @Override
    public Customer getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> getAllEntities() {
        return (List<Customer>) super.getEntities("from Customer");
    }
}
