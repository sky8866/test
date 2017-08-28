package com.antiphon.xiaomai.modules.entity.cate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

@Entity
@Table(name = "xm_cate_comment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CateComment extends RecordEntity  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shopId;
	private String content; 
	private String name;
	
	private String starSum;
	
	private String imgs;

 
	 
	
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarSum() {
		return starSum;
	}

	public void setStarSum(String starSum) {
		this.starSum = starSum;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	
	
	

}
