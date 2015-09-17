package com.best.btr.wanma.system.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.system.UserSO;
import com.best.btr.wanma.system.entity.User;
import com.best.btr.wanma.system.service.UserService;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framwork.EasyUIDataGrid;

@Controller("UserAction")
@RequestMapping("/user")
public class UserAction {
 
    @Autowired private UserService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User save(User entity) {
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
    public User delete(@PathVariable Long id) {
        return service.delete(id);
    }
    
    @RequestMapping("/query")
    @ResponseBody
    public EasyUIDataGrid search(UserSO so, int page, int rows) {
    	so.getPage().setPageNum(page);
    	so.getPage().setPageSize(rows);
    	
        PageInfo pi = service.search(so);
        
        return new EasyUIDataGrid(pi);
    }
}

