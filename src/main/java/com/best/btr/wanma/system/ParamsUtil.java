package com.best.btr.wanma.system;

import java.util.List;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamManager;
import com.jinhe.tss.framework.exception.BusinessException;

public class ParamsUtil {

	public static Param getParamItem(String comboCode, String itemName) {
		List<Param> list = ParamManager.getComboParam(comboCode);
		for(Param param : list) {
			if(itemName.equalsIgnoreCase(param.getText())) {
				return param;
			}
		}
		throw new BusinessException("code为：" + comboCode + "的系统参数里找不到名为【" + itemName + "】的参数项。");
	}
	
}
