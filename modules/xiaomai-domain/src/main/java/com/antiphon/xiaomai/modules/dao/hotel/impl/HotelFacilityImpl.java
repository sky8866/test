package com.antiphon.xiaomai.modules.dao.hotel.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl; 
import com.antiphon.xiaomai.modules.dao.hotel.HotelFacilityDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;
@Repository
public class HotelFacilityImpl extends HibernateDaoImpl<HotelFacility> implements
		HotelFacilityDao {

}
