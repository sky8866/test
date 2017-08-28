package com.antiphon.xiaomai.modules.entity.hotel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.RecordEntity;
import com.antiphon.xiaomai.modules.entity.img.Imgs;

@Entity
@Table(name = "xm_hotel")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Hotel extends RecordEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2775247482936868512L;

	/**
	 * 酒店名称
	 */
	private String hotelName;
	/**
	 * 品牌
	 */
	private String brand;
	
    private String	stars;
	
	private String hotelEname;
	
	private String hotelAbbr;
	
	private String province;
	
	private String city;
	
	private String district;
	
	private String address;
	
	private String tel;
	
	private String content;
	
	private String hotelPolicy;
	
	private String latitude;
	
	private String longitude;
	
	private String map;
	
	/**
	 * 1:启用，0：停用
	 */
	private Integer visible=1;
	
	private Integer floorPrice;
	
	  private String cover;
	
    private List<HotelFacility> facilitys=new ArrayList<HotelFacility>();
    private List<Imgs>  imgs=new ArrayList<Imgs>();


	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getHotelEname() {
		return hotelEname;
	}

	public void setHotelEname(String hotelEname) {
		this.hotelEname = hotelEname;
	}

	public String getHotelAbbr() {
		return hotelAbbr;
	}

	public void setHotelAbbr(String hotelAbbr) {
		this.hotelAbbr = hotelAbbr;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHotelPolicy() {
		return hotelPolicy;
	}

	public void setHotelPolicy(String hotelPolicy) {
		this.hotelPolicy = hotelPolicy;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	
	
	@Transient
	public List<Imgs> getImgs() {
		return imgs;
	}

	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
	}

	public Integer getFloorPrice() {
		return floorPrice;
	}

	public void setFloorPrice(Integer floorPrice) {
		this.floorPrice = floorPrice;
	}
	@Transient
	public List<HotelFacility> getFacilitys() {
		return facilitys;
	}

	public void setFacilitys(List<HotelFacility> facilitys) {
		this.facilitys = facilitys;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	
	@Transient
    public String getCoverPath(){
        
  
        if(StringUtils.isNotEmpty(cover)) return "/images/hotel/cover/"+super.getUserId()+"/"+cover;
        return "";
    }
	
}
