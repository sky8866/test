package com.antiphon.xiaomai.modules.entity.custom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;
import com.antiphon.xiaomai.modules.entity.RecordEntity;
/**
 * 定制师相册
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_custom_info") 
public class CustomPhoto extends RecordEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7437349676652457347L;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
