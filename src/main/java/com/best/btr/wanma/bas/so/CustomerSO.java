package com.best.btr.wanma.bas.so;

import java.util.HashMap;
import java.util.Map;

import com.jinhe.tss.framework.AbstractSO;

/**
 * 搜索客户信息的条件。
 * @author Created by Hsian on 15/8/31.
 */
public class CustomerSO extends AbstractSO {

    private String code;
    
    private String name;

    /** 联系电话1(默认此字段为联系电话) */
    private String phone1;
    
    private String original;
    
    private String settleType;

    /** 所属站点 */
    private Long ownerSiteId;

    /** 业务员 */
    private Long businessorId;

    /** 状态 停用 启用 */
    private Long stateId;

    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>() ;
        
        map.put("${name}", " and o.name like :name");
        map.put("${code}", " and o.code like :code");
        map.put("${phone1}", " and o.phone1 = :phone1");
        
        map.put("${original}", " and o.original = :original");
        map.put("${settleType}", " and o.settleType = :settleType");
        
        map.put("${stateId}", " and o.state.id = :stateId");
        map.put("${businessorId}", " and o.businessor.id = :businessorId");
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public Long getOwnerSiteId() {
		return ownerSiteId;
	}

	public void setOwnerSiteId(Long ownerSiteId) {
		this.ownerSiteId = ownerSiteId;
	}

	public Long getBusinessorId() {
		return businessorId;
	}

	public void setBusinessorId(Long businessorId) {
		this.businessorId = businessorId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
}
