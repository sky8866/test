package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import java.util.ArrayList;
import java.util.List;

import com.antiphon.xiaomai.apps.action.api.vo.cate.ImgsVo;
import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.hotel.Hotel;
import com.antiphon.xiaomai.modules.entity.hotel.HotelFacility; 

public class HotelInfoVo {
	/**
	 * 酒店名称
	 */
	private String hotelName;
 
	/**
	 * 星级
	 */
    private String	stars;       
	/**
	 * 最低价格
	 */
	private String floorPrice;
	 
	   
	   private String hotelId;
	   
	   private String cover;
	   
	   private String starSum="4.5";
	   
	   private String distances="1km";
	   
	
	private List<HotelFacilityVo> facilitys=new ArrayList<HotelFacilityVo>();
	
 
	public HotelInfoVo(Hotel h){
		  this.hotelName=h.getHotelName();
	 
		  
		 
		  this.stars=h.getStars();  
	  
	      
	      this.floorPrice=h.getFloorPrice()+""; 
	      this.hotelId=h.getId()+"";
	      this.starSum="4.5";
	      this.distances="1km";
	      if(StringUtils.isNotEmpty(h.getCover())){
		    	
		    	 this.cover=ConfigUtil.getValue("server")+h.getCoverPath();
		    }
	      for(HotelFacility f:h.getFacilitys()){
	    	  HotelFacilityVo fv=new HotelFacilityVo(f);
	    	  facilitys.add(fv);
	      }
	      
	     
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
	public String getFloorPrice() {
		return floorPrice;
	}
	public void setFloorPrice(String floorPrice) {
		this.floorPrice = floorPrice;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
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
	public String getDistances() {
		return distances;
	}
	public void setDistances(String distances) {
		this.distances = distances;
	}
	public List<HotelFacilityVo> getFacilitys() {
		return facilitys;
	}
	public void setFacilitys(List<HotelFacilityVo> facilitys) {
		this.facilitys = facilitys;
	}
 
	
	
}
