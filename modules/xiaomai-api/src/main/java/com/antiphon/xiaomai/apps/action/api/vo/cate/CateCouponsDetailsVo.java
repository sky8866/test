package com.antiphon.xiaomai.apps.action.api.vo.cate;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.cate.CateCoupons;
import com.antiphon.xiaomai.modules.entity.cate.Category;

public class CateCouponsDetailsVo {
	/**
     * 代金券名称
     */
	private String name;
	/**
	 * 面值
	 */
	private String faceValue;
	
	/**
	 * 团购价
	 */
	private String buy;
	
	
	   /**
	    * 人均消费参考价
	    */
	   
	   private String consumption;
	   
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
	    * 预约，内容
	    */
	   private 	String appointment;
	 
	 
	   /**
	    * 范围
	    */
	   private String scope;
	   /**
	    * 数量
	    */
	   private String amount;
	   
	   private String remark;
	   /**
	    * 菜品价格参考
	    */
	   private String dishInfo;
	   /**
	    * 代金简介
	    */
	   private String info;
	   
	   public CateCouponsDetailsVo(CateCoupons c){
			 this.name=c.getName(); 
			 this.faceValue=c.getFaceValue()+""; 
			 this.buy=c.getBuy()+"";
			 
			 this.consumption=c.getConsumption()+""; 
			 this.starttime=c.getStarttime(); 
			 this.endtime=c.getEndtime(); 
			 String time=c.getUsagestarttime()+"至"+c.getUsageendtime();
			 this.usagetime=StringUtils.isNotEmpty(c.getUsagetime())?time:""; 
			    
			 this.appointment=c.getAppointment(); 
			 
			    
			 this.scope=c.getScope(); 
			 this.amount=c.getAmount()+"";
			   
			 this.remark=c.getRemark();
			 this.dishInfo=c.getDishInfo();
			 this.info=c.getInfo();
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String consumption) {
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
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	 

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	   
	   
	   
}
