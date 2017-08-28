package com.antiphon.xiaomai.modules.service.custom;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.custom.CustomIndent;

public interface CustomIndentService {

	public PageView<CustomIndent> findPageCustomIndent(int pageNumber, Map<String,String> params);
	
	public CustomIndent findCustomIndentById(Long id);
	
	public void SaveOrupdateCustomIndent(CustomIndent customIndent);
	
	public PageView<CustomIndent> findPageHqlCustomIndent(Map<String,String> params);
	
	public String getPriceTotal(Long userId);
	
	public List<String> getCustomIndent(Long userId);
	
}
