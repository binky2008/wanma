package com.best.btr.wanma.bas.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.best.btr.wanma.bas.service.TruckScheduleService;
import com.best.btr.wanma.bas.so.TruckScheduleSO;
import com.jinhe.tss.framework.EasyUIDataGrid;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;

/**
 * @author Created by Hsian on 15/9/3.
 */
@Controller("TruckScheduleAction")
@RequestMapping("/truckschedule")
public class TruckScheduleAction {

    @Autowired
    private TruckScheduleService service;
    
    @RequestMapping(value = "/list/{siteId}", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getListBySite(@PathVariable Long siteId) {
    	return service.getListBySite(siteId);
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TruckSchedule getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TruckSchedule save(TruckSchedule entity) {
        if (null == entity.getId()) {
            service.create(entity);
        } else {
            service.update(entity);
        }
        return entity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public EasyUIDataGrid search(TruckScheduleSO so, int page, int rows) {
        so.getPage().setPageNum(page);
        so.getPage().setPageSize(rows);

        PageInfo pageInfo = service.search(so);
        return new EasyUIDataGrid(pageInfo);
    }
}
