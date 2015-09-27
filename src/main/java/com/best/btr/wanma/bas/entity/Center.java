package com.best.btr.wanma.bas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.persistence.IEntity;

/**
 * <p>分拨实体</p>
 * <p>可以同步V5数据,需要的字段以后慢慢添加</p>
 * @author Created by Hsian on 15/9/11.
 */
@Entity
@Table(name = "WM_BAS_CENTER")
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

    /** 状态 */
    @ManyToOne
    private Param state;

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

    public Param getState() {
        return state;
    }

    public void setState(Param state) {
        this.state = state;
    }

	public Serializable getPK() {
		return this.getId();
	}
}
