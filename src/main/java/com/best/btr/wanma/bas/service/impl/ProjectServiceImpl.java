package com.best.btr.wanma.bas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.dao.ProjectDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.entity.ProjectAddress;
import com.best.btr.wanma.bas.service.ProjectService;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.tss.framework.component.param.ParamConstants;
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
        Integer seqNo = dao.getMaxSeqNo(entity.getOwnerSite().getId());
        entity.setSeqNo(seqNo);

        return dao.create(entity);
    }

    public Project update(Project entity) {
    	if(entity.getSeqNo() == null) {
    		Integer seqNo = dao.getMaxSeqNo(entity.getOwnerSite().getId());
            entity.setSeqNo(seqNo);
    	}
        
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
		Customer customer = customerDao.getEntity( entity.getCustomer().getId() );
		customer.setAddress(entity.getAddress());
		customer.setPhone1(entity.getPhone());
		customer.setContacts(entity.getContacts());
		
		// TODO 如果修改时，代取件网点变了，是新增一条客户信息？还是直接修改对应之前网点的客户信息
		Site ownerSite = entity.getOwnerSite();
		if( !ownerSite.equals( customer.getOwnerSite()) ) {
			customer.setOwnerSite(ownerSite);
			customer.setCode(customerDao.getCustomerCode(ownerSite.getId()));
		}
		
		customerDao.update(customer);
	}

	public void createAddress(ProjectAddress entity) {
		entity.setCustomer(null);
		dao.createObject(entity);
		
		Project project = entity.getProject();
		
		// 创建一条客户记录
		Customer customer = new Customer();
		customer.setAddress(entity.getAddress());
		Site ownerSite = entity.getOwnerSite();
		customer.setOwnerSite(ownerSite);
		customer.setCode(customerDao.getCustomerCode(ownerSite.getId()));
		
		customer.setPhone1(entity.getPhone());
		customer.setName(entity.getCustomerName());
		customer.setContacts(entity.getContacts());
		
		customer.setFullName(project.getFullName());
		customer.setOriginal(ownerSite.getName()); // 来源为代取件网点
		
		customer.setSettleType(project.getSettleType());
		customer.setCustomerType("项目客户");
		
		Integer seqNo = customerDao.getMaxSeqNo(entity.getOwnerSite().getId());
		customer.setSeqNo(seqNo);
        
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

	public String generateCode(Long siteId) {
		String siteCode = ((Site) dao.getEntity(Site.class, siteId)).getCode() + "-P";

		Integer seqNo = dao.getMaxSeqNo(siteId);
        if(seqNo < 10) {
        	return siteCode + "00" + seqNo;
        }
        if(seqNo < 100) {
        	return siteCode + "0" + seqNo;
        }
        return siteCode + seqNo;
	}

	public void disable(Long id) {
		Project project = dao.getEntity(id);
		project.setDisabled(ParamConstants.TRUE);
		
		dao.update(project);
	}

	public void disableAddress(Long id) {
		ProjectAddress address = getAddressById(id);
		address.setDisabled(ParamConstants.TRUE);
		
		dao.update(address);
		
		Customer customer = address.getCustomer();
		customer.setDisabled(ParamConstants.TRUE);
		
		customerDao.update(customer);
	}
}
