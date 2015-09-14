package com.best.btr.wanma.user.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.user.UserSO;
import com.best.btr.wanma.user.entiy.User;
import com.best.btr.wanma.user.service.UserService;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

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
    
    @RequestMapping("/{page}")
    @ResponseBody
    public List<?> search(HttpServletResponse response, UserSO so, @PathVariable int page) {
    	so.getPage().setPageNum(page);
        PageInfo pageResult = service.search(so);
        
        return pageResult.getItems();
    }
}

