package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;  
import com.antiphon.xiaomai.modules.entity.hotel.Facility; 

public interface FacilityService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Facility  findFacility(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveFacility(Facility r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateFacility(Facility r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delFacility(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Facility findFacility(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<Facility> findPage(PageView<Facility> pv,List<PropertyFilter> filters );
	
 
	
}
