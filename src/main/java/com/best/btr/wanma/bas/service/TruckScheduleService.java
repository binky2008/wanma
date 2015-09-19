package com.best.btr.wanma.bas.service;

import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.best.btr.wanma.bas.so.TruckScheduleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface TruckScheduleService {

    /**
     * 根据Id获取信息
     * @param id 唯一Id
     * @return
     */
    TruckSchedule getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<TruckSchedule> getAllEntities();

    /**
     * 创建信息
     * @param entity 需要创建的信息
     * @return
     */
    TruckSchedule create(TruckSchedule entity);

    /**
     * 更新信息
     * @param entity 需要更新的信息
     * @return
     */
    TruckSchedule update(TruckSchedule entity);

    /**
     * 根据Id删除信息
     * @param id
     * @return
     */
    TruckSchedule delete(Long id);

    /**
     * 搜索信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(TruckScheduleSO so);
}
