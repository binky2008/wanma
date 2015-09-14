package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.Project;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/11.
 */
public interface ProjectDao extends IDao<Project> {

    /**
     * 根据Id获取信息
     * @param id 唯一
     * @return
     */
    Project getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<Project> getAllEntities();
}
