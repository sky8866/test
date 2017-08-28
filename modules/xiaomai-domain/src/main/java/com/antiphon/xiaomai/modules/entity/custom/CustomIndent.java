package com.antiphon.xiaomai.modules.entity.custom;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 定制游订单
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_custom_indent") 
public class CustomIndent extends RecordEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8344249749684738573L;
	private Long customId;//定制师id
	private String departureTime; //出发时间
	private int numberOfPeople; //出行人数
	private double totalPrices;//总金额
	private Long loginId;//后台id
	private String userName;//客户姓名
	private String userPhone;//客户电话
	private String remark; //备注
	private Long playId; 
	private String playName;//玩法名称
	private String playCity;//所在城市
	private int status;//状态
	
	private Date chargeTime;//核销时间
	
	

	public Long getCustomId() {
		return customId;
	}
	public void setCustomId(Long customId) {
		this.customId = customId;
	}

	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getPlayId() {
		return playId;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setPlayId(Long playId) {
		this.playId = playId;
	}
	public String getPlayName() {
		return playName;
	}
	public void setPlayName(String playName) {
		this.playName = playName;
	}
	public String getPlayCity() {
		return playCity;
	}
	public void setPlayCity(String playCity) {
		this.playCity = playCity;
	}
	public Date getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
