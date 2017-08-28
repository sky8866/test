package com.antiphon.xiaomai.modules.entity.advertising;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.antiphon.xiaomai.modules.entity.RecordEntity;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
@Entity
@Table(name = "xm_advertising")
public class Advertising extends RecordEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2636428354772155438L;
	
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 种类
	 */
	private Integer sort;
	
	/**
	 * 类型 
	 */
	private Integer type;
	/**
	 * 是否显示
	 */
	private Integer flag;
	
	/**
	 * 是否显示
	 */
	private List<Imgs> imgs;
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
/*	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}*/
	@Transient
	public List<Imgs> getImgs() {
		return imgs;
	}
	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
	}
	
	
}
