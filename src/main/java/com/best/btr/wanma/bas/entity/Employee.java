package com.best.btr.wanma.bas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jinhe.tss.framework.AbstractEntity;
import com.jinhe.tss.framework.component.param.Param;

/**
 * 网点人员/员工。 网点客服/老板负责新增自己网点的人员
 * 
 * @author Created by Lu on 15/9/3.
 */
@Entity
@Table(name = "WM_BAS_EMPLOYEE")
@SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", initialValue = 1000, allocationSize = 10)
public class Employee extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_sequence")
    private Long id;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 名称 */
    @Column(length = 128, nullable = false)
    private String name;
    
    /** 所属站点 */
    @ManyToOne
	private Site ownerSite;

    /**
	 * 员工岗位：客服、物流专员、财务、职业经理人，岗位可以多选
	 */
    @ManyToOne
    private Param position;

    /** 部门 */
    private String department;
    
    private String phone;
    
    @Transient
    private String password;

    /** 性别 */
    private String gender;

    /** 身份证照片附件地址 */
    @Column(length = 255)
    private String identityUrl;

    /** 头像 */
    @Column(length = 255)
    private String headPictureUrl;

    /** 企业邮箱 */
    @Column(length = 128)
    private String email;

    /** 注册来源: APP | PC */
    @Column(length = 128)
    private String original;

    /** 注册日期 */
    @Column(length = 128)
    private Date registerDate;

    /** 状态 停用 启用 */
    @ManyToOne
    private Param state;
    
    @Transient
    private int ack; // 注册时六位手机验证码

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

    public Param getPosition() {
        return position;
    }

    public void setPosition(Param position) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Site getOwnerSite() {
        return ownerSite;
    }

    public void setOwnerSite(Site ownerSite) {
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

	public int getAck() {
		return ack;
	}

	public void setAck(int ack) {
		this.ack = ack;
	}
}
