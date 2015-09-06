package com.best.btr.wanma.customer;

import com.best.btr.wanma.bas.action.CustomerAction;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.jinhe.tss.demo.TxTestSupport;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Created by Lu on 15/8/31.
 */
public class CustomerTest extends TxTestSupport {

    @Autowired
    CustomerAction action;

    List<Param> settleTypeList;
    List<Param> stateList;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        if (null == paramService.getParam("CustomerState")) {
            Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "CustomerState", "测试状态");
            addComboItem(cp.getId(), "1", "停用");
            addComboItem(cp.getId(), "0", "启用");
        }
        stateList = paramService.getComboParam("CustomerState");

        if (null == paramService.getParam("SettleType")) {
            Param param = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "SettleType", "结算方式");
            addComboItem(param.getId(), "0", "现付");
            addComboItem(param.getId(), "1", "月结");
        }
        settleTypeList = paramService.getComboParam("SettleType");
    }

    @Test
    public void testCRUD() {
        // 获取所有的实体
        List<Customer> customerList = action.getAllEntities();
        Assert.assertEquals(0, customerList.size());

        String code = "Cus001";
        // 创建
        Customer customer = new Customer();
        customer.setCode(code);
        customer.setName("客户001");
        customer.setContacts("联系人001");
        customer.setSettleType(settleTypeList.get(0));
        customer.setState(stateList.get(0));
        customer.setPhone1("13558996822");
        customer.setSsq("浙江省杭州市江干区");
        customer.setAddress("2号大街");
        customer.setOwnerSite("江干一部");
        customer.setSendMessage(true);
        customer = action.save(customer);

        Long id = customer.getId();
        Assert.assertNotNull(id);
        // 根据id获取
        customer = action.getEntityById(id);
        Assert.assertNotNull(customer);
        Assert.assertEquals(code, customer.getCode());

        // 修改
        customer.setName("kehu001");
        customer = action.save(customer);
        Assert.assertEquals("kehu001", customer.getName());

        customerList = action.getAllEntities();
        Assert.assertEquals(1, customerList.size());

        // 搜索
        CustomerSO so = new CustomerSO();
        so.setCode(code);
        List<?> list2 = action.search(response, so, 1);
        Assert.assertEquals(1, list2.size());

        // 删除
        action.delete(id);

        customerList = action.getAllEntities();
        junit.framework.Assert.assertEquals(0, customerList.size());

    }
}
