package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.Vehicle;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface VehicleDao extends IDao<Vehicle> {

    /**
     * 根据Id获取客户信息
     * @param id 唯一
     * @return
     */
    Vehicle getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<Vehicle> getAllEntities();
}
