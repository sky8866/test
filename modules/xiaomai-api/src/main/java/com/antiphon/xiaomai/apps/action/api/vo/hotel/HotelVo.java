package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import java.util.ArrayList;
import java.util.List;

import com.antiphon.xiaomai.apps.action.api.vo.cate.ImgsVo;
import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;
import com.antiphon.xiaomai.modules.entity.img.Imgs;

public class HotelVo {
	/**
	 * 酒店名称
	 */
	private String hotelName;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 星级
	 */
    private String	stars;
	/**
	 * 英文名字
	 */
	private String hotelEname;
	/**
	 * 酒店简称
	 */
	private String hotelAbbr;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 地区
	 */
	private String district;
	/**
	 * 具体位置
	 */
	private String address;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 酒店介绍
	 */
	private String content;
	/**
	 * 酒店政策
	 */
	private String hotelPolicy;
	/**
	 * 最低价格
	 */
	private String floorPrice;
	
	 /**
	    * 经度
	    */
	   private String longitude;
	   
	   /**
	    * 纬度
	    */
	   private String latitude;
	   
	   private String hotelId;
	   
	   private String cover;
	   
	   private String starSum="4.5";
	   
	   private String distances="1km";
	   
	
	private List<HotelFacilityVo> facilitys=new ArrayList<HotelFacilityVo>();
	
	private List<ImgsVo>  hotelImgs=new ArrayList<ImgsVo>();
	public HotelVo(Hotel h){
		  this.hotelName=h.getHotelName();
	 
		  this.brand=h.getBrand();
		 
		  this.stars=h.getStars(); 
		  this.hotelEname=h.getHotelEname();
	 
		  this.hotelAbbr=h.getHotelAbbr();
		 
		   this.province=h.getProvince();
	    
		   this.city=h.getCity(); 
	      this.district=h.getDistrict(); 
	      this.address=h.getAddress(); 
	      this.tel=h.getTel();
	      this.content=h.getContent(); 
	      this.hotelPolicy=h.getHotelPolicy();
	      this.floorPrice=h.getFloorPrice()+"";
	      this.latitude=h.getLatitude();
	      this.longitude=h.getLongitude();
	      this.hotelId=h.getId()+"";
	      if(StringUtils.isNotEmpty(h.getCover())){
		    	
		    	 this.cover=ConfigUtil.getValue("server")+h.getCoverPath();
		    }
	      for(HotelFacility f:h.getFacilitys()){
	    	  HotelFacilityVo fv=new HotelFacilityVo(f);
	    	  facilitys.add(fv);
	      }
	      for(Imgs im:h.getImgs()){
		    	ImgsVo vo=new ImgsVo(im);
		    	hotelImgs.add(vo);
		    }
	}
	
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

	public String getFloorPrice() {
		return floorPrice;
	}

	public void setFloorPrice(String floorPrice) {
		this.floorPrice = floorPrice;
	}

	public List<ImgsVo> getHotelImgs() {
		return hotelImgs;
	}

	public void setHotelImgs(List<ImgsVo> hotelImgs) {
		this.hotelImgs = hotelImgs;
	}

	public List<HotelFacilityVo> getFacilitys() {
		return facilitys;
	}

	public void setFacilitys(List<HotelFacilityVo> facilitys) {
		this.facilitys = facilitys;
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

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getStarSum() {
		return starSum;
	}

	public void setStarSum(String starSum) {
		this.starSum = starSum;
	}

	public String getDistances() {
		return distances;
	}

	public void setDistances(String distances) {
		this.distances = distances;
	}
	
	
	
	
	
}
