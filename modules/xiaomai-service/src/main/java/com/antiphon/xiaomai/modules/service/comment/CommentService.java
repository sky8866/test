package com.antiphon.xiaomai.modules.service.comment;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.dto.CommentAndReturnDto;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.entity.comment.Comment;

public interface CommentService {

	public List<Comment> findCommentList(Long userId); 
	
	public CommentDto findPageCommentByParams(Map<String,String> params); 
	
	public void saveComment(Comment comment); 
	
	public List<CommentAndReturnDto> findPageCommentsByParams(Map<String,String> params); 
	
}
