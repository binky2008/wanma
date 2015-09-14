package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.VehicleSchedule;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/10.
 */
public interface VehicleScheduleDao extends IDao<VehicleSchedule> {

    /**
     * 根据Id获取客户信息
     * @param id 唯一
     * @return
     */
    VehicleSchedule getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<VehicleSchedule> getAllEntities();
}
