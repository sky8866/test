package com.antiphon.xiaomai.modules.entity.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 门票管理
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_ticket_manage") 
public class TicketManage extends RecordEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3724814896528534593L;

	/**
	 * 门票名称
	 */
	private String ticketName;
	
	/**
	 * 门票价格
	 */
	private Double ticketPrice;
	
	/**
	 * 门票类型
	 */
	private String ticketType;
	
	/**
	 * 门票照片封面
	 */
	private String ticketPhotoUrl;
	
	/**
	 * 预定时间
	 */
	private String presetTime;
	
	/**
	 * 使用方式
	 */
	private String usageMode;
	
	/**
	 * 退订规则
	 */
	private String unsubscribeRules;
	
	/**
	 * 预定须知
	 */
	private String bookings;
	
	/**
	 * 备注
	 */
	private String notes;
	
	
	/**
	 * 门票所在城市
	 */
	private String ticketCity;
	
	/**
	 * 百度地图经度
	 */
	private String longitude;
	
	/**
	 * 百度地图纬度
	 */
	private String latitude;
	
	/**
	 * 开放时间
	 */
	private String openTime;
	
	/**
	 * 人群政策
	 */
	private String policy;
	
	/**
	 * 预定提醒
	 */
	private String presetRemind;
	
	/**
	 * 温馨提示
	 */
	private String warmRemind;
	
	/**
	 * 特殊日期说明
	 */
	private String specialDateDescription;

	/**
	 * 销量
	 */
	
	private String salesVolume;
	/**
	 * 总价格
	 */
	private String salesTotalPrice;
	
	/**
	 * 精选景点
	 */
	private String ticketAddress;
	/**
	 * 提前几天预定
	 */
	private Integer reserveDate;
	/**
	 * 景点介绍
	 */
	private String ticketIntroduce;
	
	/**
	 * 门票状态
	 */
	private Integer status;
	
	//private Integer selectTicket;

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}


	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTicketCity() {
		return ticketCity;
	}

	public void setTicketCity(String ticketCity) {
		this.ticketCity = ticketCity;
	}

	public String getPresetTime() {
		return presetTime;
	}

	public void setPresetTime(String presetTime) {
		this.presetTime = presetTime;
	}

	public String getUsageMode() {
		return usageMode;
	}

	public void setUsageMode(String usageMode) {
		this.usageMode = usageMode;
	}

	public String getUnsubscribeRules() {
		return unsubscribeRules;
	}

	public void setUnsubscribeRules(String unsubscribeRules) {
		this.unsubscribeRules = unsubscribeRules;
	}

	public String getBookings() {
		return bookings;
	}

	public void setBookings(String bookings) {
		this.bookings = bookings;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Column(updatable=false)
	public String getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(String salesVolume) {
		this.salesVolume = salesVolume;
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

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getPresetRemind() {
		return presetRemind;
	}

	public void setPresetRemind(String presetRemind) {
		this.presetRemind = presetRemind;
	}

	public String getWarmRemind() {
		return warmRemind;
	}

	public void setWarmRemind(String warmRemind) {
		this.warmRemind = warmRemind;
	}

	public String getSpecialDateDescription() {
		return specialDateDescription;
	}

	public void setSpecialDateDescription(String specialDateDescription) {
		this.specialDateDescription = specialDateDescription;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketPhotoUrl() {
		return ticketPhotoUrl;
	}

	public void setTicketPhotoUrl(String ticketPhotoUrl) {
		this.ticketPhotoUrl = ticketPhotoUrl;
	}
	@Column(updatable=false)
	public String getSalesTotalPrice() {
		return salesTotalPrice;
	}

	public void setSalesTotalPrice(String salesTotalPrice) {
		this.salesTotalPrice = salesTotalPrice;
	}

	public String getTicketAddress() {
		return ticketAddress;
	}

	public void setTicketAddress(String ticketAddress) {
		this.ticketAddress = ticketAddress;
	}

	public Integer getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Integer reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getTicketIntroduce() {
		return ticketIntroduce;
	}

	public void setTicketIntroduce(String ticketIntroduce) {
		this.ticketIntroduce = ticketIntroduce;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


/*	public Integer getSelectTicket() {
		return selectTicket;
	}

	public void setSelectTicket(Integer selectTicket) {
		this.selectTicket = selectTicket;
	}*/

	@Transient
	public String getImagePath() {
		if (StringUtils.isNotEmpty(ticketPhotoUrl))
			return ConfigUtil.getValue("server")+ticketPhotoUrl;
		return "";
	}
	
	
	
}
