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
 * <p>网点实体</p>
 * <p>可以同步V5数据,需要的字段以后慢慢添加</p>
 * @author Created by Hsian on 15/9/11.
 * 
select  s.id id, s.code code, s.name name, s1.id PID, s1.code pcode, s1.name pname
from gt_site s,gt_site s1,data_site_age a
where s.parent_site_id=s1.id
and s.type<>110
and s.name not like '%同行%'
and s.name not like '%营业%'
and s.name not like '%项目%'
and s.status='ENABLE'
and s.id=a.site_id(+)

 */
@Entity
@Table(name = "WM_BAS_SITE")
@SequenceGenerator(name = "site_sequence", sequenceName = "site_sequence", initialValue = 1000, allocationSize = 10)
public class Site implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "site_sequence")
    private Long id;

    /** 编码 */
    @Column(length = 128, unique = true, nullable = false)
    private String code;

    /** 名称 */
    @Column(length = 128, nullable = false)
    private String name;

    /** 所属分拨中心 或 站点（如果记录是承包区的话） */
    private Long parentId;
    private String parentCode;
    private String parentName;
    
    /**
     * 是否为百世签约网点（看是否挂在分拨下）
     */
    public boolean isBestSite() {
    	return this.parentName != null && this.parentName.indexOf("分拨") > 0;
    }

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
