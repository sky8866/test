package com.antiphon.xiaomai.apps.action.web.cate;

 

import javax.servlet.http.HttpServletRequest;    
import org.springframework.stereotype.Controller;    
import org.springframework.web.bind.annotation.RequestMapping;    
 
  


@Controller
@RequestMapping(value = "/admin/cate/order")
public class CateOrderController { 
	private final static String BASE_PATH = "cate/";  
    
	@RequestMapping(value = "")
	public String room(String active,String page,HttpServletRequest request) {
		 
		     request.setAttribute("meishi_active", "active");
		 
			 request.setAttribute("cate_order_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"order";
	}
	
    
   
}


