package com.best.btr.wanma.bas.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.bas.entity.TruckSchedule;
import com.best.btr.wanma.bas.service.TruckScheduleService;
import com.best.btr.wanma.bas.so.TruckScheduleSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framwork.EasyUIDataGrid;

/**
 * @author Created by Hsian on 15/9/3.
 */
@Controller("TruckScheduleAction")
@RequestMapping("/truckschedule")
public class TruckScheduleAction {

    @Autowired
    private TruckScheduleService service;
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TruckSchedule getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TruckSchedule save(TruckSchedule truckSchedule) {
        /*
         * TODO 1 根据车型和到岗时间生成班次号
         * TODO 3 生效日期在保存或者修改是都要当前时间到48小时后生效.
         */

        if (null == truckSchedule.getId()) {
            service.create(truckSchedule);
        } else {
            service.update(truckSchedule);
        }
        return truckSchedule;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public TruckSchedule delete(@PathVariable Long id) {
        return service.delete(id);
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
