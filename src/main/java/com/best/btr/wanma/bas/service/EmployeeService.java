package com.best.btr.wanma.bas.service;

import java.util.List;

import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.jinhe.tss.framework.component.log.Logable;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

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
    
    List<?> getEmployeesBySite(Long siteId);

    /**
     * 创建客户信息
     * @param entity 需要创建的客户信息
     * @return
     */
    @Logable(operateObject="员工信息", operateInfo="新增了一个员工信息：${returnVal?default(\"\")}")
    Employee create(Employee entity);

    /**
     * 更新客户信息
     * @param entity 需要更新的客户信息
     * @return
     */
    @Logable(operateObject="员工信息", operateInfo="修改了员工信息，修改后的值为：${returnVal?default(\"\") }")
    Employee update(Employee entity);

    /**
     * 根据Id删除客户信息
     * @param id
     * @return
     */
    @Logable(operateObject="员工信息", operateInfo="删除了员工信息（ID=${args[0]?default(\"\")})")
    Employee delete(Long id);

    /**
     * 搜索客户信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(EmployeeSO so);
}
