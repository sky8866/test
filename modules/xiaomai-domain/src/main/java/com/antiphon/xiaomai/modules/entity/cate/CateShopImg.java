package com.antiphon.xiaomai.modules.entity.cate;

import javax.persistence.Entity;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 
import com.antiphon.xiaomai.modules.entity.IdEntity; 

@Entity
@Table(name = "xm_cate_shop_img")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CateShopImg extends IdEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -209928231174434618L;
	/**
	 * 门店Id
	 */
	private Long shopId;
	/**
	 * 图片
	 */
	private String imgId;

	 

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	
	
 
}
