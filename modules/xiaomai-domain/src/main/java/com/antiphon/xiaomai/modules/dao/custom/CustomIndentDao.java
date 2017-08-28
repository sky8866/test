package com.antiphon.xiaomai.modules.dao.custom;

import java.util.List;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomIndent;

public interface CustomIndentDao extends HibernateDao<CustomIndent>{

	public List <CustomHomeHotCityDto> getCustomHomeHotCityDtoList();
	
	public int updateIndentStatus(Long id);
	
	public String getPriceTotal(Long userId) ;
	
	public List<Long> getCustomIndent(Long userId) ;
	
}
