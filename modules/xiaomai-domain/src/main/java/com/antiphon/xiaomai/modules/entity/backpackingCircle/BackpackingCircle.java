package com.antiphon.xiaomai.modules.entity.backpackingCircle;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 约伴-麦圈
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_backpacking_circle") 
public class BackpackingCircle extends RecordEntity {
	private String content;
	private String address;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
