package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
 
import com.antiphon.xiaomai.modules.dao.cate.CateShopDao;
import com.antiphon.xiaomai.modules.entity.cate.CateShop; 
import com.antiphon.xiaomai.modules.service.cate.CateShopService;
@Service
public class CateShopServiceImpl implements CateShopService {

	@Autowired private CateShopDao cateShopDao;
	@Override
	public CateShop findCateShop(Long id) {
		 
		return this.cateShopDao.find(id);
	}

	@Override
	public void saveCateShop(CateShop r) {
		 this.cateShopDao.save(r);
		
	}

	@Override
	public void updateCateShop(CateShop r) {
	        this.cateShopDao.update(r);
		
	}

	@Override
	public void delCateShop(Serializable... entityids) {
		 this.cateShopDao.delete(entityids);
		
	}

	@Override
	public CateShop findCateShop(Object p, Object v) {
	 
		return this.cateShopDao.findProperty(p, v);
	}

	@Override
	public QueryResult<CateShop> findPage(PageView<CateShop> pv, List<PropertyFilter> filters) {
		 
		return this.cateShopDao.findPage(pv, filters);
	}


}
