package com.antiphon.xiaomai.modules.service.indent;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalRecord;


public interface WithdrawalRecordService  {

	public void SaveWithdrawalRecord(WithdrawalRecord withdrawalRecord);
	
	public boolean getSubmitted(Long id);
	
	
	public PageView<WithdrawalRecord> findPageWithdrawalRecord(Map<String,String> params);
	
	public PageView<WithdrawalRecord> getPageIndentRecord(Map<String,String> params);
	
	public void saveLastMonthMoneyTotal(Long userId);
	
	public void updateWithdrawalRecordStatus(String ids,int status);
	
}
