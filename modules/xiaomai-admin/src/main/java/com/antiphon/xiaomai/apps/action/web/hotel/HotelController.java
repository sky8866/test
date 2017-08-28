package com.antiphon.xiaomai.apps.action.web.hotel;

 
 

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;   
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
  
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.bean.MatchType; 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter; 
import com.antiphon.xiaomai.modules.entity.hotel.Facility;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelImg; 
import com.antiphon.xiaomai.modules.service.hotel.FacilityService;
import com.antiphon.xiaomai.modules.service.hotel.HotelFacilityService;
import com.antiphon.xiaomai.modules.service.hotel.HotelService;
import com.antiphon.xiaomai.modules.service.hotel.impl.HotelImgServiceImpl;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/hotel")
public class HotelController { 
	private final static String BASE_PATH = "hotel/"; 
	@Autowired private MemberManager memberManager;     
     @Autowired private HotelService hotelService;
     @Autowired private HotelImgServiceImpl hotelImgService;
     
     @Autowired private ImgsService imgsService;
     @Autowired private HotelFacilityService hotelFacilityService;
     @Autowired private FacilityService facilityService;
     
     @RequestMapping(value="info" , method = RequestMethod.GET)
 	public String info(Model model){
 		model.addAttribute("hotel_active", "active");
 		model.addAttribute("hotel_info_active" , "active");
 		 Hotel hotel=this.hotelService.findHotel("userId", this.memberManager.getUserId());
 		  if(hotel!=null){
 			 HotelImg shopImg=this.hotelImgService.findHotelImg("hotelId",hotel.getId());
 			 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
 				 hotel.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
 			 }  
 		  }
 		
 		 model.addAttribute("hotel", hotel); 	   
 		return BASE_PATH + "hotelForm";
 	}
     
	 

    @RequestMapping(value = "saveAndUpdatehotel",method =RequestMethod.POST)
    public String saveAndUpdateDish(   @ModelAttribute("preloadhotelCard")  Hotel hotel,MultipartFile filename,String imgId,String page,
    		HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
     
    		try{ 
    		 
    			 String imgagename=imgagename(filename, request);
    			 if(StringUtils.isNotEmpty(imgagename))hotel.setCover(imgagename);
    			 
    			 if(hotel.getId()==null){
    				  hotel.setUserId(this.memberManager.getUserId());
    				 hotelService.saveHotel(hotel);
    				 // setFacilitys(hotel.getId());
    			 }else{
    				  hotelService.updateHotel(hotel);
    				 
    			 }
    			 
    			 dishImg(imgId, hotel);
	    		  redirectAttributes.addFlashAttribute("message",  "操作成功");
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    		redirectAttributes.addFlashAttribute("message",  "操作失败"); 
			 
			}
    	 	
    		return  "redirect:/admin/hotel/info";
  }
	
    /**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
	 * 
	 */
	@ModelAttribute("preloadhotelCard")
	public Hotel getNewsType(@RequestParam(value = "id", required = false) Long id,@Valid  Hotel hotel) {
		if (id != null) {
			return this.hotelService.findHotel(id);
		}
		return hotel;
	}
	
	
	 @RequestMapping(value = "updateImgId",method =RequestMethod.POST)
	    @ResponseBody
	    public String updateImg(String id,Long hotelId,
	    		HttpServletRequest request,HttpServletResponse response) {
	     
	    		try{
	    			
	    			if(hotelId!=null){
	    				 HotelImg shopImg=this.hotelImgService.findHotelImg("hotelId",hotelId);
	    				 shopImg.setImgId(updateImgId(id, shopImg));
	    				this.hotelImgService.updateHotelImg(shopImg);
	    			}
		    		
		    		
		    		return  "true";
		    	}catch (Exception e) {
					return "false";
				}
	     
	  
	  }
	    
	    private String updateImgId(String id,HotelImg shopImg){
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
	    
	
	    private void dishImg(String imgId,Hotel room){
	    	 if(StringUtils.isNotEmpty(imgId)){
	    		 HotelImg shopImg=this.hotelImgService.findHotelImg("hotelId",room.getId());
	            	 
	            	if(shopImg==null){
	            		shopImg=new HotelImg();
	            		shopImg.setImgId(imgId);
	                	shopImg.setHotelId(room.getId());
	                	this.hotelImgService.saveHotelImg(shopImg);
	            	}else{
	            		
	            		String oldImg=StringUtils.isNotEmpty(shopImg.getImgId())?shopImg.getImgId()+",":"";
	            		shopImg.setImgId(oldImg+imgId);
	            		shopImg.setHotelId(room.getId());
	                	this.hotelImgService.updateHotelImg(shopImg);	
	            	}
	            
	            	
	            }
	    }
	   
	
	private void setFacilitys(Long hotelId){
		PageView<Facility> pageView = new PageView<Facility>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>(); 
		
			 filters.add(new PropertyFilter("parent", MatchType.NULL, null));
			 List<Facility> fs=this.facilityService.findPage(pageView, filters).getResultlist();
		 
			 for(Facility f:fs){
				 HotelFacility hf=new HotelFacility();
				 hf.setHotelId(hotelId);
				 hf.setUserId(this.memberManager.getUserId());
				 hf.setName(f.getName());
				 this.hotelFacilityService.saveHotelFacility(hf);
				 Long id=hf.getId();
				 for(Facility fy:f.getChildtypes()){
					   hf=new HotelFacility();
					 hf.setHotelId(hotelId);
					 hf.setParent(new HotelFacility(id));
					 hf.setUserId(this.memberManager.getUserId());
					 hf.setName(fy.getName());
					 this.hotelFacilityService.saveHotelFacility(hf); 
				 }
			 }
	}
	
	
	private String  imgagename(MultipartFile filename,HttpServletRequest request){
		if(filename==null){
			return "";
		}
		String fileName = filename.getOriginalFilename();
	    
        System.out.println("flename:"+filename.getOriginalFilename());
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        String    imagename = UUID.getUUID() + "." + ext; // 构建文件名称  
     	try {
			UploadUtils.saveFile(filename, "/images/hotel/cover/" + this.memberManager.getUserId(),imagename, request);
		} catch (Exception e) {
		 
		}
		return imagename;
	}
  
}


