package com.antiphon.xiaomai.modules.dao.user.impl;

import org.springframework.stereotype.Repository; 

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.RoleDao;
import com.antiphon.xiaomai.modules.entity.user.Role;
 
@Repository
public class RoleDaoImpl extends HibernateDaoImpl<Role> implements RoleDao {
	
	@Override
	public boolean exsitRole(Long userid,String name) {
		try{
			long count = (Long) em
					.createQuery("select count(o) from Role o where o.rolename=?1 and o.userId=?2")
					.setParameter(1, name).setParameter(2, userid).getSingleResult();
		
			return count > 0;
		}catch (Exception e) {
			return false;
		}
	}

}
