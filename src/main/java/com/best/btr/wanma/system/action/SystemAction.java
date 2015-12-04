package com.best.btr.wanma.system.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best.btr.wanma.system.service.SystemService;
import com.jinhe.tss.framework.sso.Environment;
import com.jinhe.tss.framework.sso.SSOConstants;
import com.jinhe.tss.framework.sso.context.Context;

/**
 * @author Created by Hsian on 15/9/16.
 */
@Controller("SystemAction")
@RequestMapping("/sys")
public class SystemAction {

    @Autowired private SystemService service;

    @RequestMapping(value = "/region/{zoneId}", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getRegionsByZone(@PathVariable Long zoneId) {
        return service.getRegions(zoneId);
    }
    
	/** 用户所属组织、角色等信息的json接口 */
	@RequestMapping(value = "/user/info", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getUserHas() {
		
		Long userId = Environment.getUserId();
		
		HttpSession session = Context.getRequestContext().getSession();
		
		Object[] userHas = new Object[5];
		userHas[0] = session.getAttribute("SITE_INFO");    // site
		userHas[1] = session.getAttribute("CENTER_INFO");  // center
		userHas[2] = userId;
		userHas[3] = Environment.getUserCode();
		userHas[4] = Environment.getUserName();
		userHas[5] = session.getAttribute(SSOConstants.USER_RIGHTS_IN_SESSION); // 用户角色
		
		return userHas;
	}
	
    @RequestMapping(value = "/site/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getSites(@PathVariable Long id) {
        return service.getSites(id);
    }
}
