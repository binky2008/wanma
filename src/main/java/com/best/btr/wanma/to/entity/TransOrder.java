package com.best.btr.wanma.to.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.ManyToOne;

import com.best.btr.wanma.bas.entity.Centre;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.entity.Site;
import com.best.btr.wanma.system.entity.User;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;

public class TransOrder extends OperateInfo {
	
	private Long id;
	
	// 寄件信息
	/**
	 * 寄件网点, 根据登录的网点自动带出
	 */
	private Site sendSite;
	
	/**
	 * 寄件日期
	 */
	private Date sendDate;
	
	/**
	 * 收件员指派	文本	Y	Y	所以业务员及维护的物流专员选项
	 */
	private User courier;
	
	/**
	 * 客户信息	文本	Y	Y	根据维护的客户信息得出
	 */
	private Customer customer;
	
	// 收件信息
	/**
	 * 收件公司
	 */
	private String acceptCompany;
	
	/**
	 * 收件电话
	 */
	private String acceptPhone;
	
	/**
	 * 收件人
	 */
	private String acceptPerson;
	
	/**
	 * 收件地址
	 */
	private String acceptAddress;
	
	/**
	 * 派件分拨	文本	Y	Y	根据地址得出
	 */
	private Centre sendCentre;
	
	/**
	 * 派件网点	选择框	Y	Y	根据地址得出
	 */
	private Site destSite;
	
	/**
	 * 服务方式	选择框	Y	Y	根据网点选择
	 */
	@ManyToOne
	private Param serviceMode;
	
	// 运单信息
	/**
	 * 运单编号
	 */
	private String code;
	
	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 客户单号
	 */
	private String customerNo;
	
	/**
	 * 来源
	 */
	private String source;
	
	/**
	 * 货物名称
	 */
	private String cargo;
	
	/**
	 * 主要包装
	 */
	@ManyToOne
	private Param pack;
	
	/**
	 * 件数
	 */
	private Integer amount;
	
	/**
	 * 体积
	 */
	private Double cubic;
	
	/**
	 * 实际重量
	 */
	private Double actualWeight;
	
	/**
	 * 体积重量
	 */
	private Double GROSSWEIGHT;
	
	/**
	 * 计费重量 = Max（体积重量、实际重量）
	 */
	private Double feeWeight;
	
	/**
	 * 折扣：根据产品线显示折扣值
	 */
	private Double discount;
	
	/**
	 * 折扣重量：计费重量*折扣
	 */
	private Double discountWeight;
	
	/**
	 * 保价额，根据不同的产品线有不同的最低保价额
	 */
	private Double insureAmount;
	
	/**
	 * 保险费
	 */
	private Double insurance;
	
	/**
	 * 录单费
	 */
	private Double recorFee;
	
	/**
	 * 产品类型，根据重量和体积自动分配
	 */
	@ManyToOne
	private Param productType;
	
	/**
	 * 备注，特殊要求
	 */
	private String remark;
	
	// 增值服务
	/**
	 * 回单号。当勾选原单返回时，必填
	 */
	private String podCode;
	
	/** 是否短信通知 */
	private Integer needNode;
	
	/** 是否上楼 */
	private Integer needSL;
	
	/**
	 * 是否清点CheckAmount
	 */
	private Integer needCA;
	
	/** 是否专车进仓 */
	private Integer needZCJC;
	
	/** 是否报关 */
	private Integer needBG;
	
	// 客户支付方式
	/**
	 * 支付方式：现付、月结、到付。默认根据客户信息带出，可修改
	 */
	@ManyToOne
	private Param paymentType;
	
	/**
	 * 运费金额，用于填写收客户的运费
	 */
	private Double transFee;

	public Serializable getPK() {
		return this.id;
	}

}
