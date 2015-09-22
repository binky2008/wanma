package com.best.btr.wanma.bas.dao.impl;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.bas.dao.ProjectDao;
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

}
