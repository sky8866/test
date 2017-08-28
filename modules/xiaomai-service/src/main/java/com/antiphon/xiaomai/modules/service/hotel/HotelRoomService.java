package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;  
import com.antiphon.xiaomai.modules.entity.hotel.HotelRoom; 

public interface HotelRoomService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  HotelRoom  findHotelRoom(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveHotelRoom(HotelRoom r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateHotelRoom(HotelRoom r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delHotelRoom(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public HotelRoom findHotelRoom(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<HotelRoom> findPage(PageView<HotelRoom> pv,List<PropertyFilter> filters );
	
 
	
}
