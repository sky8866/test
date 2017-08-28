package com.antiphon.xiaomai.apps.action.api.dto.cate;
 

public class ShopDto {
    private String city;
    private String district;
    private String longitude;
    private String latitude;
    private Integer distance=0;
	private String area;
	private String  gory;
	private String priceType;
	private String payType;
	private Integer  pageSize=10;
	private Integer hot;
	
	private Integer pageNo=1;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	 
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGory() {
		return gory;
	}
	public void setGory(String gory) {
		this.gory = gory;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Integer getDistance() {
		if(distance==null) return 0;
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	 
	public Integer getHot() {
		if(hot==null) return 0;
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	 
	 
	
	
}
