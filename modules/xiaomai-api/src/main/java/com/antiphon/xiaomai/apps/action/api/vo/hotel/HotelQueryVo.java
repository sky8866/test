package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelQueryVo {
	
	private List<String> koubeis=new ArrayList<String>();
    
	private List<DistanceVo> distances=new ArrayList<DistanceVo>();
	
	private List<DistrictVo> districts=new ArrayList<DistrictVo>();
	private List<StarsAndPriceVo>  stars=new ArrayList<StarsAndPriceVo>();
	
	private List<String> brands =new ArrayList<String>();
	
	private List<String> facilitys=new ArrayList<String>();

	public List<String> getKoubeis() {
		return koubeis;
	}

	public void setKoubeis(List<String> koubeis) {
		this.koubeis = koubeis;
	}

	public List<DistanceVo> getDistances() {
		return distances;
	}

	public void setDistances(List<DistanceVo> distances) {
		this.distances = distances;
	}

	public List<DistrictVo> getDistricts() {
		return districts;
	}

	public void setDistricts(List<DistrictVo> districts) {
		this.districts = districts;
	}

	public List<StarsAndPriceVo> getStars() {
		return stars;
	}

	public void setStars(List<StarsAndPriceVo> stars) {
		this.stars = stars;
	}

	public List<String> getBrands() {
		return brands;
	}

	public void setBrands(List<String> brands) {
		this.brands = brands;
	}

	public List<String> getFacilitys() {
		return facilitys;
	}

	public void setFacilitys(List<String> facilitys) {
		this.facilitys = facilitys;
	}
	
	
}
