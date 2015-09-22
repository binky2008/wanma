package com.best.btr.wanma.bas.dao.impl;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.bas.dao.TruckScheduleDao;
import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.jinhe.tss.framework.persistence.BaseDao;

/**
 * @author Created by Lu on 15/9/10.
 */
@Repository("TruckScheduleDao")
public class TruckScheduleDaoImpl extends BaseDao<TruckSchedule> implements TruckScheduleDao {

    public TruckScheduleDaoImpl() {
        super(TruckSchedule.class);
    }

}
