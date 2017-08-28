package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelImg;

public interface HotelImgService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  HotelImg  findHotelImg(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveHotelImg(HotelImg r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateHotelImg(HotelImg r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delHotelImg(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public HotelImg findHotelImg(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<HotelImg> findPage(PageView<HotelImg> pv,List<PropertyFilter> filters );
}
