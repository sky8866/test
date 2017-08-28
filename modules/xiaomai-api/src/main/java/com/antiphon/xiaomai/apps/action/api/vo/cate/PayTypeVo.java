package com.antiphon.xiaomai.apps.action.api.vo.cate;

import com.antiphon.xiaomai.modules.entity.cate.CateCoupons;
import com.antiphon.xiaomai.modules.entity.cate.PayBill;

public class PayTypeVo {
	/**
	 * 买单折扣
	 */
	private String payBillDiscount="暂无打折";
	/**
	 * 买单数量
	 */
	private String payBillCount;
	/**
     * 代金券id
     */
	private String couponsId;
	/**
     * 代金券名称
     */
	private String couponsName;
	/**
     * 代金券已售数量
     */
	private String couponsCount="300";
	/**
	 * 会员卡已售数量
	 */
	private String cardCount="1000";
	
    public PayTypeVo(CateCoupons c,PayBill b){
    	if(c!=null){
    		this.couponsId=c.getId()+"";
        	this.couponsName=c.getName();
        	 
    	}else{
    		this.couponsCount="";
    	}
    	
    	if(b!=null){
    		payBillDiscount=b.getPayBillDiscount();
    		payBillCount="500";
    	}
    
    
    }
	
	public String getPayBillDiscount() {
		return payBillDiscount;
	}
	public void setPayBillDiscount(String payBillDiscount) {
		this.payBillDiscount = payBillDiscount;
	}
	public String getPayBillCount() {
		return payBillCount;
	}
	public void setPayBillCount(String payBillCount) {
		this.payBillCount = payBillCount;
	}
	public String getCouponsId() {
		return couponsId;
	}
	public void setCouponsId(String couponsId) {
		this.couponsId = couponsId;
	}
	public String getCouponsName() {
		return couponsName;
	}
	public void setCouponsName(String couponsName) {
		this.couponsName = couponsName;
	}
	public String getCouponsCount() {
		return couponsCount;
	}
	public void setCouponsCount(String couponsCount) {
		this.couponsCount = couponsCount;
	}
	public String getCardCount() {
		return cardCount;
	}
	public void setCardCount(String cardCount) {
		this.cardCount = cardCount;
	} 
	
	
	
}
