package com.antiphon.xiaomai.modules.dto;

public class TicketHomeDto {

	private Long id;
	private Long LoginId;
	private String ticketName;
	private String ticketAddress;
	private String openTime;
	private String specialDateDescription;
	private Integer reserveDate;
	private String ticketIntroduce;
	private String bookings;
	private String usageMode;
	private double ticketPrice;
	private String longitude;
	private String latitude;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getLoginId() {
		return LoginId;
	}
	public void setLoginId(Long loginId) {
		LoginId = loginId;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getTicketAddress() {
		return ticketAddress;
	}
	public void setTicketAddress(String ticketAddress) {
		this.ticketAddress = ticketAddress;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getSpecialDateDescription() {
		return specialDateDescription;
	}
	public void setSpecialDateDescription(String specialDateDescription) {
		this.specialDateDescription = specialDateDescription;
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
	public String getBookings() {
		return bookings;
	}
	public void setBookings(String bookings) {
		this.bookings = bookings;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getUsageMode() {
		return usageMode;
	}
	public void setUsageMode(String usageMode) {
		this.usageMode = usageMode;
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
	
	
}
