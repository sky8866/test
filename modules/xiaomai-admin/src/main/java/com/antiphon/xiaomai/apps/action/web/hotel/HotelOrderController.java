package com.antiphon.xiaomai.apps.action.web.hotel;

 

import javax.servlet.http.HttpServletRequest;    
import org.springframework.stereotype.Controller;    
import org.springframework.web.bind.annotation.RequestMapping;    
 
  


@Controller
@RequestMapping(value = "/admin/hotel/order")
public class HotelOrderController { 
	private final static String BASE_PATH = "hotel/";  
    
	@RequestMapping(value = "")
	public String room(String active,String page,HttpServletRequest request) {
		 
		     request.setAttribute("hotel_active", "active");
		 
			 request.setAttribute("hotel_order_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"order";
	}
	
    
   
}


