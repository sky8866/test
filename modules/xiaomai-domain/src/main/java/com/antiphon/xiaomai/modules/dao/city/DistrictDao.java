package com.antiphon.xiaomai.modules.dao.city;

import java.util.List;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.city.District;

public interface DistrictDao extends HibernateDao<District> {
	
	public  List<District> findCitys();

}
