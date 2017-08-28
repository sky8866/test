package com.antiphon.xiaomai.apps.action.web.hotel;

 

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
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;
import com.antiphon.xiaomai.modules.entity.hotel.RoomImg; 
import com.antiphon.xiaomai.modules.service.hotel.HotelRoomService;
import com.antiphon.xiaomai.modules.service.hotel.RoomImgService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/hotel/room")
public class HotelRoomAjaxController {
	  
	private final static String BASE_PATH = "hotel/"; 
	@Autowired private MemberManager memberManager;  
    @Autowired private ImgsService imgsService;
    
    @Autowired private HotelRoomService roomService;
    @Autowired private RoomImgService roomImgService;
	@RequestMapping(value = "")
	
	public String cateShop(@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) { 
		PageView<HotelRoom> pageView = new PageView<HotelRoom>(Maxresult.MAX6,page);
		pageView.setOrderby("id", "dsec");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId()));
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));
		pageView.setQueryResult(this.roomService.findPage(pageView, filters));
		 for(HotelRoom d:pageView.getRecords()){
	    	 RoomImg shopImg=this.roomImgService.findRoomImg("roomId",d.getId());
			 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
				 d.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
			 }
	     }
		request.setAttribute("pageView", pageView); 
		 
	 
		return BASE_PATH+"roomList";
	}
	
 
 
	
    
    @RequestMapping(value = "del",method =RequestMethod.POST)
    @ResponseBody
    public String del(Long id,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
	    		 HotelRoom room=this.roomService.findHotelRoom(id);
	    		 if(room!=null){
	    			 room.setVisible(0);
	    			 this.roomService.updateHotelRoom(room);
	    		 }
	    			 
	    			 
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    @RequestMapping(value = "updateImgId",method =RequestMethod.POST)
    @ResponseBody
    public String updateImg(String id,Long roomId,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
    			
    			if(roomId!=null){
    				 RoomImg shopImg=this.roomImgService.findRoomImg("dishId",roomId);
    				 shopImg.setImgId(updateImgId(id, shopImg));
    				this.roomImgService.updateRoomImg(shopImg);
    			}
	    		
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
    
    private String updateImgId(String id,RoomImg shopImg){
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


