package com.best.btr.wanma.bas.dao;

import org.springframework.stereotype.Repository;

import com.best.btr.wanma.bas.entity.Truck;
import com.jinhe.tss.framework.persistence.BaseDao;

/**
 * @author Created by Lu on 15/9/3.
 */
@Repository("TruckDao")
public class TruckDaoImpl extends BaseDao<Truck> implements TruckDao {

    public TruckDaoImpl() {
        super(Truck.class);
    }

}
