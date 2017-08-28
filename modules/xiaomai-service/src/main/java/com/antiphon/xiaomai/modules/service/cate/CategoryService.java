package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.Category;

public interface CategoryService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Category  findCategory(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCategory(Category r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCategory(Category r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCategory(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Category findCategory(Object p,Object v);
	
	public List<Category> findCategorys();
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<Category> findPage(PageView<Category> pv,List<PropertyFilter> filters );
	
}
