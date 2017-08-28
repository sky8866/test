package com.antiphon.xiaomai.modules.dao.indent;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMonthRecord;

public interface WithdrawalMonthRecordDao  extends HibernateDao<WithdrawalMonthRecord>  {
	
	public void saveMonthRecord();
	
	public PageView<WithdrawalMonthRecord> getPageMonthRecord(Map<String,String> params,int pageNo,int pageSize);
	
	
}
