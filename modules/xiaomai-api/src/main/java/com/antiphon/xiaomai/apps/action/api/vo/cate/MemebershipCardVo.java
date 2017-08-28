package com.antiphon.xiaomai.apps.action.api.vo.cate;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.cate.MemebershipCard;

public class MemebershipCardVo {
    private String name ;
    
    /**
	 * 面值
	 */
	private String  faceValue;
	
	/**
	 * 总额
	 */
	private String  money ;
	
	  /**
	    * 使用时间
	    */
	   private String usagetime;
	 
	   
	  private String info;
	  
	  public MemebershipCardVo(MemebershipCard card){
		  this.name=card.getName(); 
		  this.faceValue=card.getFaceValue()+""; 
		  this.money=card.getMoney()+"";
			String time="";
			if(StringUtils.isNotEmpty(card.getStarttime())&&StringUtils.isNotEmpty(card.getEndtime())) time=card.getStarttime()+"至"+card.getEndtime();
		  this.usagetime=time;   
		  this.info=card.getInfo();
			  
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


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


   


	public String getUsagetime() {
		return usagetime;
	}


	public void setUsagetime(String usagetime) {
		this.usagetime = usagetime;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}
	  
	  
	  
	  

}
