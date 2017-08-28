package com.antiphon.xiaomai.apps.action.web.hotel;

 

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
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;
import com.antiphon.xiaomai.modules.entity.hotel.RoomImg; 
import com.antiphon.xiaomai.modules.service.hotel.HotelRoomService;
import com.antiphon.xiaomai.modules.service.hotel.HotelService;
import com.antiphon.xiaomai.modules.service.hotel.RoomImgService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/hotel/room")
public class HotelRoomController { 
	private final static String BASE_PATH = "hotel/"; 
	@Autowired private MemberManager memberManager; 
	 
   @Autowired private RoomImgService roomImgService;
	@Autowired private HotelService hotelService; 
    @Autowired private ImgsService imgsService;
    
    @Autowired private HotelRoomService roomService;
    
	@RequestMapping(value = "")
	public String room(String active,String page,HttpServletRequest request) {
		 
		     request.setAttribute("hotel_active", "active");
		 
			 request.setAttribute("hotel_room_active" , "active");
		  
		 request.setAttribute("page", page);
		return BASE_PATH+"room";
	}
	
    
    
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String cateShopInfo(HttpServletRequest request){
		  request.setAttribute("hotel_active", "active");
			 
			 request.setAttribute("hotel_room_active" , "active");
 
		return BASE_PATH + "roomForm";
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String cateShopInfo(@PathVariable("id") Long id, @PathVariable("page") String page,Model model){
		model.addAttribute("hotel_active", "active");
		model.addAttribute("hotel_room_active" , "active");
		model.addAttribute("page", page);
		 HotelRoom room=this.roomService.findHotelRoom(id);
		 RoomImg shopImg=this.roomImgService.findRoomImg("roomId",room.getId());
		 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
			 room.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
		 }
		 model.addAttribute("page", page); 
		 model.addAttribute("room", room); 	   
		return BASE_PATH + "roomForm";
	}
	

    @RequestMapping(value = "saveAndUpdateRoom",method =RequestMethod.POST)
    public String saveAndUpdateDish(  @ModelAttribute("preloadRoom")  HotelRoom room,String page, String imgId,
    		HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
     
    		try{
    			
    			
	    		  if(room.getId()!=null){
	    			  
	    			  
	    			   this.roomService.updateHotelRoom(room);
	    		  }else{
	    			  Hotel hotel=this.hotelService.findHotel("userId", this.memberManager.getUserId());
	    			   room.setHotelId(hotel.getId()); 
		  	    		  room.setUserId(this.memberManager.getUserId());  
	  	    	      this.roomService.saveHotelRoom(room);
	    		  }
	    		   dishImg(  imgId,  room);
	    		 
	    		  redirectAttributes.addFlashAttribute("message",  "操作成功");
	    	}catch (Exception e) {
	    		redirectAttributes.addFlashAttribute("message",  "操作失败"); 
			 
			}
    	 	
    		return  "redirect:/admin/hotel/room?page="+page;
  }
	
    
    private void dishImg(String imgId,HotelRoom room){
    	 if(StringUtils.isNotEmpty(imgId)){
            	RoomImg shopImg=this.roomImgService.findRoomImg("roomId",room.getId());
            	 
            	if(shopImg==null){
            		shopImg=new RoomImg();
            		shopImg.setImgId(imgId);
                	shopImg.setRoomId(room.getId());
                	this.roomImgService.saveRoomImg(shopImg);
            	}else{
            		
            		String oldImg=StringUtils.isNotEmpty(shopImg.getImgId())?shopImg.getImgId()+",":"";
            		shopImg.setImgId(oldImg+imgId);
            		shopImg.setRoomId(room.getId());
                	this.roomImgService.updateRoomImg(shopImg);	
            	}
            
            	
            }
    }
    /**
 	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
 	 * 
 	 */
 	@ModelAttribute("preloadRoom")
 	public HotelRoom getNewsType(@RequestParam(value = "id", required = false) Long id,@Valid HotelRoom room) {
 		if (id != null) {
 			return this.roomService.findHotelRoom(id);
 		}
 		return room;
 	}
}


