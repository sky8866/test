package com.antiphon.xiaomai.modules.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.common.utils.UtilDate;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomIndentDao;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomIndent;
@Repository
public class CustomIndentDaoImpl extends HibernateDaoImpl<CustomIndent> implements CustomIndentDao{

	/**
	 * 根据订单查询热门目的地
	 */
	@Override
	public List<CustomHomeHotCityDto> getCustomHomeHotCityDtoList() {
		Query query=this.em.createNativeQuery("select play_city,count(*) count from xm_custom_indent group by play_city  order by count desc");
		List<Object> list=query.getResultList();
		Object[] obj=null;
		List<CustomHomeHotCityDto> dtoList=new ArrayList<CustomHomeHotCityDto>();
		CustomHomeHotCityDto dto=null;
		for(int i=0;i<list.size();i++){
			obj=(Object[]) list.get(i);
			dto=new CustomHomeHotCityDto();
			dto.setCity(obj[0].toString());
			dto.setCityPhoto(obj[1].toString());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public int updateIndentStatus(Long id) {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_custom_indent set status='已取消' where id="+id);
		Query query=this.em.createNativeQuery(sql.toString());
		int data=query.executeUpdate();
		return data;
	}

	@Override
	public String getPriceTotal(Long userId) {
		StringBuffer sql=new StringBuffer();
		sql.append("select sum(total_prices) from xm_custom_indent where ");
		sql.append(" date_format(charge_time,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
		sql.append(" and user_id="+userId);
		Query query=this.em.createNativeQuery(sql.toString());
		Object data=query.getSingleResult();
		return data==null?"0":data.toString();
	}

	@Override
	public List<Long> getCustomIndent(Long userId) {
		List<Long> list=new ArrayList<Long>();
		StringBuffer sql=new StringBuffer();
		sql.append("select id from xm_custom_indent");
		sql.append(" where charge_time>='").append(UtilDate.getLastMonthOneDate()).append("'");
		sql.append(" and charge_time<'").append(UtilDate.getCurrentMonthOneDate()).append("'");
		sql.append(" and user_id=").append(userId);
		Query query= this.em.createNativeQuery(sql.toString());
		List<Object> obj=query.getResultList();
		for(Object data:obj){
			list.add(Long.parseLong(data.toString()));
		}
		return list;
	}


}
