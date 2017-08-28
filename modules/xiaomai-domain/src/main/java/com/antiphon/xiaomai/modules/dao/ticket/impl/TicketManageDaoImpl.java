package com.antiphon.xiaomai.modules.dao.ticket.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.common.utils.DistanceUtils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.ticket.TicketManageDao;
import com.antiphon.xiaomai.modules.dto.ChoicenessTicketDto;
import com.antiphon.xiaomai.modules.dto.HotTicketDto;
import com.antiphon.xiaomai.modules.entity.ticket.TicketManage;

@Repository
public class TicketManageDaoImpl  extends HibernateDaoImpl<TicketManage> implements TicketManageDao{
	/**
	 * 精选景点
	 */
	@Override
	public List<ChoicenessTicketDto> getChoicenessTicketList() {
		Query query=this.em.createNativeQuery("select id,ticket_name,ticket_price,ticket_photo_url from xm_ticket_manage where selectTicket=1 ORDER BY sales_volume desc limit 0,3");
		List<Object> data=query.getResultList();
		List<ChoicenessTicketDto> list=new ArrayList<ChoicenessTicketDto>();
		Object[] obj=null;
		ChoicenessTicketDto dto=null;
		for(int i=0;i<data.size();i++){
			obj=(Object[]) data.get(i);
			dto=new ChoicenessTicketDto();
			dto.setId(obj[0]!=null?obj[0].toString():"");
			dto.setTicketName(obj[1]!=null?obj[1].toString():"");
			dto.setTicketPrice(obj[2]!=null?obj[2].toString():"0");
			dto.setTicketPhotoUrl((obj[3]!=null?obj[3].toString():""));
			list.add(dto);
		}
		return list;
	}
	/**
	 * 热门景点
	 */
	@Override
	public List<HotTicketDto> getHotTicketList(String city,double longitude,double latitude,int pageSize) {
		StringBuffer sql=new StringBuffer();
		sql.append("select id,ticket_name,ticket_price,ticket_photo_url,ticket_city,longitude,latitude from xm_ticket_manage");
		sql.append(" where status=1 ");
		if(StringUtils.isNotEmpty(city)){
			sql.append("and  ticket_city='"+city+"'");
		}
		sql.append(" ORDER BY sales_volume desc limit 0,"+pageSize);
		Query query=this.em.createNativeQuery(sql.toString());
		List<Object> data=query.getResultList();
		List<HotTicketDto> list=new ArrayList<HotTicketDto>();
		Object[] obj=null;
		HotTicketDto dto=null;
		for(int i=0;i<data.size();i++){
			obj=(Object[]) data.get(i);
			dto=new HotTicketDto();
			dto.setId(obj[0]!=null?obj[0].toString():"");
			dto.setTicketName(obj[1]!=null?obj[1].toString():"");
			dto.setTicketPrice(obj[2]!=null?obj[2].toString():"0");
			dto.setTicketPhotoUrl((obj[3]!=null?obj[3].toString():""));
			dto.setTicketCity((obj[4]!=null?obj[4].toString():""));
			//经纬度亮点距离
			dto.setTicketDistance(DistanceUtils.getDistance(Double.parseDouble(obj[5]!=null?obj[5].toString():"0"), Double.parseDouble(obj[6]!=null?obj[6].toString():"0"), longitude,latitude));	
			
			list.add(dto);
		}
		return list;
	}
	/**
	 * 全部景点
	 */
	@Override
	public List<HotTicketDto> getPageTicket(Map<String, String> params) {
		double longitude=Double.parseDouble(params.get("longitude"));
		double latitude=Double.parseDouble(params.get("latitude"));
		double distance=Double.parseDouble(params.get("distance"));
		String ticketType=params.get("ticketType");
		String near=params.get("near");
		String ticketCity=params.get("ticketCity");
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		Map<String,String> location=DistanceUtils.queryLocation(longitude, latitude, distance);
		String rightBottomLat=location.get("right-bottom_lat");
		String leftTopLat=location.get("left-top_lat");
		String leftTopLng=location.get("left-top_lng");
		String rightBottomLng=location.get("right-bottom_lng");
		
		StringBuffer sql=new StringBuffer();
		sql.append("select id,ticket_name,ticket_price,ticket_photo_url,ticket_city,longitude,latitude ");
		if(StringUtils.isNotEmpty(near)){//由近到远
			sql.append(" ,(POWER(MOD(ABS(longitude - ").append(longitude).append("),360),2) + POWER(ABS(latitude - ").append(latitude).append("),2)) AS distance ");//由近到远
		}
		sql.append(" from xm_ticket_manage where status=1");
		sql.append(" and longitude >="+leftTopLng+" and longitude<="+rightBottomLng);
		sql.append(" and latitude <="+leftTopLat+" and latitude>"+rightBottomLat);
		if(StringUtils.isNotEmpty(ticketType)){
			sql.append(" and ticket_type="+ticketType);
		}
		if(StringUtils.isNotEmpty(ticketCity)){
			sql.append(" and ticket_city='"+ticketCity+"'");
		}
		if(StringUtils.isNotEmpty(near)){//由近到远排序
			sql.append(" ORDER BY distance");
		}
		Query query=this.em.createNativeQuery(sql.toString());
		
		query.setFirstResult(pageSize*(pageNo-1));
		query.setMaxResults(pageSize);
		
		List<Object> data=query.getResultList();
		List<HotTicketDto> list=new ArrayList<HotTicketDto>();
		Object[] obj=null;
		HotTicketDto dto=null;
		for(int i=0;i<data.size();i++){
			obj=(Object[]) data.get(i);
			dto=new HotTicketDto();
			dto.setId(obj[0]!=null?obj[0].toString():"");
			dto.setTicketName(obj[1]!=null?obj[1].toString():"");
			dto.setTicketPrice(obj[2]!=null?obj[2].toString():"0");
			dto.setTicketPhotoUrl((obj[3]!=null?obj[3].toString():""));
			dto.setTicketCity((obj[4]!=null?obj[4].toString():""));
			//经纬度亮点距离
			dto.setTicketDistance(DistanceUtils.getDistance(Double.parseDouble(obj[5]!=null?obj[5].toString():"0"), Double.parseDouble(obj[6]!=null?obj[6].toString():"0"), longitude,latitude));
			list.add(dto);
		}
		return list;
	}
	/**
	 * 统计门票销量
	 */
	@Override
	public void updateSalesTotal() {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_ticket_manage a,(select count(*) count,resource_id,charge_off from xm_ticket_indent GROUP BY resource_id) b");
		sql.append(" set a.sales_volume=b.count where a.id=b.resource_id and b.status=1");
		try{
			Query query=this.em.createNativeQuery(sql.toString());
			int count=query.executeUpdate();
			System.out.println("门票统计执行成功！条数："+count);
		}catch (Exception e) {
			System.out.println("门票统计执行失败！");
		}
		
	}
	@Override
	public void updateStatus(String[] ids,int status) {
		String id=Arrays.toString(ids);
		id=id.replace("[", "").replace("]", "");
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_ticket_manage set status=").append(status).append(" where id in(").append(id).append(")");
		Query query=this.em.createNativeQuery(sql.toString());
		query.executeUpdate();
	}

}
