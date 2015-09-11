package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.EmployeeDao;
import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.service.EmployeeService;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public Employee getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<Employee> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public Employee create(Employee entity) {
        return dao.create(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return (Employee) dao.update(entity);
    }

    @Override
    public Employee delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(EmployeeSO so) {
        String hql = " from Employee o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
