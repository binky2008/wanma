package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.VehicleDao;
import com.best.btr.wanma.bas.entity.Vehicle;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Repository("VehicleDao")
public class VehicleDaoImpl extends BaseDao<Vehicle> implements VehicleDao {

    public VehicleDaoImpl() {
        super(Vehicle.class);
    }

    @Override
    public Vehicle getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vehicle> getAllEntities() {
        return (List<Vehicle>) super.getEntities("from Vehicle");
    }
}
