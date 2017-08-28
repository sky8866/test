package com.antiphon.xiaomai.modules.dao.indent.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalMoneyDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMoney;
@Repository
public class WithdrawalMoneyDaoImpl extends HibernateDaoImpl<WithdrawalMoney> implements
		WithdrawalMoneyDao {

	@Override
	public void updateMoneyByUserId(Long userId, double money) {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_withdrawal_money set extractable_money=extractable_money-").append(money);
		sql.append(" where user_id=").append(userId);
		Query query=this.em.createNativeQuery(sql.toString());
		query.executeUpdate();
	}


}
