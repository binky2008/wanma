package com.best.btr.wanma.bas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framwork.AbstractEntity;

/**
 * 项目实体,其实是供应链里地项目的概念.
 * @author Created by LU on 15/9/10.
 */
@Entity
@Table(name = "WM_BAS_PROJECT")
@SequenceGenerator(name = "project_sequence", sequenceName = "project_sequence", initialValue = 1000, allocationSize = 10)
public class Project extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project_sequence")
    private Long id;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 名称 */
    @Column(length = 128, nullable = false)
    private String name;

    /** 全称 */
    @Column(length = 128)
    private String fullName;

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

    /** 业务员 */
    @ManyToOne
    private Employee businessor;
    
    /** 
     * 项目要求：网点录单时自动带出项目要求 
     */
    @Column(length = 1000)
    private String remark;

    /** 状态: 在用、失效 */
    @ManyToOne
    private Param state;

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

    public Employee getBusinessor() {
        return businessor;
    }

    public void setBusinessor(Employee businessor) {
        this.businessor = businessor;
    }

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }
}
