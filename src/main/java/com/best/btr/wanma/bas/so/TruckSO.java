package com.best.btr.wanma.bas.so;

import java.util.HashMap;
import java.util.Map;

import com.jinhe.tss.framwork.AbstractSO;

/**
 * @author Created by Hsian on 15/9/11.
 */
public class TruckSO extends AbstractSO {
	
    /** 车型 */
    private Long typeId;

    /** 车牌号 */
    private String code;

    /** 车品牌 */
    private String brand; 
    
    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>() ;
        
        map.put("${brand}", " and o.brand like :brand");
        map.put("${code}", " and o.code like :code");
        
        map.put("${typeId}", " and o.typeId.id = :typeId");
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

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getBrand() {
		if(brand != null){
			brand = "%" + brand.trim() + "%";           
        }
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
