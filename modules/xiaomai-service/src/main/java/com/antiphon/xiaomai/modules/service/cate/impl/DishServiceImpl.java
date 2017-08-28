package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.dao.cate.DishDao;
import com.antiphon.xiaomai.modules.entity.cate.Dish; 
import com.antiphon.xiaomai.modules.service.cate.DishService;
@Service
public class DishServiceImpl implements DishService {

	@Autowired private DishDao dishDao;
	@Override
	public Dish findDish(Long id) {
		 
		return this.dishDao.find(id);
	}

	@Override
	public void saveDish(Dish r) {
		 this.dishDao.save(r);
		
	}

	@Override
	public void updateDish(Dish r) {
	        this.dishDao.update(r);
		
	}

	@Override
	public void delDish(Serializable... entityids) {
		 this.dishDao.delete(entityids);
		
	}

	@Override
	public Dish findDish(Object p, Object v) {
	 
		return this.dishDao.findProperty(p, v);
	}

	@Override
	public QueryResult<Dish> findPage(PageView<Dish> pv, List<PropertyFilter> filters) {
		 
		return this.dishDao.findPage(pv, filters);
	}

}
