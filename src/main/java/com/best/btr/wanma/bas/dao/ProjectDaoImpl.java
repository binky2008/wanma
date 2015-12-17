package com.best.btr.wanma.bas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.bas.entity.Project;
import com.jinhe.tss.framework.persistence.BaseDao;

/**
 * @author Created by Lu on 15/9/11.
 */
@Repository("ProjectDao")
public class ProjectDaoImpl extends BaseDao<Project> implements ProjectDao {

    public ProjectDaoImpl() {
        super(Project.class);
    }
    
    public Integer getMaxSeqNo(Long siteId) {
    	String hql = "select max(o.seqNo) from Project o where o.ownerSite.id = ?";
        List<?> list = getEntities(hql, siteId); 
        Integer seqNo = (!list.isEmpty() && list.get(0) != null) ? (Integer) list.get(0) + 1 : 1;

        return seqNo;
    }

}
