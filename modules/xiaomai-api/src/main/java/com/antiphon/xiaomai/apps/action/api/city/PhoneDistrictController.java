package com.antiphon.xiaomai.apps.action.api.city;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray; 
import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.apps.action.api.vo.city.CityVo;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.city.City; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;
import com.antiphon.xiaomai.modules.service.city.CityService;
import com.antiphon.xiaomai.modules.service.city.DistrictService;
import com.antiphon.xiaomai.modules.service.city.ProvinceService;

@Controller
@RequestMapping(value = "/phone/district")
public class PhoneDistrictController extends BaseController {
 
	  @Autowired private CityService cityService;
     @Autowired private DistrictService districtService;
	/**
	 * 获取地区
	 */
	@RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO district(String city,HttpServletResponse response,HttpServletRequest request)  throws Exception{
        
		PageView<City> pageView = new PageView<City>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("cityname", MatchType.LIKE, city));
     
               List<City> citys=this.cityService.findPage(pageView, filters).getResultlist();
               JSONArray array=new JSONArray();
               for(City c:citys){
            	   c.setDistricts(this.districtService.findDistricts("citycode", c.getCitycode()));
            	   CityVo cvo=new CityVo(c);
            	   array.add(cvo);
               }
           
    		 
    		     
    		   return new BaseResponseDTO(array);     
    	 
     
        
         
    }
 
}
