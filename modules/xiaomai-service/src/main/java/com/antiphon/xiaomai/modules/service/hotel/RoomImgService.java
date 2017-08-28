package com.antiphon.xiaomai.modules.service.hotel;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.hotel.RoomImg;

public interface RoomImgService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  RoomImg  findRoomImg(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveRoomImg(RoomImg r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateRoomImg(RoomImg r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delRoomImg(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public RoomImg findRoomImg(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<RoomImg> findPage(PageView<RoomImg> pv,List<PropertyFilter> filters );
}
