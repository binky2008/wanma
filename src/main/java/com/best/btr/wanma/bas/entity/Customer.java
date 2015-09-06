package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 客户实体
 * TODO 有些字段需要其他的基础表的信息，后续维护
 * @author Created by LU on 15/8/31.
 */
@Entity
@Table(name = "WM_BAS_CUSTOMER")
@SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", initialValue = 1000, allocationSize = 10)
public class Customer extends OperateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_sequence")
    private Long id;

    /** 客户编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 客户名称 */
    @Column(length = 128, nullable = false)
    private String name;

    /** 客户全称 */
    @Column(length = 128)
    private String fullName;

    /** 客户来源 */
    @ManyToOne
    private Param original;

    /** 结算类型 */
    @ManyToOne
    private Param settleType;

    /** 联系人 */
    @Column(length = 128, nullable = false)
    private String contacts;

    /** 联系电话1(默认此字段为联系电话) */
    @Column(length = 64, nullable = false)
    private String phone1;

    /** 联系电话2 */
    @Column(length = 64)
    private String phone2;

    /** 省市区 */
    @Column(length = 255)
    private String ssq;//provinceCityDistrict

    /** 详细地址 */
    @Column(length = 255)
    private String address;

    /** 所属站点 */
    @Column(length = 128, nullable = false)
    private String ownerSite;

    /** 所属行业 */
    @Column(length = 128)
    private String industry;

    /** 业务员 */
    @Column(length = 128)
    private String businessor;

    /** 是否短信通知 */
    private Boolean sendMessage;

    /** 状态 停用 启用 */
    @ManyToOne
    private Param state;

    @Override
    public Serializable getPK() {
        return this.getId();
    }

    public String getSettleTypeName() {
        return null != settleType ? settleType.getText() : "";
    }

    public String getStateName() {
        return state.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Param getOriginal() {
        return original;
    }

    public void setOriginal(Param original) {
        this.original = original;
    }

    public Param getSettleType() {
        return settleType;
    }

    public void setSettleType(Param settleType) {
        this.settleType = settleType;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }


}
