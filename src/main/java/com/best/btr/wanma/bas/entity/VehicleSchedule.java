package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.entityaop.OperateInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
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
    @Column(length = 128, nullable = false)
    private String parentSite;

    /** 所属站点 */
    @Column(length = 128, nullable = false)
    private String ownerSite;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 班次号 */
    @Column(length = 128)
    private String taskCode;

    /** 车型 */
    @ManyToOne
    private Param vehicleType;

    /** 班次类型 */
    @Column(length = 128)
    private String taskType;

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

    public String getParentSite() {
        return parentSite;
    }

    public void setParentSite(String parentSite) {
        this.parentSite = parentSite;
    }

    public String getOwnerSite() {
        return ownerSite;
    }

    public void setOwnerSite(String ownerSite) {
        this.ownerSite = ownerSite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Param getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Param vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
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
