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
 
import com.antiphon.xiaomai.modules.bean.MatchType; 
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter; 
import com.antiphon.xiaomai.modules.entity.cate.CateCoupons;  
import com.antiphon.xiaomai.modules.service.cate.CateCouponsService; 
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/cate/coupons")
public class CouponsAjaxController {
	  
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager;  
    @Autowired private CateCouponsService couponsService;
    
	@RequestMapping(value = "")
	
	public String cateCoupons(@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) { 
		PageView<CateCoupons> pageView = new PageView<CateCoupons>(Maxresult.MAX6,page);
		pageView.setOrderby("id", "dsec");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId()));
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));
		pageView.setQueryResult(this.couponsService.findPage(pageView, filters));
	     
		request.setAttribute("pageView", pageView); 
		 
	 
		return BASE_PATH+"couponsList";
	}
	
 
 
	
    
    @RequestMapping(value = "del",method =RequestMethod.POST)
    @ResponseBody
    public String del(Long id,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
	    	CateCoupons coupons=	 this.couponsService.findCateCoupons(id);
	    		 coupons.setVisible(0);
	    		 this.couponsService.updateCateCoupons(coupons);
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    
}


