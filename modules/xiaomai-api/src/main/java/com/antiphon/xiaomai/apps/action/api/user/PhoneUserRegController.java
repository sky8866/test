package com.antiphon.xiaomai.apps.action.api.user;

  
 
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;   
 
  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO; 
import com.antiphon.xiaomai.common.utils.MD5Utils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.UUID; 
import com.antiphon.xiaomai.common.utils.user.TokenUtils;
import com.antiphon.xiaomai.modules.entity.user.Loginlog;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.entity.user.Verificationcode;
import com.antiphon.xiaomai.modules.service.user.LoginlogService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
import com.antiphon.xiaomai.modules.service.user.VerificationcodeService;

 
   


/**
 * 
 * 注册
 * @author sky
 * @version 1.0 2017-7-24
 */
@Controller
@RequestMapping(value = "/phone/reg")
public class PhoneUserRegController extends BaseController {
	 private static Log logger = LogFactory.getLog(PhoneUserRegController.class);
    @Autowired
     MemberManager accountService;   
    
    @Autowired VerificationcodeService verificationService;
    @Autowired LoginlogService loginService;
		/**
		 * 发送检验码
		 * @param user_phone
		 * @param response
		 * @param request
		 */
		@RequestMapping(value = "coder",method = RequestMethod.POST)
	    @ResponseBody
	    public BaseResponseDTO setCoder(String mobile,String type,HttpServletResponse response,HttpServletRequest request) throws Exception{
	        BaseResponseDTO base=new BaseResponseDTO();
	        
	    	 

		        String[] mobiles=new String[]{mobile};
	            String code="123456";    //UUID.getCode();
	                  
	               String msg=" 验证码为："+code+"(请在10分钟之内完成验证，如已成功启用，请忽略此短信！)";
	                //SmsUtils.sendSMS(mobiles, msg);
	                 
	                 JSONObject json_return_info = new JSONObject();
	               
	                 json_return_info.put("validate_code", this.verificationService.findVerificationcodeToMobile(mobile, code)); 
	                 base.setData(json_return_info);
	                 
	                  return  new BaseResponseDTO(code);
	    
	         
	    }
	 
		
		/**
		 * 注册
		 * @param groupName
		 * @param user
		 * @param session
		 * @param request
		 */
		
		    @RequestMapping(value = "save",method = RequestMethod.POST)
		    @ResponseBody
		    public BaseResponseDTO reg( HttpServletResponse response,HttpServletRequest request)  throws Exception{ 
		      	  String mobile = request.getParameter("mobile");  
		           String password = request.getParameter("password");
		           String validate_code = request.getParameter("validate_code");
		           
		           logger.info("mobile--"+mobile+",password----"+password+",validate_code-----"+validate_code); 
		           if(code(mobile,validate_code)){
		        	 
		        	  return new BaseResponseDTO("0", "检验码输入错误！")   ;
		           }
		           
		           if (this.accountService.findUserByMobile(mobile)!=null) {
		        	   
		        	   return new BaseResponseDTO("0", "手机号已经被注册，请换一个重试！")   ;
		        	   
		           }
		          
		           if(!StringUtils.isNotEmpty(mobile)&&!StringUtils.isNotEmpty(password)){
		        
		        	   return new BaseResponseDTO("0", "手机号与密码不能为空！")   ;    
		           }
		           
		           User user=new User();
		          
		           user.setName(UUID.getCode());
		           user.setPlainPassword(password);
		           user.setMobile(mobile);
		           user.setPwd(MD5Utils.getMD5Str(user.getPlainPassword()));
                   this.accountService.saveUser(user);
			         Loginlog loginlog=new Loginlog();
			         loginlog.setDate(new Date());
			         loginlog.setToken(TokenUtils.getToken(user.getId(), mobile, loginlog.getDate()));
			         loginlog.setUserId(user.getId());
			         this.loginService.saveLoginlog(loginlog);
			         return new BaseResponseDTO("1","注册成功！");    
			      
		      	 
		    }
	 
     public boolean code(String mobile,String validate_code){
    	 Verificationcode code=this.verificationService.findVerificationcode("mobile", mobile);
    	 if(code==null||!code.getCode().equals(validate_code)||(code.getCode().equals(validate_code)&&"2".equals(code.getState()))){
    		 return true;
    	 }
    	 if(!"1".equals(code.getType())){
    		code.setState("2");
    		this.verificationService.updateVerificationcode(code);
    	 }
    	 return false; 
     }
     
    
}
