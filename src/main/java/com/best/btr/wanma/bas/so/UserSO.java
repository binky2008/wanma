package com.best.btr.wanma.bas.so;

import com.jinhe.tss.framework.persistence.pagequery.MacrocodeQueryCondition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 搜索客户信息的条件。
 * @author Created by Hsian on 15/9/3.
 */
public class UserSO extends MacrocodeQueryCondition {

    /** 编码 */
    private String code;

    /** 名称 */
    private String name;

    /**
     * 岗位
     * TODO 物流专员、客服、财务、经理，岗位可以多选
     * 是不是相当于角色?
     */
    private String position;

    /** 部门 */
    private String department;

    /** 电话 */
    private String phone;

    /** 性别 */
    private String gender;

    /** 所属站点 */
    private String ownerSite;

    /** 企业邮箱 */
    private String email;

    /** 注册来源 */
    private String original;

    /** 注册日期 */
    private Date registerDate;

    /** 状态 停用 启用 */
    private String stateCode;

    @Override
    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("${code}", " and o.code = :code");
        map.put("${name}", " and o.name = :name");
        map.put("${position}", " and o.position = :position");
        map.put("${phone}", " and o.phone = :phone");
        map.put("${gender}", " and o.gender = :gender");
        map.put("${ownerSite}", " and o.ownerSite = :ownerSite");
        map.put("${email}", " and o.email like :email");
        map.put("${original}", " and o.original = :original");

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOwnerSite() {
        return ownerSite;
    }

    public void setOwnerSite(String ownerSite) {
        this.ownerSite = ownerSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
