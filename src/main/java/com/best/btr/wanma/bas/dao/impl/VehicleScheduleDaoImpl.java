package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.VehicleScheduleDao;
import com.best.btr.wanma.bas.entity.VehicleSchedule;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/10.
 */
@Repository("VehicleScheduleDao")
public class VehicleScheduleDaoImpl extends BaseDao<VehicleSchedule> implements VehicleScheduleDao {

    public VehicleScheduleDaoImpl() {
        super(VehicleSchedule.class);
    }

    @Override
    public VehicleSchedule getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<VehicleSchedule> getAllEntities() {
        return (List<VehicleSchedule>) super.getEntities("from VehicleSchedule");
    }
}
