package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.CateShop;

public interface CateShopService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  CateShop  findCateShop(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCateShop(CateShop r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCateShop(CateShop r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCateShop(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public CateShop findCateShop(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<CateShop> findPage(PageView<CateShop> pv,List<PropertyFilter> filters );
	
}
