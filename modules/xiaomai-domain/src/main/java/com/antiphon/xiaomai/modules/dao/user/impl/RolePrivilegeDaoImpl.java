package com.antiphon.xiaomai.modules.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.RolePrivilegeDao;
import com.antiphon.xiaomai.modules.entity.user.RolePrivilege;
 
 
@Repository
public class RolePrivilegeDaoImpl extends HibernateDaoImpl<RolePrivilege> implements RolePrivilegeDao{

}
