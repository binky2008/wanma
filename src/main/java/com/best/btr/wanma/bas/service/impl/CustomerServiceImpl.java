package com.best.btr.wanma.bas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.btr.wanma.bas.dao.CustomerDao;
import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.service.CustomerService;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.best.btr.wanma.system.entity.Site;
import com.jinhe.dm.data.sqlquery.SQLExcutor;
import com.jinhe.dm.report.ReportService;
import com.jinhe.tss.framework.component.param.ParamConstants;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import com.jinhe.tss.framework.sso.context.Context;
import com.jinhe.tss.util.EasyUtils;

/**
 * @author Created by Lu on 15/8/31.
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerDao dao;
    @Autowired private ReportService reportService;

    public Customer getEntityById(Long id) {
        return dao.getEntity(id);
    }
    
    public void syncFromV5(Long reportId, boolean bySite) {
    	Map<String, String> paramsMap = new HashMap<String, String>();
    	
    	HttpSession session = Context.getRequestContext().getSession();
		Site site = (Site) session.getAttribute("SITE_INFO");    // site
		if(bySite && site != null) { // 按站点同步（一般是站点手动做同步）
			paramsMap.put("param1", site.getId().toString());
		}
		
		SQLExcutor ex = reportService.queryReport(reportId, paramsMap, 1, 1, -1);  
        int total = ex.count, pagesize = 10000;
        int totalPages = total / pagesize;
        if( total % pagesize > 0) {
        	totalPages = totalPages + 1;
        }
        
        // 分页查询，批量插入
        for(int pageNum = 1; pageNum <= totalPages; pageNum++) {
        	ex = reportService.queryReport(reportId, paramsMap, pageNum, pagesize, -1);
        	
        	for (Map<String, Object> row : ex.result) {
        		String code = (String) row.get("code");
        		Long siteId = EasyUtils.obj2Long( row.get("siteid") );
        		
        		// 检查客户号号是否已经存在
            	List<?> list = dao.getEntities("from Customer o where o.code = ? and o.ownerSite.id = ?", code, siteId);
            	if(list.size() > 0) {
            		continue;
            	}
            	
	        	Customer temp = new Customer();
				temp.setCode( code );
	        	temp.setName( (String) row.get("name") );
	        	temp.setOriginal( (String) row.get("origin") );
	        	temp.setContacts( (String) row.get("contacts") );
	        	temp.setAddress( (String) row.get("address") );
	        	temp.setPhone1( (String) row.get("phone1") );
	        	
	        	temp.setCustomerType("普通客户");
	        	temp.setSettleType("现付");
	        	temp.setOwnerSite( (Site) dao.getEntity(Site.class, siteId) );
	        	
	        	dao.createWithoutFlush(temp);
	        }
        	dao.flush();
        }
    }

    public Customer create(Customer entity) {
    	// 检查客户号号是否已经存在
    	List<?> list = dao.getEntities("from Customer o where o.code = ?", entity.getCode());
    	if(list.size() > 0) {
    		throw new BusinessException("相同客户号的客户记录已经存在。");
    	}
    	
        Integer seqNo = dao.getMaxSeqNo(entity.getOwnerSite().getId());
        entity.setSeqNo(seqNo);
        
        return dao.create(entity);
    }

    public Customer update(Customer entity) {
        return (Customer) dao.update(entity);
    }

    public Customer delete(Long id) {
        return dao.deleteById(id);
    }

    public PageInfo search(CustomerSO so) {
        String hql = " from Customer o where 1=1 " + so.toConditionString();

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }

    public String generateCode(Long siteId) {
        return dao.getCustomerCode(siteId);
    }

	public Customer disable(Long id) {
		Customer customer = dao.getEntity(id);
		customer.setDisabled(ParamConstants.TRUE);
		
		return update(customer);
	}
}
