package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;
import com.jinhe.tss.framwork.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆班次信息
 * TODO 有些字段需要其他的基础表的信息，后续维护
 * @author Created by LU on 15/9/10.
 */
@Entity
@Table(name = "WM_BAS_TRUCK_SCHEDULE")
@SequenceGenerator(name = "truck_schedule_sequence", sequenceName = "truck_schedule_sequence", initialValue = 1000, allocationSize = 10)
public class TruckSchedule extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "truck_schedule_sequence")
    private Long id;

    /** 所属分拨 */
    @ManyToOne
    private Center ownerCenter;

    /** 所属站点 */
    @ManyToOne
    private Site ownerSite;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 班次号 */
    @Column(length = 128)
    private String serialCode;

    /** 车型 */
    @ManyToOne
    private Param truckType;

    /** 班次类型 */
    @ManyToOne
    private Param serialType;

    /** 到岗时间 */
    private Date arrivalTime;

    /** 离岗时间 */
    private Date leaveTime;

    /** 执行日 */
    private String executeDate;

    /** 生效日期 */
    private Date effectiveDate;

    /** 状态 */
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public Param getTruckType() {
        return truckType;
    }

    public void setTruckType(Param truckType) {
        this.truckType = truckType;
    }

    public Param getSerialType() {
        return serialType;
    }

    public void setSerialType(Param serialType) {
        this.serialType = serialType;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(String executeDate) {
        this.executeDate = executeDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }

}
