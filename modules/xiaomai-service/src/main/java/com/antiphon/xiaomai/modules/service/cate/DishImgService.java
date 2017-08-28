package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.entity.cate.DishImg;
 

public interface DishImgService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  DishImg  findDishImg(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveDishImg(DishImg r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateDishImg(DishImg r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delDishImg(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public DishImg findDishImg(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<DishImg> findPage(PageView<DishImg> pv,List<PropertyFilter> filters );
	
 
}
