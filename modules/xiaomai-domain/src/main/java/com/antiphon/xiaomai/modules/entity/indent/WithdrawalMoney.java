package com.antiphon.xiaomai.modules.entity.indent;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 用户可提取金额--统计表
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_withdrawal_money") 
public class WithdrawalMoney extends RecordEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4126282554391008306L;
	private double totalMoney;//总金额
	private double extractableMoney;//可提现金额
	
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public double getExtractableMoney() {
		return extractableMoney;
	}
	public void setExtractableMoney(double extractableMoney) {
		this.extractableMoney = extractableMoney;
	}
	
	
}
