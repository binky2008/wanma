package com.best.btr.wanma.bas.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.service.CustomerService;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framwork.EasyUIDataGrid;

/**
 * @author Created by Hsian on 15/8/31.
 */
@Controller("CustomerAction")
@RequestMapping("/customer")
public class CustomerAction {

    @Autowired private CustomerService service;

    /**
     * 根据Id获取客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getEntityById(@PathVariable Long id) {
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

    /**
     * 更新客户信息，包括新增与修改。
     * 如果Id为空新增，否则修改。
     *
     * @param customer 需要更新的客户
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Customer save(Customer customer) {
        if (null == customer.getId()) {
        	customer.setCustomerType("普通客户");
            service.create(customer);
        } else {
            service.update(customer);
        }
        return customer;
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
    
    @RequestMapping(value = "/disable/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void disable(@PathVariable Long id) {
        service.disable(id);
    }

    /**
     * 搜索客户信息
     * @param so
     * @param page
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public EasyUIDataGrid search(CustomerSO so, int page, int rows) {
        so.getPage().setPageNum(page);
        so.getPage().setPageSize(rows);
        PageInfo pageInfo = service.search(so);
        return new EasyUIDataGrid(pageInfo);
    }
}
