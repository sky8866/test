package com.antiphon.xiaomai.modules.dao.img;

import java.util.List;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.img.Imgs;

public interface ImgsDao extends HibernateDao<Imgs> {

	public List<String> getImgsUrl(String resourceId);
	
	public void delImgsByResourceId(Long resourceId);
	
}
