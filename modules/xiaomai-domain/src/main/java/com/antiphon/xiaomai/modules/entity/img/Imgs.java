package com.antiphon.xiaomai.modules.entity.img;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.IdEntity;

@Entity
@Table(name = "xm_imgs")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Imgs extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 222401010971650446L;

	private String imgName;
	
	private String module;
	
	private Long userId;
	
	private Long resourceId;
	 
	
	
	
	private Date  createTime=new Date();

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

 
	 
	 
	 

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		if(this.createTime==null){
			createTime=new Date();
		}
		this.createTime = createTime;
	}
	
	
	
	 @Transient
	    public String getImage60Path(){
	        
	  
	        if(StringUtils.isNotEmpty(imgName)) return "/images/"+module+"/"+userId+"/60x/"+imgName;
	        return "";
	    }
	    @Transient
	    public String getImage120Path(){
	        
	  
	        if(StringUtils.isNotEmpty(imgName)) return "/images/"+module+"/"+userId+"/120x/"+imgName;
	        return "";
	    }
	    
	    @Transient
	    public String getImage200Path(){
	        
	  
	        if(StringUtils.isNotEmpty(imgName)) return "/images/"+module+"/"+userId+"/200x/"+imgName;
	        return "";
	    }

	    @Transient
	    public String getImage700Path(){
	        
	  
	        if(StringUtils.isNotEmpty(imgName)) return "/images/"+module+"/"+userId+"/700x/"+imgName;
	        return "";
	    }
	    @Transient
	    public String getImagePath(){
	        
	  
	        if(StringUtils.isNotEmpty(imgName)) return "/images/"+module+"/"+userId+"/"+imgName;
	        return "";
	    }

		public Long getResourceId() {
			return resourceId;
		}

		public void setResourceId(Long resourceId) {
			this.resourceId = resourceId;
		}
	

}
