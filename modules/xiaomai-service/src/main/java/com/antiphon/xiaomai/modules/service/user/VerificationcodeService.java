package com.antiphon.xiaomai.modules.service.user;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.entity.user.Verificationcode;

public interface VerificationcodeService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Verificationcode  findVerificationcode(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveVerificationcode(Verificationcode r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateVerificationcode(Verificationcode r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delVerificationcode(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Verificationcode findVerificationcode(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<Verificationcode> findPage(PageView<Verificationcode> pv,List<PropertyFilter> filters );
	
	public String  findVerificationcodeToMobile(String mobile,String code);

}
