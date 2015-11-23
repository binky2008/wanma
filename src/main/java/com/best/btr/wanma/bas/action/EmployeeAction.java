package com.best.btr.wanma.bas.action;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.service.EmployeeService;
import com.best.btr.wanma.bas.so.EmployeeSO;
import com.jinhe.tss.framework.EasyUIDataGrid;
import com.jinhe.tss.framework.exception.BusinessException;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.sso.context.Context;

/**
 * @author Created by Hsian on 15/9/3.
 */
@Controller("EmployeeAction")
@RequestMapping("/employee")
public class EmployeeAction {

    @Autowired private EmployeeService service;

    /**
     * 根据Id获取客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEntityById(@PathVariable Long id) {
        Employee entity = service.getEntityById(id);
        entity.setPassword("111111111111111111111111111111");
		return entity;
    }
    
    @RequestMapping(value = "/site/{siteId}", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getEmployeesBySite(@PathVariable Long siteId) {
    	return service.getEmployeesBySite(siteId);
    }

    /**
     * 更新客户信息，包括新增与修改。
     * 如果Id为空新增，否则修改。
     *
     * @param employee 需要更新的客户
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Employee save(Employee employee) {
        if (null == employee.getId()) {
        	// 检查验证码是否匹配
        	Object ackInSession = Context.getRequestContext().getSession().getAttribute("ack");
        	Integer ackInput = employee.getAck();
        	if(ackInput > 0 && !ackInput.equals(ackInSession) ) {
        		// 验证码不匹配则抛出异常
        		throw new BusinessException("验证码错误，请重新输入。");
        	}
        	
            service.create(employee);
        } else {
            service.update(employee);
        }
        return employee;
    }
    
    @RequestMapping(value = "/ack", method = RequestMethod.POST)
    @ResponseBody
    public Object getACK(String mobile) {
    	int ack = new Random().nextInt(900000) + 100000;
    	Context.getRequestContext().getSession().setAttribute("ack", ack);
    	
    	// TODO 往参数指定的手机号码发送验证码短信
    	
    	return "success";
    }

    /**
     * 删除客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    /**
     * 搜索客户信息
     * @param response
     * @param so
     * @param page
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public EasyUIDataGrid search(EmployeeSO so, int page, int rows) {
        so.getPage().setPageNum(page);
        so.getPage().setPageSize(rows);
        
        PageInfo pi = service.search(so);
        return new EasyUIDataGrid(pi);
    }
}
