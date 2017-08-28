package com.antiphon.xiaomai.modules.entity.city;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy; 
import com.antiphon.xiaomai.modules.entity.IdEntity;

@Entity
@Table(name = "xm_district")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class District extends IdEntity{

	 private String provincecode;
	 
	 private String provincename;
	 
	 private String citycode;
	 
	 private String cityname;
	 
	 private String districtcode;
	 
	 private String districtname;
	  

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

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDistrictcode() {
		return districtcode;
	}

	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
 
	 
	 
	 
}
