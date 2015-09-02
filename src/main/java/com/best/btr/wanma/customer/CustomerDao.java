package com.best.btr.wanma.customer;

import com.jinhe.tss.framework.persistence.IDao;

import java.util.List;

/**
 * @author Created by Lu on 15/8/31.
 */
public interface CustomerDao extends IDao<Customer> {

    /**
     * 根据Id获取客户信息
     * @param id 唯一
     * @return
     */
    Customer getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<Customer> getAllEntities();
}
