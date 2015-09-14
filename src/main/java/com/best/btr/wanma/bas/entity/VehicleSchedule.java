package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆班次信息
 * TODO 有些字段需要其他的基础表的信息，后续维护
 * @author Created by LU on 15/9/10.
 */
@Entity
@Table(name = "WM_BAS_VEHICLE_SCHEDULE")
@SequenceGenerator(name = "vehicle_schedule_sequence", sequenceName = "vehicle_schedule_sequence", initialValue = 1000, allocationSize = 10)
public class VehicleSchedule extends OperateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "vehicle_schedule_sequence")
    private Long id;

    /** 所属分拨 */
    @ManyToOne
    private Centre centre;

    /** 所属站点 */
    @ManyToOne
    private Site site;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 班次号 */
    @Column(length = 128)
    private String serialCode;

    /** 车型 */
    @ManyToOne
    private Param vehicleType;

    /** 班次类型 */
    @Column(length = 128)
    private String serialType;

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

    public String getCentreName() {
        return null != this.getCentre() ? this.getCentre().getName() : "";
    }

    public String getSiteName() {
        return null != this.getSite() ? this.getSite().getName() : "";
    }

    public String getVehicleTypeName() {
        return null != this.getVehicleType() ? this.getVehicleType().getName() : "";
    }

    public String getStateName() {
        return null != state ? state.getText() : "";
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

    public Param getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Param vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSerialType() {
        return serialType;
    }

    public void setSerialType(String serialType) {
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
