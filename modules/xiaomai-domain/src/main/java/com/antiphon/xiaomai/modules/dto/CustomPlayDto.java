package com.antiphon.xiaomai.modules.dto;

public class CustomPlayDto {

	private Long id;
	private String playName;
	private Double playPrice;
	private String playCoverUrl;
	private String playType;
	private String playCity;
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


	public Double getPlayPrice() {
		return playPrice;
	}
	public void setPlayPrice(Double playPrice) {
		this.playPrice = playPrice;
	}
	public String getPlayCoverUrl() {
		return playCoverUrl;
	}
	public void setPlayCoverUrl(String playCoverUrl) {
		this.playCoverUrl = playCoverUrl;
	}
	public String getPlayType() {
		return playType;
	}
	public void setPlayType(String playType) {
		this.playType = playType;
	}
	public String getPlayCity() {
		return playCity;
	}
	public void setPlayCity(String playCity) {
		this.playCity = playCity;
	}
	
	
}
