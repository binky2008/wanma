package com.best.btr.wanma.bas.action;

import com.best.btr.wanma.bas.entity.Truck;
import com.best.btr.wanma.bas.service.TruckService;
import com.best.btr.wanma.bas.so.TruckSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framwork.EasyUIDataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Created by Hsian on 15/9/3.
 */
@Controller("TruckAction")
@RequestMapping("/truck")
public class TruckAction {

    @Autowired
    private TruckService service;

    /**
     * 根据Id获取信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Truck getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    /**
     * 更新信息，包括新增与修改。
     * 如果Id为空新增，否则修改。
     *
     * @param truck 需要更新的
     * @return
     */
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

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Truck delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * 搜索信息
     *
     * @param so
     * @param page
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public EasyUIDataGrid search(TruckSO so, int page, int rows) {
        so.getPage().setPageNum(page);
        so.getPage().setPageSize(rows);
        PageInfo pageInfo = service.search(so);
        return new EasyUIDataGrid(pageInfo);
    }
}