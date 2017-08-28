package com.antiphon.xiaomai.apps.action.api.vo.user;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.modules.entity.user.User;

public class UserInfoVo { 
 
 
	private String name; 
    private String mobile; 
  
	
	/**
	 * 性别
	 */
	private String gender;
	
	/*头像**/
	private String picture;
	
	private String token;
	
	private String user_id;
	
	public UserInfoVo(User user){
		this.name=user.getName();
		this.mobile=user.getMobile();
		this.gender=user.getGender()+"";
		this.picture=ConfigUtil.getValue("server")+user.getImagePath();
		this.user_id=user.getId()+"";
		this.token=user.getToken();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
