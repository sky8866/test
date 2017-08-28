package com.antiphon.xiaomai.modules.service.indent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.indent.WithdrawalMoneyDao;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMoney;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalMoneyService;
@Service
public class WithdrawalMoneyServiceImpl implements WithdrawalMoneyService {
	@Autowired
	private WithdrawalMoneyDao withdrawalMoneyDao;
	
	@Override
	public WithdrawalMoney getWithdrawalMoneyByUserId(Long userId) {
		WithdrawalMoney withdrawalMoney=withdrawalMoneyDao.findProperty("userId", userId);
		return withdrawalMoney;
	}

	@Override
	public void updateMoneyByUserId(Long userId, double money) {
		withdrawalMoneyDao.updateMoneyByUserId(userId, money);
	}
	

}
