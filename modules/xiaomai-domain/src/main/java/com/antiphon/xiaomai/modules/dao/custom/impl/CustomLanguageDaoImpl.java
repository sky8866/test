package com.antiphon.xiaomai.modules.dao.custom.impl;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomLanguageDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomLanguage;
@Repository
public class CustomLanguageDaoImpl extends HibernateDaoImpl<CustomLanguage> implements CustomLanguageDao{

	@Override
	public void delPkid(Long pkId) {
		Query query=this.em.createQuery("delete CustomLanguage c where c.customId="+pkId);
		query.executeUpdate();
	}



}
