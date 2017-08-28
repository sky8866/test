package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelImg;
import com.antiphon.xiaomai.modules.service.hotel.HotelImgService;

@Service
public class HotelImgServiceImpl implements HotelImgService {
	@Autowired private com.antiphon.xiaomai.modules.dao.hotel.HotelImgDao HotelImgDao;
	 
	@Override
	public HotelImg findHotelImg(Long id) {
		 
		return this.HotelImgDao.find(id);
	}

	@Override
	public void saveHotelImg(HotelImg r) {
		 this.HotelImgDao.save(r);
		
	}

	@Override
	public void updateHotelImg(HotelImg r) {
	        this.HotelImgDao.update(r);
		
	}

	@Override
	public void delHotelImg(Serializable... entityids) {
		 this.HotelImgDao.delete(entityids);
		
	}

	@Override
	public HotelImg findHotelImg(Object p, Object v) {
	 
		return this.HotelImgDao.findProperty(p, v);
	}

	@Override
	public QueryResult<HotelImg> findPage(PageView<HotelImg> pv, List<PropertyFilter> filters) {
		 
		return this.HotelImgDao.findPage(pv, filters);
	}

}
