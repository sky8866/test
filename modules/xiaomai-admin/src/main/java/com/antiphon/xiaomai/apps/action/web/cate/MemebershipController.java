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
 
import com.antiphon.xiaomai.modules.entity.cate.CateShop;  
import com.antiphon.xiaomai.modules.entity.cate.Category;
import com.antiphon.xiaomai.modules.entity.cate.MemebershipCard; 
import com.antiphon.xiaomai.modules.service.cate.CateShopService;  
import com.antiphon.xiaomai.modules.service.cate.MemebershipCardService; 
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/cate/memebership")
public class MemebershipController { 
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager;  
	@Autowired private CateShopService cateShopService;  
     @Autowired private MemebershipCardService memebershipService;
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String cateShopInfo(Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("memebership_active" , "active");
 
		return BASE_PATH + "memebershipForm";
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String cateShopInfo(@PathVariable("id") Long id, @PathVariable("page") String page,Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("memebership_active" , "active");
		model.addAttribute("page", page); 
		MemebershipCard card=this.memebershipService.findMemebershipCard(id);
		 
		 model.addAttribute("page", page); 
		 model.addAttribute("memebership", card); 	   
		return BASE_PATH + "memebershipForm";
	}
	

    @RequestMapping(value = "saveAndUpdateMemebership",method =RequestMethod.POST)
    public String saveAndUpdateDish(   @ModelAttribute("preloadMemebershipCard")  MemebershipCard memebership,Long mid,String page,
    		HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
     
    		try{ 
    			 
    			
    			 if(memebership.getId()==null){
    				 CateShop cateShop=this.cateShopService.findCateShop("userId", this.memberManager.getUserId());
        			 memebership.setUserId(cateShop.getUserId());
        			 memebership.setShopId(cateShop.getId());
    				 memebershipService.saveMemebershipCard(memebership);
    			 }else{
    				 memebershipService.updateMemebershipCard(memebership);
    			 }
    			
	    		  redirectAttributes.addFlashAttribute("message",  "操作成功");
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    		redirectAttributes.addFlashAttribute("message",  "操作失败"); 
			 
			}
    	 	
    		return  "redirect:/admin/cate/memebership?page="+page;
  }
	
    /**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
	 * 
	 */
	@ModelAttribute("preloadMemebershipCard")
	public MemebershipCard getNewsType(@RequestParam(value = "id", required = false) Long id,@Valid  MemebershipCard memebership) {
		if (id != null) {
			return this.memebershipService.findMemebershipCard(id);
		}
		return memebership;
	}
  
}


