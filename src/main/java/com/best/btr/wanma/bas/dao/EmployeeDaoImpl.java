package com.best.btr.wanma.bas.dao;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.bas.entity.Employee;
import com.jinhe.tss.framework.persistence.BaseDao;

/**
 * @author Created by Lu on 15/9/3.
 */
@Repository("EmployeeDao")
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }
}