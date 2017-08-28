package com.antiphon.xiaomai.modules.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomPlayInfoDao;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;
@Repository
public class CustomPlayInfoDaoImpl extends HibernateDaoImpl<CustomPlayInfo> implements CustomPlayInfoDao {

	@Override
	public List<CustomHomeHotCityDto> getCustomHomeHotCityDtoList() {
		Query query=this.em.createNativeQuery("select play_city,play_cover_url playCoverUrl from xm_custom_play_info group by play_city  order by play_total_sales desc");
		query.setFirstResult(0);
		query.setMaxResults(5);
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
	public void updateStatus(String ids, int status) {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_custom_play_info set");
		sql.append(" status=").append(status).append(" where id in(").append(ids).append(")");
		Query query=this.em.createNativeQuery(sql.toString());
		query.executeUpdate();
	}

}
