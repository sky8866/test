package com.antiphon.xiaomai.apps.action.web.cate;

 
 

import javax.servlet.http.HttpServletRequest;  
 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;   

import com.antiphon.xiaomai.common.utils.StringUtils;
 
 

@Controller
@RequestMapping(value = "/admin/cate")
public class CateController {
	  
	private final static String BASE_PATH = "cate/"; 
	
 
	@RequestMapping(value = "")
	public String cate(String active,String page,HttpServletRequest request) {
		 
		 request.setAttribute("meishi_active", "active");
		 
			 request.setAttribute("cate_tab", "active");
	 
		 request.setAttribute("page", page);
		return BASE_PATH+"cateHome";
	}
	
	@RequestMapping(value = "dish")
	public String dish(String active,String page,HttpServletRequest request) {
		 
		     request.setAttribute("meishi_active", "active");
		 
			 request.setAttribute("dish_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"dish";
	}
	
	
	@RequestMapping(value = "coupons")
	public String coupons(String coupons,String page,HttpServletRequest request) {
		 
		     request.setAttribute("meishi_active", "active");
		 
			 request.setAttribute("coupons_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"coupons";
	}
 
	@RequestMapping(value = "memebership")
	public String memebership( String page,HttpServletRequest request) {
		 
		     request.setAttribute("meishi_active", "active");
		 
			 request.setAttribute("memebership_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"memebership";
	}
	
	@RequestMapping(value = "payBill")
	public String payBill( String page,HttpServletRequest request) {
		 
		     request.setAttribute("meishi_active", "active");
		 
			 request.setAttribute("payBill_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"payBill";
	}
	
 
}
