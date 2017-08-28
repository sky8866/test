package com.antiphon.xiaomai.modules.service.advertising.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.advertising.AdvertisingDao;
import com.antiphon.xiaomai.modules.entity.advertising.Advertising;
import com.antiphon.xiaomai.modules.service.advertising.AdvertisingService;
@Service
public class AdvertisingServiceImpl implements AdvertisingService {
	@Autowired
	private AdvertisingDao advertisingDao;
	@Override
	public PageView<Advertising> getPageAdvertising(int pageNo, int pageSize,
			Map<String, String> params) {
		PageView<Advertising> pv=new PageView<Advertising>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		
		pv.setQueryResult(advertisingDao.findPage(pv, filters));
		return pv;
	}
	@Override
	public Advertising getAdvertisingByUserId(Long id) {
		return advertisingDao.find(id);
	}
	@Override
	public Advertising  saveOrUpdateAdvertising(Advertising advertising) {
		return advertisingDao.saveOrUpdate(advertising);
	}
	@Override
	public List<Advertising> findAdvertising(Integer sort, Integer type,
			Integer flag) {
		PageView<Advertising> pv=new PageView<Advertising>();
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("sort", MatchType.EQ, sort));
		filters.add(new PropertyFilter("type", MatchType.EQ, type));	
		filters.add(new PropertyFilter("flag", MatchType.EQ, flag));	
		List<Advertising> as=this.advertisingDao.findPage(pv, filters).getResultlist();
		return as;
	}
	@Override
	public void deleteAdvertising(Long id) {
		advertisingDao.delete(id);
	}

	
	
}
