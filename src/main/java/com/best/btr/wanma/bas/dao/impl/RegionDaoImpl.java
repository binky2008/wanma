package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.RegionDao;
import com.best.btr.wanma.bas.entity.Region;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/16.
 */
@Repository("RegionDao")
public class RegionDaoImpl extends BaseDao<Region> implements RegionDao {

    public RegionDaoImpl() {
        super(Region.class);
    }

    @Override
    public Region getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Region> getAllEntities() {
        return (List<Region>) super.getEntities("from Region");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Region> getEntityByParentId(Long parentId) {
        return (List<Region>) super.getEntities("from Region r where r.parentId = ?", parentId);
    }
}
