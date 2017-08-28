package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.dao.cate.CateShopImgDao;
import com.antiphon.xiaomai.modules.dao.img.ImgsDao;
import com.antiphon.xiaomai.modules.entity.cate.CateShopImg;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.cate.CateShopImgService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
@Service
public class CateShopImgServiceImpl implements CateShopImgService {
	@Autowired private CateShopImgDao cateShopImgDao;
	@Autowired private ImgsDao imgsDao;
	@Override
	public CateShopImg findCateShopImg(Long id) {
		 
		return this.cateShopImgDao.find(id);
	}

	@Override
	public void saveCateShopImg(CateShopImg r) {
		 this.cateShopImgDao.save(r);
		
	}

	@Override
	public void updateCateShopImg(CateShopImg r) {
	        this.cateShopImgDao.update(r);
		
	}

	@Override
	public void delCateShopImg(Serializable... entityids) {
		 this.cateShopImgDao.delete(entityids);
		
	}

	@Override
	public CateShopImg findCateShopImg(Object p, Object v) {
	 
		return this.cateShopImgDao.findProperty(p, v);
	}

	@Override
	public QueryResult<CateShopImg> findPage(PageView<CateShopImg> pv, List<PropertyFilter> filters) {
		 
		return this.cateShopImgDao.findPage(pv, filters);
	}

 
}
