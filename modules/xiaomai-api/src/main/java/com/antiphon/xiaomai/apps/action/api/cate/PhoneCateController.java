package com.antiphon.xiaomai.apps.action.api.cate;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody; 

import com.alibaba.fastjson.JSONArray; 
import com.alibaba.fastjson.JSONObject;
import com.antiphon.xiaomai.apps.action.api.dto.cate.ShopDto;
import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.apps.action.api.vo.cate.CateCouponsDetailsVo;
import com.antiphon.xiaomai.apps.action.api.vo.cate.CateCouponsVo;
import com.antiphon.xiaomai.apps.action.api.vo.cate.CateShopIndexVo; 
import com.antiphon.xiaomai.apps.action.api.vo.cate.CateShopVo;
import com.antiphon.xiaomai.apps.action.api.vo.cate.CategoryVo; 
import com.antiphon.xiaomai.apps.action.api.vo.cate.DishDetailsVo;
import com.antiphon.xiaomai.apps.action.api.vo.cate.DishVo;
import com.antiphon.xiaomai.apps.action.api.vo.cate.MemebershipCardVo;
import com.antiphon.xiaomai.apps.action.api.vo.cate.PayTypeVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.DistanceVo; 
import com.antiphon.xiaomai.apps.action.api.vo.hotel.DistrictVo;
import com.antiphon.xiaomai.apps.action.api.vo.hotel.PriceTypeVo; 
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.utils.DistanceUtils;
import com.antiphon.xiaomai.common.utils.JsonWriteUtils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType; 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.cate.CateComment;
import com.antiphon.xiaomai.modules.entity.cate.CateCoupons;
import com.antiphon.xiaomai.modules.entity.cate.CateOrder;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.cate.CateShopImg;
import com.antiphon.xiaomai.modules.entity.cate.Category; 
import com.antiphon.xiaomai.modules.entity.cate.Dish;
import com.antiphon.xiaomai.modules.entity.cate.DishImg;
import com.antiphon.xiaomai.modules.entity.cate.MemebershipCard;  
import com.antiphon.xiaomai.modules.entity.cate.PayBill;
import com.antiphon.xiaomai.modules.entity.city.District;
import com.antiphon.xiaomai.modules.entity.comment.Comment;
import com.antiphon.xiaomai.modules.service.cate.CateCommentService;
import com.antiphon.xiaomai.modules.service.cate.CateCouponsService;
import com.antiphon.xiaomai.modules.service.cate.CateOrderService;
import com.antiphon.xiaomai.modules.service.cate.CateShopImgService;
import com.antiphon.xiaomai.modules.service.cate.CateShopService;
import com.antiphon.xiaomai.modules.service.cate.CategoryService;  
import com.antiphon.xiaomai.modules.service.cate.DishImgService;
import com.antiphon.xiaomai.modules.service.cate.DishService;
import com.antiphon.xiaomai.modules.service.cate.MemebershipCardService; 
import com.antiphon.xiaomai.modules.service.cate.PayBillService;
import com.antiphon.xiaomai.modules.service.city.DistrictService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;

@Controller
@RequestMapping(value = "/termial/cate")
public class PhoneCateController extends BaseController {
 
	@Autowired private CategoryService coategoryService;
	@Autowired private  CateShopImgService shopImgService;
	@Autowired private ImgsService imgsService;
	@Autowired private CateShopService shopService;
	@Autowired private DishService dishService;
    @Autowired private DishImgService dishImgService;
    @Autowired private CateCouponsService couponsService;
    @Autowired private MemebershipCardService cardService;
    @Autowired private CateOrderService cateOrderService;
    @Autowired private DistrictService districtService;
     
    @Autowired private PayBillService payBillService;
	/**
	 * 获取菜品
	 */
	@RequestMapping(value = "gory",method = RequestMethod.POST)
    @ResponseBody
    public void gory(HttpServletResponse response,HttpServletRequest request) throws Exception{
        
             List<Category> gorys=this.coategoryService.findCategorys();
                 List<CategoryVo> cvo=new ArrayList<CategoryVo>();
               for(Category c:gorys){
            	   CategoryVo vo=new CategoryVo(c);
            	   cvo.add(vo);
               }
    		  BaseResponseDTO rdto=new BaseResponseDTO(cvo);
    		  JsonWriteUtils.setObjectToJson(rdto, response);   
    		 
         
    }
	
	

	/**
	 * 获取商家
	 */
	@RequestMapping(value = "shop",method = RequestMethod.POST)
    @ResponseBody
    public void shop(@Valid ShopDto shop,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		PageView<CateShop> pageView = new PageView<CateShop>(shop.getPageSize(),shop.getPageNo());
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		
		setQuery(shop, pageView, filters);
		List<CateShop> shops=this.shopService.findPage(pageView, filters).getResultlist();
	//	JSONObject json=new JSONObject();    //(JSONObject) JSONObject.toJSON(shop);
 
		 JSONArray array=new JSONArray();
		for(CateShop s:shops){
		/*	 CateShopImg shopImg=this.shopImgService.findCateShopImg("shopId",s.getId());
			 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
				 s.setShopImgs(imgsService.findImgsList(shopImg.getImgId())); 
			 }*/
			CateShopIndexVo vo=new CateShopIndexVo(s);
			array.add(vo);
		}
		//json.put("shops", array);
    	 BaseResponseDTO rdto=new BaseResponseDTO(array);
    	 JsonWriteUtils.setObjectToJson(rdto, response);     
    		 
         
    }
	
	
	/**
	 * 获取商家
	 */
	@RequestMapping(value = "shop/details",method = RequestMethod.POST)
    @ResponseBody
    public void shopdetails(Long shopId,HttpServletResponse response,HttpServletRequest request) throws Exception{
	       
	 
		CateShop cateShop=this.shopService.findCateShop(shopId);
		CateShopImg shopImg=this.shopImgService.findCateShopImg("shopId",cateShop.getId());
		 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
			 cateShop.setShopImgs(imgsService.findImgsList(shopImg.getImgId())); 
		 }
		 CateCoupons coupons=this.couponsService.findCateCoupons("shopId", cateShop.getId());
		 PayBill payBill=this.payBillService.findPayBill("shopId", cateShop.getId());
		 PayTypeVo pay=new PayTypeVo(coupons,payBill);
		CateShopVo vo=new CateShopVo(cateShop,pay);
		
    	 BaseResponseDTO rdto=new BaseResponseDTO(vo);
    	 JsonWriteUtils.setObjectToJson(rdto, response);    
    		 
         
    }
	
	
	
	
	
	
	
	
	
	/**
	 * 获取招牌菜
	 */
	@RequestMapping(value = "dish",method = RequestMethod.POST)
    @ResponseBody
    public void dish(Long shopId,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		PageView<Dish> pageView = new PageView<Dish>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("cateShopId", MatchType.EQ, shopId));
		//setQuery(shop, pageView, filters);
		List<Dish> shops=this.dishService.findPage(pageView, filters).getResultlist();
		 JSONArray array=new JSONArray();
		 for(Dish d:shops){
	    	 DishImg shopImg=this.dishImgService.findDishImg("dishId",d.getId());
			 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
				 d.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
			 }
			DishVo vo=new DishVo(d);
			array.add(vo);
	     }
		 
    	 BaseResponseDTO rdto=new BaseResponseDTO(array);
    		     
    	 JsonWriteUtils.setObjectToJson(rdto, response);
         
    }
	
	
	
	/**
	 * 获取招牌菜
	 */
	@RequestMapping(value = "dish/details",method = RequestMethod.POST)
    @ResponseBody
    public void details(Long dishId,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		 Dish d=this.dishService.findDish(dishId);
		 
		 DishImg shopImg=this.dishImgService.findDishImg("dishId",d.getId());
		 if(shopImg!=null&&StringUtils.isNotEmpty(shopImg.getImgId())){
			 d.setImgs(imgsService.findImgsList(shopImg.getImgId())); 
		 }
		 DishDetailsVo vo=new DishDetailsVo(d);
  
         JsonWriteUtils.setObjectToJson(new BaseResponseDTO(vo), response);
    }
	
	
	
	/**
	 * 获取查询条件
	 */
	@RequestMapping(value = "query",method = RequestMethod.POST)
    @ResponseBody
    public void hotelQuery( String city,HttpServletResponse response)throws Exception{
		 
    		    
    		     JSONObject json=new JSONObject();
    		     List<Category> gorys=this.coategoryService.findCategorys();
    		      List<String> gory=new ArrayList<String>();
    		      gory.add("全部");
    		      for(Category c:gorys){
               	    
    		    	  gory.add(c.getName());
                  }
    		     json.put("gory", gory);
    		   List<DistanceVo> distances=new ArrayList<DistanceVo>();
    		 	   distances.add(new DistanceVo("0", "不限"));
    		 	  distances.add(new DistanceVo("1", "1km"));
    		 	 distances.add(new DistanceVo("3", "3km"));
    		 	distances.add(new DistanceVo("5", "5km"));
    		 	distances.add(new DistanceVo("10", "10km"));
    		 	json.put("distances", distances);
    		 	List<DistrictVo> districts=new ArrayList<DistrictVo>();
  		 	  List<District> districe=this.districtService.findDistricts("citycode", city);
  		 	  for(District d:districe){
  		 		 DistrictVo vo=new DistrictVo(d);
		 		  districts.add(vo);
  		 		 
  		 	  }
  		 	    json.put("districts", districts);
    		 	 
  		 	    List<PriceTypeVo>  priceTypes=new ArrayList<PriceTypeVo>();
  		 	    
  		 	 priceTypes.add(new PriceTypeVo("1", "价格从高到低"));
  	    	priceTypes.add(new PriceTypeVo("0", "价格从底到高"));
  	    	 json.put("priceType", priceTypes);	
  	    	 
  	    	List<String> payType=new ArrayList<String>();
  	    	payType.add("代金券");
  	    	payType.add("现场支付");
  	    	payType.add("会员卡");
  	    	 json.put("payType", payType);	 
    		 	 BaseResponseDTO rdto=new BaseResponseDTO(json);
    		 	 JsonWriteUtils.setObjectToJson(rdto, response);
         
    }
	
	/**
	 * 获取代金
	 */
	@RequestMapping(value = "coupons",method = RequestMethod.POST)
    @ResponseBody
    public void cateCoupons(Long shopId,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		PageView<CateCoupons> pageView = new PageView<CateCoupons>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("shopId", MatchType.EQ, shopId));
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));
		//setQuery(shop, pageView, filters);
		List<CateCoupons> shops=this.couponsService.findPage(pageView, filters).getResultlist();
		 JSONArray array=new JSONArray();
		 for(CateCoupons d:shops){
	    	 CateCouponsVo vo=new CateCouponsVo(d);
			 array.add(vo);
	     }
		 
    	 BaseResponseDTO rdto=new BaseResponseDTO(array);
    		     
    	 JsonWriteUtils.setObjectToJson(rdto, response);
         
    }
	
	/**
	 * 获取代金详情
	 */
	@RequestMapping(value = "coupons/details",method = RequestMethod.POST)
    @ResponseBody
    public void couponsdetails(Long couponsId,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 
		
		CateCoupons coupons=this.couponsService.findCateCoupons(couponsId);
		 
		 CateCouponsDetailsVo vo=new CateCouponsDetailsVo(coupons);
 
    		      
    		  JsonWriteUtils.setObjectToJson(new BaseResponseDTO(vo), response); 
    }
	
	
	/**
	 * 获取会员卡
	 */
	@RequestMapping(value = "membership",method = RequestMethod.POST)
    @ResponseBody
    public void membership(Long shopId,HttpServletResponse response,HttpServletRequest request) throws Exception{
	 
		 
		
		PageView<MemebershipCard> pageView = new PageView<MemebershipCard>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("shopId", MatchType.EQ, shopId));
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));
		//setQuery(shop, pageView, filters);
		List<MemebershipCard> shops=this.cardService.findPage(pageView, filters).getResultlist();
		 JSONArray array=new JSONArray();
		 for(MemebershipCard d:shops){
			 MemebershipCardVo vo=new MemebershipCardVo(d);
			 array.add(vo);
	     }
		 
    	 BaseResponseDTO rdto=new BaseResponseDTO(array);
    		     
    	 JsonWriteUtils.setObjectToJson(rdto, response);
         
    }
	
	
 
	
 
	
	
	/**
	 * 获取订单
	 */
	@RequestMapping(value = "order",method = RequestMethod.POST)
    @ResponseBody
    public void order(@Valid CateOrder order,HttpServletResponse response) throws Exception{
		
	      this.cateOrderService.saveCateOrder(order);
		 JSONObject json=new JSONObject();
		 json.put("orderId", order.getId()+"");
    	  BaseResponseDTO rdto=new BaseResponseDTO(json);
    	  JsonWriteUtils.setObjectToJson(rdto, response);     
    		 
         
    }
	 
	
	
	/**
	 * 查询商店条件
	 * @param shop
	 * @param pageView
	 * @param filters
	 */
	private void setQuery(ShopDto shop,PageView<CateShop> pageView,List<PropertyFilter> filters){
		if(StringUtils.isNotEmpty(shop.getPriceType())){
			if("1".equals(shop.getPriceType())){
				pageView.setOrderby("consumption", "desc");	
			}else{
				pageView.setOrderby("consumption", "asc");	
			}
			
		}else{
			pageView.setOrderby("consumption", "asc");
		}
		
		
		 
		 
		if(StringUtils.isNotEmpty(shop.getCity())){
			filters.add(new PropertyFilter("city", MatchType.LIKE, shop.getCity()));
		}
		if(StringUtils.isNotEmpty(shop.getDistrict())){
			filters.add(new PropertyFilter("district", MatchType.EQ, shop.getDistrict()));
		}
		if(StringUtils.isNotEmpty(shop.getGory())){
			filters.add(new PropertyFilter("gory", MatchType.EQ, shop.getGory()));
		}
		 
		
		if(StringUtils.isNotEmpty(shop.getArea())){
			filters.add(new PropertyFilter("area", MatchType.LIKE, shop.getArea()));
		}
		 
		if(shop.getDistance()>0&&StringUtils.isNotEmpty(shop.getLongitude())&&StringUtils.isNotEmpty(shop.getLatitude())){
	    
			Map<String, String> map=DistanceUtils.queryLocation(Double.parseDouble(shop.getLongitude()), Double.parseDouble(shop.getLatitude()), shop.getDistance());
		    
			filters.add(new PropertyFilter("latitude", MatchType.GE, map.get("right-bottom_lat")));	
			filters.add(new PropertyFilter("latitude", MatchType.LE, map.get("left-top_lat")));	
			filters.add(new PropertyFilter("longitude", MatchType.GE, map.get("left-top_lng")));	
			filters.add(new PropertyFilter("longitude", MatchType.LE, map.get("right-bottom_lng")));	
			
		}
	}
 
}
