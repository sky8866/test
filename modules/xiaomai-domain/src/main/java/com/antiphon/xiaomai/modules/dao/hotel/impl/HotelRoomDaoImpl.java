package com.antiphon.xiaomai.modules.dao.hotel.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.hotel.HotelRoomDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom;
 
@Repository
public class HotelRoomDaoImpl extends HibernateDaoImpl<HotelRoom> implements
		HotelRoomDao {

}
