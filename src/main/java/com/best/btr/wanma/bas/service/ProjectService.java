package com.best.btr.wanma.bas.service;

import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

import java.util.List;

/**
 * @author Created by Lu on 15/9/11.
 */
public interface ProjectService {

    /**
     * 根据Id获取信息
     * @param id 唯一Id
     * @return
     */
    Project getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<Project> getAllEntities();

    /**
     * 创建信息
     * @param entity 需要创建的信息
     * @return
     */
    Project create(Project entity);

    /**
     * 更新信息
     * @param entity 需要更新的信息
     * @return
     */
    Project update(Project entity);

    /**
     * 根据Id删除信息
     * @param id
     * @return
     */
    Project delete(Long id);

    /**
     * 搜索信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(ProjectSO so);
}
