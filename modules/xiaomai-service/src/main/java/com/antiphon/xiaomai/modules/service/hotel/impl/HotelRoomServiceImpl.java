package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.dao.hotel.HotelRoomDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom; 
import com.antiphon.xiaomai.modules.service.hotel.HotelRoomService;
   
@Service
public class HotelRoomServiceImpl implements HotelRoomService {

	@Autowired private  HotelRoomDao hotelRoomDao; 
	@Override
	public HotelRoom findHotelRoom(Long id) {
		 
		return this.hotelRoomDao.find(id);
	}

	@Override
	public void saveHotelRoom(HotelRoom r) {
		 this.hotelRoomDao.save(r);
		
	}

	@Override
	public void updateHotelRoom(HotelRoom r) {
	        this.hotelRoomDao.update(r);
		
	}

	@Override
	public void delHotelRoom(Serializable... entityids) {
		 this.hotelRoomDao.delete(entityids);
		
	}

	@Override
	public HotelRoom findHotelRoom(Object p, Object v) {
	 
		return this.hotelRoomDao.findProperty(p, v);
	}

	@Override
	public QueryResult<HotelRoom> findPage(PageView<HotelRoom> pv, List<PropertyFilter> filters) {
		 
		return this.hotelRoomDao.findPage(pv, filters);
	}

	 


}
