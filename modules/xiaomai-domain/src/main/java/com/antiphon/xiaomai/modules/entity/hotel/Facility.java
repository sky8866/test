package com.antiphon.xiaomai.modules.entity.hotel;
 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;

/**
 * 门店品类
 * @author sky
 *
 */
@Entity
@Table(name = "xm_facility")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Facility extends IdEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017863348281141637L;

	/**
	 * 父名字
	 */
	private String name;
	
	private Facility parent;
	/** 子类别 **/
	private Set<Facility> childtypes = new HashSet<Facility>();

 
	
	public Facility(){}
	public Facility(Long id){
		this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
 

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="parentid")
	public Facility getParent() {
		return parent;
	}

	public void setParent(Facility parent) {
		this.parent = parent;
	}
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parent")
	@OrderBy("id ASC")
	public Set<Facility> getChildtypes() {
		return childtypes;
	}

	public void setChildtypes(Set<Facility> childtypes) {
		this.childtypes = childtypes;
	}
}
