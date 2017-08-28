package com.antiphon.xiaomai.modules.entity.custom;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;
/**
 * 定制师拥有语言
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_custom_language") 
public class CustomLanguage  extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6848208762094294102L;
	private long customId; // CustomInfo主键
	private Long userId;
	private String type; //语言所属类型
	private String name;  //语言名称
	private String level; //熟练程度
	
	public long getCustomId() {
		return customId;
	}
	public void setCustomId(long customId) {
		this.customId = customId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
