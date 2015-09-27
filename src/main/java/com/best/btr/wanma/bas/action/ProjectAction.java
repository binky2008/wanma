package com.best.btr.wanma.bas.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.entity.ProjectAddress;
import com.best.btr.wanma.bas.service.ProjectService;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framwork.EasyUIDataGrid;

/**
 * @author Created by Hsian on 15/9/11.
 */
@Controller("ProjectAction")
@RequestMapping("/project")
public class ProjectAction {

    @Autowired private ProjectService service;
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Project getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }
    
    /**
     * 生成编码
     * @param siteCode
     * @return
     */
    @RequestMapping(value = "/getNewCode", method = RequestMethod.POST)
    @ResponseBody
    public String generateCustomerCode(Long siteId) {
        return service.generateCode(siteId);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Project save(Project project) {
    	if(project.getBusinessor().getId() == null) {
    		project.setBusinessor(null);
    	}
    	
        if (null == project.getId()) {
            service.create(project);
        } else {
            service.update(project);
        }
        return project;
    }

    /**
     * 删除信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
    @RequestMapping(value = "/disable/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void disable(@PathVariable Long id) {
        service.disable(id);
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public EasyUIDataGrid search(ProjectSO so, int page, int rows) {
        so.getPage().setPageNum(page);
        so.getPage().setPageSize(rows);
        PageInfo pageInfo = service.search(so);
        
        return new EasyUIDataGrid(pageInfo);
    }
    
    @RequestMapping(value = "/address/list/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectAddress> getAddressList(@PathVariable Long projectId) {
        return service.getAddressList(projectId);
    }
    
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectAddress getAddressById(@PathVariable Long id) {
        return service.getAddressById(id);
    }
    
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseBody
    public ProjectAddress saveAddress(ProjectAddress entity) {
        if (null == entity.getId()) {
            service.createAddress(entity);
        } else {
            service.updateAddress(entity);
        }
        return entity;
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }
    
    @RequestMapping(value = "/address/disable/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void disableAddress(@PathVariable Long id) {
        service.disableAddress(id);
    }
}
