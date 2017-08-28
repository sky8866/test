package com.antiphon.xiaomai.modules.entity.comment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;

/**
 * 评论表
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_comment") 
public class Comment extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6071989914301693186L;
	private Long userId;
	private String userName;
	private Date createTime;
	private Long resourceId;
	private String resourceName;
	private String content;
	private Float score;
	private String picture;
	private Long typeId;//酒店id或者定制游id或者其他id
	private int type;
	
	@PrePersist
    public void prePersist(){
		this.createTime = new Date();
    }
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
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
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
