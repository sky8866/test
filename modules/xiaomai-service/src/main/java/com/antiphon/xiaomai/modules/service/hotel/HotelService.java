package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;  
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;

public interface HotelService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Hotel  findHotel(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveHotel(Hotel r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateHotel(Hotel r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delHotel(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Hotel findHotel(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<Hotel> findPage(PageView<Hotel> pv,List<PropertyFilter> filters );
	
}
