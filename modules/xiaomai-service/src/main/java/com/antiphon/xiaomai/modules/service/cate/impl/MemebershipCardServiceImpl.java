package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
  
import com.antiphon.xiaomai.modules.dao.cate.MemebershipCardDao;
import com.antiphon.xiaomai.modules.entity.cate.MemebershipCard; 
import com.antiphon.xiaomai.modules.service.cate.MemebershipCardService;
@Service
public class MemebershipCardServiceImpl implements MemebershipCardService {

	@Autowired private MemebershipCardDao memebershipCardDao;
	@Override
	public MemebershipCard findMemebershipCard(Long id) {
		 
		return this.memebershipCardDao.find(id);
	}

	@Override
	public void saveMemebershipCard(MemebershipCard r) {
		 this.memebershipCardDao.save(r);
		
	}

	@Override
	public void updateMemebershipCard(MemebershipCard r) {
	        this.memebershipCardDao.update(r);
		
	}

	@Override
	public void delMemebershipCard(Serializable... entityids) {
		 this.memebershipCardDao.delete(entityids);
		
	}

	@Override
	public MemebershipCard findMemebershipCard(Object p, Object v) {
	 
		return this.memebershipCardDao.findProperty(p, v);
	}

	@Override
	public QueryResult<MemebershipCard> findPage(PageView<MemebershipCard> pv, List<PropertyFilter> filters) {
		 
		return this.memebershipCardDao.findPage(pv, filters);
	}


}
