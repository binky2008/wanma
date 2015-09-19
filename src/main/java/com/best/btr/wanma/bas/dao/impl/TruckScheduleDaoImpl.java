package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.TruckScheduleDao;
import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/10.
 */
@Repository("TruckScheduleDao")
public class TruckScheduleDaoImpl extends BaseDao<TruckSchedule> implements TruckScheduleDao {

    public TruckScheduleDaoImpl() {
        super(TruckSchedule.class);
    }

    @Override
    public TruckSchedule getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TruckSchedule> getAllEntities() {
        return (List<TruckSchedule>) super.getEntities("from TruckSchedule");
    }
}
