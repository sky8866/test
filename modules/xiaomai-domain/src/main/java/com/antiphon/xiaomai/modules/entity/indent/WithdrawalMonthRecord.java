package com.antiphon.xiaomai.modules.entity.indent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;
import com.antiphon.xiaomai.modules.entity.RecordEntity;
/**
 * 月结记录
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_withdrawal_month_record") 
public class WithdrawalMonthRecord extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4967068447188803222L;
	private double money;
	private Date createTime;
	private Long userId;
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
