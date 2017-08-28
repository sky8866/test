package com.antiphon.xiaomai.modules.dto;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;

public class CustomInfoPlayDto {
	private Long id;
	private String playName;
	private String photoUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlayName() {
		return playName;
	}
	public void setPlayName(String playName) {
		this.playName = playName;
	}
	public String getPhotoUrl() {
		if (StringUtils.isNotEmpty(photoUrl))
			return ConfigUtil.getValue("server")+photoUrl;
		return "";
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}
