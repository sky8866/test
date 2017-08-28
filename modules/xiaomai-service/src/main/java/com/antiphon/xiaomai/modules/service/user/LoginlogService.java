package com.antiphon.xiaomai.modules.service.user;

import java.io.Serializable;

import com.antiphon.xiaomai.modules.entity.user.Loginlog;

public interface LoginlogService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Loginlog  findLoginlog(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveLoginlog(Loginlog r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateLoginlog(Loginlog r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delLoginlog(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Loginlog findLoginlog(Object p,Object v);
}
