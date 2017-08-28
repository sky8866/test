package com.antiphon.xiaomai.modules.service.city.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.modules.dao.city.DistrictDao;
import com.antiphon.xiaomai.modules.entity.city.District;
import com.antiphon.xiaomai.modules.service.city.DistrictService;
@Service
public class DistrictServiceImpl implements DistrictService {
	 @Autowired private DistrictDao districtDao;
		@Override
		public District findDistrict(Long id) {
			 
			return this.districtDao.find(id);
		}

		@Override
		public void saveDistrict(District r) {
			 this.districtDao.save(r);
			
		}

		@Override
		public void updateDistrict(District r) {
		        this.districtDao.update(r);
			
		}

		@Override
		public void delDistrict(Serializable... entityids) {
			 this.districtDao.delete(entityids);
			
		}

		@Override
		public District findDistrict(Object p, Object v) {
		 
			return this.districtDao.findProperty(p, v);
		}

		@Override
		public List<District> findDistricts(Object p, Object v) {
			 
			return this.districtDao.findPropertyList(p, v);
		}

	 

		@Override
		public List<District> findCitys() {
		   
			return this.districtDao.findLists();
		}
}
