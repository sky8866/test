package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.hotel.FacilityDao; 
import com.antiphon.xiaomai.modules.entity.hotel.Facility; 
import com.antiphon.xiaomai.modules.service.hotel.FacilityService;
   
@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired private  FacilityDao facilityDao; 
	@Override
	public Facility findFacility(Long id) {
		 
		return this.facilityDao.find(id);
	}

	@Override
	public void saveFacility(Facility r) {
		 this.facilityDao.save(r);
		
	}

	@Override
	public void updateFacility(Facility r) {
	        this.facilityDao.update(r);
		
	}

	@Override
	public void delFacility(Serializable... entityids) {
		 this.facilityDao.delete(entityids);
		
	}

	@Override
	public Facility findFacility(Object p, Object v) {
	 
		return this.facilityDao.findProperty(p, v);
	}

	@Override
	public QueryResult<Facility> findPage(PageView<Facility> pv, List<PropertyFilter> filters) {
		 
		return this.facilityDao.findPage(pv, filters);
	}

	 


}
