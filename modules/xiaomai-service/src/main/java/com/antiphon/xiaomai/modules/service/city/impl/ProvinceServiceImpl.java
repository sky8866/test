package com.antiphon.xiaomai.modules.service.city.impl;

import java.io.Serializable; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.modules.dao.city.ProvinceDao;
import com.antiphon.xiaomai.modules.entity.city.Province;
import com.antiphon.xiaomai.modules.service.city.ProvinceService;
@Service
public class ProvinceServiceImpl implements ProvinceService {
	 @Autowired private ProvinceDao ProvinceDao;
		@Override
		public Province findProvince(Long id) {
			 
			return this.ProvinceDao.find(id);
		}

		@Override
		public void saveProvince(Province r) {
			 this.ProvinceDao.save(r);
			
		}

		@Override
		public void updateProvince(Province r) {
		        this.ProvinceDao.update(r);
			
		}

		@Override
		public void delProvince(Serializable... entityids) {
			 this.ProvinceDao.delete(entityids);
			
		}

		@Override
		public Province findProvince(Object p, Object v) {
		 
			return this.ProvinceDao.findProperty(p, v);
		}

		@Override
		public List<Province> findProvinces(Object p, Object v) {
			 
			return this.ProvinceDao.findPropertyList(p, v);
		}

		@Override
		public List<Province> findProvinces() {
			 
			return this.ProvinceDao.findLists();
		}

	 
 
}
