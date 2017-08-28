package com.antiphon.xiaomai.modules.dto;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;

public class CustomHomeHotCityDto {

	/**
	 * 热门城市
	 */
	private String city;
	/**
	 * 城市的关联图片url
	 */
	private String cityPhoto;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityPhoto() {
		if (StringUtils.isNotEmpty(cityPhoto))
			return ConfigUtil.getValue("server")+cityPhoto;
		return "";
	}
	public void setCityPhoto(String cityPhoto) {
		this.cityPhoto = cityPhoto;
	}
	
	
}
