package com.antiphon.xiaomai.modules.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.PrivilegeDao;
import com.antiphon.xiaomai.modules.entity.user.Privilege;
 
 

@Repository
public class PrivilegeDaoImpl extends HibernateDaoImpl<Privilege> implements
		PrivilegeDao {

	@Override
	public boolean exsit(String name) {
		try{
			long count = (Long) em
					.createQuery("select count(o) from Privilege o where o.privilegevalue=?1")
					.setParameter(1, name).getSingleResult();
		
			return count > 0;
		}catch (Exception e) {
			return false;
		}
	}

}
