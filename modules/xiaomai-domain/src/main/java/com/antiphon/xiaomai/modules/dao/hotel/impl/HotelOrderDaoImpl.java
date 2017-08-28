package com.antiphon.xiaomai.modules.dao.hotel.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.hotel.HotelOrderDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder;
@Repository
public class HotelOrderDaoImpl extends HibernateDaoImpl<HotelOrder> implements
		HotelOrderDao {

}
