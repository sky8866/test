package com.antiphon.xiaomai.modules.service.user;

import com.antiphon.xiaomai.modules.entity.user.User;

public interface UserService {
	public User findUser(Long id);
	
	public void updatePhone(Long id,String phone);
	
	public void updateUser(User user);
	
}
