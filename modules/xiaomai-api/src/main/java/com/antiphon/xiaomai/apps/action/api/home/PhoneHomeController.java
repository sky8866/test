package com.antiphon.xiaomai.apps.action.api.home;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray; 
import com.alibaba.fastjson.JSONObject;  
import com.antiphon.xiaomai.apps.action.api.user.BaseController;   
import com.antiphon.xiaomai.apps.action.api.vo.cate.CateShopIndexVo; 
import com.antiphon.xiaomai.apps.action.api.vo.hotel.HotelIndexVo; 
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.DistanceUtils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType; 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;  
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.dto.CustomPlayDto;
import com.antiphon.xiaomai.modules.dto.HotTicketDto;
import com.antiphon.xiaomai.modules.entity.advertising.Advertising;
import com.antiphon.xiaomai.modules.entity.cate.CateShop; 
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;  
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.advertising.AdvertisingService; 
import com.antiphon.xiaomai.modules.service.cate.CateShopService;
import com.antiphon.xiaomai.modules.service.custom.CustomInfoService;
import com.antiphon.xiaomai.modules.service.custom.CustomPlayInfoService; 
import com.antiphon.xiaomai.modules.service.hotel.HotelService;
import com.antiphon.xiaomai.modules.service.img.ImgsService; 
import com.antiphon.xiaomai.modules.service.ticket.TicketManageService;

@Controller
@RequestMapping(value = "/termial/home")
public class PhoneHomeController extends BaseController {
   
   @Autowired private HotelService hotelService; 
    
   
   @Autowired private CustomInfoService customInfoService; 
 
	@Autowired private CateShopService shopService;
	
	@Autowired private CustomPlayInfoService playInfoService;

	@Autowired
	private  TicketManageService ticketManageService;
	
	@Autowired private AdvertisingService advertisingServie;
	
	@Autowired private ImgsService imgsService;

	/**
	 * 获取商家
	 */
	@RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO shop(String city,String  longitude,String latitude,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject json=  new JSONObject();//(JSONObject) JSONObject.toJSON(hotel); 
		
		
		List<Advertising> as=this.advertisingServie.findAdvertising(0, 1, 1);
		
		  
		   JSONArray jo=new JSONArray();
		   if(!as.isEmpty()){
			List<Imgs> imgs= this.imgsService.findImgsList("resourceId", as.get(0).getId());
			 for(Imgs m:imgs){
				 JSONObject j=new JSONObject();
				 j.put("bannerUrl", "http://www.baidu.com");
				 j.put("bannerImg", ConfigUtil.getValue("server")+m.getImagePath());
				 jo.add(j);
			 }
		   }
			  
			 
			
		 
		
		
		 json.put("banner", jo);
		
		
		Map<String, String> params=new HashMap<String, String>();
		params.put("pageNo", "1");
		params.put("pageSize", "5");

		
		  List<CustomInfoDto> cinfos=  this.customInfoService.getCustomInfoHomeByParams(params);
		
		 json.put("customs", cinfos);
		 
		 List<CustomPlayDto> customPlays=  this.playInfoService.findCustomPlayHomeByUserId();
		 json.put("customPlays", customPlays);
		List<HotTicketDto>  tickes=new ArrayList<HotTicketDto>();
		if(StringUtils.isNotEmpty(longitude)&&StringUtils.isNotEmpty(latitude)){
			  tickes=ticketManageService.getHotTicketList(city,Double.parseDouble(longitude),Double.parseDouble(latitude),2);
			
		}
		json.put("tickes", tickes);

		PageView<Hotel> pageView = new PageView<Hotel>(2,1);
		pageView.setOrderby("id", "desc"); 
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		setQuery(city, longitude, latitude, filters);
		List<Hotel> shops=this.hotelService.findPage(pageView, filters).getResultlist();
		
		 JSONArray array=new JSONArray();       
		hotels(shops, array);
		json.put("hotels", array);
		
		
		 
		PageView<CateShop> pageViewCateShop = new PageView<CateShop>(2,1); 
		
	 
		List<CateShop> shopsCateShop=this.shopService.findPage(pageViewCateShop, filters).getResultlist();
	 
		array=new JSONArray();   
		  
		shops( shopsCateShop,array);
		json.put("shops", array);
		
		
		
    	 BaseResponseDTO rdto=new BaseResponseDTO(json);
    		     
    		  return rdto; 
         
    }







	private void shops( List<CateShop> shopsCateShop,JSONArray array) {
		for(CateShop s:shopsCateShop){
			  
			CateShopIndexVo vo=new CateShopIndexVo(s);
			array.add(vo);
		}
	}







	private void hotels(List<Hotel> shops,JSONArray array) {
		for(Hotel s:shops){
			 
			 HotelIndexVo vo=new HotelIndexVo(s);
			 array.add(vo); 
		}
	}
 
	
	
	 
	 
	 
	
	/**
	 * 查询条件
	 * @param shop
	 * @param pageView
	 * @param filters
	 */
	private void setQuery(String city,String  longitude,String latitude,List<PropertyFilter> filters){
		 
		  
		if(StringUtils.isNotEmpty(city)){
			filters.add(new PropertyFilter("city", MatchType.LIKE, city));
		}
		  
		 
		if(StringUtils.isNotEmpty(longitude)&&StringUtils.isNotEmpty(latitude)){
	    
			Map<String, String> map=DistanceUtils.queryLocation(Double.parseDouble(longitude), Double.parseDouble(latitude), 10);
		    
			filters.add(new PropertyFilter("latitude", MatchType.GE, map.get("right-bottom_lat")));	
			filters.add(new PropertyFilter("latitude", MatchType.LE, map.get("left-top_lat")));	
			filters.add(new PropertyFilter("longitude", MatchType.GE, map.get("left-top_lng")));	
			filters.add(new PropertyFilter("longitude", MatchType.LE, map.get("right-bottom_lng")));	
			
		}
	}
	
	
	 
 
}
