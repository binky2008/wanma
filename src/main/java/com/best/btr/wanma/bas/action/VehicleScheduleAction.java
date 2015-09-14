package com.best.btr.wanma.bas.action;

import com.best.btr.wanma.bas.entity.VehicleSchedule;
import com.best.btr.wanma.bas.service.VehicleScheduleService;
import com.best.btr.wanma.bas.so.VehicleScheduleSO;
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
 * @author Created by Hsian on 15/9/3.
 */
@Controller("VehicleScheduleAction")
@RequestMapping("/vehicleschedule")
public class VehicleScheduleAction {

    @Autowired
    private VehicleScheduleService service;

    /**
     * 获取所有的客户信息
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public List<VehicleSchedule> getAllEntities() {
        return service.getAllEntities();
    }

    /**
     * 根据Id获取客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public VehicleSchedule getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    /**
     * 更新客户信息，包括新增与修改。
     * 如果Id为空新增，否则修改。
     *
     * @param vehicleSchedule 需要更新的客户
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public VehicleSchedule save(VehicleSchedule vehicleSchedule) {
        if (null == vehicleSchedule.getId()) {
            service.create(vehicleSchedule);
        } else {
            service.update(vehicleSchedule);
        }
        return vehicleSchedule;
    }

    /**
     * 删除客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public VehicleSchedule delete(@PathVariable Long id) {
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
    public List<?> search(HttpServletResponse response, VehicleScheduleSO so, @PathVariable int page) {
        so.getPage().setPageNum(page);
        PageInfo pageInfo = service.search(so);
        return pageInfo.getItems();
    }
}