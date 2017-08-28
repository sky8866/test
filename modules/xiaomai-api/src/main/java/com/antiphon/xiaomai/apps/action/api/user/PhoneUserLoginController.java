package com.antiphon.xiaomai.apps.action.api.user;

  
 
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;   

 
 
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.apps.action.api.vo.user.UserInfoVo;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO; 
import com.antiphon.xiaomai.common.utils.user.TokenUtils;
import com.antiphon.xiaomai.modules.entity.user.Loginlog;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.service.user.LoginlogService;
import com.antiphon.xiaomai.modules.service.user.MemberManager; 
 
   


/**
 * 
 * 登录
 * @author sky
 * @version 1.0 2017-7-25
 */
@Controller
@RequestMapping(value = "/phone/login")
public class PhoneUserLoginController extends BaseController{

    @Autowired
     MemberManager accountService;  
		@Autowired LoginlogService loginlogService;  
        /**
		 * 登录
		 * @param user_phone
		 * @param response
		 * @param request
		 */
		@RequestMapping(value = "",method = RequestMethod.POST)
	    @ResponseBody
	    public BaseResponseDTO login(String mobile,String password,HttpServletResponse response,HttpServletRequest request) throws Exception{
	        
			 
	    	 

	    		 User user = this.accountService.validate(mobile, password);
	    		 
	    		 if(user==null){ 
	    			 return new BaseResponseDTO("0", "用户名或密码错误！");
	    		 }
	    		
	    		  setLoginlog(user);//取得令牌
	    		  UserInfoVo uvo=new UserInfoVo(user); 
	              return new BaseResponseDTO(JSONObject.fromObject(uvo));
	    	 
	    		 
			 
	    	
	     
	        
	         
	    }
		
		/**
		 * 更新令牌
		 * @param user
		 */
		
		public void setLoginlog(User user){
			 
			 Loginlog loginlog=this.loginlogService.findLoginlog("userId", user.getId());
   		  if(loginlog==null){
   			  loginlog=new Loginlog();
   			   
   		  }
   		      loginlog.setDate(new Date());
			  loginlog.setToken(TokenUtils.getToken(user.getId(), user.getMobile(), loginlog.getDate()));
			  loginlog.setUserId(user.getId());
			  if(loginlog.getId()!=null){
				  this.loginlogService.updateLoginlog(loginlog);
			  }else{
				  this.loginlogService.saveLoginlog(loginlog);
			  }
			  user.setToken(loginlog.getToken());
		}
	 
		 
}
