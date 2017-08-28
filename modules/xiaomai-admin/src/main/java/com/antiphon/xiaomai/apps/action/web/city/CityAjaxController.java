package com.antiphon.xiaomai.apps.action.web.city;

 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List; 
import java.util.Set;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.cate.CateShopImg;
import com.antiphon.xiaomai.modules.entity.cate.Category;
import com.antiphon.xiaomai.modules.entity.city.City;
import com.antiphon.xiaomai.modules.entity.city.District;
import com.antiphon.xiaomai.modules.entity.city.Province; 
import com.antiphon.xiaomai.modules.service.city.CityService;
import com.antiphon.xiaomai.modules.service.city.DistrictService;
import com.antiphon.xiaomai.modules.service.city.ProvinceService; 
  


@Controller
@RequestMapping(value = "/admin/ajax")
public class CityAjaxController {
 
	  private final static String BASE_PATH = "city/"; 
       @Autowired private ProvinceService provinceService;
       @Autowired private CityService cityService;
       @Autowired private DistrictService districtService;
    @RequestMapping(value = "province",method =RequestMethod.POST)
	public String cateShop(String provincecode,String citycode,HttpServletRequest request) {
    	    
    	  List<Province> ps=this.provinceService.findProvinces();
    	 
    	  request.setAttribute("provinceList", ps);
    	  request.setAttribute("provincecode", provincecode); 
    	return BASE_PATH+"province";
	}
    
    
    @RequestMapping(value = "city",method =RequestMethod.POST)
	public String city(String provincecode,String citycode,HttpServletRequest request) {
    	    
    	  List<City> ps=this.cityService.findCitys("provincecode", provincecode);
    	  request.setAttribute("cityList", ps);
    	  if(!ps.contains(citycode)){
    		 
    		  citycode=ps.get(0).getCitycode(); 
    	  }
    	  request.setAttribute("citycode", citycode);
    	return BASE_PATH+"city";
	}
    
    
    @RequestMapping(value = "district",method =RequestMethod.POST)
	public String district(String citycode,String districtcode,HttpServletRequest request) {
    	    System.out.println("city"+citycode);
    	  List<District> ps=this.districtService.findDistricts("citycode", citycode);
    	  request.setAttribute("districtList", ps); 
    	 /* for(District d:ps){
    		  System.out.println("d:"+d.getDistrictcode());
    	  }
    	  System.out.println("dn:"+districtcode);*/
    	  
    	  request.setAttribute("districtcode", districtcode); 
    	return BASE_PATH+"distrtct";
	}
    
   
 
}


