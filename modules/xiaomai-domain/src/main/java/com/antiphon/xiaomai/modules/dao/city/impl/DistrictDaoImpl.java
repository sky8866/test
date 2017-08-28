package com.antiphon.xiaomai.modules.dao.city.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.city.DistrictDao;
import com.antiphon.xiaomai.modules.entity.city.District;
@Repository
public class DistrictDaoImpl extends HibernateDaoImpl<District> implements
		DistrictDao {

	@Override
	public List<District> findCitys() {
		   Query q = (Query) em
	                .createQuery("select  c from District c where c.citycode in(select distinct p.citycode from District p)");
	               
		   List<District> list =(List<District>) q.getResultList();
		return list;
	}

}
