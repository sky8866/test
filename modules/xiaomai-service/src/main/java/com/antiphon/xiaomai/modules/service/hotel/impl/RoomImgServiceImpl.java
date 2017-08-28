package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.hotel.RoomImg;
import com.antiphon.xiaomai.modules.service.hotel.RoomImgService;

@Service
public class RoomImgServiceImpl implements RoomImgService {
	@Autowired private com.antiphon.xiaomai.modules.dao.hotel.RoomImgDao RoomImgDao;
	 
	@Override
	public RoomImg findRoomImg(Long id) {
		 
		return this.RoomImgDao.find(id);
	}

	@Override
	public void saveRoomImg(RoomImg r) {
		 this.RoomImgDao.save(r);
		
	}

	@Override
	public void updateRoomImg(RoomImg r) {
	        this.RoomImgDao.update(r);
		
	}

	@Override
	public void delRoomImg(Serializable... entityids) {
		 this.RoomImgDao.delete(entityids);
		
	}

	@Override
	public RoomImg findRoomImg(Object p, Object v) {
	 
		return this.RoomImgDao.findProperty(p, v);
	}

	@Override
	public QueryResult<RoomImg> findPage(PageView<RoomImg> pv, List<PropertyFilter> filters) {
		 
		return this.RoomImgDao.findPage(pv, filters);
	}

}
