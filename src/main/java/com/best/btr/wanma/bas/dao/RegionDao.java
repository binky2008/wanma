package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.Region;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/16.
 */
public interface RegionDao extends IDao<Region> {

    /**
     * 根据Id获取信息
     * @param id 唯一
     * @return
     */
    Region getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<Region> getAllEntities();

    List<Region> getEntityByParentId(Long parentId);
}
