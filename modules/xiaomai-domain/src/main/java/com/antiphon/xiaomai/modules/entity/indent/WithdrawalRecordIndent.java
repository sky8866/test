package com.antiphon.xiaomai.modules.entity.indent;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.IdEntity;

/**
 * 提现记录管理订单表
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_withdrawal_record_indent") 
public class WithdrawalRecordIndent extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5910475326544007405L;
	private Long recordId;
	private Long indentId;
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public Long getIndentId() {
		return indentId;
	}
	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}
	
}
