package com.antiphon.xiaomai.modules.service.user.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.user.LoginlogDao;
import com.antiphon.xiaomai.modules.entity.user.Loginlog;
import com.antiphon.xiaomai.modules.service.user.LoginlogService;
@Service
public class LoginlogServiceImpl implements LoginlogService {
	 @Autowired private LoginlogDao loginlogDao;
		@Override
		public Loginlog findLoginlog(Long id) {
			 
			return this.loginlogDao.find(id);
		}

		@Override
		public void saveLoginlog(Loginlog r) {
			 this.loginlogDao.save(r);
			
		}

		@Override
		public void updateLoginlog(Loginlog r) {
		        this.loginlogDao.update(r);
			
		}

		@Override
		public void delLoginlog(Serializable... entityids) {
			 this.loginlogDao.delete(entityids);
			
		}

		@Override
		public Loginlog findLoginlog(Object p, Object v) {
		 
			return this.loginlogDao.findProperty(p, v);
		}
}
