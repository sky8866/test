package com.antiphon.xiaomai.apps.action.web.user;
 
 

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
 


/**
 * 修改个人资料
 * sky
 */
@Controller
@RequestMapping(value = "/admin")
public class SystemIndexController {  
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request){ 
	 
		request.setAttribute("index_active", "active");
			return "home";
		 
		
	}
	
	 
 
}
