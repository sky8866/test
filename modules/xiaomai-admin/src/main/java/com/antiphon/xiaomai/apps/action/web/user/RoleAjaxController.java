package com.antiphon.xiaomai.apps.action.web.user;
  
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.user.Role;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.entity.user.UserRole;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
import com.antiphon.xiaomai.modules.service.user.PrivilegeService;

      

 

/**
 * 修改个人资料
 * sky
 */
@Controller
@RequestMapping(value = "/admin/ajax/role")
public class RoleAjaxController {
	private final static String BASE_PATH = "user/";
	@Autowired
	 MemberManager accountService;
 
 
       @Autowired private PrivilegeService privilegeManager;
 
	 
	/** 
	 * @param id
	 * @param request
	 * @return
	 */
	

	@RequestMapping(value = "toList")
	public String deptouserList( @RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
		 
		PageView<Role> pageView = new PageView<Role>(Maxresult.MAX10,page);
		pageView.setOrderby("id", "asc");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		  
		 
		 
		 
		pageView.setQueryResult(this.privilegeManager.findRolePage(pageView, filters));
		request.setAttribute("pageView", pageView); 
		return BASE_PATH+"roleList";
		
		 
	}
	
	
 
	 
	
	
 
	
	@RequestMapping(value = "userToRoles")
	public String userToRoles(Long userid,HttpServletRequest request) { 
	   List<Role> roles=this.privilegeManager.findByRoleToUser(userid); 
	   
	   request.setAttribute("roles", roles);
	   request.setAttribute("userid", userid); 
		return BASE_PATH+"userToRoles";
	}
	
	
	
	/**
	 * 显示此角色下拥有的权限
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "roleToPrivilegeList")
	public String  privilegeList( Long roleId,HttpServletRequest request) {
	 request.setAttribute("privilegeList",this.privilegeManager.findPrivilegeAll() );
	 
	 request.setAttribute("rolePrivilege", this.privilegeManager.findRP(roleId));
	 request.setAttribute("roleid", roleId);
		return BASE_PATH+"roleToPrivilegeList";
	}
	
	
	
 
 
	@RequestMapping(value = "editRoleToPrivilege")
	public String  editRoleToPrivilege( Long roleid,HttpServletRequest request) {
	 request.setAttribute("privilegeList",this.privilegeManager.findPrivilegeAll() );
	 
	 request.setAttribute("rolePrivilege", this.privilegeManager.findRP(roleid));
	 
	 request.setAttribute("roleid", roleid);
		return BASE_PATH+"editRoleToPrivilege";
	}
  
}
