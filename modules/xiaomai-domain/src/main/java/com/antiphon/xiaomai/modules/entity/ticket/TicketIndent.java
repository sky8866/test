package com.antiphon.xiaomai.modules.entity.ticket;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 门票订单
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_ticket_indent") 
public class TicketIndent extends RecordEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1981633420362091789L;

	/**
	 * 登陆id
	 */
	private String LoginId;
	
	/**
	 * 客户昵称
	 */
	private String userName;
	/**
	 * 客户电话
	 */
	private long userPhone;
	/**
	 * 使用时间
	 */
	private String serviceTime;
	/**
	 * 资源id
	 */
	private Long resourceId;
	/**
	 * 资源名称
	 */
	private String resourceName;
	/**
	 * 数量
	 */
	private int numberOfPeople;
	/**
	 * 总金额
	 */
	private double totalMoney;
	/**
	 * 状态
	 */
	private Integer status;

	public String getLoginId() {
		return LoginId;
	}
	public void setLoginId(String loginId) {
		LoginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	
}
