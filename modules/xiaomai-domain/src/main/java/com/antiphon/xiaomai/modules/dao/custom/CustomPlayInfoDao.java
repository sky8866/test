package com.antiphon.xiaomai.modules.dao.custom;

import java.util.List;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;

public interface CustomPlayInfoDao extends HibernateDao<CustomPlayInfo>{

	public List<CustomHomeHotCityDto> getCustomHomeHotCityDtoList();
	
	public void updateStatus(String ids, int status) ;
}
