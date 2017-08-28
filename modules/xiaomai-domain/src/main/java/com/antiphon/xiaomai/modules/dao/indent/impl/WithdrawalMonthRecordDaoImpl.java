package com.antiphon.xiaomai.modules.dao.indent.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalMonthRecordDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMonthRecord;
@Repository
public class WithdrawalMonthRecordDaoImpl extends HibernateDaoImpl<WithdrawalMonthRecord> implements WithdrawalMonthRecordDao {

	@Override
	public void saveMonthRecord() {
		StringBuffer sql=new StringBuffer();
		sql.append("insert into xm_withdrawal_month_record (user_id,money)");
		sql.append(" select user_id,sum(total_prices) from xm_custom_indent where");
		sql.append("date_format(charge_time,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
		sql.append("group by user_id");
		Query query=this.em.createNativeQuery(sql.toString());
		System.out.println(query.executeUpdate());
	}

	@Override
	public PageView<WithdrawalMonthRecord> getPageMonthRecord(
			Map<String, String> params, int pageNo, int pageSize) {
		
		return null;
	}



}
