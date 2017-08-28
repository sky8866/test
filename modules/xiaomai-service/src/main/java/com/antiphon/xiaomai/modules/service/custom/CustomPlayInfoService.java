package com.antiphon.xiaomai.modules.service.custom;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.dto.CustomPlayDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;

public interface CustomPlayInfoService {

	public List<CustomPlayInfo> findCustomPlayInfoByUserId(Long id);
	
	public PageView<CustomPlayInfo> findPageCustomPlayInfo(int page,Map<String, String> params);
	
	public CustomPlayInfo findCustomPlayInfo(Long id);
	
	 public void saveOrUpdateCustomPlayInfo(CustomPlayInfo customPlayInfo);
	 
	 public void delPlayInfo(Long id);
	 
	 public List<CustomHomeHotCityDto>  getCustomHomeHotCityDtoList();
	 
	 public void updateStatus(String ids,int status);
	 
	 public List<CustomPlayDto> findCustomPlayHomeByUserId();
	 
}
