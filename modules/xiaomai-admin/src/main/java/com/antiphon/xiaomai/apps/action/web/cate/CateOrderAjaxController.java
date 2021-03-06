package com.antiphon.xiaomai.apps.action.web.cate;

 

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
import com.antiphon.xiaomai.modules.dao.hotel.HotelOrderDao;
import com.antiphon.xiaomai.modules.entity.cate.CateOrder;
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder;
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;
import com.antiphon.xiaomai.modules.entity.hotel.RoomImg; 
import com.antiphon.xiaomai.modules.service.cate.CateOrderService;
import com.antiphon.xiaomai.modules.service.hotel.HotelOrderService;
import com.antiphon.xiaomai.modules.service.hotel.HotelRoomService;
import com.antiphon.xiaomai.modules.service.hotel.RoomImgService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/cate/order")
public class CateOrderAjaxController {
	  
	private final static String BASE_PATH = "cate/"; 
	@Autowired private MemberManager memberManager;   
	
     @Autowired private CateOrderService orderService;	
	@RequestMapping(value = "")
	
	public String cateShop(@RequestParam(value = "page", defaultValue = "1") int  page,
			String status,String query ,String starttime,String endtime,HttpServletRequest request) { 
 		
	 
		PageView<CateOrder> pageView = new PageView<CateOrder>(2,page);
		pageView.setOrderby("id", "dsec");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, this.memberManager.getUserId())); 
		pageView.setQueryResult(this.orderService.findPageOrder(pageView, status, starttime, endtime));
		 
		request.setAttribute("pageView", pageView); 
		 
	 
		return BASE_PATH+"orderList";
	}
	
 
 
	
 
 
 
}


