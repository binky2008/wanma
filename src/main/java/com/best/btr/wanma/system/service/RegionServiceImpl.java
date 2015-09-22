package com.best.btr.wanma.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.system.entity.Region;
import com.jinhe.tss.framework.persistence.ICommonDao;

/**
 * @author Created by Lu on 15/9/16.
 */
@Service("RegionService")
public class RegionServiceImpl implements RegionService {

    @Autowired private ICommonDao dao;

    @SuppressWarnings("unchecked")
	public List<Region> getEntityByParentId(Long parentId) {
    	return (List<Region>) dao.getEntities("from Region r where r.parentId = ?", parentId);
    }

}
