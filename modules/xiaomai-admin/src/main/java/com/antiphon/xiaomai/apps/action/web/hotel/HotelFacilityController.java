package com.antiphon.xiaomai.apps.action.web.hotel;

 

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;   
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;   
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.cate.Category; 
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;
import com.antiphon.xiaomai.modules.service.cate.CategoryService; 
import com.antiphon.xiaomai.modules.service.hotel.HotelFacilityService;
import com.antiphon.xiaomai.modules.service.hotel.HotelService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/hotel/facility")
public class HotelFacilityController {
	private final static String URL="/admin/hotel/facility";
	private final static String BASE_PATH = "hotel/"; 
	@Autowired private HotelFacilityService facilityService; 
	@Autowired private MemberManager memberManager; 
	@Autowired private HotelService hotelService;
	@RequestMapping(value = "")
	
	public String list(String query,Long parentid,String starttime,String endtime,@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
		 
		request.setAttribute("hotel_active", "active");
		request.setAttribute("hotel_facility_active", "active");	
			PageView<HotelFacility> pageView = new PageView<HotelFacility>(Maxresult.MAX10,page);
			List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
			 
			 filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId()));
			
			 if(parentid!=null){
		        	
	        	 filters.add(new PropertyFilter("parent.id", MatchType.EQ, parentid));
			}else{
			
				 filters.add(new PropertyFilter("parent", MatchType.NULL, null));

			}
			 if(StringUtils.isNotEmpty(query)){
					filters.add(new PropertyFilter("name", MatchType.LIKE, query));
				}
			pageView.setQueryResult(this.facilityService.findPage(pageView, filters));
		 
			request.setAttribute("pageView", pageView); 
	
			request.setAttribute("parentid", parentid); 
		return BASE_PATH+"hotelFacility";
	}
	
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String createForm(String parentid,Model model){
		model.addAttribute("hotel_active", "active");
		model.addAttribute("hotel_facility_active", "active");	
		model.addAttribute("parentid", parentid);
		HotelFacility hfacility=null;
		if(StringUtils.isNotEmpty(parentid)) hfacility=this.facilityService.findHotelFacility(Long.parseLong(parentid));
		model.addAttribute("photelFacility",hfacility);
		model.addAttribute("action", "create");
		return BASE_PATH + "hotelFacilityForm";
	}
	@RequestMapping(value="create" , method = RequestMethod.POST)
	public String create(@Valid HotelFacility type,Long parentid,Model model,RedirectAttributes redirectAttributes){
		model.addAttribute("hotel_active", "active");
		model.addAttribute("hotel_facility_active", "active");	
		try {
			 Hotel hotel=this.hotelService.findHotel("userId", this.memberManager.getUserId());
			type.setUserId(this.memberManager.getUserId());
		     if(hotel!=null) type.setHotelId(hotel.getId());
			if(parentid!=null) type.setParent(new HotelFacility(parentid));
			this.facilityService.saveHotelFacility(type);
			
			redirectAttributes.addFlashAttribute("message",  "添加成功");
			 
			
		} catch (Exception e) {
			model.addAttribute("action", "create"); 
			redirectAttributes.addFlashAttribute("message",  "添加失败！");
			model.addAttribute("parentid", parentid);
			return BASE_PATH + "hotelFacilityForm";
		}

		return  "redirect:"+URL;
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String update_ui(@PathVariable("id") Long id, @PathVariable("page") String page,HttpServletRequest request){
		request.setAttribute("hotel_active", "active");
		request.setAttribute("hotel_facility_active", "active");
		HotelFacility type=this.facilityService.findHotelFacility(id);
		request.setAttribute("type", type);
		request.setAttribute("page", page);
		HotelFacility hfacility=null;
		if(type.getParent()!=null) hfacility= type.getParent();
		request.setAttribute("photelFacility",hfacility);
		
		
		request.setAttribute("action", "update");
		return  BASE_PATH +"hotelFacilityForm";
	}
	
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadCategory") HotelFacility type,Model model, RedirectAttributes redirectAttributes,String page){
	
		model.addAttribute("hotel_active", "active");
		model.addAttribute("hotel_facility_active", "active");	
		try {
			 Hotel hotel=this.hotelService.findHotel("userId", this.memberManager.getUserId());
				type.setUserId(this.memberManager.getUserId());
			     if(hotel!=null) type.setHotelId(hotel.getId());
			this.facilityService.updateHotelFacility(type);
			redirectAttributes.addFlashAttribute("message", "更新成功");
			 
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "操作失败");
		}
		return  "redirect:"+URL+"?page="+page;
	}
	
	
	
	
	
	
	
	@RequestMapping(value="delete" , method = RequestMethod.POST)
    @ResponseBody
	public String del(Long id, RedirectAttributes redirectAttributes){
	
		try{
			 
			 
			this.facilityService.delHotelFacility(id);
 
		
			
			return  "true";
			
		}catch (Exception e) { 
			return "false";
			
		}
		
	
		 
	}
	
	 
	
	
	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
	 * 
	 */
	@ModelAttribute("preloadCategory")
	public HotelFacility getNewsType(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return this.facilityService.findHotelFacility(id);
		}
		return null;
	}
	
	
  
}


