package com.antiphon.xiaomai.modules.service.custom;

import java.util.List;

import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;

public interface CustomLabelService {

	public List<CustomLabel> getCustomLabelList(Long id);
	
	public void saveOrUpdateCustomLabel(Long id,String[] label);
}
