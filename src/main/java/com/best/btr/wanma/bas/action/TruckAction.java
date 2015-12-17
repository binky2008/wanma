package com.best.btr.wanma.bas.action;

import com.best.btr.wanma.bas.entity.Truck;
import com.best.btr.wanma.bas.service.TruckService;
import com.best.btr.wanma.bas.so.TruckSO;
import com.jinhe.tss.framework.EasyUIDataGrid;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author Created by Hsian on 15/9/3.
 */
@Controller("TruckAction")
@RequestMapping("/truck")
public class TruckAction {

    @Autowired
    private TruckService service;
    
    @RequestMapping(value = "/list/{siteId}", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getListBySite(@PathVariable Long siteId) {
    	return service.getListBySite(siteId);
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Truck getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Truck save(Truck truck) {
        // 设定更新时间
        truck.setUpdateTime(new Date());

        if (null == truck.getId()) {
            service.create(truck);
        } else {
            service.update(truck);
        }
        return truck;
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
 
    @RequestMapping(value = "/query")
    @ResponseBody
    public EasyUIDataGrid search(TruckSO so, int page, int rows) {
        so.getPage().setPageNum(page);
        so.getPage().setPageSize(rows);
        PageInfo pageInfo = service.search(so);
        return new EasyUIDataGrid(pageInfo);
    }
}
