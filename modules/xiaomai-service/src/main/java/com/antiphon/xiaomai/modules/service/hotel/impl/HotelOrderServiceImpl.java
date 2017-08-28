package com.antiphon.xiaomai.modules.service.hotel.impl;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.dao.hotel.HotelOrderDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder; 
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.service.hotel.HotelOrderService;
   
@Service
public class HotelOrderServiceImpl implements HotelOrderService {

	@Autowired private  HotelOrderDao HotelOrderDao; 
	@Override
	public HotelOrder findHotelOrder(Long id) {
		 
		return this.HotelOrderDao.find(id);
	}

	@Override
	public void saveHotelOrder(HotelOrder r) {
		 this.HotelOrderDao.save(r);
		
	}

	@Override
	public void updateHotelOrder(HotelOrder r) {
	        this.HotelOrderDao.update(r);
		
	}

	@Override
	public void delHotelOrder(Serializable... entityids) {
		 this.HotelOrderDao.delete(entityids);
		
	}

	@Override
	public HotelOrder findHotelOrder(Object p, Object v) {
	 
		return this.HotelOrderDao.findProperty(p, v);
	}

	@Override
	public QueryResult<HotelOrder> findPage(PageView<HotelOrder> pv, List<PropertyFilter> filters) {
		 
		return this.HotelOrderDao.findPage(pv, filters);
	}

	 
	 @Cacheable(value="departCache") 
		public QueryResult<HotelOrder> findPageHotelOrder(PageView<HotelOrder> pv,String query,String status ,String starttime,String endtime){
		 
		 StringBuffer hql = new StringBuffer("");
		 hql.append("1=1  ");
		 List<Object> queryParams = new ArrayList<Object>();
		 
		 if(StringUtils.isNotEmpty(status)){
			 hql.append("and o.status=?").append(queryParams.size()+1);
			 queryParams.add(status);
		 }	 
		 
		 
		 
       if(StringUtils.isNotEmpty(query)){
			 
       	hql.append(" and ( o.hotelName like ?").append(queryParams.size()+1);
       	queryParams.add("%"+query+ "%");
       	hql.append(" or o.roomName like ?").append(queryParams.size()+1);
       	queryParams.add("%"+query+ "%");
       	  
       	hql.append(" )");
       	
		 }
       String start="";
       String end=""; 
       if (!StringUtils.isNotEmpty(starttime)) {
           start = "2014-01-01";
       }else{
           start=starttime+" 00:00:00";
       }
       if (!StringUtils.isNotEmpty(endtime)) {
           end = "2100-12-31";
       }else{
           end = endtime+" 23:59:59"; 
       }
       String  date=" and o.createTime between '"+start+"' and '"+end+"'";
       hql.append(date);
			 return findPageHotelOrder(pv,hql.toString(),  queryParams.toArray());
		}
	 
	 @Cacheable(value="departCache") 
     public QueryResult<HotelOrder> findPageHotelOrder(PageView<HotelOrder> pv,String hql, Object[] queryParams){
         return this.HotelOrderDao.findPage(pv,   hql, queryParams);
     }


}
