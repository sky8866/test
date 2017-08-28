package com.antiphon.xiaomai.modules.dto;
/**
 * 精选人气景点
 * @author pjz
 *
 */
public class ChoicenessTicketDto {

	private String id;
	private String ticketPhotoUrl;
	private String ticketName;
	private String ticketPrice;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTicketPhotoUrl() {
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
	
	
}
