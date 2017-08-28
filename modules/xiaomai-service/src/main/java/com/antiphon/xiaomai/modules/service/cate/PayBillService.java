package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.PayBill;

public interface PayBillService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  PayBill  findPayBill(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void savePayBill(PayBill r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updatePayBill(PayBill r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delPayBill(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public PayBill findPayBill(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<PayBill> findPage(PageView<PayBill> pv,List<PropertyFilter> filters );
	
}
