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
@Table(name = "xm_hotel_facility")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HotelFacility extends IdEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017863348281141637L;
	
	private  Long hotelId;
	
	private Long userId;

	/**
	 * 父名字
	 */
	private String name;
	
 
	
	private HotelFacility parent;
	/** 子类别 **/
	private Set<HotelFacility> childtypes = new HashSet<HotelFacility>();

 
	 
	 
	
	public HotelFacility(){}
	public HotelFacility(Long id){
		this.id=id;
	}
	
	
	
	
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 

	 

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="parentid")
	public HotelFacility getParent() {
		return parent;
	}

	public void setParent(HotelFacility parent) {
		this.parent = parent;
	}
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parent")
	@OrderBy("id ASC")
	public Set<HotelFacility> getChildtypes() {
		return childtypes;
	}

	public void setChildtypes(Set<HotelFacility> childtypes) {
		this.childtypes = childtypes;
	}
}
