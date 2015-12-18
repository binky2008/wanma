package com.best.btr.wanma.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.to.entity.JJPC;
import com.jinhe.tss.util.DateUtil;

@Controller("TOAction")
@RequestMapping("/to")
public class TOAction {
	
	@Autowired private TOService service;
	
	@RequestMapping(value = "/jjpc", method = RequestMethod.POST)
    @ResponseBody
	public JJPC saveJJPC(JJPC entity) {
		if (null == entity.getId()) {
            service.create(entity);
        } else {
            service.update(entity);
        }
        return entity;
	}
	
	@RequestMapping(value = "/jjpc", method = RequestMethod.DELETE)
    @ResponseBody
	public Object deleteJJPC(Long id) {
		service.delete(JJPC.class, id);
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/jjpc/{tag}", method = RequestMethod.GET)
    @ResponseBody
	public List<?> getTodayJJPCs(@PathVariable Integer tag) {
		return service.getList("from JJPC where createTime >= ? and tag=? ", DateUtil.today(), tag);
	}

}
