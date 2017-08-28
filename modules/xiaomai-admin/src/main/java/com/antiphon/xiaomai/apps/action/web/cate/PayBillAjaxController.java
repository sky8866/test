package com.antiphon.xiaomai.apps.action.web.cate;

 

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody; 

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;  
import com.antiphon.xiaomai.modules.entity.cate.Dish; 
import com.antiphon.xiaomai.modules.entity.cate.DishImg;
import com.antiphon.xiaomai.modules.entity.cate.PayBill;
import com.antiphon.xiaomai.modules.service.cate.DishImgService;
import com.antiphon.xiaomai.modules.service.cate.DishService;
import com.antiphon.xiaomai.modules.service.cate.PayBillService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/cate/payBill")
public class PayBillAjaxController {
	  
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager; 
	@Autowired private  PayBillService dishService;  
 
	@RequestMapping(value = "")
	
	public String cateShop(@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) { 
		PageView<PayBill> pageView = new PageView<PayBill>(Maxresult.MAX6,page);
		pageView.setOrderby("id", "dsec");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId()));
		pageView.setQueryResult(this.dishService.findPage(pageView, filters));
	     
		request.setAttribute("pageView", pageView); 
		 
	 
		return BASE_PATH+"payBillList";
	}
	
 
 
	
    
    @RequestMapping(value = "del",method =RequestMethod.POST)
    @ResponseBody
    public String del(Long id,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
	    		 this.dishService.delPayBill(id);
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    
    
 
}


