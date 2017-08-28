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
import com.antiphon.xiaomai.modules.entity.cate.MemebershipCard;
import com.antiphon.xiaomai.modules.service.cate.CateCouponsService; 
import com.antiphon.xiaomai.modules.service.cate.MemebershipCardService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/cate/memebership")
public class MemebershipAjaxController {
	  
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager;  
	@Autowired private MemebershipCardService cardService; 
	@RequestMapping(value = "")
	
	public String card(@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) { 
		PageView<MemebershipCard> pageView = new PageView<MemebershipCard>(Maxresult.MAX6,page);
		pageView.setOrderby("id", "dsec");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId()));
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));
		pageView.setQueryResult(this.cardService.findPage(pageView, filters));
	     
		request.setAttribute("pageView", pageView); 
		 
	 
		return BASE_PATH+"memebershipList";
	}
	
 
 
	
    
    @RequestMapping(value = "del",method =RequestMethod.POST)
    @ResponseBody
    public String del(Long id,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
    			MemebershipCard coupons=	 this.cardService.findMemebershipCard(id);
    			coupons.setVisible(0);
	    		 this.cardService.updateMemebershipCard(coupons);
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    
}


