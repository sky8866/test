package com.antiphon.xiaomai.modules.service.custom;

import java.util.List;

import com.antiphon.xiaomai.modules.entity.custom.CustomLanguage;

public interface CustomLanguageService {

	public List<CustomLanguage> getCustomLanguageList(Long id);
	
	public void saveOrUpdateCustomLanguage(Long id,String[] languages);
}
