package com.antiphon.xiaomai.modules.service.custom.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.comment.CommentDao;
import com.antiphon.xiaomai.modules.dao.custom.CustomIndentDao;
import com.antiphon.xiaomai.modules.dao.custom.CustomInfoDao;
import com.antiphon.xiaomai.modules.dao.custom.CustomLabelDao;
import com.antiphon.xiaomai.modules.dao.custom.CustomLanguageDao;
import com.antiphon.xiaomai.modules.dao.custom.CustomPlayInfoDao;
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoHomeDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoPlayDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;
import com.antiphon.xiaomai.modules.entity.custom.CustomLanguage;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;
import com.antiphon.xiaomai.modules.service.comment.CommentService;
import com.antiphon.xiaomai.modules.service.custom.CustomInfoService;

@Service
public class CustomInfoServiceImpl implements CustomInfoService {
	 @Autowired 
	 private CustomInfoDao customInfoDao;
	 @Autowired 
	 private CustomLanguageDao customLanguageDao;
	 @Autowired 
	 private CustomLabelDao customLabelDao;
	 @Autowired 
	 private CustomPlayInfoDao customPlayInfoDao;
	 @Autowired 
	 private CustomIndentDao customIndentDao;
	 @Autowired 
	 private CommentService commentService;
	 
	@Override
	public CustomInfo getCustomInfo(Long id) {
		return customInfoDao.find(id);
	}

	@Override
	public void saveOrUpdateCustomInfo(CustomInfo customInfo) {
		if(customInfo.getId()==null){
			customInfoDao.save(customInfo);
			saveCustoms(customInfo);
		}else{
			//修改主表
			customInfoDao.update(customInfo);
			//删除关联副表
			Long customId=customInfo.getId();
			customLanguageDao.delPkid(customId);//语言
			customLabelDao.delPkid(customId);//个性标签
			saveCustoms(customInfo);
		}
	}
	
	/**
	 * 新增副表
	 */
	public void saveCustoms(CustomInfo customInfo){
		//语言
		CustomLanguage customLanguage=null;
		List <String> list=customInfo.getCustomLanguage();
		if(list!=null){
			//String[] names=null;
		for(int i=0;i<list.size();i++){
			customLanguage=new CustomLanguage();
			customLanguage.setName(list.get(i));
			customLanguage.setCustomId(customInfo.getId());
			customLanguage.setUserId(customInfo.getUserId());
			customLanguageDao.save(customLanguage);
			}
		}
		//个性标签
		CustomLabel customLabel=null;
		List <String> LabelList=customInfo.getCustomLabel();
		if(LabelList!=null){
		for(int i=0;i<LabelList.size();i++){
			customLabel=new CustomLabel();
			customLabel.setName(LabelList.get(i));
			customLabel.setCustomId(customInfo.getId());
			customLabel.setUserId(customInfo.getUserId());
			customLabelDao.save(customLabel);
		}
		}
		
	}

	@Override
	public CustomInfo getCustomInfoByuserId(Long userId) {
		return customInfoDao.findProperty("userId", userId);
	}

	@Override
	public QueryResult<CustomInfo> findPageCustomInfo(int page,
			Map<String, String> params) {
		params.put("playName","1");
		CustomInfoDto customInfoDto=new CustomInfoDto();
		PageView<CustomInfo> pageView = new PageView<CustomInfo>(10,page);
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		//pageView.setQueryResult(this.customInfoDao.findPage(pageView, filters));
		QueryResult<CustomInfo> data=this.customInfoDao.findPage(pageView,filters);
		List<CustomInfo> list=data.getResultlist();
		List<Long> userIds=new ArrayList<Long>();
		//获取玩法的userId
		for(CustomInfo customInfo:list){
			userIds.add(customInfo.getUserId());
		}
		filters.add(new PropertyFilter("", MatchType.IN, userIds));
		return data;
	}

	@Override
	public List<CustomInfo> findCustomInfo(Map<String, String> params) {
		return null;
	}
	/**
	 * 定制师首页
	 */
	@Override
	public CustomInfoHomeDto getCustomInfoHome(Long customId) {
		CustomInfo customInfo=customInfoDao.findProperty("id",customId);
		//定制师信息
		CustomInfoHomeDto dto=new CustomInfoHomeDto();
		dto.setId(customInfo.getId());
		dto.setCustomName(customInfo.getNickname());
		dto.setInhabitCity(customInfo.getCity());
		dto.setIndentTotal(customInfo.getIndentTotal());
		dto.setIntroduceMyself(customInfo.getIntroduceMyself());
		dto.setCommentTotal(customInfo.getCommentTotal());
		dto.setServeBest(customInfo.getServeBest());
		dto.setCustomPhoto(customInfo.getPictureLink());
		//玩法
		List<CustomPlayInfo> list=customPlayInfoDao.findPropertyList("customId",customId);
		List<CustomInfoPlayDto> playDtoList=new ArrayList<CustomInfoPlayDto>();
		CustomInfoPlayDto playDto=null;
		for(CustomPlayInfo data:list){
			playDto=new CustomInfoPlayDto();
			playDto.setId(data.getId());
			playDto.setPlayName(data.getPlayName());
			playDto.setPhotoUrl(data.getPlayCoverUrl());
			playDtoList.add(playDto);
		}
		dto.setCustomInfoPlayDtoList(playDtoList);
		
		List<String> labels=customLabelDao.getLabel(customId);//标签
		dto.setLabels(labels);
		
		Map<String,String> params=new HashMap<String,String>();
		params.put("categoryId", customId.toString());
		params.put("pageSize", "1");
		params.put("pageNo", "1");
		dto.setComments(commentService.findPageCommentsByParams(params));//评论加回复
		return dto;
	}

	@Override
	public List<CustomInfoDto> getCustomInfoHomeByParams(Map<String, String> params) {
		List<CustomInfoDto> list=null;
		//定制师列表
		list=customInfoDao.getCustomInfoHomeByParams(params);
		
		List<Long> tempids=new ArrayList<Long>();
		//获取定制师的userid
		for(CustomInfoDto data:list){
			tempids.add(data.getCustomId());
		}
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("customId", MatchType.IN, tempids.toArray()));
		Set<String> set=null;
		//查询列表下定制师的标签
		List<CustomLabel> labels=customLabelDao.findLists(null, filters);
				for(CustomInfoDto data:list){
					set=new HashSet<String>(); 
					for(CustomLabel data1:labels){
					if(data1.getCustomId().equals(data.getCustomId())){
						set.add((data1.getName()));
						data1=null;
					}
				}
					data.setCustomLabels(set);
			}
		return list;
	}
	/**
	 * 修改主表
	 */
	@Override
	public void saveOrUpdateCustomInfoAppoint(CustomInfo customInfo) {
		customInfoDao.saveOrUpdateCustomInfoAppoint(customInfo);
	}
	

}
