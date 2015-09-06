package com.best.btr.wanma.bas.so;

import com.jinhe.tss.framework.persistence.pagequery.MacrocodeQueryCondition;

import java.util.HashMap;
import java.util.Map;

/**
 * 搜索客户信息的条件。
 * @author Created by Hsian on 15/8/31.
 */
public class CustomerSO extends MacrocodeQueryCondition {

    private String code;
    private String name;
    private String fullName;

    /** 联系电话1(默认此字段为联系电话) */
    private String phone1;

    /** 联系电话2 */
    private String phone2;

    /** 省市区 */
    private String ssq;

    /** 详细地址 */
    private String address;

    /** 所属站点 */
    private String ownerSite;

    /** 所属行业 */
    private String industry;

    /** 业务员 */
    private String businessor;

    /** 是否短信通知 */
    private Boolean sendMessage;

    /** 状态 停用 启用 */
    private String stateCode;

    @Override
    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("${code}", " and o.code = :code");
        map.put("${name}", " and o.name = :name");
        map.put("${fullName}", " and o.fullName = :fullName");
        map.put("${phone1}", " and o.phone1 = :phone1");
        map.put("${phone2}", " and o.phone2 = :phone2");
        map.put("${ssq}", " and o.ssq like :ssq");
        map.put("${address}", " and o.address like :address");

        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getSsq() {
        return ssq;
    }

    public void setSsq(String ssq) {
        this.ssq = ssq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerSite() {
        return ownerSite;
    }

    public void setOwnerSite(String ownerSite) {
        this.ownerSite = ownerSite;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getBusinessor() {
        return businessor;
    }

    public void setBusinessor(String businessor) {
        this.businessor = businessor;
    }

    public Boolean isSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(Boolean sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
