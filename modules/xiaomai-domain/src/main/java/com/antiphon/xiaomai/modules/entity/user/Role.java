package com.antiphon.xiaomai.modules.entity.user;
  
import javax.persistence.Entity; 
import javax.persistence.Table; 
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;
  
 

@Entity
@Table(name="xm_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends IdEntity{
 
	 

   /**
    * 角色名字
    */
	private String rolename;
	/**
	 * 角色说明 
	 */
	
	private String roleInfo;
	/**
	 * 父ID
	 */
	private Long parentId;

	private Integer type=1;
 
	
	 
	
	
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	 
	public String getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
	 
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	 
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
	
    public Long userId;





	@Transient
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
     
    
}
