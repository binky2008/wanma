package com.best.btr.wanma.bas.action;

import com.best.btr.wanma.bas.entity.Region;
import com.best.btr.wanma.bas.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Created by Hsian on 15/9/16.
 */
@Controller("RegionAction")
@RequestMapping("/region")
public class RegionAction {

    @Autowired
    private RegionService service;

    /**
     * 获取所有的信息
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public List<Region> getAllEntities() {
        return service.getAllEntities();
    }

    /**
     * 根据Id获取信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Region getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    /**
     * 更新信息，包括新增与修改。
     * 如果Id为空新增，否则修改。
     *
     * @param region 需要更新的
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Region save(Region region) {
        if (null == region.getId()) {
            service.create(region);
        } else {
            service.update(region);
        }
        return region;
    }

    @RequestMapping(value = "/sublist/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Region> getRegionByParentId(@PathVariable Long parentId) {
        return service.getEntityByParentId(parentId);
    }
}
