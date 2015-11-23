package com.best.btr.wanma.system.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.system.AccountSO;
import com.best.btr.wanma.system.entity.Account;
import com.best.btr.wanma.system.service.AccountService;
import com.jinhe.tss.framework.EasyUIDataGrid;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

@Controller("AccountAction")
@RequestMapping("/account")
public class AccountAction {
 
    @Autowired private AccountService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Account getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account save(Account entity) {
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
    public Account delete(@PathVariable Long id) {
        return service.delete(id);
    }
    
    @RequestMapping("/query")
    @ResponseBody
    public EasyUIDataGrid search(HttpServletRequest request, AccountSO so, int page, int rows) {
    	so.getPage().setPageNum(page);
    	so.getPage().setPageSize(rows);
    	so.getOrderByFields().add("o.id desc");
    	
        PageInfo pi = service.search(so);
        
        return new EasyUIDataGrid(pi);
    }
}

