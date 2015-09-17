package com.best.btr.wanma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamConstants;
import com.jinhe.tss.framework.component.param.ParamService;

@Controller
@RequestMapping("/init")
public class SystemInit {
	
	@Autowired protected ParamService paramService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object init() {
		if (null == paramService.getParam("EntityState")) {
            Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "EntityState", "对象状态");
            addComboItem(cp.getId(), "1", "停用");
            addComboItem(cp.getId(), "0", "启用");
        }
		
		if(paramService.getParam("UserJob") == null) {
        	Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "UserJob", "员工岗位");
        	addComboItem( cp.getId(), "1", "客服" );
        	addComboItem( cp.getId(), "2", "物流专员" );
        	addComboItem( cp.getId(), "3", "财务" );
        	addComboItem( cp.getId(), "4", "财务兼客服" );
        	addComboItem( cp.getId(), "5", "职业经理人" );
        }
		
		if(paramService.getParam("UserType") == null) {
        	Param cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "UserType", "用户类型");
        	addComboItem( cp.getId(), "1", "超级管理员" );
        	addComboItem( cp.getId(), "2", "管理用户" );
        	addComboItem( cp.getId(), "3", "实操用户" );
        	addComboItem( cp.getId(), "4", "网点编号" );
        }
		
        if (null == paramService.getParam("SettleType")) {
            Param param = addComboParam(ParamConstants.DEFAULT_PARENT_ID, "SettleType", "结算方式");
            addComboItem(param.getId(), "0", "现付");
            addComboItem(param.getId(), "1", "月结");
        }
		
		return new Object[] { "Success" };
	}
	
	
    /** 简单参数 */
    Param addParam(Long parentId, String code, String name, String value) {
        Param param = new Param();
        param.setCode(code);
        param.setName(name);
        param.setValue(value);
        param.setParentId(parentId);
        param.setType(ParamConstants.NORMAL_PARAM_TYPE);
        param.setModality(ParamConstants.SIMPLE_PARAM_MODE);
        paramService.saveParam(param);
        return param;
    }

    /** 下拉型参数 */
    Param addComboParam(Long parentId, String code, String name) {
        Param param = new Param();
        param.setCode(code);
        param.setName(name);
        param.setParentId(parentId);
        param.setType(ParamConstants.NORMAL_PARAM_TYPE);
        param.setModality(ParamConstants.COMBO_PARAM_MODE);
        paramService.saveParam(param);
        return param;
    }

    /** 新建设参数项 */
    Param addComboItem(Long parentId, String value, String text) {
        Param param = new Param();
        param.setValue(value);
        param.setText(text);
        param.setParentId(parentId);
        param.setType(ParamConstants.ITEM_PARAM_TYPE);
        paramService.saveParam(param);
        return param;
    }
}
