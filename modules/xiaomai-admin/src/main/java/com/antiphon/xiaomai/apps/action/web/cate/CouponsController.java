package com.antiphon.xiaomai.apps.action.web.cate;

 
 

import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;   
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antiphon.xiaomai.common.utils.StringUtils; 
import com.antiphon.xiaomai.modules.entity.cate.CateCoupons;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;    
import com.antiphon.xiaomai.modules.service.cate.CateCouponsService;
import com.antiphon.xiaomai.modules.service.cate.CateShopService;  
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/cate/coupons")
public class CouponsController { 
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager;  
	@Autowired private CateShopService cateShopService;  
    
    @Autowired private CateCouponsService couponsService;
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String cateShopInfo(Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("coupons_active" , "active");
 
		return BASE_PATH + "couponsForm";
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String cateShopInfo(@PathVariable("id") Long id, @PathVariable("page") String page,Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("coupons_active" , "active");
		model.addAttribute("page", page);
		CateCoupons coupons=this.couponsService.findCateCoupons(id);
		
		 
		 model.addAttribute("page", page); 
		 model.addAttribute("coupons", coupons); 	   
		return BASE_PATH + "couponsForm";
	}
	

    @RequestMapping(value = "saveAndUpdateCoupons",method =RequestMethod.POST)
    public String saveAndUpdateDish(  @ModelAttribute("preloadCateCoupons")  CateCoupons coupons,String page,
    		HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
     
    		try{ 
    			 
    			
    			if(StringUtils.isNotEmpty(coupons.getUsageendtime())&&StringUtils.isNotEmpty(coupons.getUsageendtime())){
    				coupons.setUsagetime(coupons.getUsageendtime()+"_"+coupons.getUsageendtime());
    			}
    			if(coupons.getIsAppointment()==0){
    				coupons.setAppointment(coupons.getAppointment()); 
    			}else{
    				coupons.setAppointment(coupons.getAppointment1()); 	
    			}
    			
    			if(coupons.getIsScope()==0){
    				 coupons.setScope(coupons.getScope());
    			}else if(coupons.getIsScope()==2){
    				coupons.setScope(coupons.getScope2());
    			}else{
    				coupons.setScope(coupons.getScope1());
    			}
    			
    			
    			 
	      		 if(coupons.getId()!=null){
	      			 
	      			 this.couponsService.updateCateCoupons(coupons);
	      		 }else{
	      			CateShop cateShop=this.cateShopService.findCateShop("userId", this.memberManager.getUserId());
	      			coupons.setShopId(cateShop.getId());
	      			coupons.setUserId(this.memberManager.getUserId());
	      		
	      			this.couponsService.saveCateCoupons(coupons);
	      		 }
	    		 
	    		  redirectAttributes.addFlashAttribute("message",  "操作成功");
	    	}catch (Exception e) {
	    		redirectAttributes.addFlashAttribute("message",  "操作失败"); 
			 
			}
    	 	
    		return  "redirect:/admin/cate/coupons?page="+page;
  }
	
    /**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
	 * 
	 */
	@ModelAttribute("preloadCateCoupons")
	public CateCoupons getNewsType(@RequestParam(value = "id", required = false) Long id,@Valid CateCoupons coupons) {
		if (id != null) {
			return this.couponsService.findCateCoupons(id);
		}
		return coupons;
	}
  
}


