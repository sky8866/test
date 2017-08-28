package com.antiphon.xiaomai.modules.entity.cate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.RecordEntity;
@Entity
@Table(name = "xm_cate_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CateOrder  extends RecordEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7103907408820550236L;
	/**
     * 消费总额
     */
	private Double totalAmount;
	/**
	 * 实付金额
	 */
	private Double amountPaid;
	
	  /**
     * 0：等待付款，1：已经付款，2：已取消
     */
    private String status="0";
    
    private String name;
    private Long shopId;
    
    private String userName;
    private String phone;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	@Transient
	 public String getStatu(){
		if("0".equals(status)){
			return "未付款";
		}else if("1".equals(status)){
			return "已付款";
		}
		return "已取消";
	}
	
}
