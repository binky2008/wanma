package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.ProjectDao;
import com.best.btr.wanma.bas.entity.Project;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/11.
 */
@Repository("ProjectDao")
public class ProjectDaoImpl extends BaseDao<Project> implements ProjectDao {

    public ProjectDaoImpl() {
        super(Project.class);
    }

    @Override
    public Project getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> getAllEntities() {
        return (List<Project>) super.getEntities("from Project");
    }
}
