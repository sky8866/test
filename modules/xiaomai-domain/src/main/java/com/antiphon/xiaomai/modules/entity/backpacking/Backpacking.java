package com.antiphon.xiaomai.modules.entity.backpacking;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 约伴
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_backpacking") 
public class Backpacking extends RecordEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5238363982719016650L;
	
	private String title;
	private String type;
	private String city;
	private String address;
	private String longitude;
	private String latitude;
	/**
	 * 邀约对象
	 */
	private String inviteObject;
	/**
	 *  邀约人数
	 */
	private Integer inviteNum;
	/**
	 * 费用
	 */
	private String expense;
	/**
	 * 时间 
	 */
	private String serviceTime;
	/**
	 * 接送
	 */
	private String pickUp;
	/**
	 * 说明
	 */
	private String introduce;
	private Integer status;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getInviteObject() {
		return inviteObject;
	}
	public void setInviteObject(String inviteObject) {
		this.inviteObject = inviteObject;
	}
	public Integer getInviteNum() {
		return inviteNum;
	}
	public void setInviteNum(Integer inviteNum) {
		this.inviteNum = inviteNum;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public String getPickUp() {
		return pickUp;
	}
	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
