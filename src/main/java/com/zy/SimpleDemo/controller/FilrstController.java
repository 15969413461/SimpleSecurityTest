
package com.zy.SimpleDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.security.annotation.PreAuthorize;
import com.zy.security.core.context.SecurityContext;
import com.zy.security.core.context.SecurityContextStrategy;
import com.zy.security.web.session.CsrfContextHolder;

/**
* @author zy
* @Date 2019-11-29 周五 下午 13:39:44
* @Description
* @version 
*/
@Controller
public class FilrstController {
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		SecurityContext context = SecurityContextStrategy.getContext();
		System.out.println(context);
		return "index";
		
	}
	@RequestMapping("/getMsg")
	@ResponseBody
	@PreAuthorize(url="/getMsg",value="user:edit,add")
	public String msg(HttpServletRequest request) {
		String csrfBySessionId = CsrfContextHolder.getCsrfBySessionId(request);
		
		SecurityContext context = SecurityContextStrategy.getContext();
		System.out.println(context);
		
		return "csrf："+csrfBySessionId;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request) {
		SecurityContext context = SecurityContextStrategy.getContext();
		System.out.println(context);
		return "context："+context;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(HttpServletRequest request) {
		SecurityContext context = SecurityContextStrategy.getContext();
		System.out.println(context);
		return "context："+context;
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(HttpServletRequest request) {
		SecurityContext context = SecurityContextStrategy.getContext();
		System.out.println(context);

		Object principal = context.getAuthentication().getPrincipal();
		return principal.toString();
	}
}
