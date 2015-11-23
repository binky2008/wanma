package com.best.btr.wanma.system;

import java.util.HashMap;
import java.util.Map;

import com.jinhe.tss.framework.AbstractSO;

public class AccountSO extends AbstractSO {
    
    /** 用户名 */
    private String loginName;

    /** 名称 */
    private String userName;
    
    /** 用户类型 */
    private Long userTypeId;

    /** 岗位 */
    private Long positionId;

    /** 状态 停用 启用 */
    private Long stateId;

    @Override
    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>() ;

        map.put("${userName}", " and o.userName like :userName");
        map.put("${loginName}", " and o.loginName like :loginName");
        
        map.put("${stateId}", " and o.state.id = :stateId");
        map.put("${userTypeId}", " and o.userType.id = :userTypeId");
        map.put("${positionId}", " and o.employee.position.id = :positionId");
        map.put("${ownerSiteId}", " and o.employee.ownerSite.id = :ownerSiteId");
        
        return map;
    }

	public String getLoginName() {
		if(loginName != null){
			loginName = "%" + loginName.trim() + "%";           
        }
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		if(userName != null){
			userName = "%" + userName.trim() + "%";           
        }
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

}
