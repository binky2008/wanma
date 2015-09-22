package com.best.btr.wanma.bas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.TruckScheduleDao;
import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.best.btr.wanma.bas.service.TruckScheduleService;
import com.best.btr.wanma.bas.so.TruckScheduleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("VehicleScheduleService")
public class TruckScheduleServiceImpl implements TruckScheduleService {

    @Autowired private TruckScheduleDao dao;

    public TruckSchedule getEntityById(Long id) {
        return dao.getEntity(id);
    }

    public TruckSchedule create(TruckSchedule entity) {
        return dao.create(entity);
    }

    public TruckSchedule update(TruckSchedule entity) {
        return (TruckSchedule) dao.update(entity);
    }

    public TruckSchedule delete(Long id) {
        return dao.deleteById(id);
    }

    public PageInfo search(TruckScheduleSO so) {
        String hql = " from TruckSchedule o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
