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
import com.antiphon.xiaomai.modules.entity.cate.Dish;
import com.antiphon.xiaomai.modules.entity.cate.DishImg; 
import com.antiphon.xiaomai.modules.service.cate.CateShopService; 
import com.antiphon.xiaomai.modules.service.cate.DishImgService;
import com.antiphon.xiaomai.modules.service.cate.DishService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/cate/dish")
public class DishController { 
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager; 
	@Autowired private  DishService dishService;
   @Autowired private DishImgService dishImgService;
	@Autowired private CateShopService cateShopService; 
    @Autowired private ImgsService imgsService;
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String cateShopInfo(Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("dish_active" , "active");
 
		return BASE_PATH + "dishForm";
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String cateShopInfo(@PathVariable("id") Long id, @PathVariable("page") String page,Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("dish_active" , "active");
		model.addAttribute("page", page);
		 Dish dish=this.dishService.findDish(id);
		 DishImg shopImg=this.dishImgService.findDishImg("dishId",dish.getId());
		 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
			 dish.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
		 }
		 model.addAttribute("page", page); 
		 model.addAttribute("dish", dish); 	   
		return BASE_PATH + "dishForm";
	}
	

    @RequestMapping(value = "saveAndUpdateDish",method =RequestMethod.POST)
    public String saveAndUpdateDish(  @ModelAttribute("preloadDish")  Dish dish,String page, String imgId,
    		HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
     
    		try{
    			
    			
	    		  if(dish.getId()!=null){
	    			  
	    			  
	    			  this.dishService.updateDish(dish);
	    		  }else{
	    			  CateShop cateShop=this.cateShopService.findCateShop("userId", this.memberManager.getUserId());
		      			dish.setCateShopId(cateShop.getId());
		  	    		  dish.setUserId(this.memberManager.getUserId());  
	  	    		this.dishService.saveDish(dish);
	    		  }
	    		   dishImg(  imgId,  dish);
	    		 
	    		  redirectAttributes.addFlashAttribute("message",  "操作成功");
	    	}catch (Exception e) {
	    		redirectAttributes.addFlashAttribute("message",  "操作失败"); 
			 
			}
    	 	
    		return  "redirect:/admin/cate/dish?page="+page;
  }
	
    
    private void dishImg(String imgId,Dish dish){
    	 if(StringUtils.isNotEmpty(imgId)){
            	DishImg shopImg=this.dishImgService.findDishImg("dishId",dish.getId());
            	 
            	if(shopImg==null){
            		shopImg=new DishImg();
            		shopImg.setImgId(imgId);
                	shopImg.setDishId(dish.getId());
                	this.dishImgService.saveDishImg(shopImg);
            	}else{
            		
            		String oldImg=StringUtils.isNotEmpty(shopImg.getImgId())?shopImg.getImgId()+",":"";
            		shopImg.setImgId(oldImg+imgId);
            		shopImg.setDishId(dish.getId());
                	this.dishImgService.updateDishImg(shopImg);	
            	}
            
            	
            }
    }
    /**
 	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
 	 * 
 	 */
 	@ModelAttribute("preloadDish")
 	public Dish getNewsType(@RequestParam(value = "id", required = false) Long id,@Valid Dish dish) {
 		if (id != null) {
 			return this.dishService.findDish(id);
 		}
 		return dish;
 	}
}


