package com.antiphon.xiaomai.modules.dao.backpacking;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.BackpackingListDto;
import com.antiphon.xiaomai.modules.entity.backpacking.Backpacking;

public interface BackpackingDao extends HibernateDao<Backpacking>{
	public void updateStatus(String ids, int status);
	/**
	 * 约伴列表
	 * @param pageNo
	 * @param pageSize
	 * @param params
	 * @return
	 */
	public List<BackpackingListDto> findBackpackingListDto(int pageNo,int pageSize,Map<String,String> params);
	
	public void addCount(Long id) ;
}
