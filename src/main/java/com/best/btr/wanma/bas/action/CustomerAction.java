package com.best.btr.wanma.bas.action;

import com.best.btr.wanma.bas.entity.Customer;
import com.best.btr.wanma.bas.so.CustomerSO;
import com.best.btr.wanma.bas.service.CustomerService;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Created by Hsian on 15/8/31.
 */
@Controller("CustomerAction")
@RequestMapping("/customer")
public class CustomerAction {

    @Autowired
    private CustomerService service;

    /**
     * 获取所有的客户信息
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public List<Customer> getAllEntities() {
        return service.getAllEntities();
    }

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
    public Customer delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * 搜索客户信息
     * @param response
     * @param so
     * @param page
     * @return
     */
    @RequestMapping(value = "/{page}")
    @ResponseBody
    public List<?> search(HttpServletResponse response, CustomerSO so, @PathVariable int page) {
        so.getPage().setPageNum(page);
        PageInfo pageInfo = service.search(so);
        return pageInfo.getItems();
    }
}