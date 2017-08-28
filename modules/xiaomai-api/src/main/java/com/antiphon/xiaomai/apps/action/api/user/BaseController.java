package com.antiphon.xiaomai.apps.action.api.user;

 
 
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.common.bean.BaseResponseDTO; 
import com.antiphon.xiaomai.common.utils.JsonWriteUtils;
 
 
public class BaseController {
	
	
	
	 @ExceptionHandler 
	 @ResponseBody
     public void exp(HttpServletRequest request,HttpServletResponse response, Exception ex) {  
              ex.printStackTrace(); 
              JsonWriteUtils.setObjectToJson(new BaseResponseDTO("0", "操作失败！"), response);
             return;  
           
     } 
	
	
	
	  
 
}
