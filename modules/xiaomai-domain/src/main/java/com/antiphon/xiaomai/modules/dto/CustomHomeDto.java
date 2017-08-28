package com.antiphon.xiaomai.modules.dto;

import java.util.List;

public class CustomHomeDto {

	private List<CustomInfoDto> CustomInfoDtos;
	
	private List<CustomHomeHotCityDto> CustomHomeHotCityDtos;

	public List<CustomInfoDto> getCustomInfoDtos() {
		return CustomInfoDtos;
	}

	public void setCustomInfoDtos(List<CustomInfoDto> customInfoDtos) {
		CustomInfoDtos = customInfoDtos;
	}

	public List<CustomHomeHotCityDto> getCustomHomeHotCityDtos() {
		return CustomHomeHotCityDtos;
	}

	public void setCustomHomeHotCityDtos(
			List<CustomHomeHotCityDto> customHomeHotCityDtos) {
		CustomHomeHotCityDtos = customHomeHotCityDtos;
	}
	
	
}
