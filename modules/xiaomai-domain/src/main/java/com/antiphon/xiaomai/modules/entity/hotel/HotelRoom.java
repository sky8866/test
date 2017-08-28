package com.antiphon.xiaomai.modules.entity.hotel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity; 
import com.antiphon.xiaomai.modules.entity.img.Imgs;

@Entity
@Table(name = "xm_hotel_room")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HotelRoom extends IdEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2775247482936868512L;

	
   private  Long hotelId;
	
	private Long userId;
   /**
    * 房间名称
    */
    private String roomName;
	 
    /**
     * 房间面积
     */
     private Integer roomArea;
     /**
      * 床型
      */
     private String bedType;
     /**
      * 几人入住
      */
     private Integer bedNumber;
     /**
      * 楼层
      */
     private Integer floor;
     /**
      * 是否加床0不能1可以
      */
     private Integer addBed;
     
     /**
      * 早餐服务0无早1单早2双早
      */
     private Integer isBreakfast;
     
     /**
      * 1可安排无烟楼层2该房型有无烟房3该房可无烟处理，4无法安排无烟，5
      */
     private Integer smoke;
     /**
      * 0没有1免费2收费
      */
     private Integer broadband;
     
     /**
      * 库存
      */
     private Integer roomNumber;
	
     
     
     /**
      * 客房介绍
      */
     private String roomDesc;
     
     /**
      * 价格
      */
     private String roomPrice;
     
     
     /**
      * 便利设施
      */
     private String amenities;
     
     /**
      * 媒体/科技
      */
     private String multimedia;
     
     /**
      * 食品和饮品
      */
     private String  drink;
     
     /**
      * 浴室
      */
     private String  bathroom;
     
     /**
      * 室外/景观
      */
     private String  outdoor;
     
     /**
      * 服务及其他
      */
     private String  service;
     
 	/**
		 * 1:启用，0：停用
		 */
		private Integer visible=1;
     
     private List<Imgs>  imgs=new ArrayList<Imgs>();

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Integer roomArea) {
		this.roomArea = roomArea;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getAddBed() {
		return addBed;
	}

	public void setAddBed(Integer addBed) {
		this.addBed = addBed;
	}

	public Integer getIsBreakfast() {
		return isBreakfast;
	}

	public void setIsBreakfast(Integer isBreakfast) {
		this.isBreakfast = isBreakfast;
	}

	public Integer getSmoke() {
		return smoke;
	}

	public void setSmoke(Integer smoke) {
		this.smoke = smoke;
	}

	public Integer getBroadband() {
		return broadband;
	}

	public void setBroadband(Integer broadband) {
		this.broadband = broadband;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(String multimedia) {
		this.multimedia = multimedia;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getBathroom() {
		return bathroom;
	}

	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	public String getOutdoor() {
		return outdoor;
	}

	public void setOutdoor(String outdoor) {
		this.outdoor = outdoor;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
     
	@Transient
	public List<Imgs> getImgs() {
		return imgs;
	}

	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

     
     
}
