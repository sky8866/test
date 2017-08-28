package com.antiphon.xiaomai.modules.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
@MappedSuperclass
public class RecordEntity extends IdEntity{
	private static final long serialVersionUID = 2119242071627599693L;
	private Long userId;
	
	private Date  createTime;
	
	private Date  updateTime;

	@PrePersist
    public void prePersist(){
		this.updateTime = new Date();
		this.createTime = this.updateTime;
    }

    @PreUpdate
    public void preUpdate(){
        this.updateTime = new Date();                
    }
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(updatable=false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
}
