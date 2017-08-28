package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.CateCoupons;

public interface CateCouponsService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  CateCoupons  findCateCoupons(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCateCoupons(CateCoupons r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCateCoupons(CateCoupons r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCateCoupons(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public CateCoupons findCateCoupons(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<CateCoupons> findPage(PageView<CateCoupons> pv,List<PropertyFilter> filters );
	
}
