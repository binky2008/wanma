package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 网点人员/员工.
 * @author Created by Lu on 15/9/3.
 */
@Entity
@Table(name = "WM_BAS_EMPLOYEE")
@SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", initialValue = 1000, allocationSize = 10)
public class Employee extends OperateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_sequence")
    private Long id;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 名称 */
    @Column(length = 128, nullable = false)
    private String name;

    /**
     * 岗位
     * TODO 物流专员、客服、财务、经理，岗位可以多选
     * 是不是相当于角色?
     */
    private String position;

    /** 部门 */
    @ManyToOne
    private Param department;

    /** 电话 */
    @Column(length = 128, nullable = false)
    private String phone;

    /** 密码 */
    @Column(length = 255, nullable = false)
    private String password;

    /** 性别 */
    @ManyToOne
    private Param gender;

    /** 所属站点 */
    @Column(length = 128, nullable = false)
    private String ownerSite;

    /** 身份证照片附件地址 */
    @Column(length = 255)
    private String identityUrl;

    /** 头像 */
    @Column(length = 255)
    private String headPictureUrl;

    /** 企业邮箱 */
    @Column(length = 128)
    private String email;

    /** 注册来源 */
    @Column(length = 128)
    private String original;

    /** 注册日期 */
    @Column(length = 128)
    private Date registerDate;

    /** 状态 停用 启用 */
    @ManyToOne
    private Param state;

    @Override
    public Serializable getPK() {
        return this.getId();
    }

    public String getStateName() {
        return null != state ? state.getText() : "";
    }

    public String getDepartmentName() {
        return null != department ? department.getText() : "";
    }

    public String getGenderName() {
        return null != gender ? gender.getText() : "";
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Param getDepartment() {
        return department;
    }

    public void setDepartment(Param department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Param getGender() {
        return gender;
    }

    public void setGender(Param gender) {
        this.gender = gender;
    }

    public String getOwnerSite() {
        return ownerSite;
    }

    public void setOwnerSite(String ownerSite) {
        this.ownerSite = ownerSite;
    }

    public String getIdentityUrl() {
        return identityUrl;
    }

    public void setIdentityUrl(String identityUrl) {
        this.identityUrl = identityUrl;
    }

    public String getHeadPictureUrl() {
        return headPictureUrl;
    }

    public void setHeadPictureUrl(String headPictureUrl) {
        this.headPictureUrl = headPictureUrl;
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

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }
}