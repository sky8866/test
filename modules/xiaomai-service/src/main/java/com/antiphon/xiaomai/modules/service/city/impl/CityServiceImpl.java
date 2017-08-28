package com.antiphon.xiaomai.modules.service.city.impl;

import java.io.Serializable;
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.city.CityDao;
import com.antiphon.xiaomai.modules.dao.city.DistrictDao;
import com.antiphon.xiaomai.modules.entity.city.City;
import com.antiphon.xiaomai.modules.entity.city.District;
import com.antiphon.xiaomai.modules.service.city.CityService;
@Service
public class CityServiceImpl implements CityService {
	 @Autowired private CityDao CityDao;
	 @Autowired private DistrictDao districtDao;
		@Override
		public City findCity(Long id) {
			 
			return this.CityDao.find(id);
		}

		@Override
		public void saveCity(City r) {
			 this.CityDao.save(r);
			
		}

		@Override
		public void updateCity(City r) {
		        this.CityDao.update(r);
			
		}

		@Override
		public void delCity(Serializable... entityids) {
			 this.CityDao.delete(entityids);
			
		}

		@Override
		public City findCity(Object p, Object v) {
		 
			return this.CityDao.findProperty(p, v);
		}

		@Override
		public List<City> findCitys() {
			 List<City> citys=this.CityDao.findLists();
			 for(City c:citys){
				c.setDistricts(this.districtDao.findPropertyList("citycode", c.getCitycode()));
			 }
			return citys;
		}

		@Override
		public List<City> findCitys(Object p, Object v) {
			 
			return this.CityDao.findPropertyList(p, v);
		}

		@Override
		public QueryResult<City> findPage(PageView<City> pv,
				List<PropertyFilter> filters) {
			 
			return this.CityDao.findPage(pv, filters);
		}

	 

	 
 
}
