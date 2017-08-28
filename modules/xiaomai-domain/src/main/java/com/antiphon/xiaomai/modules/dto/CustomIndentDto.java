package com.antiphon.xiaomai.modules.dto;

public class CustomIndentDto {
	private Long loginId;
	private Long playId;
	private String playName;
	private String playCity;
	private double playPrice;
	private Long customId;

	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public Long getPlayId() {
		return playId;
	}
	public void setPlayId(Long playId) {
		this.playId = playId;
	}
	public String getPlayName() {
		return playName;
	}
	public void setPlayName(String playName) {
		this.playName = playName;
	}
	public String getPlayCity() {
		return playCity;
	}
	public void setPlayCity(String playCity) {
		this.playCity = playCity;
	}
	public double getPlayPrice() {
		return playPrice;
	}
	public void setPlayPrice(double playPrice) {
		this.playPrice = playPrice;
	}
	public Long getCustomId() {
		return customId;
	}
	public void setCustomId(Long customId) {
		this.customId = customId;
	}
	
}
