package com.antiphon.xiaomai.apps.action.web.user;
  
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;  

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.user.Privilege;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
import com.antiphon.xiaomai.modules.service.user.PrivilegeService;
 
     

 

/**
 * 权限
 * sky
 */
@Controller
@RequestMapping(value = "/admin/ajax/privilege")
public class PrivilegeAjaxController {
	private final static String BASE_PATH = "user/";
	@Autowired
	 MemberManager accountService; 
 
       @Autowired private PrivilegeService privilegeManager;
 
	 
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	

	@RequestMapping(value = "toList")
	public String deptouserList( Long parent ,@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
	  
		PageView<Privilege> pageView = new PageView<Privilege>(Maxresult.MAX10,page);
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("visible", MatchType.EQ, 1));  
		if(parent!=null){
			filters.add(new PropertyFilter("parent.id", MatchType.EQ, parent));  
		}  
		 
		pageView.setQueryResult(this.privilegeManager.findPage(pageView, filters));
		request.setAttribute("pageView", pageView); 
		return BASE_PATH+"privilegeList";
	}
	
	@RequestMapping(value = "toPrivilegeEdit")
	public String roleUpdate( String action,Long privilegeId,HttpServletRequest request) {
	 
			
			 
			if( privilegeId!=null){
			 
				Privilege r=this.privilegeManager.find(privilegeId);
				
				if("save".equals(action)){
					request.setAttribute("parentid", r.getId());
					request.setAttribute("privilege_name", r.getName());
				}else{
					if(r.getParent()!=null){
				    	
						request.setAttribute("privilege_name", r.getParent().getName());
				    }
					request.setAttribute("privilege", r);
				}
			    
			    
			}
			
			request.setAttribute("action", action);
		 
		
		return BASE_PATH+"privilegeEdit";
	}
 
	 
  
}
