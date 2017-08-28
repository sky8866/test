package com.antiphon.xiaomai.modules.entity.cate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

@Entity
@Table(name = "xm_cate_paybill")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PayBill  extends RecordEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long shopId;
	/**
	 * 买单折扣
	 */
	private String payBillDiscount;
	/**
	 * 买单数量
	 */
	private Integer payBillCount;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getPayBillDiscount() {
		return payBillDiscount;
	}

	public void setPayBillDiscount(String payBillDiscount) {
		this.payBillDiscount = payBillDiscount;
	}

	public Integer getPayBillCount() {
		return payBillCount;
	}

	public void setPayBillCount(Integer payBillCount) {
		this.payBillCount = payBillCount;
	}
	
	
	
}
