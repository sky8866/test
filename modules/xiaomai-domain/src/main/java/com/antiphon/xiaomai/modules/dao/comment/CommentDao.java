package com.antiphon.xiaomai.modules.dao.comment;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.CommentAndReturnDto;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.dto.NameAndValueDto;
import com.antiphon.xiaomai.modules.entity.comment.Comment;

public interface CommentDao  extends HibernateDao<Comment>{
	public CommentDto getComment();
	
	public NameAndValueDto getCommentCountAndAvg(String type,String playId);
	
	public List<CommentAndReturnDto> findPageCommentByUserId(Map<String,String> params);
}
