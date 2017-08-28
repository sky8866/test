package com.antiphon.xiaomai.modules.entity.user;
  
import javax.persistence.Entity; 
import javax.persistence.Table; 
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;
  
 
@Entity
@Table(name="xm_user_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserRole extends IdEntity{
	/**
	 * 用户ID
	 */
    private Long  userId;
    /**
     * 角色IDs
     */
	private String roleIds;

	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
 
	
	
 
	
	 
	  
	 
	
	
}
