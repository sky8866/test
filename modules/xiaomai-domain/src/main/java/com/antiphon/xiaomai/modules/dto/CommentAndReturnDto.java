package com.antiphon.xiaomai.modules.dto;

import java.util.List;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;

/**
 * 评论表dto
 * @author pjz
 *
 */
public class CommentAndReturnDto{

	private Long id;
	private String picture;//头像
	private String userName;
	private String createTime;
	private String resourceName;
	private String content;
	private String score;
	
	private List<String> photo;//评论图片
	
	private List<CommentReplyDto> CommentReplys;

	//private String customName;
	//private String replyTime;
	//private String replycontent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public List<CommentReplyDto> getCommentReplys() {
		return CommentReplys;
	}
	public void setCommentReplys(List<CommentReplyDto> commentReplys) {
		CommentReplys = commentReplys;
	}
	public List<String> getPhoto() {
		if(photo!=null){
		for(int i=0;i<photo.size();i++){
			String data=photo.get(i);
			if (StringUtils.isNotEmpty(data)){
				photo.set(i,ConfigUtil.getValue("server")+data);
			}
		}
	}
		return photo;
	}
	public void setPhoto(List<String> photo) {
		this.photo = photo;
	}
	
	
	
}
