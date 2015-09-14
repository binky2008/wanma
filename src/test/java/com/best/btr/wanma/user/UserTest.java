package com.best.btr.wanma.user;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.best.btr.wanma.user.action.UserAction;
import com.best.btr.wanma.user.entiy.User;
import com.jinhe.tss.demo.TxTestSupport;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamConstants;

public class UserTest extends TxTestSupport {
	
	@Autowired UserAction action;
	
	List<Param> list1, list2;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		if(paramService.getParam("UserJob") == null) {
        	Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "UserJob", "员工岗位");
        	addComboItem( cp.getId(), "1", "客服" );
        	addComboItem( cp.getId(), "2", "物流专员" );
        	addComboItem( cp.getId(), "3", "财务" );
        	addComboItem( cp.getId(), "4", "职业经理人" );
        }
		list1 = paramService.getComboParam("UserJob");
		
		if(paramService.getParam("UserType") == null) {
        	Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "UserType", "用户类型");
        	addComboItem( cp.getId(), "1", "实操用户" );
        	addComboItem( cp.getId(), "2", "管理用户" );
        	addComboItem( cp.getId(), "3", "超级管理员" );
        }
		list2 = paramService.getComboParam("UserJob");
	}
	
	@Test
	public void test() {
		UserSO so = new UserSO();
		List<?> list = action.search(response, so, 1);
		Assert.assertEquals(0, list.size());
		
		User entity = new User();
		entity.setLoginName("test 1");
		entity.setUserName("test 1");
		entity.setPassword("123456");
		entity.setFranchisee("加盟方");
		entity.setOrg("浙江分公司");
		entity.setUserJob(list1.get(0));
		entity.setUserType(list2.get(0));
		
		entity = action.save(entity );
		
		Long id = entity.getId();
		Assert.assertNotNull(id);
		entity = action.getEntityById(id);
		Assert.assertNotNull(entity);
		Assert.assertEquals("test 1", entity.getLoginName());
		
		entity.setUserName("test 1 update");
		action.save(entity);
		entity = action.getEntityById(id);
		Assert.assertEquals("test 1 update", entity.getUserName());
		
		list = action.search(response, so, 1);
		Assert.assertEquals(1, list.size());
		
		so.setLoginName("test 1");
		List<?> list2 = action.search(response, so , 1);
		Assert.assertEquals(1, list2.size());
		
		so.setLoginName("test 22");
		List<?> list3 = action.search(response, so , 1);
		Assert.assertEquals(0, list3.size());
		
		action.delete(id);
		
		list = action.search(response, so, 1);;
		Assert.assertEquals(0, list.size());
	}

}