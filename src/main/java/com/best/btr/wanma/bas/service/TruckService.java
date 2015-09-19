package com.best.btr.wanma.bas.service;

import com.best.btr.wanma.bas.entity.Truck;
import com.best.btr.wanma.bas.so.TruckSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
public interface TruckService {

    /**
     * 根据Id获取信息
     * @param id 唯一Id
     * @return
     */
    Truck getEntityById(Long id);

    /**
     * 获取所有的信息
     * @return
     */
    List<Truck> getAllEntities();

    /**
     * 创建信息
     * @param entity 需要创建的信息
     * @return
     */
    Truck create(Truck entity);

    /**
     * 更新信息
     * @param entity 需要更新的信息
     * @return
     */
    Truck update(Truck entity);

    /**
     * 根据Id删除信息
     * @param id
     * @return
     */
    Truck delete(Long id);

    /**
     * 搜索信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(TruckSO so);
}
