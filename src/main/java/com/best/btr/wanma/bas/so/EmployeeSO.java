package com.best.btr.wanma.bas.so;

import java.util.HashMap;
import java.util.Map;

import com.jinhe.tss.framwork.AbstractSO;

/**
 * 搜索客户信息的条件。
 * @author Created by Hsian on 15/9/3.
 */
public class EmployeeSO extends AbstractSO {

    /** 编码 */
    private String code;

    /** 名称 */
    private String name;

    /** 岗位 */
    private Long positionId;

    /** 状态 停用 启用 */
    private Long stateId;

    @Override
    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>() ;

        map.put("${name}", " and o.name like :name");
        map.put("${code}", " and o.code like :code");
        
        map.put("${stateId}", " and o.state.id = :stateId");
        map.put("${positionId}", " and o.position.id = :positionId");
        map.put("${ownerSiteId}", " and o.ownerSite.id = :ownerSiteId");
        
        return map;
    }

	public String getCode() {
		if(code != null){
			code = "%" + code.trim() + "%";           
        }
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		if(name != null){
			name = "%" + name.trim() + "%";           
        }
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
 
}
