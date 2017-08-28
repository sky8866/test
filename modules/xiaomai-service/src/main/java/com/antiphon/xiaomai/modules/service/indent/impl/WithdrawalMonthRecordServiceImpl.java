package com.antiphon.xiaomai.modules.service.indent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalMonthRecordDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMonthRecord;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalMonthRecordService;
@Service
public class WithdrawalMonthRecordServiceImpl implements
		WithdrawalMonthRecordService {
	@Autowired
	private  WithdrawalMonthRecordDao withdrawalMonthRecordDao;
	@Override
	public PageView<WithdrawalMonthRecord> getPageMonthRecord(
			Map<String, String> params, int pageNo, int pageSize) {
		long userId=Long.parseLong(params.get("userId"));
		PageView<WithdrawalMonthRecord> pv=new PageView<WithdrawalMonthRecord>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId",MatchType.EQ,userId));
		pv.setOrderby("createTime", "desc");
		pv.setQueryResult(withdrawalMonthRecordDao.findPage(pv, filters));
		return pv;
	}

}
