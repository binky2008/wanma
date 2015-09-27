package com.best.btr.wanma.system.entity;

import com.jinhe.tss.framework.persistence.IEntity;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Created by Hsian on 15/9/14.
 */
@Entity
@Table(name = "WM_SYS_REGION")
@SequenceGenerator(name = "region_sequence", sequenceName = "region_sequence", initialValue = 47498, allocationSize = 10)
public class Region implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "region_sequence")
    @JsonProperty("i")
    private Long id;
    private Long code;
    private Long parentId;
    
    @JsonProperty("n")
    private String name;
    private Integer level;

    public Serializable getPK() {
        return this.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
