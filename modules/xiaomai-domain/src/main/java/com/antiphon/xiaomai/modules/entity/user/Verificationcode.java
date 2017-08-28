package com.antiphon.xiaomai.modules.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;
@Entity
@Table(name = "xm_verificationcode")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Verificationcode extends IdEntity{
	
	private String   mobile;  
	
    private String code;
    
    private String type;
    
    private String  state;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    

}
