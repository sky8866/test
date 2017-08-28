package com.antiphon.xiaomai.apps.action.api.vo.hotel;

import java.util.ArrayList;
import java.util.List;

public class StarsAndPriceVo {
	
    private List<String> stars=new ArrayList<String>();
    private List<PriceTypeVo> priceTypes=new ArrayList<PriceTypeVo>();
    
    public StarsAndPriceVo(){
    	stars.add("不限");
    	stars.add("客栈公寓");
    	stars.add("经济连锁");
    	stars.add("经济连锁");
    	stars.add("二星");
    	stars.add("三星合适");
    	stars.add("四星高档");
    	stars.add("五星豪华");
    	
    	priceTypes.add(new PriceTypeVo("1", "价格从高到低"));
    	priceTypes.add(new PriceTypeVo("0", "价格从底到高"));
    }
	 
    
    
	public List<PriceTypeVo> getPriceTypes() {
		return priceTypes;
	}
	public void setPriceTypes(List<PriceTypeVo> priceTypes) {
		this.priceTypes = priceTypes;
	}
      
    
     
    
}
