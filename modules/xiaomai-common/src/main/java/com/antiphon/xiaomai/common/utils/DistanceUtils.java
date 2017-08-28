package com.antiphon.xiaomai.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 

public class DistanceUtils {
	 private static Log logger = LogFactory.getLog(DistanceUtils.class);
	/**
	 * 默认地球半径
	 */
	private static double EARTH_RADIUS = 6371;
	 
	

	 //地球平均半径  
   private static final double EARTH_RADIUSS = 6371004;  
   //把经纬度转为度（°）  
   private static double rad(double d){  
      return d * Math.PI / 180.0;  
   }  
   
	/**
	 * 计算经纬度点对应正方形4个点的坐标
	 *
	 * @param longitude
	 * @param latitude
	 * @param distance
	 * @return
	 */
	public static Map<String, double[]> returnLLSquarePoint(double longitude,
	        double latitude, double distance) {
	    Map<String, double[]> squareMap = new HashMap<String, double[]>();
	    // 计算经度弧度,从弧度转换为角度
	    double dLongitude = 2 * (Math.asin(Math.sin(distance
	            / (2 * EARTH_RADIUS))
	            / Math.cos(Math.toRadians(latitude))));
	    dLongitude = Math.toDegrees(dLongitude);
	    // 计算纬度角度
	    double dLatitude = distance / EARTH_RADIUS;
	    dLatitude = Math.toDegrees(dLatitude);
	    // 正方形
	    double[] leftTopPoint = { latitude + dLatitude, longitude - dLongitude };
	    double[] rightTopPoint = { latitude + dLatitude, longitude + dLongitude };
	    double[] leftBottomPoint = { latitude - dLatitude,
	            longitude - dLongitude };
	    double[] rightBottomPoint = { latitude - dLatitude,
	            longitude + dLongitude };
	    logger.info("leftTopPoint------lat:"+leftTopPoint[0]+",lang:"+leftTopPoint[1]);
	    logger.info("rightTopPoint------lat:"+rightTopPoint[0]+",lang:"+rightTopPoint[1]);
	    logger.info("leftBottomPoint------lat:"+leftBottomPoint[0]+",lang:"+leftBottomPoint[1]);
	    logger.info("rightBottomPoint------lat:"+rightBottomPoint[0]+",lang:"+rightBottomPoint[1]);
	    squareMap.put("leftTopPoint", leftTopPoint);
	    squareMap.put("rightTopPoint", rightTopPoint);
	    squareMap.put("leftBottomPoint", leftBottomPoint);
	    squareMap.put("rightBottomPoint", rightBottomPoint);
	    return squareMap;
	}
	/**
	 * 
	 * 查询数据库的条件
	 * @param longitude
	 * @param latitude
	 * @param distance
	 * @return
	 */
	
	 public static Map<String, String> queryLocation(double longitude, double latitude, double distance){
         Map<String, double[]> returnLLSquarePoint=returnLLSquarePoint(longitude, latitude, distance); 
		 Map<String, String> location=new HashMap<String, String>();
		 location.put("right-bottom_lat", returnLLSquarePoint.get("rightBottomPoint")[0]+"");
		 location.put("left-top_lat", returnLLSquarePoint.get("leftTopPoint")[0]+"");
		 location.put("left-top_lng", returnLLSquarePoint.get("leftTopPoint")[1]+"");
		 location.put("right-bottom_lng", returnLLSquarePoint.get("rightBottomPoint")[1]+"");
		 return location;
	 }
	
	 
	 
	    /**  
	     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米  
	     * @param lng1  
	     * @param lat1  
	     * @param lng2  
	     * @param lat2  
	     * @return  
	     */  
	    public static double getDistance(double lng1, double lat1, double lng2, double lat2){
	       double radLat1 = rad(lat1);  
	       double radLat2 = rad(lat2);  
	       double a = radLat1 - radLat2;  
	       double b = rad(lng1) - rad(lng2);  
	       double s = 2 * Math.asin(  
	            Math.sqrt(  
	                Math.pow(Math.sin(a/2),2)   
	                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)  
	            )  
	        );  
	       s = s * EARTH_RADIUSS;  
	       s = Math.round(s * 10000) / 10000;  
	       return s;  
	    }  
 
}
