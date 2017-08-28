package com.antiphon.xiaomai.modules.entity.cate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.antiphon.xiaomai.modules.entity.IdEntity;

/**
 * 门店品类
 * @author sky
 *
 */
@Entity
@Table(name = "xm_category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category extends IdEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017863348281141637L;

	/**
	 * 品类名字
	 */
	private String name;
	
	private Category parent;
	/** 子类别 **/
	private Set<Category> childtypes = new HashSet<Category>();

	private Date  createTime=new Date();
	 
	
	private String ico;
	
	/**
	 * 1:启用，0：停用
	 */
	private Integer visible=1;
	
	public Category(){}
	public Category(Long id){
		this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="parentid")
	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parent")
	@OrderBy("createTime ASC")
	public Set<Category> getChildtypes() {
		return childtypes;
	}

	public void setChildtypes(Set<Category> childtypes) {
		this.childtypes = childtypes;
	}
	public Integer getVisible() {
		return visible;
	}
	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	
	
}
