package com.antiphon.xiaomai.modules.service.cate;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.entity.cate.CateComment;

public interface CateCommentService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  CateComment  findCateComment(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveCateComment(CateComment r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateCateComment(CateComment r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delCateComment(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public CateComment findCateComment(Object p,Object v);
	
	/**
	 * 根据条件查询
	 * @param pv
	 * @param filters
	 * @return
	 */
	public QueryResult<CateComment> findPage(PageView<CateComment> pv,List<PropertyFilter> filters );
	
}
