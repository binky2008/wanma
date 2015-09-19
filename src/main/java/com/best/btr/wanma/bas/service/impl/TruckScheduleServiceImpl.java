package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.TruckScheduleDao;
import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.best.btr.wanma.bas.service.TruckScheduleService;
import com.best.btr.wanma.bas.so.TruckScheduleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("VehicleScheduleService")
public class TruckScheduleServiceImpl implements TruckScheduleService {

    @Autowired
    private TruckScheduleDao dao;

    @Override
    public TruckSchedule getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<TruckSchedule> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public TruckSchedule create(TruckSchedule entity) {
        return dao.create(entity);
    }

    @Override
    public TruckSchedule update(TruckSchedule entity) {
        return (TruckSchedule) dao.update(entity);
    }

    @Override
    public TruckSchedule delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(TruckScheduleSO so) {
        String hql = " from TruckSchedule o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
