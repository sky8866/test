package com.antiphon.xiaomai.modules.entity.city;

 

import javax.persistence.Entity;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy; 
import com.antiphon.xiaomai.modules.entity.IdEntity;

@Entity
@Table(name = "xm_province")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Province extends IdEntity{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -1045987964272661788L;

	private String provincecode;
	 
	 private String provincename;

	public String getProvincecode() {
		return provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	 
	 
	 
	 
}
