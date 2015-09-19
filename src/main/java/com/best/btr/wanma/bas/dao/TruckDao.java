package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.Truck;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface TruckDao extends IDao<Truck> {

    /**
     * 根据Id获取信息
     * @param id 唯一
     * @return
     */
    Truck getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<Truck> getAllEntities();
}
