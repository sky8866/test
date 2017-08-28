package com.antiphon.xiaomai.modules.service.city;

import java.io.Serializable;
import java.util.List;
 

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.entity.cate.DishImg;
import com.antiphon.xiaomai.modules.entity.city.City;
 
public interface CityService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  City  findCity(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCity(City r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCity(City r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCity(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public City findCity(Object p,Object v);
	
	public List<City> findCitys(Object p,Object v);
	public List<City>  findCitys();
	
	public QueryResult<City> findPage(PageView<City> pv,List<PropertyFilter> filters );
	
	 
}
