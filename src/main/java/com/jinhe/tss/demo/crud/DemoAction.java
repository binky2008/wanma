package com.jinhe.tss.demo.crud;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framwork.EasyUIDataGrid;

@Controller("DemoAction")
@RequestMapping("/demo")
public class DemoAction {
 
    @Autowired private DemoService service;
 
    @RequestMapping("/")
    @ResponseBody
    public List<DemoEntity> getAllEntities() {
        return service.getAllEntities();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DemoEntity getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public DemoEntity save(DemoEntity entity) {
    	if(entity.getId() == null) {
    		service.create(entity);
    	}
    	else {
    		service.update(entity);
    	}
        return entity;
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DemoEntity delete(@PathVariable Long id) {
        return service.delete(id);
    }
    
    @RequestMapping("/query")
    @ResponseBody
    public EasyUIDataGrid search(HttpServletResponse response, DemoSO so, int page, int rows) {
    	so.getPage().setPageNum(page);
    	so.getPage().setPageSize(rows);
    	
        PageInfo pi = service.search(so);
        
        return new EasyUIDataGrid(pi);
    }
}

