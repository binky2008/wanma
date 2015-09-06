package com.best.btr.wanma.bas;

import com.best.btr.wanma.bas.action.UserAction;
import com.best.btr.wanma.bas.entity.User;
import com.best.btr.wanma.bas.so.UserSO;
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
public class UserTest extends TxTestSupport {

    @Autowired
    UserAction action;

    List<Param> stateList;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        if (null == paramService.getParam("UserState")) {
            Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "UserState", "测试状态");
            addComboItem(cp.getId(), "1", "停用");
            addComboItem(cp.getId(), "0", "启用");
        }
        stateList = paramService.getComboParam("UserState");
    }

    @Test
    public void testCRUD() {
        // 获取所有的实体
        List<User> userList = action.getAllEntities();
        Assert.assertEquals(0, userList.size());

        String code = "User001";
        // 创建
        User user = new User();
        user.setCode(code);
        user.setName("用户001");
        user.setState(stateList.get(0));
        user.setPhone("13558996822");
        user.setPassword("13558996822");
        user.setOwnerSite("江干一部");
        user.setIdentityUrl("identityUrl");
        user = action.save(user);

        Long id = user.getId();
        Assert.assertNotNull(id);
        // 根据id获取
        user = action.getEntityById(id);
        Assert.assertNotNull(user);
        Assert.assertEquals(code, user.getCode());

        // 修改
        user.setName("yonghu001");
        user = action.save(user);
        Assert.assertEquals("yonghu001", user.getName());

        userList = action.getAllEntities();
        Assert.assertEquals(1, userList.size());

        // 搜索
        UserSO so = new UserSO();
        so.setCode(code);
        List<?> list2 = action.search(response, so, 1);
        Assert.assertEquals(1, list2.size());

        // 删除
        action.delete(id);

        userList = action.getAllEntities();
        junit.framework.Assert.assertEquals(0, userList.size());

    }
}
