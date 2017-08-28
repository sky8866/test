package com.antiphon.xiaomai.modules.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.custom.CustomLanguageDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomLanguage;
import com.antiphon.xiaomai.modules.service.custom.CustomLanguageService;
@Service
public class CustomLanguageServiceImpl  implements  CustomLanguageService{

	 @Autowired 
	 private CustomLanguageDao customLanguageDao;

	@Override
	public List<CustomLanguage> getCustomLanguageList(Long id) {
		return customLanguageDao.findPropertyList("userId", id);
	}

	@Override
	public void saveOrUpdateCustomLanguage(Long id, String[] languages) {
		customLanguageDao.delPkid(id);
		CustomLanguage 	customLanguage=null;
		for(String data: languages){
			customLanguage=new CustomLanguage();
			customLanguage.setCustomId(id);
			customLanguage.setUserId(id);
			customLanguage.setName(data);
			customLanguage.setType("2");
			customLanguageDao.save(customLanguage);
		}
	}
}
