package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
  
import com.antiphon.xiaomai.modules.dao.cate.CateCommentDao;
import com.antiphon.xiaomai.modules.entity.cate.CateComment; 
import com.antiphon.xiaomai.modules.service.cate.CateCommentService;
@Service
public class CateCommentServiceImpl implements CateCommentService {

	@Autowired private CateCommentDao cateCommentDao;
	@Override
	public CateComment findCateComment(Long id) {
		 
		return this.cateCommentDao.find(id);
	}

	@Override
	public void saveCateComment(CateComment r) {
		 this.cateCommentDao.save(r);
		
	}

	@Override
	public void updateCateComment(CateComment r) {
	        this.cateCommentDao.update(r);
		
	}

	@Override
	public void delCateComment(Serializable... entityids) {
		 this.cateCommentDao.delete(entityids);
		
	}

	@Override
	public CateComment findCateComment(Object p, Object v) {
	 
		return this.cateCommentDao.findProperty(p, v);
	}

	@Override
	public QueryResult<CateComment> findPage(PageView<CateComment> pv, List<PropertyFilter> filters) {
		 
		return this.cateCommentDao.findPage(pv, filters);
	}


}
