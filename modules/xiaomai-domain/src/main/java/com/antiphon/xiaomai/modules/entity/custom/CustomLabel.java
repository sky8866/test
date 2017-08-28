package com.antiphon.xiaomai.modules.entity.custom;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;
/**
 * 定制师个性标签
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_custom_label") 
public class CustomLabel extends IdEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9086919587317487904L;
	private Long customId;
	private Long userId;
	private String name;
	public Long getCustomId() {
		return customId;
	}
	public void setCustomId(Long customId) {
		this.customId = customId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
