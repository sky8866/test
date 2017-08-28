package com.antiphon.xiaomai.modules.service.custom.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.custom.CustomPlayInfoDao;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.dto.CustomPlayDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;
import com.antiphon.xiaomai.modules.service.custom.CustomPlayInfoService;
@Service
public class CustomPlayInfoServiceImpl implements CustomPlayInfoService{

	 @Autowired 
	 private CustomPlayInfoDao customPlayInfoDao;
	@Override
	public List<CustomPlayInfo> findCustomPlayInfoByUserId(Long id) {
		return customPlayInfoDao.findPropertyList("userId", id);
	}
	@Override
	public PageView<CustomPlayInfo>  findPageCustomPlayInfo(int page,Map<String, String> pamas) {
		PageView<CustomPlayInfo> pageView = new PageView<CustomPlayInfo>(3,page);
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		Long userId=Long.parseLong(pamas.get("userId"));
		if(userId!=null){
			filters.add(new PropertyFilter("userId", MatchType.EQ, userId));
		}
		pageView.setQueryResult(this.customPlayInfoDao.findPage(pageView, filters));
		return pageView;
	}
	@Override
	public CustomPlayInfo findCustomPlayInfo(Long id) {
		return customPlayInfoDao.find(id);
	}
	@Override
	public void saveOrUpdateCustomPlayInfo(CustomPlayInfo customPlayInfo) {
		if(customPlayInfo.getId()==null){
			customPlayInfoDao.save(customPlayInfo);
			//saveCustoms(customPlayInfo);
		}else{
			//修改主表
			customPlayInfoDao.update(customPlayInfo);
			//删除关联副表
			Long customId=customPlayInfo.getId();
			/*customLanguageDao.delPkid(customId);//语言
			customLabelDao.delPkid(customId);//个性标签
			saveCustoms(customPlayInfo);*/
		}
	}
	@Override
	public void delPlayInfo(Long id) {
		customPlayInfoDao.delete(id);
	}
	@Override
	public List<CustomHomeHotCityDto>  getCustomHomeHotCityDtoList() {
		return customPlayInfoDao.getCustomHomeHotCityDtoList();
	}
	@Override
	public void updateStatus(String ids, int status) {
		customPlayInfoDao.updateStatus(ids, status);
	}
	@Override
	public List<CustomPlayDto> findCustomPlayHomeByUserId() {
		List<CustomPlayDto> dtos=new ArrayList<CustomPlayDto>();
		CustomPlayDto customPlayDto=null;
		try {
			List <CustomPlayInfo> lists=(List<CustomPlayInfo>) customPlayInfoDao.findAllPage("select a from CustomPlayInfo a", 0, 5);
			 for(CustomPlayInfo data:lists){
				 customPlayDto=new CustomPlayDto();
				 customPlayDto.setId(data.getId());
				 customPlayDto.setPlayCity(data.getPlayCity());
				 customPlayDto.setPlayCoverUrl(data.getPlayCoverUrl());
				 customPlayDto.setPlayName(data.getPlayName());
				 customPlayDto.setPlayPrice(data.getPlayPrice());
				 customPlayDto.setPlayType(data.getPlayType());
				 dtos.add(customPlayDto);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

}
