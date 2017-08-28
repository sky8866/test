package com.antiphon.xiaomai.modules.service.backpacking.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.backpacking.BackpackingDao;
import com.antiphon.xiaomai.modules.dao.img.ImgsDao;
import com.antiphon.xiaomai.modules.dto.BackpackingListDto;
import com.antiphon.xiaomai.modules.entity.backpacking.Backpacking;
import com.antiphon.xiaomai.modules.service.backpacking.BackpackingService;

@Service
public class BackpackingServiceImpl implements BackpackingService {

	@Autowired
	private BackpackingDao backpackingDao;
	@Autowired
	private ImgsDao imgsDao;
	
	@Override
	public PageView<Backpacking> findPageView(int pageNo, int pageSize,
			Map<String, String> params) {
		PageView<Backpacking> pv=new PageView<Backpacking>(pageSize,pageNo);
		pv.setOrderby("createTime", "desc");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		String status=params.get("status");
		if(StringUtils.isNotEmpty(status)&& !status.equals("0")){
			filters.add(new PropertyFilter("status",MatchType.EQ,Integer.parseInt(status)));
		}
		pv.setQueryResult(backpackingDao.findPage(pv,filters));
		return pv;
	}

	@Override
	public void updateStatus(String ids, int status) {
		backpackingDao.updateStatus(ids, status);
	}

	@Override
	public void saveBackpacking(Backpacking backpacking) {
		backpackingDao.save(backpacking);
	}

	@Override
	public List<BackpackingListDto>  findPageList(int pageNo,int pageSize,Map<String,String> params){
		List<BackpackingListDto> dto=backpackingDao.findBackpackingListDto(pageNo, pageSize, params);
		for(BackpackingListDto data:dto){
			data.setPhotos(imgsDao.getImgsUrl(data.getId()));
		}
		return dto;
	}

	@Override
	public void addCount(Long id) {
		backpackingDao.addCount(id);
	}

}
