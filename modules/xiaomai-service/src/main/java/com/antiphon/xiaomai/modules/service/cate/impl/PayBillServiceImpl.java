package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
  
import com.antiphon.xiaomai.modules.dao.cate.PayBillDao;
import com.antiphon.xiaomai.modules.entity.cate.PayBill; 
import com.antiphon.xiaomai.modules.service.cate.PayBillService;
@Service
public class PayBillServiceImpl implements PayBillService {

	@Autowired private PayBillDao payBillDao;
	@Override
	public PayBill findPayBill(Long id) {
		 
		return this.payBillDao.find(id);
	}

	@Override
	public void savePayBill(PayBill r) {
		 this.payBillDao.save(r);
		
	}

	@Override
	public void updatePayBill(PayBill r) {
	        this.payBillDao.update(r);
		
	}

	@Override
	public void delPayBill(Serializable... entityids) {
		 this.payBillDao.delete(entityids);
		
	}

	@Override
	public PayBill findPayBill(Object p, Object v) {
	 
		return this.payBillDao.findProperty(p, v);
	}

	@Override
	public QueryResult<PayBill> findPage(PageView<PayBill> pv, List<PropertyFilter> filters) {
		 
		return this.payBillDao.findPage(pv, filters);
	}


}
