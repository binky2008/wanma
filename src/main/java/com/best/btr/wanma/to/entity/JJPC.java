package com.best.btr.wanma.to.entity;

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
import com.best.btr.wanma.bas.entity.Truck;
import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;
import com.jinhe.tss.util.EasyUtils;
 
/**
 * 寄件(接件)排车班次
 */
@Entity
@Table(name = "wm_to_jjpc")
@SequenceGenerator(name = "jjpc_sequence", sequenceName = "jjpc_sequence", initialValue = 1000, allocationSize = 10)
public class JJPC extends OperateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "jjpc_sequence")
    private Long id;
 
    @ManyToOne
    private Site ownerSite;
    
    @ManyToOne
    private Truck truck;
    
    @ManyToOne
    private TruckSchedule ts;
    
    @ManyToOne
    private Employee driver;
    
    private Integer amount;
    
    private Double cubic;
    
    private Double weight;
    
    @Column(length = 4000)
    private String tos;
    
    @Column(length = 2, nullable = false)
    private Integer tag;  // 1:寄件排车   2：接件排车
    
    public Integer getNum() {
    	return this.getToList().length;
    }
    
    public String[] getToList(){
    	if( EasyUtils.isNullOrEmpty(tos) ) {
    		return new String[]{};
    	}
    	return tos.split(",");
    }

	public Site getOwnerSite() {
		return ownerSite;
	}

	public void setOwnerSite(Site ownerSite) {
		this.ownerSite = ownerSite;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public TruckSchedule getTs() {
		return ts;
	}

	public void setTs(TruckSchedule ts) {
		this.ts = ts;
	}

	public Employee getDriver() {
		return driver;
	}

	public void setDriver(Employee driver) {
		this.driver = driver;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getCubic() {
		return cubic;
	}

	public void setCubic(Double cubic) {
		this.cubic = cubic;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serializable getPK() {
		return this.id;
	}

	public Long getId() {
		return id;
	}

	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}
    
}