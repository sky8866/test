package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.MemebershipCard;

public interface MemebershipCardService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  MemebershipCard  findMemebershipCard(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveMemebershipCard(MemebershipCard r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateMemebershipCard(MemebershipCard r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delMemebershipCard(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public MemebershipCard findMemebershipCard(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<MemebershipCard> findPage(PageView<MemebershipCard> pv,List<PropertyFilter> filters );
	
}
