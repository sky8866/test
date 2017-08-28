package com.antiphon.xiaomai.modules.entity.cate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 代金券
 * @author sky
 *
 */
@Entity
@Table(name = "xm_cate_coupons")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CateCoupons extends RecordEntity{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -3495525477015494148L;
	/**
       * 代金券名称
       */
	private String name;
	/**
	 * 面值
	 */
	private Integer faceValue;
	
	/**
	 * 团购价
	 */
	private Integer buy;
	
	
	   /**
	    * 人均消费参考价
	    */
	   
	   private Integer consumption;
	   
	  /**
	   * 开始时间
	   */
	   private String starttime;
	   /**
	    * 结束时间
	    */
	   private String endtime;
	   
	   
	   
	   /**
	    * 使用时间
	    */
	   private String usagetime;
	   
	   /**
	    * 预约,0:不需要，1：需要
	    */
	   private 	Integer isAppointment;
	   
	   /**
	    * 预约，内容
	    */
	   private 	String appointment;
	   /**
	    * 限制
	    */
	   
	   private String restricted;
	   
	   /**
	    * 0：全场   1：一部分  2：除了某些之外，全场
	    */
	   
	   private Integer isScope;
	   /**
	    * 范围
	    */
	   private String scope;
	   /**
	    * 数量
	    */
	   private Integer amount;
	   
	   private String remark;
	   
	   private String dishInfo;
	   
	   private String info;
	   
	   private Long shopId;
	   
		/**
		 * 1:启用，0：停用
		 */
		private Integer visible=1;
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(Integer faceValue) {
		this.faceValue = faceValue;
	}
	public Integer getBuy() {
		return buy;
	}
	public void setBuy(Integer buy) {
		this.buy = buy;
	}
	public Integer getConsumption() {
		return consumption;
	}
	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getUsagetime() {
		return usagetime;
	}
	public void setUsagetime(String usagetime) {
		this.usagetime = usagetime;
	}
	public String getAppointment() {
		if(isAppointment==0) return ""; 
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	public String getRestricted() {
		return restricted;
	}
	public void setRestricted(String restricted) {
		this.restricted = restricted;
	}
	public String getScope() {
		 
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
 
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Integer getIsAppointment() {
		return isAppointment;
	}
	public void setIsAppointment(Integer isAppointment) {
		this.isAppointment = isAppointment;
	}
	public Integer getIsScope() {
		return isScope;
	}
	public void setIsScope(Integer isScope) {
		this.isScope = isScope;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
	public Integer getVisible() {
		return visible;
	}
	public void setVisible(Integer visible) {
		this.visible = visible;
	}

     
    




	public String getDishInfo() {
		return dishInfo;
	}
	public void setDishInfo(String dishInfo) {
		this.dishInfo = dishInfo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}







	private String usagestarttime;
	
	private String usageendtime;
	@Transient
	public String getUsagestarttime() {
		if(StringUtils.isNotEmpty(usagetime)) return usagetime.split("_")[0];
		return usagestarttime;
	}
	public void setUsagestarttime(String usagestarttime) {
		this.usagestarttime = usagestarttime;
	}
	@Transient
	public String getUsageendtime() {
		if(StringUtils.isNotEmpty(usagetime)) return usagetime.split("_")[1];
		return usageendtime;
	}
	public void setUsageendtime(String usageendtime) {
		this.usageendtime = usageendtime;
	}
	
	private String appointment1;
	
	
	@Transient
	public String getAppointment1() {
		if(StringUtils.isNotEmpty(appointment1))return appointment1 ;
		if(StringUtils.isNotEmpty(appointment)&&isAppointment==1)return getAppointment();
		return appointment1;
	}
	public void setAppointment1(String appointment1) {
		this.appointment1 = appointment1;
	}


	private String scope1;
	
	
	@Transient
	public String getScope1() {
		if(StringUtils.isNotEmpty(scope1)) return scope1;
		if(StringUtils.isNotEmpty(scope)&&isScope==1)return getScope();
		return scope1;
	}
	public void setScope1(String scope1) {
		this.scope1 = scope1;
	}


	private String scope2;
	@Transient
	public String getScope2() {
		if(StringUtils.isNotEmpty(scope2)) return scope2;
		if(StringUtils.isNotEmpty(scope)&&isScope==2)return getScope();
		
		return scope2;
	}
	public void setScope2(String scope2) {
		this.scope2 = scope2;
	}
	
	
	   
	   
}
