package com.best.btr.wanma.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jinhe.tss.framework.persistence.IEntity;

/**
 * <p>分拨实体</p>
 * <p> 查询TSS.Group的分拨作为分拨视图 </p>
 * @author Created by Hsian on 15/9/11.
 
drop table VIEW_WM_CENTER;

CREATE VIEW wanma.VIEW_WM_CENTER AS
select fromGroupId*-1 as id, description as code, name, parentId as orgId from wanma.um_group 
where levelNo = 5;

truncate table wanma.wm_bas_truck_schedule;
truncate table wanma.wm_bas_truck;

drop table wanma.WM_BAS_CENTER;
drop table wanma.WM_BAS_CENTRE;

drop table wanma.wm_bas_vehicle;
drop table wanma.wm_bas_vehicle_schedule;

 */
@Entity
@Table(name = "VIEW_WM_CENTER")
@SequenceGenerator(name = "center_sequence", sequenceName = "center_sequence", initialValue = 1000, allocationSize = 10)
public class Center implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "center_sequence")
    private Long id;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 名称 */
    @Column(length = 128, nullable = false)
    private String name;
    
    private Long orgId; // 分公司ID

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

	public Serializable getPK() {
		return this.getId();
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
