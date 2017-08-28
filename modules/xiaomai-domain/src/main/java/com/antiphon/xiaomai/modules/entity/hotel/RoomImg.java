package com.antiphon.xiaomai.modules.entity.hotel;

import javax.persistence.Entity;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 
import com.antiphon.xiaomai.modules.entity.IdEntity; 

@Entity
@Table(name = "xm_hotel_room_img")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RoomImg extends IdEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -209928231174434618L;
	/**
	 * 酒店Id
	 */
	private Long roomId;
	/**
	 * 图片
	 */
	private String imgId;
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	 
     
}
