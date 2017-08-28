package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.entity.cate.CateShopImg;
import com.antiphon.xiaomai.modules.entity.img.Imgs;

public interface CateShopImgService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  CateShopImg  findCateShopImg(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCateShopImg(CateShopImg r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCateShopImg(CateShopImg r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCateShopImg(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public CateShopImg findCateShopImg(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<CateShopImg> findPage(PageView<CateShopImg> pv,List<PropertyFilter> filters );
	
 
}
