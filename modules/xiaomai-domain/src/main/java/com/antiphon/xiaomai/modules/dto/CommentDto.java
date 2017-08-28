package com.antiphon.xiaomai.modules.dto;

import java.util.List;

import com.antiphon.xiaomai.modules.entity.comment.Comment;

/**
 * 评论表
 * @author pjz
 *
 */
public class CommentDto {

	private Long total;
	
	private Float scores;
	
	private List<CommentAndReturnDto> comment;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Float getScores() {
		return scores;
	}
	public void setScores(Float scores) {
		this.scores = scores;
	}
	public List<CommentAndReturnDto> getComment() {
		return comment;
	}
	public void setComment(List<CommentAndReturnDto> comment) {
		this.comment = comment;
	}
	
	
}
