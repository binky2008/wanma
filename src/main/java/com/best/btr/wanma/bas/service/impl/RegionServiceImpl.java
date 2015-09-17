package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.RegionDao;
import com.best.btr.wanma.bas.entity.Region;
import com.best.btr.wanma.bas.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/16.
 */
@Service("RegionService")
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao dao;

    @Override
    public Region getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<Region> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public Region create(Region entity) {
        return dao.create(entity);
    }

    @Override
    public Region update(Region entity) {
        return (Region) dao.update(entity);
    }

    @Override
    public List<Region> getEntityByParentId(Long parentId) {
        return dao.getEntityByParentId(parentId);
    }

}
