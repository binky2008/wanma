package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.EmployeeDao;
import com.best.btr.wanma.bas.entity.Employee;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Repository("EmployeeDao")
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    public Employee getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEntities() {
        return (List<Employee>) super.getEntities("from Employee");
    }
}
