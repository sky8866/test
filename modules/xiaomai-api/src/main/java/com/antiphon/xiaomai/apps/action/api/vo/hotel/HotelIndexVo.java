package com.antiphon.xiaomai.apps.action.api.vo.hotel;
 
import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel; 

public class HotelIndexVo {
	
	private String hotelId;
	/**
	 * 酒店名称
	 */
	private String hotelName;
 
	/**
	 * 星级
	 */
    private String	stars;     
	/**
	 * 具体位置
	 */
	private String address;   
	/**
	 * 最低价格
	 */
	private String floorPrice;  
	   
	   private String cover;
	   
	   private String starSum="4.5";
	    
	    
	public HotelIndexVo(Hotel h){
		  this.hotelName=h.getHotelName();
	  
		 this.hotelId=h.getId()+"";
		  this.stars=h.getStars(); 
		  
	      this.address=h.getAddress(); 
	    
	      this.floorPrice=h.getFloorPrice()+"";
	      this.starSum="4.5";
	      if(StringUtils.isNotEmpty(h.getCover())){
		    	
		    	 this.cover=ConfigUtil.getValue("server")+h.getCoverPath();
		    }
	   
	}


	public String getHotelId() {
		return hotelId;
	}


	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getStars() {
		return stars;
	}


	public void setStars(String stars) {
		this.stars = stars;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getFloorPrice() {
		return floorPrice;
	}


	public void setFloorPrice(String floorPrice) {
		this.floorPrice = floorPrice;
	}


	public String getCover() {
		return cover;
	}


	public void setCover(String cover) {
		this.cover = cover;
	}


	public String getStarSum() {
		return starSum;
	}


	public void setStarSum(String starSum) {
		this.starSum = starSum;
	}
	
	 
	
	
}
