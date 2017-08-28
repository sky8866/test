package com.antiphon.xiaomai.modules.dao.custom;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;

public interface CustomInfoDao extends HibernateDao<CustomInfo>  {
	
	public List<CustomInfo> findCustomInfo(Map<String,String> params);
	
	 /**
	  * 根据服务地玩法等搜索定制师
	  * @param params
	  * @return
	  */
	 public List<CustomInfoDto> getCustomInfoHomeByParams(Map<String,String> params);
	 
	 
	 /**
	  * 定时器--订单总量，服务最好
	  * @param params
	  * @return
	  */
	 public void updateCustomInfo();
	 
	 public void saveOrUpdateCustomInfoAppoint(CustomInfo customInfo);
}
