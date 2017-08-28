package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;

public class RoomVo {
	
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
	     private String addBed;
	     
	     /**
	      * 早餐服务0无早1单早2双早
	      */
	     private String isBreakfast;
	 
	     /**
	      * 0没有1免费 
	      */
	     private String wifi;
	     
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
	     
	     private String roomId;
	     
	
	
	public RoomVo(HotelRoom r){ 
		    this.roomName=r.getRoomName();
			 
		     this.roomArea=r.getRoomArea();
		    
		     this.bedType=r.getBedType(); 
		     this.bedNumber=r.getBedNumber(); 
		     this.floor=r.getFloor(); 
		     this.addBed=r.getAddBed()==0?"不能":"可以"; 
		     String breakfast="无早";
		     if(r.getIsBreakfast()==1){
		    	 breakfast="单早";
		     }else if(r.getIsBreakfast()==2){
		    	 breakfast="双早";
		     }
		     this.isBreakfast=breakfast;
		      
		     this.wifi=r.getBroadband()==0?"无":"有";
		      
		    this.roomNumber=r.getRoomNumber(); 
		    this.roomDesc=r.getRoomDesc(); 
		    this.roomPrice=r.getRoomPrice(); 
		    this.amenities=r.getAmenities(); 
		     this.multimedia=r.getMultimedia(); 
		   this.drink=r.getDrink(); 
		   this.bathroom=r.getBathroom(); 
		   this.outdoor=r.getOutdoor(); 
		   this.service=r.getService();
		   this.roomId=r.getId()+"";  
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





	public String getAddBed() {
		return addBed;
	}





	public void setAddBed(String addBed) {
		this.addBed = addBed;
	}





	public String getIsBreakfast() {
		return isBreakfast;
	}





	public void setIsBreakfast(String isBreakfast) {
		this.isBreakfast = isBreakfast;
	}





	public String getWifi() {
		return wifi;
	}





	public void setWifi(String wifi) {
		this.wifi = wifi;
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





	public String getRoomId() {
		return roomId;
	}





	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}



 
	
	

}
