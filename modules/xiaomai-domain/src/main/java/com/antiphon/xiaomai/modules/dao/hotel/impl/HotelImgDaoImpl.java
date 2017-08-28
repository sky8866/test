package com.antiphon.xiaomai.modules.dao.hotel.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.hotel.HotelImgDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelImg;
@Repository
public class HotelImgDaoImpl extends HibernateDaoImpl<HotelImg> implements
		HotelImgDao {

}
