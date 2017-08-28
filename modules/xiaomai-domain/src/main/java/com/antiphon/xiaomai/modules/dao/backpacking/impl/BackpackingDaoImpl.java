package com.antiphon.xiaomai.modules.dao.backpacking.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.common.utils.DistanceUtils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.dao.backpacking.BackpackingDao;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dto.BackpackingListDto;
import com.antiphon.xiaomai.modules.entity.backpacking.Backpacking;

@Repository
public class BackpackingDaoImpl extends HibernateDaoImpl<Backpacking> implements BackpackingDao{

	@Override
	public void updateStatus(String ids, int status) {
		Query query=this.em.createNativeQuery("update xm_backpacking set status="+status+" where id in("+ids+")");
		query.executeUpdate();
	}

	/**
	 * 约伴列表
	 */
	@Override
	public List<BackpackingListDto> findBackpackingListDto(int pageNo,
			int pageSize, Map<String, String> params) {
		String type=params.get("type");
		String city=params.get("city");
		String sex=params.get("sex");
		String near=params.get("near");
		String longitude=params.get("longitude");
		String latitude=params.get("latitude");
		StringBuffer sql=new StringBuffer();
		sql.append("select a.id,a.title,a.introduce,a.service_time,a.address,a.create_time,a.expense,a.count,c.name,c.gender,c.age,c.picture,a.longitude,a.latitude,a.invite_object,a.invite_num,a.pick_up");
		if(StringUtils.isNotEmpty(near)){//由近到远
			sql.append(" ,(POWER(MOD(ABS(a.longitude - ").append(longitude).append("),360),2) + POWER(ABS(a.latitude - ").append(latitude).append("),2)) AS distance ");//由近到远
		}
		sql.append(" from xm_backpacking a LEFT JOIN xm_imgs b on a.id=b.resource_id");
		sql.append(" LEFT JOIN xm_user c on a.user_id=c.id where 1=1");
		if(StringUtils.isNotEmpty(type)){
			sql.append(" and a.type=").append(type);	
		}
		if(StringUtils.isNotEmpty(city)){
			sql.append(" and a.city='").append(city).append("'");	
		}
		if(StringUtils.isNotEmpty(sex)){
			sql.append(" and c.gender=").append(sex);	
		}
		sql.append(" group by a.id order by distance ");
		Query query=this.em.createNativeQuery(sql.toString());
		query.setFirstResult(pageSize*(pageNo-1));
		query.setMaxResults(pageSize);
		List list=query.getResultList();
		List<BackpackingListDto> data=new ArrayList<BackpackingListDto>();
		BackpackingListDto dto=null;
		Object[] obj=null;
		for(int i=0;i<list.size();i++){
			dto=new BackpackingListDto();
			obj=(Object[]) list.get(i);
			dto.setId(obj[0].toString());
			dto.setTitle(obj[1].toString());
			dto.setIntroduce(obj[2].toString());
			dto.setServiceTime(obj[3].toString());
			dto.setAddress(obj[4].toString());
			dto.setCreateTime(obj[5].toString());
			dto.setExpense(obj[6].toString());
			dto.setCount(obj[7].toString());
			dto.setName(obj[8]!=null?obj[8].toString():"");
			dto.setSex(obj[9]!=null?obj[9].toString():"");
			dto.setAge(obj[10]!=null?obj[10].toString():"");
			dto.setPicture(obj[11]!=null?obj[11].toString():"");
			if(StringUtils.isNotEmpty(longitude) && StringUtils.isNotEmpty(latitude)){
				dto.setDistance(DistanceUtils.getDistance(Double.parseDouble(obj[12]!=null?obj[12].toString():"0"), Double.parseDouble(obj[13]!=null?obj[13].toString():"0"), Double.parseDouble(longitude),Double.parseDouble(latitude)));
			}
			dto.setInviteObject(obj[14]!=null?obj[14].toString():"");
			dto.setInviteNum(obj[15]!=null?obj[15].toString():"");
			dto.setPickUp(obj[16]!=null?obj[16].toString():"");
			data.add(dto);
		}
		return data;
	}

	@Override
	public void addCount(Long id) {
		Query query=this.em.createNativeQuery("update xm_backpacking set count=count+1 where id="+id);
		query.executeUpdate();
	}

}
