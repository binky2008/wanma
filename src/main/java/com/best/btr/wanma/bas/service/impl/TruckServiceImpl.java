package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.TruckDao;
import com.best.btr.wanma.bas.entity.Truck;
import com.best.btr.wanma.bas.service.TruckService;
import com.best.btr.wanma.bas.so.TruckSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("TruckService")
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckDao dao;

    @Override
    public Truck getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<Truck> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public Truck create(Truck entity) {
        return dao.create(entity);
    }

    @Override
    public Truck update(Truck entity) {
        return (Truck) dao.update(entity);
    }

    @Override
    public Truck delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(TruckSO so) {
        String hql = " from Truck o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
