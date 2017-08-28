package com.antiphon.xiaomai.apps.action.web.cate;

 

import javax.servlet.http.HttpServletRequest;   
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;   
import org.springframework.web.multipart.MultipartFile; 
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antiphon.xiaomai.common.utils.StringUtils; 
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.cate.CateShopImg;
import com.antiphon.xiaomai.modules.service.cate.CateShopImgService;
import com.antiphon.xiaomai.modules.service.cate.CateShopService; 
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/cate/catshop")
public class CateShopController {
	private final static String URL="/admin/cate";  
	@Autowired private CateShopService cateShopService; 
	 @Autowired private CateShopImgService shopImgService; 
	@Autowired private MemberManager memberManager; 
	
	
	@RequestMapping(value="create" , method = RequestMethod.POST)
	public String create(@Valid CateShop  shop,MultipartFile filename,Model model,String starttime,String endtime, String imgId,RedirectAttributes redirectAttributes,HttpServletRequest request){
		model.addAttribute("meishi_active", "active");
		try {
           if(StringUtils.isNotEmpty(starttime)){
			    shop.setBusinessHours(starttime+"_"+endtime);	
			}
              shop.setCover(imgagename(filename, request));
			 shop.setUserId(memberManager.getUserId());
			this.cateShopService.saveCateShop(shop);
			shopImg(imgId, shop);
			
			redirectAttributes.addFlashAttribute("message",  "提交成功，等待审核！");
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("action", "create"); 
			redirectAttributes.addFlashAttribute("message",  "操作失败！");
			 
			 
		}

		return  "redirect:"+URL;
	}
 
 
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadCateShop") CateShop shop,MultipartFile filename,String imgId,String starttime,String endtime,Model model, RedirectAttributes redirectAttributes,String page,HttpServletRequest request){
 
		model.addAttribute("meishi_active", "active"); 
		 
		try {
			 
	 
		 String imgagename=imgagename(filename, request);
		 if(StringUtils.isNotEmpty(imgagename))shop.setCover(imgagename);
			
			
		
			
			if(StringUtils.isNotEmpty(starttime)){
			    shop.setBusinessHours(starttime+"_"+endtime);	
			     
			}
		 
			this.cateShopService.updateCateShop(shop);
			shopImg(imgId, shop);
			
			redirectAttributes.addFlashAttribute("message", "更新成功，等待审核！");
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "操作失败");
		}
		return  "redirect:"+URL;
	}
	
	private String  imgagename(MultipartFile filename,HttpServletRequest request){
		if(filename==null){
			return "";
		}
		String fileName = filename.getOriginalFilename();
	    
        
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        String    imagename = UUID.getUUID() + "." + ext; // 构建文件名称  
     	try {
			UploadUtils.saveFile(filename, "/images/cate/cover/" + this.memberManager.getUserId(),imagename, request);
		} catch (Exception e) {
		 
		}
		return imagename;
	}
	
	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
	 * 
	 */
	@ModelAttribute("preloadCateShop")
	public CateShop getCateShop(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return this.cateShopService.findCateShop(id);
		}
		return null;
	}
	
	private void shopImg(String imgId,CateShop shop){
		 if(StringUtils.isNotEmpty(imgId)){
          	CateShopImg shopImg=this.shopImgService.findCateShopImg("shopId",shop.getId() );
          	 
          	if(shopImg==null){
          		shopImg=new CateShopImg();
          		shopImg.setImgId(imgId);
              	shopImg.setShopId(shop.getId());
              	this.shopImgService.saveCateShopImg(shopImg);
          	}else{
          		
          		String oldImg=StringUtils.isNotEmpty(shopImg.getImgId())?shopImg.getImgId()+",":"";
          		shopImg.setImgId(oldImg+imgId);
              	shopImg.setShopId(shop.getId());
              	this.shopImgService.updateCateShopImg(shopImg);	
          	}
          
          	
          }
	}
	
  
}


