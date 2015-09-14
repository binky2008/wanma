package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.VehicleScheduleDao;
import com.best.btr.wanma.bas.entity.VehicleSchedule;
import com.best.btr.wanma.bas.service.VehicleScheduleService;
import com.best.btr.wanma.bas.so.VehicleScheduleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("VehicleScheduleService")
public class VehicleScheduleServiceImpl implements VehicleScheduleService {

    @Autowired
    private VehicleScheduleDao dao;

    @Override
    public VehicleSchedule getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<VehicleSchedule> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public VehicleSchedule create(VehicleSchedule entity) {
        return dao.create(entity);
    }

    @Override
    public VehicleSchedule update(VehicleSchedule entity) {
        return (VehicleSchedule) dao.update(entity);
    }

    @Override
    public VehicleSchedule delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(VehicleScheduleSO so) {
        String hql = " from VehicleSchedule o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
