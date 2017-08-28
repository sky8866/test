package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;

public class HotelFacilityVo {
	
	private String faciityName;
	
	public HotelFacilityVo(HotelFacility f){
		this.faciityName=f.getName();
	}

	public String getFaciityName() {
		return faciityName;
	}

	public void setFaciityName(String faciityName) {
		this.faciityName = faciityName;
	}
	
	

}
