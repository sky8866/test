package com.antiphon.xiaomai.modules.dao.user;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.user.Role;
 

public interface RoleDao extends HibernateDao<Role> {

	boolean exsitRole(Long companyid,String name);

}
