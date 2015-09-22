package com.best.btr.wanma.bas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.dao.ProjectDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.entity.ProjectAddress;
import com.best.btr.wanma.bas.entity.Site;
import com.best.btr.wanma.bas.service.ProjectService;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;

/**
 * @author Created by Lu on 15/9/11.
 */
@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired private ProjectDao dao;
    @Autowired private CustomerDao customerDao;

    public Project getEntityById(Long id) {
        return dao.getEntity(id);
    }

    public Project create(Project entity) {
        return dao.create(entity);
    }

    public Project update(Project entity) {
        return (Project) dao.update(entity);
    }

    public Project delete(Long id) {
        return dao.deleteById(id);
    }

    public PageInfo search(ProjectSO so) {
        String hql = " from Project o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }

	public ProjectAddress deleteAddress(Long id) {
		ProjectAddress address = getAddressById(id);
		
		dao.delete(address.getCustomer());
		dao.delete(address);
		return address;
	}

	public void updateAddress(ProjectAddress entity) {
		entity = (ProjectAddress) dao.update(entity);
		
		// 同时修改对应该地址客户记录
		Customer customer = entity.getCustomer();
		customer.setAddress(entity.getAddress());
		customer.setPhone1(entity.getPhone());
		customer.setContacts(entity.getContacts());
		
		// TODO 如果修改时，代取件网点变了，是新增一条客户信息？还是直接修改对应之前网点的客户信息
		Site ownerSite = entity.getOwnerSite();
		if( !ownerSite.equals(customer.getOwnerSite()) ) {
			customer.setOwnerSite(ownerSite);
			customer.setCode(customerDao.getCustomerCode(ownerSite.getId()));
			customer.setOriginal(ownerSite.getName()); // 来源为代取件网点
		}
		
		customerDao.update(customer);
	}

	public void createAddress(ProjectAddress entity) {
		dao.createObject(entity);
		
		Project project = entity.getProject();
		
		// 创建一条客户记录
		Customer customer = new Customer();
		customer.setAddress(entity.getAddress());
		// customer.setBusinessor(project.getBusinessor());
		Site ownerSite = entity.getOwnerSite();
		customer.setOwnerSite(ownerSite);
		customer.setCode(customerDao.getCustomerCode(ownerSite.getId()));
		
		customer.setPhone1(entity.getPhone());
		customer.setName(project.getName());
		customer.setContacts(entity.getContacts());
		
		customer.setFullName(project.getFullName());
		customer.setOriginal(ownerSite.getName()); // 来源为代取件网点
		
		customer = customerDao.create(customer);
		
		entity.setCustomer(customer);
		dao.update(entity);
	}

	public ProjectAddress getAddressById(Long id) {
		return (ProjectAddress) dao.getEntity(ProjectAddress.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ProjectAddress> getAddressList(Long projectId) {
		String hql = "from ProjectAddress o where o.project.id = ?";
		return (List<ProjectAddress>) dao.getEntities(hql, projectId);
	}
}
