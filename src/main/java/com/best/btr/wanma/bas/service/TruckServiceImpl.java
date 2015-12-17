package com.best.btr.wanma.bas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.TruckDao;
import com.best.btr.wanma.bas.entity.Truck;
import com.best.btr.wanma.bas.so.TruckSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("TruckService")
public class TruckServiceImpl implements TruckService {

    @Autowired private TruckDao dao;
    
    public List<?> getListBySite(Long siteId) {
    	String hql = " from Truck o where o.ownerSite.id = ? ";
        return dao.getEntities(hql, siteId);
    }

    public Truck getEntityById(Long id) {
        return dao.getEntity(id);
    }

    public Truck create(Truck entity) {
        return dao.create(entity);
    }

    public Truck update(Truck entity) {
        return (Truck) dao.update(entity);
    }

    public Truck delete(Long id) {
        return dao.deleteById(id);
    }

    public PageInfo search(TruckSO so) {
        String hql = " from Truck o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
