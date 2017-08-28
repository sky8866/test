package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.Dish;

public interface DishService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Dish  findDish(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveDish(Dish r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateDish(Dish r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delDish(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Dish findDish(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<Dish> findPage(PageView<Dish> pv,List<PropertyFilter> filters );
	
}
