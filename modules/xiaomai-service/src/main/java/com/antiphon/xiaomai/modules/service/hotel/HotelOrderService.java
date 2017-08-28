package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;  
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder; 

public interface HotelOrderService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  HotelOrder  findHotelOrder(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveHotelOrder(HotelOrder r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateHotelOrder(HotelOrder r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delHotelOrder(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public HotelOrder findHotelOrder(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<HotelOrder> findPage(PageView<HotelOrder> pv,List<PropertyFilter> filters );
	 public QueryResult<HotelOrder> findPageHotelOrder(PageView<HotelOrder> pv,String hql, Object[] queryParams);
 
	public QueryResult<HotelOrder> findPageHotelOrder(PageView<HotelOrder> pv,String query,String status ,String starttime,String endtime);
}
