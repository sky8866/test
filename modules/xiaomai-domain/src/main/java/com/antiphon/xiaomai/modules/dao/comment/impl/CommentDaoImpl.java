package com.antiphon.xiaomai.modules.dao.comment.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.comment.CommentDao;
import com.antiphon.xiaomai.modules.dto.CommentAndReturnDto;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.dto.CommentReplyDto;
import com.antiphon.xiaomai.modules.dto.NameAndValueDto;
import com.antiphon.xiaomai.modules.entity.comment.Comment;
@Repository
public class CommentDaoImpl  extends HibernateDaoImpl<Comment> implements CommentDao{

	@Override
	public CommentDto getComment() {
	/*	Query query=this.em.createNativeQuery("select * from xm_comment  where user_id=1");
		List<CommentDto> d=query.getResultList();
		//Object d=query.getSingleResult();
		CommentDto commentDto=new CommentDto();
		List<Comment> list=new ArrayList<Comment>();
		Comment comment=new Comment();
		list.add(comment);
		commentDto.setComment(list);
		return commentDto;*/
		return null;
	}

	@Override
	public NameAndValueDto getCommentCountAndAvg(String type,String resourceId) {
		StringBuffer sql=new StringBuffer("select count(*),avg(score) from xm_comment where 1=1");
		if(StringUtils.isNotEmpty(type)){
			sql.append(" and type="+type);
		}
		if(StringUtils.isNotEmpty(resourceId)){
			sql.append(" and resource_id="+resourceId);
		}
		Query query=this.em.createNativeQuery(sql.toString());
		Object[] obj=(Object[]) query.getSingleResult();
		NameAndValueDto dto=new NameAndValueDto();
		if(obj!=null){
		dto.setTotal(Long.parseLong(obj[0].toString()));
		dto.setAvgScore(obj[1]!=null?Float.parseFloat(obj[1].toString()):0);
		}
		return dto;
	}

	@Override
	public List<CommentAndReturnDto> findPageCommentByUserId(Map<String,String> params) {
		String type=params.get("type");
		String resourceId=params.get("resourceId");
		String categoryId=params.get("categoryId");
		Integer pageSize=Integer.parseInt(params.get("pageSize"));
		Integer pageNo=Integer.parseInt(params.get("pageNo"));
		
		PageView<Comment> pv=new PageView<Comment>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		if(StringUtils.isNotEmpty(type)){
			filters.add(new PropertyFilter("type", MatchType.EQ, Integer.parseInt(type)));
		}
		if(StringUtils.isNotEmpty(resourceId)){
			filters.add(new PropertyFilter("resourceId", MatchType.EQ, Long.parseLong(resourceId)));
		}
		if(StringUtils.isNotEmpty(categoryId)){
			filters.add(new PropertyFilter("categoryId", MatchType.EQ, Long.parseLong(categoryId)));
		}
		pv.setOrderby("createTime", "desc");
		List<Comment> lists=this.findLists(pv,filters);
		List<CommentAndReturnDto> dtoList=new ArrayList<CommentAndReturnDto>();
		CommentAndReturnDto dto=null;
		for(Comment data:lists){
			 dto=new CommentAndReturnDto();
			 dto.setUserName(data.getUserName());
			 dto.setCreateTime(data.getCreateTime().toString());
			 dto.setResourceName(data.getResourceName());
			 dto.setContent(data.getContent());
			 dto.setScore(data.getScore().toString());
			 dto.setId(data.getId());
			 dto.setPicture(data.getPicture());
			Query query1= this.em.createNativeQuery("select img_name from xm_imgs where module='comment' and resource_id="+dto.getId());//查询照片
			List<String> imgNames=query1.getResultList();
			dto.setPhoto(imgNames);
			dtoList.add(dto);
		}
		return dtoList;
	}

}
