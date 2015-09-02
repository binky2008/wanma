package com.best.btr.wanma.customer;

import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

import java.util.List;

/**
 * @author Created by Lu on 15/8/31.
 */
public interface CustomerService {

    /**
     * 根据Id获取客户信息
     * @param id 唯一Id
     * @return
     */
    Customer getEntityById(Long id);

    /**
     * 获取所有的客户信息
     * @return
     */
    List<Customer> getAllEntities();

    /**
     * 创建客户信息
     * @param entity 需要创建的客户信息
     * @return
     */
    Customer create(Customer entity);

    /**
     * 更新客户信息
     * @param entity 需要更新的客户信息
     * @return
     */
    Customer update(Customer entity);

    /**
     * 根据Id删除客户信息
     * @param id
     * @return
     */
    Customer delete(Long id);

    /**
     * 搜索客户信息
     * @param so 搜索条件
     * @return
     */
    PageInfo search(CustomerSO so);
}
