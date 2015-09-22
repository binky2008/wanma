package com.best.btr.wanma;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamConstants;
import com.jinhe.tss.framework.component.param.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/init")
public class SystemInit {
	
	@Autowired protected ParamService paramService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object init() {
		String[][] items = new String[][]{ 
        		{"1", "停用"}, 
        		{"0", "启用"} 
        	};
        addComboParam("EntityState", "对象状态", items);
        
        items = new String[][]{ 
        		{"1", "客服"}, 
        		{"2", "物流专员"},
        		{"3", "财务"},
        		{"4", "财务兼客服"},
        		{"5", "职业经理人"}
        	};
        addComboParam("UserJob", "员工岗位", items);
		
		items = new String[][]{ 
				{ "1", "超级管理员"},
	        	{ "2", "管理用户"},
	        	{ "3", "实操用户"},
	        	{ "4", "网点编号"}
        	};
        addComboParam("UserType", "用户类型", items);
		
		items = new String[][]{ 
        		{"1", "现付"}, 
        		{"0", "月结"} 
        	};
        addComboParam("SettleType", "结算方式", items);

        items = new String[][]{ 
        		{ "3.0", "微型车"},
                { "4.2", "4米2"},
                { "6.8", "6米8"},
                { "7.6", "7米6"},
                { "9.6", "9米6"},
                { "12.5", "12米5"},
                { "13.5", "13米5"},
                { "58", "58货柜"},
                { "61", "61货柜"},
                { "1.0", "其他"}
        	};
        addComboParam("TruckType", "车辆类型", items);
        
        items = new String[][]{ 
        		{"1", "在用"}, 
        		{"2", "报废"} 
        	};
        addComboParam("TruckState", "车辆状态", items);
        
        items = new String[][]{ 
        		{ "1", "手动新增"},
                { "2", "项目客户"},
                { "3", "turbo"},
                { "4", "阿里"},
                { "5", "微信"},
                { "6", "淘宝"},
                { "7", "天猫"}
        	};
        addComboParam("CustomerFrom", "客户来源", items);
  
        items = new String[][]{ 
        		{"1", "交件"}, 
        		{"2", "取件"} 
        	};
        addComboParam("TruckScheduleType", "班次类型", items);

        items = new String[][]{
        		{"1", "正常"},
        		{"0", "待生效"},
        		{"-1", "失效"}
        	};
        addComboParam("TruckScheduleState", "班次状态", items);
        
		return new Object[] { "Success" };
	}
	
	void addComboParam(String code, String name, String[][] items) {
		Param cp;
		List<Param> list;
		
		if( (cp = paramService.getParam(code)) != null) {
			list = paramService.getComboParam(code);
		}
		else {
			cp = addComboParam(ParamConstants.DEFAULT_PARENT_ID, code, name);
			list = new ArrayList<Param>();
		}
		
		L:for(String[] item : items) {
			for(Param p : list) {
				if(p.getValue().equals(item[0])) {
					p.setText(item[1]);
					paramService.saveParam(p);
					continue L;
				}
			}
			addComboItem(cp.getId(), item[0], item[1]);
		}
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
