package com.antiphon.xiaomai.modules.dto;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;

/**
 * 热门景点
 * @author pjz
 *
 */
public class HotTicketDto {

	private String id;
	private String ticketPhotoUrl;
	private String ticketName;
	private String ticketPrice;
	private Double ticketDistance;
	private String ticketCity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTicketPhotoUrl() {
		if(StringUtils.isNotEmpty(ticketPhotoUrl)) return ConfigUtil.getValue("server")+""+ticketPhotoUrl;
		return ticketPhotoUrl;
	}
	public void setTicketPhotoUrl(String ticketPhotoUrl) {
		this.ticketPhotoUrl = ticketPhotoUrl;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Double getTicketDistance() {
		return ticketDistance;
	}
	public void setTicketDistance(Double ticketDistance) {
		this.ticketDistance = ticketDistance;
	}
	public String getTicketCity() {
		return ticketCity;
	}
	public void setTicketCity(String ticketCity) {
		this.ticketCity = ticketCity;
	}
	
	
}
