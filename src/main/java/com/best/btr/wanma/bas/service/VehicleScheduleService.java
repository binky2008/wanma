package com.best.btr.wanma.bas.service;

import com.best.btr.wanma.bas.entity.VehicleSchedule;
import com.best.btr.wanma.bas.so.VehicleScheduleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface VehicleScheduleService {

    /**
     * 根据Id获取客户信息
     * @param id 唯一Id
     * @return
     */
    VehicleSchedule getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<VehicleSchedule> getAllEntities();

    /**
     * 创建客户信息
     * @param entity 需要创建的客户信息
     * @return
     */
    VehicleSchedule create(VehicleSchedule entity);

    /**
     * 更新客户信息
     * @param entity 需要更新的客户信息
     * @return
     */
    VehicleSchedule update(VehicleSchedule entity);

    /**
     * 根据Id删除客户信息
     * @param id
     * @return
     */
    VehicleSchedule delete(Long id);

    /**
     * 搜索客户信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(VehicleScheduleSO so);
}
