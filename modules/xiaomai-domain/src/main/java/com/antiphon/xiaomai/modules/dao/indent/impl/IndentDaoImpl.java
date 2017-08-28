package com.antiphon.xiaomai.modules.dao.indent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.indent.IndentDao;
import com.antiphon.xiaomai.modules.dto.IndentDto;
import com.antiphon.xiaomai.modules.entity.indent.Indent;
@Repository
public class IndentDaoImpl extends HibernateDaoImpl<Indent> implements IndentDao   {

	@Override
	public List<IndentDto> findPageIndent(Long clientId,String status, int pageNo,int pageSize) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from (");
		//门票
		sql.append("select a.id,a.type,a.indent_id,b.resource_id resource_id,b.resource_name resourceName,b.total_money price,b.service_time,b.create_time,b.status,b.user_id categoryId  from xm_indent_all a,xm_ticket_indent b");
		sql.append(" where a.indent_id=b.id and a.type=2 and a.user_id=").append(clientId);
		if(StringUtils.isNotEmpty(status)){
			sql.append(" and b.status=").append(status);
		}//定制游
		sql.append(" UNION ALL");
		sql.append(" select a.id,a.type,a.indent_id,b.play_id resource_id,b.play_name resourceName,b.total_prices price,b.departure_time service_time,b.create_time,b.status,b.custom_id categoryId  from xm_indent_all a,xm_custom_indent b");
		sql.append(" where a.indent_id=b.id and a.type=1  and a.user_id=").append(clientId);
		if(StringUtils.isNotEmpty(status)){
			sql.append(" and b.status=").append(status);
		}
		//美食
		sql.append(" UNION ALL");
		sql.append(" select a.id,a.type,a.id indent_id,b.shop_id resource_id,b.name");
		sql.append(" resourceName,b.amount_paid price,b.update_time service_time,b.create_time,");
		sql.append(" b.status,b.shop_id categoryId  from xm_indent_all a,xm_cate_order b");
		sql.append(" where a.indent_id=b.id and a.type=3  and a.user_id=").append(clientId);
		if(StringUtils.isNotEmpty(status)){
			sql.append(" and b.status=").append(status);
		}
		//酒店
		sql.append(" UNION ALL");
		sql.append(" select a.id,a.type,b.id indent_id,b.hotel_id resource_id,b.hotel_name ");
		sql.append(" resourceName,b.total price,b.checkin_time service_time,b.ckeck_time create_time,b.status,b.hotel_id categoryId ");
		sql.append(" from xm_indent_all a,xm_hotel_order b");
		sql.append(" where a.indent_id=b.id and a.type=4  and a.user_id=").append(clientId);
		if(StringUtils.isNotEmpty(status)){
			sql.append(" and b.status=").append(status);
		}
		
		sql.append(") temp order by temp.create_time desc");
		Query query=this.em.createNativeQuery(sql.toString());
		query.setFirstResult(pageSize*(pageNo-1));
		query.setMaxResults(pageSize);
		List<Object> data=query.getResultList();
		List<IndentDto> list=new ArrayList<IndentDto>();
		Object[] obj=null;
		IndentDto dto=null;
		for(int i=0;i<data.size();i++){
			obj=(Object[]) data.get(i);
			dto=new IndentDto();
			dto.setId(obj[0]!=null?obj[0].toString():"");
			dto.setType(obj[1]!=null?obj[1].toString():"");
			dto.setIndentId(obj[2]!=null?obj[2].toString():"");
			dto.setResourceId(obj[3]!=null?obj[3].toString():"");
			dto.setResourceName(obj[4]!=null?obj[4].toString():"");
			dto.setPrice(obj[5]!=null?obj[5].toString():"");
			dto.setServiceTime(obj[6]!=null?obj[6].toString():"");
			dto.setEndTime(obj[7]!=null?obj[7].toString():"");
			dto.setStatus(obj[8]!=null?obj[8].toString():"");
			dto.setTypeId(obj[9]!=null?obj[9].toString():"");
			list.add(dto);
		}
		return list;
	}

	@Override
	public int updateIndentStatus(Long id,String table) {
		StringBuffer sql=new StringBuffer();
		sql.append("update "+table+" set status=1 where id="+id);
		Query query=this.em.createNativeQuery(sql.toString());
		int data=query.executeUpdate();
		return data;
	}
	
/*	private String getSql(List<Map<String,String>> list){
		StringBuffer sql=new StringBuffer();
		for(int i=0;i<list.size();i++){
			Map<String,String> params=list.get(i);
			String d=params.get("");
			sql.append(" UNION ALL");
			sql.append(" select a.id,a.type,client_id,b.user_id,a.indent_id,b.play_id resource_id,b.play_name resourceName,b.total_prices price,b.departure_time service_time,b.create_time,b.status  from xm_indent_all a,xm_custom_indent b");
			sql.append(" where a.indent_id=b.id and a.type=1  and b.client_id=").append(clientId);
			if(StringUtils.isNotEmpty(status)){
				sql.append(" and b.status='").append(status+"'");
			}
		}
		return "";
	}
*/
}
