package com.antiphon.xiaomai.apps.action.api.vo.city;

import java.util.ArrayList;
import java.util.List;

import com.antiphon.xiaomai.modules.entity.city.City;
import com.antiphon.xiaomai.modules.entity.city.District;
 

public class CityVo { 
 
 
	 
	 private String citycode;
	 
	 private String cityname;
	 
	 private List<DistrictVo> districts=new ArrayList<DistrictVo>();
     
	 public CityVo(City c){
		 this.citycode=c.getCitycode();
		 this.cityname=c.getCityname();
		 for(District d:c.getDistricts()){
			 DistrictVo dv=new DistrictVo(d);
			 districts.add(dv);
		 }
		 
	 }
	 
	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public List<DistrictVo> getDistricts() {
		return districts;
	}
	public void setDistricts(List<DistrictVo> districts) {
		this.districts = districts;
	}
 
	
	
	 
	 
	 
	 
	 
	 
	
}
