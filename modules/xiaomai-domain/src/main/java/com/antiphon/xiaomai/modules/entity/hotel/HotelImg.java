package com.antiphon.xiaomai.modules.entity.hotel;

import javax.persistence.Entity;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 
import com.antiphon.xiaomai.modules.entity.IdEntity; 

@Entity
@Table(name = "xm_hotel_img")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HotelImg extends IdEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -209928231174434618L;
	/**
	 * 酒店Id
	 */
	private Long hotelId;
	/**
	 * 图片
	 */
	private String imgId;
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	 
     
}
