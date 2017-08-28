package com.antiphon.xiaomai.apps.action.api.vo.cate;

import java.util.ArrayList;
import java.util.List;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
 

public class CateShopVo {
	
	     private String shopId;
	/**
	    * 店名
	    */
		private String name;
	   /**
	    * 店类型
	    */
	   private String type;
	   /**
	    * 电话
	    */
	   private String phone;
	   /**
	    * 城市
	    */
	   private String city;
	   
	   /**
	    * 行政区
	    */
	   private String district;
	   
	   /**
	    * 地址
	    */
	   private String address;
	   
	   /**
	    * 区域
	    */
	   private String area;
	   /**
	    * 状态
	    */
	   private String status;
	   
	   /**
	    * 人均消费
	    */
	   
	   private String consumption;
	   
 

	   /**
	    * 营业时间
	    */
	   
	   private String businessHours;
	   /**
	    * 0：无,1:有
	    */
	   private String wifi;
	   /**
	    * 停车位 0：无,1:有
	    */
	   private String parkingSpace;
	   
	   private String cover;
	   
	   private String info;
	   
	   /**
	    * 经度
	    */
	   private String longitude;
	   
	   /**
	    * 纬度
	    */
	   private String latitude;
	   
	   private String starSum="4.5";
	   
	   private List<ImgsVo>  shopImgs=new ArrayList<ImgsVo>();

       private PayTypeVo payType;
	   
	   public CateShopVo(CateShop s,PayTypeVo payType){
		   this.shopId=s.getId()+"";
		    this.name=s.getName(); 
		    type=s.getType();
		    phone=s.getPhone(); 
		    city=s.getCity();
		    district=s.getDistrict(); 
		    address=s.getAddress(); 
		    area=s.getArea(); 
		    status=s.getStatus(); 
		    consumption=s.getConsumption();
		    String time=s.getStarttime()+"至"+s.getEndtime();
		    businessHours=StringUtils.isNotEmpty(s.getBusinessHours())?time:""; 
		    wifi="0".equals(s.getWifi())?"无":"有";
		    parkingSpace="0".equals(s.getParkingSpace())?"无":"有";
		    this.payType=payType;
		    if(StringUtils.isNotEmpty(s.getCover())){
		    	
		    	 this.cover=ConfigUtil.getValue("server")+s.getCoverPath();
		    }
	        this.latitude=s.getLatitude();
	        this.longitude=s.getLongitude();
	         this.info=s.getInfo();
		    for(Imgs im:s.getShopImgs()){
		    	ImgsVo vo=new ImgsVo(im);
		    	shopImgs.add(vo);
		    }
		    
		    
	   }
	   
	   
	   
	public String getShopId() {
		return shopId;
	}



	public void setShopId(String shopId) {
		this.shopId = shopId;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getConsumption() {
		return consumption;
	}


	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}

 


	public String getBusinessHours() {
		return businessHours;
	}


	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}


	public String getWifi() {
		return wifi;
	}


	public void setWifi(String wifi) {
		this.wifi = wifi;
	}


	public String getParkingSpace() {
		return parkingSpace;
	}


	public void setParkingSpace(String parkingSpace) {
		this.parkingSpace = parkingSpace;
	}


	public List<ImgsVo> getShopImgs() {
		return shopImgs;
	}


	public void setShopImgs(List<ImgsVo> shopImgs) {
		this.shopImgs = shopImgs;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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



	public String getStarSum() {
		return starSum;
	}



	public void setStarSum(String starSum) {
		this.starSum = starSum;
	}



	public PayTypeVo getPayType() {
		return payType;
	}



	public void setPayType(PayTypeVo payType) {
		this.payType = payType;
	}
	   
	   
}
