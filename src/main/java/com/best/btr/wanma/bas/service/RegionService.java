package com.best.btr.wanma.bas.service;

import com.best.btr.wanma.bas.entity.Region;

import java.util.List;

/**
 * @author Created by Lu on 15/9/16.
 */
public interface RegionService {

    /**
     * 根据Id获取信息
     * @param id 唯一Id
     * @return
     */
    Region getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<Region> getAllEntities();

    /**
     * 创建信息
     * @param entity 需要创建的信息
     * @return
     */
    Region create(Region entity);

    /**
     * 更新信息
     * @param entity 需要更新的信息
     * @return
     */
    Region update(Region entity);

    /**
     * 根据父Id获取子集.
     * @param parentId
     * @return
     */
    List<Region> getEntityByParentId(Long parentId);

}
