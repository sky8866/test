package com.antiphon.xiaomai.apps.action.api.vo.city;

import com.antiphon.xiaomai.modules.entity.city.District;
 

public class DistrictVo { 
 
 
	 
	 private String districtcode;
	 
	 private String districtname;

	 public DistrictVo(District d){
		 this.districtcode=d.getDistrictcode();
		 this.districtname=d.getDistrictname();
	 }
	public String getDistrictcode() {
		return districtcode;
	}

	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	 
	 
	 
	 
	
}
