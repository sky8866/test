package com.antiphon.xiaomai.modules.dao.indent;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.IndentRecordDto;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalRecord;

public interface WithdrawalRecordDao extends HibernateDao<WithdrawalRecord> {

	public List<IndentRecordDto> getPageIndentRecord(Map<String,String> params);
	
	
	public void updateWithdrawalRecordStatus(String ids, int status);
}
