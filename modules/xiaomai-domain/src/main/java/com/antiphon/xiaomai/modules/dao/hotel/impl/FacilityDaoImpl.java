package com.antiphon.xiaomai.modules.dao.hotel.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.hotel.FacilityDao;
import com.antiphon.xiaomai.modules.entity.hotel.Facility;
 
@Repository
public class FacilityDaoImpl extends HibernateDaoImpl<Facility> implements
		FacilityDao {

}
