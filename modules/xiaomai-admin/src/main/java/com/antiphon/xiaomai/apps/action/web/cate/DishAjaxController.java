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
import com.antiphon.xiaomai.modules.service.cate.DishImgService;
import com.antiphon.xiaomai.modules.service.cate.DishService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/cate/dish")
public class DishAjaxController {
	  
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager; 
	@Autowired private  DishService dishService; 
    @Autowired private DishImgService dishImgService;
    @Autowired private ImgsService imgsService;
	@RequestMapping(value = "")
	
	public String cateShop(@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) { 
		PageView<Dish> pageView = new PageView<Dish>(Maxresult.MAX6,page);
		pageView.setOrderby("id", "dsec");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId()));
		pageView.setQueryResult(this.dishService.findPage(pageView, filters));
	     for(Dish d:pageView.getRecords()){
	    	 DishImg shopImg=this.dishImgService.findDishImg("dishId",d.getId());
			 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
				 d.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
			 }
	     }
		request.setAttribute("pageView", pageView); 
		 
	 
		return BASE_PATH+"dishList";
	}
	
 
 
	
    
    @RequestMapping(value = "del",method =RequestMethod.POST)
    @ResponseBody
    public String del(Long id,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
	    		 this.dishService.delDish(id);
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    @RequestMapping(value = "updateImgId",method =RequestMethod.POST)
    @ResponseBody
    public String updateImg(String id,Long dishId,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
    			
    			if(dishId!=null){
    				 DishImg shopImg=this.dishImgService.findDishImg("dishId",dishId);
    				 shopImg.setImgId(updateImgId(id, shopImg));
    				this.dishImgService.updateDishImg(shopImg);
    			}
	    		
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    private String updateImgId(String id,DishImg shopImg){
    	   String shopImgId=shopImg.getImgId();
    	 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
			 String[] imgs=shopImg.getImgId().split(",");
			 StringBuffer sb=new StringBuffer();
			 for(String s:imgs){
				 if(!s.equals(id)){
					 sb.append(s).append(",");
				 }
			 }
			 if(sb.length()>1){
				 sb.deleteCharAt(sb.length()-1);
			 }
			 shopImgId=sb.toString();
			
		 }
    	 return shopImgId;
    }
    
 
}


