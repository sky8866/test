package com.antiphon.xiaomai.modules.dao.user;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.user.User;

public interface UserDao extends HibernateDao<User> {
	 public User validate( String name, String password);

	    public User validate( String name);

	   

	    public boolean exsitMobile(String name, Long uid);

	    public boolean exsitMobile(String name);

	    public void disableToUser(Integer visible, Long[] userids);

	    public void delToUser(Long[] userids);

	    public boolean exsitTokenid(String token_id);
	 
	    User findUserByMobile( String mobile); 
	    
	    public void updatePhone(Long id,String phone);
}
