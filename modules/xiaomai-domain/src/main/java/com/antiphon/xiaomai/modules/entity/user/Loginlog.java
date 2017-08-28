package com.antiphon.xiaomai.modules.entity.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;
@Entity
@Table(name = "xm_loginlog")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Loginlog extends IdEntity {
	
	public Long userId;
	
	public Date date;
	
	public String  token;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
