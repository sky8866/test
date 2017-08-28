package com.antiphon.xiaomai.apps.action.web.user;
 

import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
 
 
/**
 * 负责打开登录页面(GET请求)和登录(POST请求)，
 * 
 */
@Controller
@RequestMapping(value = "/web/login")
public class LoginController { 
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
	     
		return "adminLogin";
	}
/**
 *  真正登录的POST请求由Filter完成
 */
	@RequestMapping(method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, Model model,HttpSession session) {
 
		 
		return "redirect:/";
	}

}



