package com.best.btr.wanma.bas.entity;

import com.best.btr.wanma.system.entity.Center;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.framework.AbstractEntity;
import com.jinhe.tss.framework.component.param.Param;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆信息
 * @author Created by LU on 15/9/10.
 */
@Entity
@Table(name = "wm_bas_truck")
@SequenceGenerator(name = "truck_sequence", sequenceName = "truck_sequence", initialValue = 1000, allocationSize = 10)
public class Truck extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "truck_sequence")
    private Long id;

    /** 所属分拨: 该班次接送货的分拨。一个站点可以往多个分拨开通班次 */
    @ManyToOne
    private Center ownerCenter;

    /** 所属站点 */
    @ManyToOne
    private Site ownerSite;

    /** 班车卡卡号 */
    @Column(length = 128, unique = true, nullable = false)
    private String cardCode;

    /** 车厢条码 */
    @Column(length = 128, unique = true, nullable = false)
    private String barCode;

    /** 车型 */
    @ManyToOne
    private Param type;

    /** 车牌号 */
    @Column(length = 128)
    private String code;

    /** 车品牌 */
    @Column(length = 128)
    private String brand;

    /** 修订日期 */
    private Date updateTime;

    /** 车辆状态 */
    @ManyToOne
    private Param state;

    @Override
    public Serializable getPK() {
        return this.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Center getOwnerCenter() {
        return ownerCenter;
    }

    public void setOwnerCenter(Center ownerCenter) {
        this.ownerCenter = ownerCenter;
    }

    public Site getOwnerSite() {
        return ownerSite;
    }

    public void setOwnerSite(Site ownerSite) {
        this.ownerSite = ownerSite;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Param getType() {
        return type;
    }

    public void setType(Param type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }

}
