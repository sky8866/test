package com.antiphon.xiaomai.modules.dao.indent;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMoney;

public interface WithdrawalMoneyDao extends HibernateDao<WithdrawalMoney> {
	public void updateMoneyByUserId(Long userId, double money) ;
}
