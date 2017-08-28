package com.antiphon.xiaomai.modules.service.backpacking;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dto.BackpackingListDto;
import com.antiphon.xiaomai.modules.entity.backpacking.Backpacking;

public interface BackpackingService {

	public PageView<Backpacking> findPageView(int pageNo,int pageSize,Map<String,String> params);
	
	public void updateStatus(String ids,int status);
	
	public void saveBackpacking(Backpacking backpacking);
	
	public List<BackpackingListDto> findPageList(int pageNo,int pageSize,Map<String,String> params);
	
	public void addCount(Long id);
	
}
