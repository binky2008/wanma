package com.best.btr.wanma.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.best.btr.wanma.bas.entity.Employee;
import com.jinhe.tss.framework.AbstractEntity;
import com.jinhe.tss.framework.component.param.Param;

@Entity
@Table(name = "wm_sys_user")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", initialValue = 1000, allocationSize = 10)
public class Account extends AbstractEntity {
			
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
	
	@Column(length = 100, nullable = false) 
	private String password;
	
    /** 状态 停用 启用 */
    @ManyToOne
    private Param state;
	
	/**
	 * 用户类型：实操用户、网点编号、管理用户、超级管理员
	 */
	@ManyToOne
	private Param userType;
	
	/**
	 * 用户对应网点员工信息
	 */
	@ManyToOne
	private Employee employee;
	
	/**
	 * 所属组织, 网点所属组织同步自天马
	 */
	@Column(length = 100) 
	private String org;
	
	/** 加盟方 */
	@Column(length = 100) 
	private String franchisee;
	
	private String mobile;
	private String telephone;
	private String email;
	private String idCardNo;   // 身份证
	private String address;
	private String department; // 所属部门

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

	public Param getState() {
		return state;
	}

	public void setState(Param state) {
		this.state = state;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	
}
