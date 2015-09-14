package com.best.btr.wanma;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/init")
public class SystemInit {
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object getVersion(HttpServletRequest request, HttpServletResponse response) {
		// TODO
		return new Object[] { "Success" };
	}
	
}
