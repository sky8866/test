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
@RequestMapping(value = "/phone/retrieve")
public class PhoneUserPasswordController extends BaseController {
	 private static Log logger = LogFactory.getLog(PhoneUserPasswordController.class);
    @Autowired
     MemberManager accountService;   
	@Autowired LoginlogService loginlogService;  
    @Autowired VerificationcodeService verificationService;
 
		 
    
    @RequestMapping(value = "password",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO reg( HttpServletResponse response,HttpServletRequest request)  throws Exception{ 
      	  String mobile = request.getParameter("mobile");   
           String validate_code = request.getParameter("validate_code");
           String password = request.getParameter("password");
           logger.info("mobile--"+mobile+",validate_code-----"+validate_code); 
           if(code(mobile,validate_code)){
        	 
        	  return new BaseResponseDTO("0", "检验码输入错误！")   ;
           }
           
           User user=this.accountService.findUserByMobile(mobile);
           
            if(user==null){
            	 return new BaseResponseDTO("0", "此帐号不存在！")   ;
            }
          
            
           user.setPlainPassword(password);
           user.setMobile(mobile);
           user.setPwd(MD5Utils.getMD5Str(user.getPlainPassword()));
           setLoginlog(user);//取得令牌
           this.accountService.updateUser(user);
	         return new BaseResponseDTO("1","重设密码成功！");    
	      
      	 
    }
    
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
