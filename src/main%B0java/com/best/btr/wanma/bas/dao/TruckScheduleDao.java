package com.best.btr.wanma.bas.dao;

import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/9/10.
 */
public interface TruckScheduleDao extends IDao<TruckSchedule> {

    /**
     * 根据Id获取信息
     * @param id 唯一
     * @return
     */
    TruckSchedule getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<TruckSchedule> getAllEntities();
}