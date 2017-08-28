package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.hotel.HotelDao;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
import com.antiphon.xiaomai.modules.service.hotel.HotelService;
   
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired private HotelDao hotelDao;
	@Override
	public Hotel findHotel(Long id) {
		 
		return this.hotelDao.find(id);
	}

	@Override
	public void saveHotel(Hotel r) {
		 this.hotelDao.save(r);
		
	}

	@Override
	public void updateHotel(Hotel r) {
	        this.hotelDao.update(r);
		
	}

	@Override
	public void delHotel(Serializable... entityids) {
		 this.hotelDao.delete(entityids);
		
	}

	@Override
	public Hotel findHotel(Object p, Object v) {
	 
		return this.hotelDao.findProperty(p, v);
	}

	@Override
	public QueryResult<Hotel> findPage(PageView<Hotel> pv, List<PropertyFilter> filters) {
		 
		return this.hotelDao.findPage(pv, filters);
	}


}
