package com.antiphon.xiaomai.modules.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.LoginlogDao;
import com.antiphon.xiaomai.modules.entity.user.Loginlog;
@Repository
public class LoginlogDaoImpl extends HibernateDaoImpl<Loginlog> implements
		LoginlogDao {

}
