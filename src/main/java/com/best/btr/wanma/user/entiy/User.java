package com.best.btr.wanma.user.entiy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.best.btr.wanma.bas.entity.Site;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.component.param.ParamConstants;
import com.jinhe.tss.framework.persistence.IEntity;

@Entity
@Table(name = "wm_user")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", initialValue = 1000, allocationSize = 10)
public class User implements IEntity {
			
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
	private Long id;
	
	/**
	 * 必填且唯一，一旦用户新建成功，用户名不能再修改，不区分大小写。同步V5的数据不能修改
	 */
	@Column(length = 100, nullable = false) 
	private String loginName;
	
	/**
	 * 同步V5的数据不能修改
	 */
	@Column(length = 100, nullable = false) 
	private String userName;
	
	@Column(length = 30, nullable = false) 
	private String password;
	
	/** 用户状态：停用、启用 */
	private Integer disabled = ParamConstants.TRUE;
	
	/**
	 * 用户类型：实操用户、管理用户、超级管理员
	 */
	@ManyToOne
	private Param userType;
	
	/**
	 * 员工岗位：客服、物流专员、财务、职业经理人
	 */
	@ManyToOne
	private Param userJob;
	
	/**
	 * 操作站点
	 */
	@ManyToOne
	private Site ownerSite;
	
	private String mobile;
	private String telephone;
	private String email;
	private String idCardNo; // 身份证
	private String address;
	private String department; // 所属部门
	
	/**
	 * 所属组织, 网点所属组织同步至天马
	 */
	@Column(length = 30, nullable = false) 
	private String org;
	
	/**
	 * 加盟方
	 */
	@Column(length = 30, nullable = false) 
	private String franchisee;

	public Serializable getPK() {
		return this.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Param getUserType() {
		return userType;
	}

	public void setUserType(Param userType) {
		this.userType = userType;
	}

	public Param getUserJob() {
		return userJob;
	}

	public void setUserJob(Param userJob) {
		this.userJob = userJob;
	}

	public Site getOwnerSite() {
		return ownerSite;
	}

	public void setOwnerSite(Site ownerSite) {
		this.ownerSite = ownerSite;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getFranchisee() {
		return franchisee;
	}

	public void setFranchisee(String franchisee) {
		this.franchisee = franchisee;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	
}
