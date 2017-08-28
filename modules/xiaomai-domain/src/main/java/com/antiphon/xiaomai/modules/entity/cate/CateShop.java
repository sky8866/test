package com.antiphon.xiaomai.modules.entity.cate;

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
@Table(name = "xm_cate_shop")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CateShop extends RecordEntity{
   /**
	 * 
	 */
	private static final long serialVersionUID = -2099282311744674618L;
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
   
   private String province;
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
    * 经度
    */
   private String longitude;
   
   /**
    * 纬度
    */
   private String latitude;
   
    /**
     * 地图
     */
   private String map;
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
	 * 1:启用，0：停用
	 */
	private Integer visible=1;
   
   private List<Imgs>  shopImgs=new ArrayList<Imgs>();

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

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
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
	 
	private String starttime;
	private String endtime;
	@Transient
	public String getStarttime() {
		if(StringUtils.isNotEmpty(businessHours)){
    		String[] hours=businessHours.split("_");
    		return  hours[0];
    	}
    	return starttime;
		
		 
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	@Transient
	public String getEndtime() {
		if(StringUtils.isNotEmpty(businessHours)){
    		String[] hours=businessHours.split("_");
    		return  hours[1];
    	}
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Transient
	public List<Imgs> getShopImgs() {
		return shopImgs;
	}

	public void setShopImgs(List<Imgs> shopImgs) {
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
	
	
	 public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	
	

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Transient
	    public String getCoverPath(){
	        
	  
	        if(StringUtils.isNotEmpty(cover)) return "/images/cate/cover/"+super.getUserId()+"/"+cover;
	        return "";
	    }
	
 
}
