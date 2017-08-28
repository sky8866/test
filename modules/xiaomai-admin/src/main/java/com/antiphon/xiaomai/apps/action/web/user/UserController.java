package com.antiphon.xiaomai.apps.action.web.user;

 

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
 

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
	  
	private final static String BASE_PATH = "user/";  
	
 
	@RequestMapping(value = "")
	public String word(String page,HttpServletRequest request) {
		 request.setAttribute("user_active", "active");
		 request.setAttribute("user_query_action", "active");
		 request.setAttribute("page", page);
		return BASE_PATH+"home";
	}
 
}
