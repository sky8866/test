package com.antiphon.xiaomai.modules.service.custom;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dto.CustomHomeDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoHomeDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;

public interface CustomInfoService  {
	
	 public CustomInfo getCustomInfo(Long id);
	 
	 public void saveOrUpdateCustomInfo(CustomInfo customInfo);
	 
	 public CustomInfo getCustomInfoByuserId(Long userId);
	 
	 public QueryResult<CustomInfo> findPageCustomInfo(int page,Map<String,String> params);
	 
	 public List<CustomInfo> findCustomInfo(Map<String, String> params);
	 /**
	  * 定制师首页
	  * @param userId
	  * @return
	  */
	 public CustomInfoHomeDto getCustomInfoHome(Long customId);
	 /**
	  * 根据服务地玩法等搜索定制师
	  * @param userId
	  * @return
	  */
	 public List<CustomInfoDto> getCustomInfoHomeByParams(Map<String,String> params);
	 
	 /**
	  * 修改资料
	  * @param 
	  * @return
	  */
	 public void saveOrUpdateCustomInfoAppoint(CustomInfo customInfo);
}
