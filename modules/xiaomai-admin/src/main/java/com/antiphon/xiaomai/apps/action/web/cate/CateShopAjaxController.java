package com.antiphon.xiaomai.apps.action.web.cate;

 
 

import java.util.List;

import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.cate.CateShopImg;  
import com.antiphon.xiaomai.modules.entity.cate.Category;
import com.antiphon.xiaomai.modules.service.cate.CateShopImgService;
import com.antiphon.xiaomai.modules.service.cate.CateShopService;
import com.antiphon.xiaomai.modules.service.cate.CategoryService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/cateshop")
public class CateShopAjaxController {
	  
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager; 
	@Autowired private CateShopService cateShopService; 
	
	@Autowired private  CateShopImgService shopImgService;
	@Autowired private ImgsService imgsService;
	@Autowired private CategoryService goryService;
	
	@RequestMapping(value = "")
	
	public String cateShop(HttpServletRequest request) { 
		CateShop cateShop=this.cateShopService.findCateShop("userId", this.memberManager.getUserId());
		
		if(cateShop!=null){
			 CateShopImg shopImg=this.shopImgService.findCateShopImg("shopId",cateShop.getId());
			 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
				 cateShop.setShopImgs(imgsService.findImgsList(shopImg.getImgId())); 
			 }
			
			 
		}
		List<Category> gorys=this.goryService.findCategorys();
		
		request.setAttribute("gorys", gorys);
		
		request.setAttribute("cateShop", cateShop);
		if(cateShop!=null){
			request.setAttribute("action", "update");
		}
		 
		return BASE_PATH+"cateShopInfo";
	}
	
	@RequestMapping(value = "other")
	public String cateShopOther(HttpServletRequest request) { 
		CateShop cateShop=this.cateShopService.findCateShop("userId", this.memberManager.getUserId());
		request.setAttribute("cateShop", cateShop);
		if(cateShop!=null){
			request.setAttribute("action", "update");
		}
		 
		return BASE_PATH+"cateShopOther";
	}
 
    @RequestMapping(value = "updateImgId",method =RequestMethod.POST)
    @ResponseBody
    public String updateImg(String id,Long shopId,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
    			
    			if(shopId!=null){
    				 CateShopImg shopImg=this.shopImgService.findCateShopImg("shopId", shopId); 
    				 shopImg.setImgId(updateImgId(id, shopImg));
    				this.shopImgService.updateCateShopImg(shopImg);
    			}
	    		
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    private String updateImgId(String id,CateShopImg shopImg){
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


