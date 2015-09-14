package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.ProjectDao;
import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.service.ProjectService;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/11.
 */
@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao dao;

    @Override
    public Project getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<Project> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public Project create(Project entity) {
        return dao.create(entity);
    }

    @Override
    public Project update(Project entity) {
        return (Project) dao.update(entity);
    }

    @Override
    public Project delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(ProjectSO so) {
        String hql = " from Project o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
