package com.antiphon.xiaomai.modules.dao.custom;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomLanguage;

public interface CustomLanguageDao extends HibernateDao<CustomLanguage> {

	public void delPkid(Long pkId);
	
	
}
