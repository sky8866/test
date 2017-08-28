package com.antiphon.xiaomai.modules.dto;

import java.util.Set;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;

public class CustomInfoDto {
	private String name;//定制师昵称
	private String customPhoto;//定制师头像
	private double grade;//评分
	private String inhabitCity;//服务地
	private String VOL;//成交量
	//private Long userId;
	private Long customId;//定制师id
	private String introduceMyself;//定制师自我介绍
	private Set<String>  customLabels;//个性标签
	
//	private List<CustomHomeHotCityDto>  hotCityDts;//热门目的地
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getInhabitCity() {
		return inhabitCity;
	}
	public void setInhabitCity(String inhabitCity) {
		this.inhabitCity = inhabitCity;
	}
	public String getVOL() {
		return VOL;
	}
	public void setVOL(String vOL) {
		VOL = vOL;
	}
	
	public Set<String> getCustomLabels() {
		return customLabels;
	}
	public void setCustomLabels(Set<String> customLabels) {
		this.customLabels = customLabels;
	}
	
	public Long getCustomId() {
		return customId;
	}
	public void setCustomId(Long customId) {
		this.customId = customId;
	}
	public String getCustomPhoto() {
		return customPhoto;
	}
	public void setCustomPhoto(String customPhoto) {
		if(StringUtils.isNotEmpty(customPhoto)){
			customPhoto=ConfigUtil.getValue("server")+customPhoto;
		}
		this.customPhoto = customPhoto;
	}
	public String getIntroduceMyself() {
		return introduceMyself;
	}
	public void setIntroduceMyself(String introduceMyself) {
		this.introduceMyself = introduceMyself;
	}
	
	
}
