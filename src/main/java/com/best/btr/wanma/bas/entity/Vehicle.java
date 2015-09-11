package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 车辆信息
 * TODO 有些字段需要其他的基础表的信息，后续维护
 * @author Created by LU on 15/9/10.
 */
@Entity
@Table(name = "WM_BAS_VEHICLE")
@SequenceGenerator(name = "vehicle_sequence", sequenceName = "vehicle_sequence", initialValue = 1000, allocationSize = 10)
public class Vehicle extends OperateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "vehicle_sequence")
    private Long id;

    /** 所属分拨 */
    @ManyToOne
    private Centre centre;

    /** 所属站点 */
    @ManyToOne
    private Site site;

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
    private String licensePlate;

    /** 车品牌 */
    @Column(length = 128)
    private String brand;

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

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }


}
