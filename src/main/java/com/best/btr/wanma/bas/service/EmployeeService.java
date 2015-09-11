package com.best.btr.wanma.bas.service;

import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface EmployeeService {

    /**
     * 根据Id获取客户信息
     * @param id 唯一Id
     * @return
     */
    Employee getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<Employee> getAllEntities();

    /**
     * 创建客户信息
     * @param entity 需要创建的客户信息
     * @return
     */
    Employee create(Employee entity);

    /**
     * 更新客户信息
     * @param entity 需要更新的客户信息
     * @return
     */
    Employee update(Employee entity);

    /**
     * 根据Id删除客户信息
     * @param id
     * @return
     */
    Employee delete(Long id);

    /**
     * 搜索客户信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(EmployeeSO so);
}
