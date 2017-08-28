package com.antiphon.xiaomai.modules.service.cate.impl;

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
import com.antiphon.xiaomai.modules.dao.cate.CateOrderDao;  
import com.antiphon.xiaomai.modules.entity.cate.CateOrder; 
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder;
import com.antiphon.xiaomai.modules.service.cate.CateOrderService; 
@Service
public class CateOrderServiceImpl implements CateOrderService {
	@Autowired private CateOrderDao CateOrderDao;
 
	@Override
	public CateOrder findCateOrder(Long id) {
		 
		return this.CateOrderDao.find(id);
	}

	@Override
	public void saveCateOrder(CateOrder r) {
		 this.CateOrderDao.save(r);
		
	}

	@Override
	public void updateCateOrder(CateOrder r) {
	        this.CateOrderDao.update(r);
		
	}

	@Override
	public void delCateOrder(Serializable... entityids) {
		 this.CateOrderDao.delete(entityids);
		
	}

	@Override
	public CateOrder findCateOrder(Object p, Object v) {
	 
		return this.CateOrderDao.findProperty(p, v);
	}

	@Override
	public QueryResult<CateOrder> findPage(PageView<CateOrder> pv, List<PropertyFilter> filters) {
		 
		return this.CateOrderDao.findPage(pv, filters);
	}

	 @Cacheable(value="departCache") 
		public QueryResult<CateOrder> findPageOrder(PageView<CateOrder> pv,String status ,String starttime,String endtime){
		 
		 StringBuffer hql = new StringBuffer("");
		 hql.append("1=1  ");
		 List<Object> queryParams = new ArrayList<Object>();
		 
		 if(StringUtils.isNotEmpty(status)){
			 hql.append("and o.status=?").append(queryParams.size()+1);
			 queryParams.add(status);
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
			 return findPageOrder(pv,hql.toString(),  queryParams.toArray());
		}
	 
	 @Cacheable(value="departCache") 
  public QueryResult<CateOrder> findPageOrder(PageView<CateOrder> pv,String hql, Object[] queryParams){
      return this.CateOrderDao.findPage(pv,   hql, queryParams);
  }

	
}
