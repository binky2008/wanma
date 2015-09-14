package com.best.btr.wanma.user;

import java.util.HashMap;
import java.util.Map;

import com.jinhe.tss.framework.persistence.pagequery.MacrocodeQueryCondition;

public class UserSO extends MacrocodeQueryCondition {
    
	private String  userName;
	private String  loginName; 
    
	public Map<String, Object> getConditionMacrocodes() {
		Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("${userName}", " and o.userName = :userName");
        map.put("${loginName}", " and o.loginName = :loginName");
        
        return map;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
