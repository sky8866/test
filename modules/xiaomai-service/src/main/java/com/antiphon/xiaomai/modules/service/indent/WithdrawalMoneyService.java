package com.antiphon.xiaomai.modules.service.indent;

import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMoney;

public interface WithdrawalMoneyService {

	public WithdrawalMoney getWithdrawalMoneyByUserId(Long userId);
	
	public void updateMoneyByUserId(Long userId,double money);
}
