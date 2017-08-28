 
package com.antiphon.xiaomai.common.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

 

/**
 * 添加说明 
 * @author sky
 * @version 1.0 2014-3-6
 */
public class JsonWriteUtils {
    
    public static void setJson(Object json,HttpServletResponse response){
        try{
            response.setContentType("text/json;charset=utf-8");
            byte[] jsonBytes = json.toString().getBytes("utf-8");

            response.setContentLength(jsonBytes.length);
            response.getOutputStream().write(jsonBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }catch (Exception ex) {
            // TODO: handle exception
        }finally{
            try {
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                 
            }
            
        }
       
    }
    
 

    
    public static void setObjectToJson(Object obj,HttpServletResponse response){
    	setJson(JSONObject.toJSON(obj), response);
    }
}
