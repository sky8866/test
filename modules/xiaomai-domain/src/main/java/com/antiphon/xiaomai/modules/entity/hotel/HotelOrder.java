package com.antiphon.xiaomai.modules.entity.hotel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

@Entity
@Table(name = "xm_hotel_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HotelOrder extends RecordEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 95594209768836438L;
	
	/**
	 * 入住时间
	 */
     private String checkinTime;
     /**
      * 退房时间
      */
     private String ckeckTime;
     /**
      * 天数
      */
     private Integer day;
     /**
      * 房间数
      */
     private Integer roomNumber;
     /**
      * 入住人数
      */
     private Integer bedNumber;
     /**
      * 联系方式
      */
     private String  phone;
     /**
      * 姓名
      */
     private String name;
     
     /**
      * 最晚到店时间
      */
     private String longestTime;
     /**
      * 特殊要求
      */
     private String  remark;
     /**
      * 发票
      */
     private String invoice;
     /**
      * 总额
      */
     private Double total;
     /**
      * 0：等待付款，1：已经付款，2：已取消
      */
     private String status="0";
     
     private Long  hotelId;
     
     private Long roomId;

     private String hotelName;
     
     private String roomName;

	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getCkeckTime() {
		return ckeckTime;
	}

	public void setCkeckTime(String ckeckTime) {
		this.ckeckTime = ckeckTime;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongestTime() {
		return longestTime;
	}

	public void setLongestTime(String longestTime) {
		this.longestTime = longestTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	@Transient
	 public String getStatu(){
		if("0".equals(status)){
			return "未付款";
		}else if("1".equals(status)){
			return "已付款";
		}
		return "已取消";
	}
     
     
     
}
