package com.antiphon.xiaomai.apps.action.web.user;

 

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/user")
public class UserAjaxUserController {
	  
	private final static String BASE_PATH = "user/"; 
	@Autowired private MemberManager memberManager; 
	@RequestMapping(value = "list")
	
	public String word(String query,String starttime,String endtime,@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
	 
			
			PageView<User> pageView = new PageView<User>(Maxresult.MAX10,page);
			 
			 
			pageView.setQueryResult(this.memberManager.findPageUser(pageView, query, starttime, endtime));
		 
			request.setAttribute("pageView", pageView); 
	
		 
		return BASE_PATH+"userList";
	}
	
 
    @RequestMapping(value = "inputForm",method =RequestMethod.POST)
    @ResponseBody
    public String update(Long id,String name,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
	    		User user=this.memberManager.findUser(id);
	    		 
	    		user.setName(name);
	    		 
	    		this.memberManager.updateUser(user);
	    		
	    		return  "true";
	    	}catch (Exception e) {
				return "false";
			}
     
  
  }
}


