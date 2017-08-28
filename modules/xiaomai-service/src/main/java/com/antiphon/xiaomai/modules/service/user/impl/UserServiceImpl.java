package com.antiphon.xiaomai.modules.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.user.UserDao;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.service.user.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDao userDao;
	@Override
	public User findUser(Long id) {
		return userDao.find(id);
	}
	
	public void updatePhone(Long id,String phone){
		userDao.updatePhone(id,phone);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
		
	}



}
