package com.antiphon.xiaomai.modules.entity.cate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 
import com.antiphon.xiaomai.modules.entity.RecordEntity;
import com.antiphon.xiaomai.modules.entity.img.Imgs;

/**
 * 菜品
 * @author sky
 *
 */
@Entity
@Table(name = "xm_cate_dish")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dish extends RecordEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 菜品分类
	 */
	private String type;
	/**
	 * 价格
	 */
	private Integer price;
	/**
	 * 单位
	 */
	private String unit;
	
	private Long cateShopId;
	
	private String info;
	
	/**
	 * 1:启用，0：停用
	 */
	private Integer visible=1;

	
	   private List<Imgs>  imgs=new ArrayList<Imgs>();
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getCateShopId() {
		return cateShopId;
	}

	public void setCateShopId(Long cateShopId) {
		this.cateShopId = cateShopId;
	}
	@Transient
	public List<Imgs> getImgs() {
		return imgs;
	}

	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
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
	


	
	
	
	

}
