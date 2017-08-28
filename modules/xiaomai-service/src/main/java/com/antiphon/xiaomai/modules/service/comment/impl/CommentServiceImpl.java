package com.antiphon.xiaomai.modules.service.comment.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.comment.CommentDao;
import com.antiphon.xiaomai.modules.dao.comment.CommentReplyDao;
import com.antiphon.xiaomai.modules.dao.img.ImgsDao;
import com.antiphon.xiaomai.modules.dto.CommentAndReturnDto;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.dto.CommentReplyDto;
import com.antiphon.xiaomai.modules.dto.NameAndValueDto;
import com.antiphon.xiaomai.modules.entity.comment.Comment;
import com.antiphon.xiaomai.modules.entity.comment.CommentReply;
import com.antiphon.xiaomai.modules.service.comment.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired 
	private CommentDao commentDao;
	@Autowired 
	private CommentReplyDao commentReplyDao;
	@Autowired 
	private ImgsDao imgsDao;
	@Override
	public List<Comment> findCommentList(Long userId) {
		return commentDao.findPropertyList("userId",userId);
	}
	/**
	 * 获取评论分页跟总长度
	 */
	@Override
	public CommentDto findPageCommentByParams(Map<String,String> params) {
		NameAndValueDto dto=commentDao.getCommentCountAndAvg(params.get("type"),params.get("resourceId"));//评论表用户下总条数/评价评分
		List<CommentAndReturnDto> comment=	commentDao.findPageCommentByUserId(params);//评论表
		List<CommentReplyDto> res=null;
		//回复
		for(CommentAndReturnDto data:comment){
			List<CommentReply> commentReplys= commentReplyDao.findPropertyList("commentId", data.getId());
			res=new ArrayList<CommentReplyDto>();
			if(commentReplys!=null){
				for(CommentReply data1:commentReplys){
					CommentReplyDto ReplyDtos=new CommentReplyDto();
					ReplyDtos.setUserName(data1.getUserName());
					ReplyDtos.setCreateTime(data1.getCreateTime()+"");
					ReplyDtos.setContent(data1.getContent());
					res.add(ReplyDtos);
				}
			}
			data.setCommentReplys(res);
		}

		CommentDto commentDto=new CommentDto();
		commentDto.setComment(comment);
		commentDto.setScores(dto.getAvgScore());
		commentDto.setTotal(dto.getTotal());
		return commentDto;
	}
	@Override
	public void saveComment(Comment comment) {
		commentDao.save(comment);
	}
	@Override
	public List<CommentAndReturnDto> findPageCommentsByParams(
			Map<String, String> params) {
		List<CommentAndReturnDto> comment=	commentDao.findPageCommentByUserId(params);//评论表
		List<CommentReplyDto> res=null;
		//回复
		for(CommentAndReturnDto data:comment){
			List<CommentReply> commentReplys= commentReplyDao.findPropertyList("commentId", data.getId());
			res=new ArrayList<CommentReplyDto>();
			if(commentReplys!=null){
				for(CommentReply data1:commentReplys){
					CommentReplyDto ReplyDtos=new CommentReplyDto();
					ReplyDtos.setUserName(data1.getUserName());
					ReplyDtos.setCreateTime(data1.getCreateTime()+"");
					ReplyDtos.setContent(data1.getContent());
					res.add(ReplyDtos);
				}
			}
			data.setCommentReplys(res);
		}

		return comment;
	}

}
