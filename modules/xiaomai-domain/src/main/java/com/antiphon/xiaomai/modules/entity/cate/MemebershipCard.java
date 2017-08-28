package com.antiphon.xiaomai.modules.entity.cate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 会员卡
 * @author sky
 *
 */
@Entity
@Table(name = "xm_cate_membership_card")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MemebershipCard  extends RecordEntity{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2070866009890240854L;

	private String name ;
    
    /**
	 * 面值
	 */
	private Integer faceValue;
	
	/**
	 * 总额
	 */
	private Integer money ;
	
	  /**
	   * 开始时间
	   */
	   private String starttime;
	   /**
	    * 结束时间
	    */
	   private String endtime;
	
	   private Long shopId;
	   
	  private String info;
	  
	   
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

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
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
	   
	   
}
