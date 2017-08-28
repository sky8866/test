package com.antiphon.xiaomai.modules.service.indent;

import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMonthRecord;

public interface WithdrawalMonthRecordService   {
	
	public PageView<WithdrawalMonthRecord> getPageMonthRecord(Map<String,String> params,int pageNo,int pageSize);
}
