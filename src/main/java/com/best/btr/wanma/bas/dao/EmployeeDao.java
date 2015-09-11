package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.Employee;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface EmployeeDao extends IDao<Employee> {

    /**
     * 根据Id获取客户信息
     * @param id 唯一
     * @return
     */
    Employee getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<Employee> getAllEntities();
}
