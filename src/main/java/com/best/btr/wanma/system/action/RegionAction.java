package com.best.btr.wanma.system.action;

import com.best.btr.wanma.system.entity.Region;
import com.best.btr.wanma.system.service.RegionService;

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

    @Autowired private RegionService service;

    @RequestMapping(value = "/sublist/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Region> getRegionByParentId(@PathVariable Long parentId) {
        return service.getEntityByParentId(parentId);
    }
}
