package com.best.btr.wanma.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.system.entity.Center;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.framework.persistence.ICommonDao;
import com.jinhe.tss.framework.persistence.IEntity;
import com.jinhe.tss.um.entity.Group;

/**
 * @author Created by Lu on 15/9/16.
 */
@Service("SystemService")
public class SystemServiceImpl implements SystemService {

    @Autowired private ICommonDao dao;

	public List<?> getRegions(Long zoneId) {
    	return dao.getEntities("from Region r where r.parentId = ?", zoneId);
    }
	
	public Center getCenterBySite(Site site) {
		Long centerId = null;
    	if( site.isBestSite() ) {
    		centerId = site.getParentId(); 
    	}
    	else {
    		site = (Site) dao.getEntity(Site.class, site.getParentId() );
    		if(site != null) {
    			centerId = site.getParentId();
    		}
    	}
    	
    	if(centerId != null) {
    		return (Center) dao.getEntity(Center.class, centerId );
    	}
    	return null;
	}

	public Group getGroupBySite(Site site) {
		Center center = getCenterBySite(site);
		List<Object> list = new ArrayList<Object>();
		if(center != null) {
			list.addAll(dao.getEntities(" from Group where fromGroupId = ?", center.getId().toString() ));
			list.addAll(dao.getEntities(" from Group where name = ?", "百世快运" ));
		}
		return (Group) list.get(0);
	}
	
	public IEntity getEntity(Class<?> clazz, Long id) {
		return dao.getEntity(clazz, id);
	}

	public List<?> getSites(Long id) {
		String hql = " from Site ";
		if(id.longValue() > 0) {
			hql += " where id=" + id;
		}
		return dao.getEntities(hql);
	}

}
