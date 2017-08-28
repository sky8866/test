package com.antiphon.xiaomai.modules.service.indent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.custom.CustomIndentDao;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalMonthRecordDao;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalRecordDao;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalRecordIndentDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMonthRecord;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalRecord;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalRecordIndent;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalRecordService;
@Service
public class WithdrawalRecordServiceImpl implements WithdrawalRecordService {

	@Autowired
	private WithdrawalRecordDao withdrawalRecordDao;
	
	@Autowired
	private WithdrawalRecordIndentDao withdrawalRecordIndentDao;
	
	@Autowired
	private CustomIndentDao customIndentDao;
	@Autowired
	private WithdrawalMonthRecordDao withdrawalMonthRecordDao;
	
	@Override
	public void SaveWithdrawalRecord(WithdrawalRecord withdrawalRecord) {
		withdrawalRecordDao.save(withdrawalRecord);
		List<WithdrawalRecordIndent> list=new ArrayList<WithdrawalRecordIndent>();
		List<Long> ids=customIndentDao.getCustomIndent(withdrawalRecord.getUserId());
		for(Long id:ids){
			WithdrawalRecordIndent indent=new WithdrawalRecordIndent();
			indent.setIndentId(id);
			indent.setRecordId(withdrawalRecord.getId());
			list.add(indent);
		}
		withdrawalRecordIndentDao.saveAll(list);
	}


	@Override
	public boolean getSubmitted(Long id) {
		Object [] obj1=new Object[]{"userId","status"};
		Object [] obj2=new Object[]{id,1};
		WithdrawalRecord data=withdrawalRecordDao.findPropertys(obj1,obj2);
		if(data==null){
			return false;
		}
		return true;
	}

	/**
	 * 申请提现记录
	 */
	@Override
	public PageView<WithdrawalRecord> findPageWithdrawalRecord(
			Map<String, String> params) {
		String pageNo=params.get("pageNo");
		PageView<WithdrawalRecord> pv=new PageView<WithdrawalRecord>(10,Integer.parseInt(pageNo==null?"1":pageNo));
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		String userId=params.get("userId");
		if(StringUtils.isNotEmpty(userId)){
			filters.add(new PropertyFilter("userId", MatchType.EQ,Long.parseLong(userId)));
		}
		pv.setOrderby("withdrawalTime", "desc");
		pv.setQueryResult(withdrawalRecordDao.findPage(pv, filters));
		return pv;
	}


	@Override
	public PageView<WithdrawalRecord> getPageIndentRecord(
			Map<String, String> params) {
		PageView<WithdrawalRecord> pv=new PageView<WithdrawalRecord>();
		withdrawalRecordDao.getPageIndentRecord(params);
		return null;
	}

	
	@Override
	public void saveLastMonthMoneyTotal(Long userId) {
		String total=customIndentDao.getPriceTotal(userId);
		if(StringUtils.isNotEmpty(total)){
		WithdrawalMonthRecord wmr=new WithdrawalMonthRecord();
		wmr.setMoney(Double.parseDouble(total));
		wmr.setUserId(userId);
		withdrawalMonthRecordDao.save(wmr);
		}
	}


	@Override
	public void updateWithdrawalRecordStatus(String ids, int status) {
		withdrawalRecordDao.updateWithdrawalRecordStatus(ids, status);
	}
	
}
