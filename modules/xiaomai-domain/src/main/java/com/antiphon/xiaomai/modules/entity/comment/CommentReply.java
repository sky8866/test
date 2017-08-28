package com.antiphon.xiaomai.modules.entity.comment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;

/**
 * 回复
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_comment_reply") 
public class CommentReply extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5516719560520178295L;
	
	
	private Long userId;
	private String userName;
	private Date createTime;
	private String content;
	private Long commentId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	
	
}
