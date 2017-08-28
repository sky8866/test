package com.antiphon.xiaomai.modules.entity.indent;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;
import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 总订单表
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_indent_all") 
public class Indent extends RecordEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4677504159015567513L;
	private  Integer status;
	private Long indentId;
	private Integer type;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getIndentId() {
		return indentId;
	}
	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
