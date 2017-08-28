package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;
import com.antiphon.xiaomai.modules.service.hotel.HotelFacilityService;
@Service
public class HotelFacilityServiceImpl implements HotelFacilityService {

	@Autowired private com.antiphon.xiaomai.modules.dao.hotel.HotelFacilityDao hotelFacilityDao;
	@Override
	public HotelFacility findHotelFacility(Long id) {
		 
		return this.hotelFacilityDao.find(id);
	}

	@Override
	public void saveHotelFacility(HotelFacility r) {
		 this.hotelFacilityDao.save(r);
		
	}

	@Override
	public void updateHotelFacility(HotelFacility r) {
	        this.hotelFacilityDao.update(r);
		
	}

	@Override
	public void delHotelFacility(Serializable... entityids) {
		 this.hotelFacilityDao.delete(entityids);
		
	}

	@Override
	public HotelFacility findHotelFacility(Object p, Object v) {
	 
		return this.hotelFacilityDao.findProperty(p, v);
	}

	@Override
	public QueryResult<HotelFacility> findPage(PageView<HotelFacility> pv, List<PropertyFilter> filters) {
		 
		return this.hotelFacilityDao.findPage(pv, filters);
	}

	@Override
	public List<HotelFacility> findHotelFacilitys(Object p, Object v) {
		 
		return this.hotelFacilityDao.findPropertyList(p, v);
	}


}
