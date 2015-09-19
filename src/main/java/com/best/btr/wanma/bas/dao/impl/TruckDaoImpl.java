package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.TruckDao;
import com.best.btr.wanma.bas.entity.Truck;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Repository("TruckDao")
public class TruckDaoImpl extends BaseDao<Truck> implements TruckDao {

    public TruckDaoImpl() {
        super(Truck.class);
    }

    @Override
    public Truck getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Truck> getAllEntities() {
        return (List<Truck>) super.getEntities("from Truck");
    }
}
