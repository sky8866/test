package com.antiphon.xiaomai.modules.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.UserRoleDao;
import com.antiphon.xiaomai.modules.entity.user.UserRole;
 
@Repository
public class UserRoleDaoImpl extends HibernateDaoImpl<UserRole> implements
		UserRoleDao {
    
    @Override
    public boolean exsitUser(Long roleId,Long userId) {
        try{
            long count = (Long) em
                    .createQuery("select count(o) from UserRole o where o.roleId=?1 and o.userId=?2")
                    .setParameter(1, roleId).setParameter(2, userId).getSingleResult();
        
            return count > 0;
        }catch (Exception e) {
            return false;
        }
        
    }

}
