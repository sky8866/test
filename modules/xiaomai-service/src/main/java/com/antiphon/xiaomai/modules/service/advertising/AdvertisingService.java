package com.antiphon.xiaomai.modules.service.advertising;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.advertising.Advertising;

public interface AdvertisingService {

	public PageView<Advertising> getPageAdvertising(int pageNo,int pageSize,Map<String,String> params);
	
	public Advertising getAdvertisingByUserId(Long id);
	
	public Advertising saveOrUpdateAdvertising(Advertising advertising);
	
	public List<Advertising> findAdvertising(Integer sort,Integer type,Integer flag);
	
	
	public void deleteAdvertising(Long id);
}
