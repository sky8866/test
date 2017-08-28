package com.antiphon.xiaomai.modules.dao.user;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.user.Privilege;
 
 

public interface PrivilegeDao extends HibernateDao<Privilege> {
	boolean exsit(String name);
}
