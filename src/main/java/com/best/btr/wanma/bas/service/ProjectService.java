package com.best.btr.wanma.bas.service;

import java.util.List;

import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.entity.ProjectAddress;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

/**
 * @author Created by Lu on 15/9/11.
 */
public interface ProjectService {

    /**
     * 根据Id获取
     */
    Project getEntityById(Long id);

    /**
     * 创建
     */
    Project create(Project entity);

    /**
     * 更新
     */
    Project update(Project entity);

    /**
     * 根据Id删除
     */
    Project delete(Long id);

    /**
     * 搜索
     * 
     * @param so 搜索条件
     * @return
     */
    PageInfo search(ProjectSO so);

	ProjectAddress deleteAddress(Long id);

	void updateAddress(ProjectAddress entity);

	void createAddress(ProjectAddress entity);

	ProjectAddress getAddressById(Long id);

	List<ProjectAddress> getAddressList(Long projectId);
}
