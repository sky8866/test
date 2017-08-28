package com.antiphon.xiaomai.modules.entity.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;  
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;
 
 
@Entity
@Table(name="xm_privilege")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Privilege extends IdEntity {
	/**
	 * 父
	 */
	private Privilege parent;
	
	/** 子类别 **/
	private Set<Privilege> childtypes = new HashSet<Privilege>();
	/**
	 * 权限名字
	 */
	
	private String name;
	/**
	 * 
	 */
	private String action;
	/**
	 * 权限值
	 */
	
	private String privilegevalue;
	/**
	 * 权限说明
	 */
	private String privilegeinfo;
	
	   /**
     * 1:启用，0：停用
     */
    private Integer visible=1;
	
	 
	public Privilege(){}
	public Privilege(Long p){
		this.id=p;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="parent_id")
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parent")
	public Set<Privilege> getChildtypes() {
		return childtypes;
	}
	public void setChildtypes(Set<Privilege> childtypes) {
		this.childtypes = childtypes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPrivilegevalue() {
		return privilegevalue;
	}
	public void setPrivilegevalue(String privilegevalue) {
		this.privilegevalue = privilegevalue;
	}
    public String getPrivilegeinfo() {
        return privilegeinfo;
    }
    public void setPrivilegeinfo(String privilegeinfo) {
        this.privilegeinfo = privilegeinfo;
    }
	
 
    public Integer getVisible() {
        return visible;
    }
    public void setVisible(Integer visible) {
        this.visible = visible;
    }
 
}
