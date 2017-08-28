package com.antiphon.xiaomai.modules.dto;

import java.util.List;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.comment.Comment;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;

public class CustomInfoHomeDto {
	
	private Long id;
	private String customName;
	private String customPhoto;
	private Integer IndentTotal;
	private String inhabitCity;
	private String introduceMyself;
	private Double serveBest;//评分
	private Integer commentTotal;
	private List<CustomInfoPlayDto> CustomInfoPlayDtoList;
	
	List<CommentAndReturnDto>  comments;
	
	List<String> labels;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	public Integer getIndentTotal() {
		return IndentTotal;
	}
	public void setIndentTotal(Integer indentTotal) {
		IndentTotal = indentTotal;
	}
	public String getInhabitCity() {
		return inhabitCity;
	}
	public void setInhabitCity(String inhabitCity) {
		this.inhabitCity = inhabitCity;
	}
	public String getIntroduceMyself() {
		return introduceMyself;
	}
	public void setIntroduceMyself(String introduceMyself) {
		this.introduceMyself = introduceMyself;
	}
	public List<CustomInfoPlayDto> getCustomInfoPlayDtoList() {
		return CustomInfoPlayDtoList;
	}
	public void setCustomInfoPlayDtoList(
			List<CustomInfoPlayDto> customInfoPlayDtoList) {
		CustomInfoPlayDtoList = customInfoPlayDtoList;
	}
	public Double getServeBest() {
		return serveBest;
	}
	public void setServeBest(Double serveBest) {
		this.serveBest = serveBest;
	}
	public Integer getCommentTotal() {
		return commentTotal;
	}
	public void setCommentTotal(Integer commentTotal) {
		this.commentTotal = commentTotal;
	}
	public List<CommentAndReturnDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentAndReturnDto> comments) {
		this.comments = comments;
	}
	
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public String getCustomPhoto() {
		if (StringUtils.isNotEmpty(customPhoto))
			return ConfigUtil.getValue("server")+customPhoto;
		return "";
	}
	public void setCustomPhoto(String customPhoto) {
		this.customPhoto = customPhoto;
	}
	
	
	
}
