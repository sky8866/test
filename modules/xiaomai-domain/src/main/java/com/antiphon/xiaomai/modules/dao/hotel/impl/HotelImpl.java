package com.antiphon.xiaomai.modules.dao.hotel.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl; 
import com.antiphon.xiaomai.modules.dao.hotel.HotelDao;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
@Repository
public class HotelImpl extends HibernateDaoImpl<Hotel> implements
		HotelDao {

}
