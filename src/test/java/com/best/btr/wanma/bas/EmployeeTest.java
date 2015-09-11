package com.best.btr.wanma.bas;

import com.best.btr.wanma.bas.action.EmployeeAction;
import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.jinhe.tss.demo.TxTestSupport;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

        if (null == paramService.getParam("EmployeeState")) {
            Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "EmployeeState", "测试状态");
            addComboItem(cp.getId(), "1", "停用");
            addComboItem(cp.getId(), "0", "启用");
        }
        stateList = paramService.getComboParam("EmployeeState");
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
        employee.setOwnerSite("江干一部");
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
        List<?> list2 = action.search(response, so, 1);
        Assert.assertEquals(1, list2.size());

        // 删除
        action.delete(id);

        employeeList = action.getAllEntities();
        junit.framework.Assert.assertEquals(0, employeeList.size());

    }
}
