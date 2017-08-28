package com.antiphon.xiaomai.modules.entity.indent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;

/**
 * 总订单表
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_withdrawal_record") 
public class WithdrawalRecord extends IdEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5401125733538609103L;
	private Date withdrawalTime; 
	private double money;
	private double totalMoney;
	private Long userId;
	/**
	 * 1.提交  2.审核通过 3.审核不通过 4。已打款
	 */
	private Integer status;
	public Date getWithdrawalTime() {
		return withdrawalTime;
	}
	public void setWithdrawalTime(Date withdrawalTime) {
		this.withdrawalTime = withdrawalTime;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
