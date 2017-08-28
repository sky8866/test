package com.antiphon.xiaomai.modules.dao.user;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.user.UserRole;
 
 

public interface UserRoleDao extends HibernateDao<UserRole> {

    /**
     * @param depid
     * @param userid
     * @return
     */
   public  boolean exsitUser(Long roleId,Long userId);

}
