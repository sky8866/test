package com.antiphon.xiaomai.modules.dto;

import java.util.List;

import com.antiphon.xiaomai.modules.entity.comment.Comment;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;

/**
 * 玩法详情
 * @author pjz
 *
 */
public class CustomPlayHomeDto {

	private String playCoverUrl;
	private String playName;
	private String playCity;
	private List<CustomLabel> customLabels;
	
	private String customPhotoUrl;
	private String customName;
	private String province;
	private String playContent;
	private String playBookings;
	private Double playPrice;
	
	private CommentDto commentDto;
	public String getPlayCoverUrl() {
		return playCoverUrl;
	}
	public void setPlayCoverUrl(String playCoverUrl) {
		this.playCoverUrl = playCoverUrl;
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
	public List<CustomLabel> getCustomLabels() {
		return customLabels;
	}
	public void setCustomLabels(List<CustomLabel> customLabels) {
		this.customLabels = customLabels;
	}
	public String getCustomPhotoUrl() {
		return customPhotoUrl;
	}
	public void setCustomPhotoUrl(String customPhotoUrl) {
		this.customPhotoUrl = customPhotoUrl;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPlayContent() {
		return playContent;
	}
	public void setPlayContent(String playContent) {
		this.playContent = playContent;
	}
	public String getPlayBookings() {
		return playBookings;
	}
	public void setPlayBookings(String playBookings) {
		this.playBookings = playBookings;
	}
	public Double getPlayPrice() {
		return playPrice;
	}
	public void setPlayPrice(Double playPrice) {
		this.playPrice = playPrice;
	}
	public CommentDto getCommentDto() {
		return commentDto;
	}
	public void setCommentDto(CommentDto commentDto) {
		this.commentDto = commentDto;
	}
	
	
	
}
