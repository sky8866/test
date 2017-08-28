package com.antiphon.xiaomai.modules.dao.custom;

import java.util.List;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;

public interface CustomLabelDao extends HibernateDao<CustomLabel> {
	public void delPkid(Long pkId);
	
	public List<String> getLabel(Long customId);
}
