package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
  
import com.antiphon.xiaomai.modules.dao.cate.CateCouponsDao;
import com.antiphon.xiaomai.modules.entity.cate.CateCoupons; 
import com.antiphon.xiaomai.modules.service.cate.CateCouponsService;
@Service
public class CateCouponsServiceImpl implements CateCouponsService {

	@Autowired private CateCouponsDao cateCouponsDao;
	@Override
	public CateCoupons findCateCoupons(Long id) {
		 
		return this.cateCouponsDao.find(id);
	}

	@Override
	public void saveCateCoupons(CateCoupons r) {
		 this.cateCouponsDao.save(r);
		
	}

	@Override
	public void updateCateCoupons(CateCoupons r) {
	        this.cateCouponsDao.update(r);
		
	}

	@Override
	public void delCateCoupons(Serializable... entityids) {
		 this.cateCouponsDao.delete(entityids);
		
	}

	@Override
	public CateCoupons findCateCoupons(Object p, Object v) {
	 
		return this.cateCouponsDao.findProperty(p, v);
	}

	@Override
	public QueryResult<CateCoupons> findPage(PageView<CateCoupons> pv, List<PropertyFilter> filters) {
		 
		return this.cateCouponsDao.findPage(pv, filters);
	}


}
