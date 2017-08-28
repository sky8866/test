package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;  
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility;

public interface HotelFacilityService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  HotelFacility  findHotelFacility(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveHotelFacility(HotelFacility r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateHotelFacility(HotelFacility r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delHotelFacility(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public HotelFacility findHotelFacility(Object p,Object v);
	
	public List<HotelFacility> findHotelFacilitys(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<HotelFacility> findPage(PageView<HotelFacility> pv,List<PropertyFilter> filters );
	
}
