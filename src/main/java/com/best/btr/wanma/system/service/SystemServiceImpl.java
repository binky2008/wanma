package com.best.btr.wanma.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.system.entity.Center;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.dm.DMConstants;
import com.jinhe.dm.data.sqlquery.SQLExcutor;
import com.jinhe.dm.report.ReportService;
import com.jinhe.tss.framework.persistence.ICommonDao;
import com.jinhe.tss.framework.persistence.IEntity;
import com.jinhe.tss.um.entity.Group;
import com.jinhe.tss.util.EasyUtils;

/**
 * @author Created by Lu on 15/9/16.
 */
@Service("SystemService")
public class SystemServiceImpl implements SystemService {

    @Autowired private ICommonDao dao;
    @Autowired private ReportService reportService;

	public List<?> getRegions(Long zoneId) {
    	return dao.getEntities("from Region r where r.parentId = ?", zoneId);
    }
	
	public Center getCenterBySite(Site site) {
		Object centerId = null;
    	if( site.isBestSite() ) {
    		centerId = site.getParentCode(); 
    	}
    	else {
    		site = (Site) dao.getEntity(Site.class, site.getParentId() );
    		if(site != null) {
    			centerId = site.getParentCode();
    		}
    	}
    	
    	if(centerId != null) {
    		return (Center) dao.getEntity(Center.class, EasyUtils.obj2Long(centerId) );
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

	// 693
	public void syncSiteFromV5(Long reportId) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		SQLExcutor ex = reportService.queryReport(reportId, paramsMap, 1, 50000, -1);
		
		String insertSQL = " insert WM_BAS_SITE (id,code,name,pid,pcode,pname) values (?, ?, ?, ?, ?, ?)";
		List<Map<Integer, Object>> paramsList = new ArrayList<Map<Integer,Object>>();
		
    	for (Map<String, Object> row : ex.result) {
    		String code = (String) row.get("code");
    		
        	List<?> list = dao.getEntities("from Site o where o.code = ? ", code);
        	if(list.size() > 0) {
        		continue;
        	}
        	
        	Long id = EasyUtils.obj2Long( row.get("id") );
        	Long pid = EasyUtils.obj2Long( row.get("pid") );
        	String name = (String) row.get("name");
        	String pcode = (String) row.get("pcode");
        	String pname = (String) row.get("pname");
        	
        	Map<Integer, Object> tempMap = new HashMap<Integer, Object>();
        	tempMap.put(1, id);
        	tempMap.put(2, code);
        	tempMap.put(3, name);
        	tempMap.put(4, pid);
        	tempMap.put(5, pcode);
        	tempMap.put(6, pname);
        	
			paramsList.add(tempMap);
        }
    	
		SQLExcutor.excuteBatch(insertSQL, paramsList, DMConstants.LOCAL_CONN_POOL);
    }
		
	
}
