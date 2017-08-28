package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import com.antiphon.xiaomai.modules.entity.city.District;

public class DistrictVo {
	
 
	private String code;
	private String name;
	
	public DistrictVo(District d){
	    this.code=d.getDistrictcode();
		this.name=d.getDistrictname();
	}

 

	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
