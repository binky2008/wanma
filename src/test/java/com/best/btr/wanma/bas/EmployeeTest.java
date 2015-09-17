package com.best.btr.wanma.bas;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.best.btr.wanma.bas.action.EmployeeAction;
import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.jinhe.tss.demo.TxTestSupport;
import com.jinhe.tss.framework.component.param.Param;

/**
 * @author Created by Lu on 15/9/6.
 */
public class EmployeeTest extends TxTestSupport {

    @Autowired
    EmployeeAction action;

    List<Param> stateList;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        stateList = paramService.getComboParam("EntityState");
    }

    @Test
    public void testCRUD() {
        // 获取所有的实体
        List<Employee> employeeList = action.getAllEntities();
        Assert.assertEquals(0, employeeList.size());

        String code = "Employee001";
        // 创建
        Employee employee = new Employee();
        employee.setCode(code);
        employee.setName("员工001");
        employee.setState(stateList.get(0));
        employee.setPhone("13558996822");
        employee.setPassword("13558996822");
        employee.setOwnerSite(null);
        employee.setIdentityUrl("identityUrl");
        employee.setHeadPictureUrl("HeadPictureUrl");
        employee = action.save(employee);

        Long id = employee.getId();
        Assert.assertNotNull(id);
        // 根据id获取
        employee = action.getEntityById(id);
        Assert.assertNotNull(employee);
        Assert.assertEquals(code, employee.getCode());

        // 修改
        employee.setName("员工001-update");
        employee = action.save(employee);
        Assert.assertEquals("员工001-update", employee.getName());

        employeeList = action.getAllEntities();
        Assert.assertEquals(1, employeeList.size());

        // 搜索
        EmployeeSO so = new EmployeeSO();
        so.setCode(code);
        List<?> list2 = action.search(so, 1, 10).rows;
        Assert.assertEquals(1, list2.size());

        // 删除
        action.delete(id);

        employeeList = action.getAllEntities();
        Assert.assertEquals(0, employeeList.size());

    }
}
