package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.VehicleDao;
import com.best.btr.wanma.bas.entity.Vehicle;
import com.best.btr.wanma.bas.service.VehicleService;
import com.best.btr.wanma.bas.so.VehicleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao dao;

    @Override
    public Vehicle getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<Vehicle> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public Vehicle create(Vehicle entity) {
        return dao.create(entity);
    }

    @Override
    public Vehicle update(Vehicle entity) {
        return (Vehicle) dao.update(entity);
    }

    @Override
    public Vehicle delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(VehicleSO so) {
        String hql = " from Vehicle o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
