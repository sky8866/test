package com.antiphon.xiaomai.common.constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Constants  {
	
	/**
	 * 个性标签
	 */
	public final static Set<String> CUSTOM_LABELS = new HashSet<String>();
	
	/**
	 * 国际语言
	 */
	public final static  Set<String> GLANGUAGES =new HashSet<String>();
	
	/**
	 * 方言
	 */
	public final static  Set<String>  FLANGUAGES = new HashSet<String>();
	
	
	/**
	 * 排序
	 */
	public final static Map<String,String> PLAY_ORDER = new HashMap<String, String>();
	
	
	/**
	 * 玩法类型 1.一日游,2.经典路线,3.跟团游,4.特色游
	 */
	public final static Map<String,String> PLAY_TYPES = new HashMap<String, String>();
	
	/**
	 * 门票景点主题
	 */
	public final static Map<String,String> TICKET_TYPE = new HashMap<String, String>();
	
	public static final int AUDIT_STATUS_PASS = 1;
    public static final int AUDIT_STATUS_NOT_PASS = 2;
   
	
	
	 /**
		* 订单状态
		*/
	public final static  Map<Integer,String>  INDENT_STATUS = new HashMap<Integer,String>();
	/**
	 * app页大小5
	 */
	public static final int PAGE_SIZE_PHONE = 5;
	
	/**
	 * pc页大小
	 */
	public static final int PAGE_SIZE_PC = 10;
	
	
	/**
	 * 定制游订单标志
	 */
	public static final int INDENT_TYPE_CUSTOM = 1;
	
	/**
	 * 门票订单标志
	 */
	public static final int INDENT_TYPE_TICKET = 2;
	/**
	 * 美食订单标志
	 */
	public static final int INDENT_TYPE_CATE = 3;
	/**
	 * 酒店订单标志
	 */
	public static final int INDENT_TYPE_HOTEL = 4;
	

	/**
	 * 门票订单评论图片
	 */
	public static final String IMGS_INDENT = "indent";
	
	/**
	 * 约伴图片
	 */
	public static final String IMGS_BACKPACKING = "backpacking";
	
	
	/**
	 * 约伴--麦圈图片
	 */
	public static final String IMGS_BACKPACKING_CIRCLE = "backpackingCircle";
	
	
	/**
	 * 门票状态
	 */
	public final static  Map<Integer,String>  TICKET_STATUS = new HashMap<Integer,String>();
	
	
	/**
	 * 广告模块
	 */
	public final static  Map<Integer,String>  ADVERTISING_SORT = new HashMap<Integer,String>();
	
	/**
	 * 广告位置
	 */
	public final static  Map<Integer,String>  ADVERTISING_TYPE = new HashMap<Integer,String>();
	
	
	/**
	 * 提现状态
	 */
/*	public static final String WITHDRAWAL_STATUS = "indent";
	*/
	
	/**
	 * 约伴类型
	 */
	public final static  Map<Integer,String>  BACKPACKING_TYPE = new HashMap<Integer,String>();
	
	
    static {  
    	/*CUSTOM_LABELS.put("syk", "摄影控");  
    	CUSTOM_LABELS.put("xb", "学霸");  
    	CUSTOM_LABELS.put("jxydhs", "极限运动好手");  
    	CUSTOM_LABELS.put("mslr", "美食猎人");  
    	CUSTOM_LABELS.put("yyez", "越野e族");  
    	CUSTOM_LABELS.put("xjfw", "星级服务");  
    	CUSTOM_LABELS.put("tsns", "退税能手");  
    	CUSTOM_LABELS.put("dgyynlz", "多国语言能力者");  
    	CUSTOM_LABELS.put("lxdzs", "旅行定制师");  
    	CUSTOM_LABELS.put("hsds", "婚摄大师");  
    	CUSTOM_LABELS.put("qpdr", "球票达人");  
    	CUSTOM_LABELS.put("swjd", "商务接待");  */
    	
    	CUSTOM_LABELS.add("摄影控");  
    	CUSTOM_LABELS.add("学霸");  
    	CUSTOM_LABELS.add("极限运动好手");  
    	CUSTOM_LABELS.add("美食猎人");  
    	CUSTOM_LABELS.add("越野e族");  
    	CUSTOM_LABELS.add("星级服务");  
    	CUSTOM_LABELS.add("退税能手");  
    	CUSTOM_LABELS.add("多国语言能力者");  
    	CUSTOM_LABELS.add("旅行定制师");  
    	CUSTOM_LABELS.add("婚摄大师");  
    	CUSTOM_LABELS.add("球票达人");  
    	CUSTOM_LABELS.add("商务接待");  
    	
    /*	FLANGUAGES.put("pt", "普通话");
    	FLANGUAGES.put("sc", "四川话");
    	FLANGUAGES.put("kj", "客家话");
    	FLANGUAGES.put("yy", "粤语");
    	FLANGUAGES.put("db", "东北话");
    	FLANGUAGES.put("ml", "闽南话");*/
    	
    	FLANGUAGES.add("普通话");
    	FLANGUAGES.add("四川话");
    	FLANGUAGES.add("客家话");
    	FLANGUAGES.add("粤语");
    	FLANGUAGES.add("东北话");
    	FLANGUAGES.add("闽南话");
    	
    	/*GLANGUAGES.put("english", "英语");
    	GLANGUAGES.put("french", "法语");
    	GLANGUAGES.put("korean", "韩语");
    	GLANGUAGES.put("japanese", "日语");
    	GLANGUAGES.put("german", "德语");
    	GLANGUAGES.put("russian", "俄语");
    	GLANGUAGES.put("portugal", "葡萄牙语");
    	GLANGUAGES.put("spain", "西班牙语");*/
    	
    	GLANGUAGES.add("英语");
    	GLANGUAGES.add("法语");
    	GLANGUAGES.add("韩语");
    	GLANGUAGES.add("日语");
    	GLANGUAGES.add("德语");
    	GLANGUAGES.add("俄语");
    	GLANGUAGES.add("葡萄牙语");
    	GLANGUAGES.add("西班牙语");
    	
    	
    	PLAY_TYPES.put("1", "一日游");
    	PLAY_TYPES.put("2", "经典路线");
    	PLAY_TYPES.put("3", "跟团游");
    	PLAY_TYPES.put("4", "特色游");
    	
    	
    	PLAY_ORDER.put("0", "综合排序");
    	PLAY_ORDER.put("1", "服务最佳");
    	PLAY_ORDER.put("2", "销量最佳");
    	PLAY_ORDER.put("3", "价格从高到低");
    	PLAY_ORDER.put("4", "价格从低到高");
    	
    	TICKET_TYPE.put("0", "名胜风光");
    	TICKET_TYPE.put("1", "赏花田园");
    	TICKET_TYPE.put("2", "温泉");
    	TICKET_TYPE.put("3", "古镇园林");
    	TICKET_TYPE.put("4", "主题乐园");
    	TICKET_TYPE.put("5", "城市观光");
    	TICKET_TYPE.put("6", "文化古迹");
    	TICKET_TYPE.put("7", "展馆");
    	TICKET_TYPE.put("8", "水上玩乐");
    	TICKET_TYPE.put("9", "海洋馆");
    	TICKET_TYPE.put("10", "动物园");
    	
    	INDENT_STATUS.put(1, "已完成");
    	INDENT_STATUS.put(2, "未使用");
    	INDENT_STATUS.put(3, "待付款");
    	INDENT_STATUS.put(4, "未付款");
    	INDENT_STATUS.put(5, "已取消");
    	INDENT_STATUS.put(6, "已退款");
    	
    	
    	TICKET_STATUS.put(1, "已上线");
    	TICKET_STATUS.put(2, "审核中");
    	TICKET_STATUS.put(3, "已下线");
    	
    	
    	ADVERTISING_TYPE.put(1,"广告一号位");
    	ADVERTISING_TYPE.put(2,"广告二号位");
    	ADVERTISING_TYPE.put(3,"广告三号位");
    	ADVERTISING_TYPE.put(4,"广告四号位");
    	
    	ADVERTISING_SORT.put(0, "首页");
    	ADVERTISING_SORT.put(1, "定制游");
    	ADVERTISING_SORT.put(2, "门票");
    	ADVERTISING_SORT.put(3, "美食");
    	ADVERTISING_SORT.put(4, "酒店");
    	
    	
    	
    	BACKPACKING_TYPE.put(1, "麦圈");
    	BACKPACKING_TYPE.put(2, "旅行");
    	BACKPACKING_TYPE.put(3, "电影");
    	BACKPACKING_TYPE.put(4, "吃饭");
    	BACKPACKING_TYPE.put(5, "K歌");
    	BACKPACKING_TYPE.put(6, "运动");
    	BACKPACKING_TYPE.put(7, "逛街");
    	BACKPACKING_TYPE.put(8, "下午茶");
    } 
}
