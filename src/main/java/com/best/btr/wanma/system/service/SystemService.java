package com.best.btr.wanma.system.service;

import java.util.List;

import com.best.btr.wanma.system.entity.Center;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.framework.component.cache.Cached;
import com.jinhe.tss.framework.persistence.IEntity;
import com.jinhe.tss.um.entity.Group;

/**
 * @author Created by Lu on 15/9/16.
 */
public interface SystemService {

    /**
     * 获取街道信息
     * @param zoneId
     * @return
     */
	@Cached
    List<?> getRegions(Long zoneId);
    
    Group getGroupBySite(Site site);
    
    Center getCenterBySite(Site site);
    
    IEntity getEntity(Class<?> clazz, Long id);

    @Cached
	List<?> getSites(Long id);

	void syncSiteFromV5(Long reportId);
}
