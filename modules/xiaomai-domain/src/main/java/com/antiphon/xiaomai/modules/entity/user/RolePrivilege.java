package com.antiphon.xiaomai.modules.entity.user;
 
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;
  
 

@Entity
@Table(name="xm_role_privilege")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RolePrivilege extends IdEntity{
	 
    /**
     * 角色ID
     */
	private Long roleId;
	/**
	 * 权限ID
	 */
	private Long privilegeId;
 
 
 

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
  
}
