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
import com.antiphon.xiaomai.modules.entity.cate.PayBill;
import com.antiphon.xiaomai.modules.service.cate.CateShopService;  
import com.antiphon.xiaomai.modules.service.cate.PayBillService; 
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/cate/payBill")
public class PayBillController { 
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager; 
	@Autowired private  PayBillService payBillService; 
	@Autowired private CateShopService cateShopService;  
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String cateShopInfo(Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("payBill_active" , "active");
 
		return BASE_PATH + "payBillForm";
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String cateShopInfo(@PathVariable("id") Long id, @PathVariable("page") String page,Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("payBill_active" , "active");
		model.addAttribute("page", page);
		 PayBill payBill=this.payBillService.findPayBill(id);
		 
		  
		 model.addAttribute("page", page); 
		 model.addAttribute("payBill", payBill); 	   
		return BASE_PATH + "payBillForm";
	}
	

    @RequestMapping(value = "saveAndUpdatepayBill",method =RequestMethod.POST)
    public String saveAndUpdatepayBill(  @ModelAttribute("preloadpayBill")  PayBill payBill,String page, String imgId,
    		HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
     
    		try{
    			
    			
	    		  if(payBill.getId()!=null){
	    			  
	    			  
	    			  this.payBillService.updatePayBill(payBill);
	    		  }else{
	    			  CateShop cateShop=this.cateShopService.findCateShop("userId", this.memberManager.getUserId());
		      			 payBill.setShopId(cateShop.getId());
		  	    		  payBill.setUserId(this.memberManager.getUserId());  
	  	    		this.payBillService.savePayBill(payBill);
	    		  }
	    		   
	    		 
	    		  redirectAttributes.addFlashAttribute("message",  "操作成功");
	    	}catch (Exception e) {
	    		redirectAttributes.addFlashAttribute("message",  "操作失败"); 
			 
			}
    	 	
    		return  "redirect:/admin/cate/payBill?page="+page;
  }
	
 
    /**
 	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
 	 * 
 	 */
 	@ModelAttribute("preloadpayBill")
 	public PayBill getNewsType(@RequestParam(value = "id", required = false) Long id,@Valid PayBill payBill) {
 		if (id != null) {
 			return this.payBillService.findPayBill(id);
 		}
 		return payBill;
 	}
}


