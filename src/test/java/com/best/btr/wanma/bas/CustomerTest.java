package com.best.btr.wanma.bas;

import com.best.btr.wanma.bas.action.CustomerAction;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.demo.TxTestSupport;
import com.jinhe.tss.framework.component.param.Param;
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

        stateList = paramService.getComboParam("EntityState");
        settleTypeList = paramService.getComboParam("SettleType");
    }

    @Test
    public void testCRUD() {
        // 获取所有的实体
        List<?> customerList = action.search(new CustomerSO(), 1, 20).rows;
        Assert.assertEquals(0, customerList.size());

        String code = "Cus001";
        
        // 创建
        Customer customer = new Customer();
        customer.setCode(code);
        customer.setName("客户001");
        customer.setContacts("联系人001");
        customer.setSettleType("月结");
        customer.setDisabled(0);
        customer.setPhone1("13558996822");
        customer.setRegion("浙江省杭州市江干区");
        customer.setAddress("2号大街");
        customer.setOwnerSite(new Site());
        customer.setNeedMessage(true);
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

        // 搜索
        CustomerSO so = new CustomerSO();
        so.setCode(code);
        List<?> list2 = action.search(so, 1, 20).rows;
        Assert.assertEquals(1, list2.size());

        // 删除
        action.delete(id);

        customerList = action.search(new CustomerSO(), 1, 20).rows;
        Assert.assertEquals(0, customerList.size());

    }
}
