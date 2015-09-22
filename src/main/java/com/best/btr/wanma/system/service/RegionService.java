package com.best.btr.wanma.system.service;

import com.best.btr.wanma.system.entity.Region;

import java.util.List;

/**
 * @author Created by Lu on 15/9/16.
 */
public interface RegionService {

    /**
     * 根据父Id获取子集.
     * @param parentId
     * @return
     */
    List<Region> getEntityByParentId(Long parentId);

}
