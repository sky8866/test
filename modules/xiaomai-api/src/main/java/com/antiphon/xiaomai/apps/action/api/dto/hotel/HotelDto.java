package com.antiphon.xiaomai.apps.action.api.dto.hotel;
 

public class HotelDto {
    private String city;
    private String district;
    private String longitude;
    private String latitude;
    private Integer distance=0;
	private String area;
	private String  koubei;
	private String stars;
	private String brand;
	private String facility;
	
	private String priceType;
	
	private Integer pageSize=10;
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

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getKoubei() {
		return koubei;
	}

	public void setKoubei(String koubei) {
		this.koubei = koubei;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	 
	

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType ) {
		this.priceType = priceType;
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
