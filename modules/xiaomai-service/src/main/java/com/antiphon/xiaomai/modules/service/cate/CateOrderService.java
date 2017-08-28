package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.entity.cate.CateOrder; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder;

public interface CateOrderService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  CateOrder  findCateOrder(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCateOrder(CateOrder r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCateOrder(CateOrder r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCateOrder(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public CateOrder findCateOrder(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<CateOrder> findPage(PageView<CateOrder> pv,List<PropertyFilter> filters );
	
	 public QueryResult<CateOrder> findPageOrder(PageView<CateOrder> pv,String hql, Object[] queryParams);
	 
		public QueryResult<CateOrder> findPageOrder(PageView<CateOrder> pv,String status ,String starttime,String endtime);
}
