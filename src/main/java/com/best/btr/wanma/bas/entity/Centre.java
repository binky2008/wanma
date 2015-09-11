package com.best.btr.wanma.bas.entity;

import com.jinhe.tss.framework.component.param.Param;

import javax.persistence.*;

/**
 * <p>分拨实体</p>
 * <p>可以同步V5数据,需要的字段以后慢慢添加</p>
 * @author Created by Hsian on 15/9/11.
 */
@Entity
@Table(name = "WM_BAS_CENTRE")
@SequenceGenerator(name = "centre_sequence", sequenceName = "centre_sequence", initialValue = 1000, allocationSize = 10)
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "centre_sequence")
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
}
