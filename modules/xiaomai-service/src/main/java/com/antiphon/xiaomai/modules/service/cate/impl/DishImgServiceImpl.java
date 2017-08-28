package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.dao.cate.DishImgDao;
 
import com.antiphon.xiaomai.modules.entity.cate.DishImg;
 
import com.antiphon.xiaomai.modules.service.cate.DishImgService; 
@Service
public class DishImgServiceImpl implements DishImgService {
	@Autowired private DishImgDao dishImgDao;
 
	@Override
	public DishImg findDishImg(Long id) {
		 
		return this.dishImgDao.find(id);
	}

	@Override
	public void saveDishImg(DishImg r) {
		 this.dishImgDao.save(r);
		
	}

	@Override
	public void updateDishImg(DishImg r) {
	        this.dishImgDao.update(r);
		
	}

	@Override
	public void delDishImg(Serializable... entityids) {
		 this.dishImgDao.delete(entityids);
		
	}

	@Override
	public DishImg findDishImg(Object p, Object v) {
	 
		return this.dishImgDao.findProperty(p, v);
	}

	@Override
	public QueryResult<DishImg> findPage(PageView<DishImg> pv, List<PropertyFilter> filters) {
		 
		return this.dishImgDao.findPage(pv, filters);
	}

 
}
