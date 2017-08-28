package com.antiphon.xiaomai.apps.action.api.hotel;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray; 
import com.alibaba.fastjson.JSONObject; 
import com.antiphon.xiaomai.apps.action.api.dto.hotel.HotelDto;
import com.antiphon.xiaomai.apps.action.api.user.BaseController;   
import com.antiphon.xiaomai.apps.action.api.vo.hotel.DistanceVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.DistrictVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.HotelInfoVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.HotelVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.RoomVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.StarsAndPriceVo;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.utils.DistanceUtils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType; 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;  
import com.antiphon.xiaomai.modules.entity.city.District;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;
import com.antiphon.xiaomai.modules.entity.hotel.HotelImg; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder;
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;
import com.antiphon.xiaomai.modules.service.city.DistrictService;
import com.antiphon.xiaomai.modules.service.hotel.HotelFacilityService;
import com.antiphon.xiaomai.modules.service.hotel.HotelImgService;
import com.antiphon.xiaomai.modules.service.hotel.HotelOrderService;
import com.antiphon.xiaomai.modules.service.hotel.HotelRoomService;
import com.antiphon.xiaomai.modules.service.hotel.HotelService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;

@Controller
@RequestMapping(value = "/termial/hotel")
public class PhoneHotelController extends BaseController {
  
	@Autowired private  HotelImgService hotelImgService;
	@Autowired private ImgsService imgsService; 
   @Autowired private HotelService hotelService;
   @Autowired private HotelFacilityService facilityService;
   
   @Autowired private HotelRoomService roomService;
   @Autowired private HotelOrderService hotelOrderService;
   
   @Autowired private DistrictService districtService;

	/**
	 * 获取商家
	 */
	@RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO shop(@Valid HotelDto hotel,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		PageView<Hotel> pageView = new PageView<Hotel>(hotel.getPageSize(),hotel.getPageNo());
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		
		 setQuery(hotel, pageView, filters);
		List<Hotel> shops=this.hotelService.findPage(pageView, filters).getResultlist();
		//JSONObject json=  new JSONObject();//(JSONObject) JSONObject.toJSON(hotel);
              
		 JSONArray array=new JSONArray();
		for(Hotel s:shops){
			 List<HotelFacility> hfs=this.facilityService.findHotelFacilitys("hotelId", s.getId());
			 s.setFacilitys(hfs);
			 
			 HotelInfoVo vo=new HotelInfoVo(s);
			array.add(vo);
		}
		 
    	 BaseResponseDTO rdto=new BaseResponseDTO(array);
    		     
    		  return rdto; 
         
    }
 
	/**
	 * 获取商家
	 */
	@RequestMapping(value = "details",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO details(String hotelId,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		 Hotel s=this.hotelService.findHotel(Long.parseLong(hotelId));
		 List<HotelFacility> hfs=this.facilityService.findHotelFacilitys("hotelId", s.getId());
		 s.setFacilitys(hfs);
		 
		 HotelVo vo=new HotelVo(s);
    	 BaseResponseDTO rdto=new BaseResponseDTO(vo);
    		     
    		  return rdto; 
         
    }
 
	
	
	/**
	 * 获取订单
	 */
	@RequestMapping(value = "order",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO order(@Valid HotelOrder order) throws Exception{
		
	      this.hotelOrderService.saveHotelOrder(order);
	      JSONObject json=new JSONObject();
			 json.put("orderId", order.getId()+"");
    	  BaseResponseDTO rdto=new BaseResponseDTO(json);
    		     
    		  return rdto; 
         
    }
	
	/**
	 * 获取查询条件
	 */
	@RequestMapping(value = "query",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO hotelQuery( String city)throws Exception{
		 
    		    
    		     JSONObject json=new JSONObject();
    		      List<String> koubeis=new ArrayList<String>();
    		     koubeis.add("服务");
    		     koubeis.add("环境");
    		     koubeis.add("设施");
    		     koubeis.add("餐饮");
    		     json.put("koubeis", koubeis);
    		   List<DistanceVo> distances=new ArrayList<DistanceVo>();
    		 	   distances.add(new DistanceVo("0", "不限"));
    		 	  distances.add(new DistanceVo("1", "1km"));
    		 	 distances.add(new DistanceVo("3", "3km"));
    		 	distances.add(new DistanceVo("5", "5km"));
    		 	distances.add(new DistanceVo("10", "10km"));
    		 	json.put("distances", distances);
    		 	  List<DistrictVo> districts=new ArrayList<DistrictVo>();
    		 	  List<District> districe=this.districtService.findDistricts("citycode", city);
    		 	  for(District d:districe){
    		 		 DistrictVo vo=new DistrictVo(d);
    		 		  districts.add(vo);
    		 		 
    		 	  }
    		 	 json.put("districts", districts);
    		 	  StarsAndPriceVo stars=new  StarsAndPriceVo();
    		 	   json.put("startsAndPrice", stars);
    		 	   
    		 	
    		 	  List<String> facilitys=new ArrayList<String>();
    		 	  facilitys.add("游泳沲");
    		 	 facilitys.add("健身");
    		 	facilitys.add("温泉");
    		 	facilitys.add("海景");
    		 	 json.put("facilitys", facilitys);
    		 	 BaseResponseDTO rdto=new BaseResponseDTO(json);
    		  return rdto; 
         
    }
	 
	/**
	 * 获取房间
	 */
	@RequestMapping(value = "room",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO room(Long hotelId,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		PageView<HotelRoom> pageView = new PageView<HotelRoom>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("hotelId", MatchType.EQ, hotelId));
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));
		 
		List<HotelRoom> shops=this.roomService.findPage(pageView, filters).getResultlist();
		 JSONArray array=new JSONArray();
		 for(HotelRoom d:shops){
			 RoomVo vo=new RoomVo(d);
			 array.add(vo);
	     }
		 
    	 BaseResponseDTO rdto=new BaseResponseDTO(array);
    		     
    		  return rdto; 
         
    }
	 
	
	/**
	 * 查询商店条件
	 * @param shop
	 * @param pageView
	 * @param filters
	 */
	private void setQuery(HotelDto shop,PageView<Hotel> pageView,List<PropertyFilter> filters){
		if(StringUtils.isNotEmpty(shop.getPriceType())){
			if("1".equals(shop.getPriceType())){
				pageView.setOrderby("floorPrice", "desc");	
			}else{
				pageView.setOrderby("floorPrice", "asc");	
			}
			
		}else{
			pageView.setOrderby("floorPrice", "asc");
		}
		
		if(StringUtils.isNotEmpty(shop.getBrand())){
			filters.add(new PropertyFilter("brand", MatchType.EQ, shop.getBrand()));
		}
		 
		if(StringUtils.isNotEmpty(shop.getStars())&&!"不限".equals(shop.getStars())){
			filters.add(new PropertyFilter("stars", MatchType.EQ, shop.getStars()));
		}
		 
		if(StringUtils.isNotEmpty(shop.getCity())){
			filters.add(new PropertyFilter("city", MatchType.LIKE, shop.getCity()));
		}
		if(StringUtils.isNotEmpty(shop.getDistrict())){
			filters.add(new PropertyFilter("district", MatchType.EQ, shop.getDistrict()));
		}
		 
		 
		
		if(StringUtils.isNotEmpty(shop.getArea())){
			filters.add(new PropertyFilter("area", MatchType.LIKE, shop.getArea()));
		}
		 
		if(shop.getDistance()>0&&StringUtils.isNotEmpty(shop.getLongitude())&&StringUtils.isNotEmpty(shop.getLatitude())){
	    
			Map<String, String> map=DistanceUtils.queryLocation(Double.parseDouble(shop.getLongitude()), Double.parseDouble(shop.getLatitude()), shop.getDistance());
		    
			filters.add(new PropertyFilter("latitude", MatchType.GE, map.get("right-bottom_lat")));	
			filters.add(new PropertyFilter("latitude", MatchType.LE, map.get("left-top_lat")));	
			filters.add(new PropertyFilter("longitude", MatchType.GE, map.get("left-top_lng")));	
			filters.add(new PropertyFilter("longitude", MatchType.LE, map.get("right-bottom_lng")));	
			
		}
	}
 
}
