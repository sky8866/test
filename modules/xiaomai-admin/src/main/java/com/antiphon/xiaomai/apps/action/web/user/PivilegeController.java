package com.antiphon.xiaomai.apps.action.web.user;
 
 
  
import java.util.List;

import javax.servlet.http.HttpServletRequest;   
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import com.antiphon.xiaomai.modules.entity.user.Privilege;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
import com.antiphon.xiaomai.modules.service.user.PrivilegeService;
 
 

 

/**
 * 权限
 * sky
 */
@Controller
@RequestMapping(value = "/admin/privilege")
public class PivilegeController {
	private final static String BASE_PATH = "user/";
	@Autowired
	 MemberManager accountService;
	@Autowired
	private PrivilegeService privilegeManager; 
	
	private final static String URL="/admin/privilege";
	@RequestMapping(value = "")
	public String reg( @RequestParam(value = "parentId",required = false ) Long  parentId,HttpServletRequest request) {
	 
	 request.setAttribute("parentId", parentId);
	 request.setAttribute("user_active", "active");
	 request.setAttribute("privilege_active", "active");
		return BASE_PATH+"privilege";
	}
	
	
	@RequestMapping(value = "{id}")
	public String byId(@PathVariable("id") Long id, HttpServletRequest request) {
	 
		try{ 
			List<Privilege> deps = this.privilegeManager.findPrivilegeAll();
			   
		     
		 
			Privilege department=this.privilegeManager.find(id);
			
		    request.setAttribute("dep", department);
		    request.setAttribute("deps", deps);
		    request.setAttribute("privilege", "active");
			 
		}catch (Exception e) {
			 
			 
		}
		
		
		return BASE_PATH+"privilege";
	}
	
	
	@RequestMapping(value = "save")
	public String password(@Valid  Privilege privilege,Long parentid ,HttpServletRequest request) {
	  
		 
		    try{
		    	
		    	
		     
		 		if (!this.privilegeManager.exsitDepartment(privilege.getPrivilegevalue())) {
		 		    
			    	if(parentid!=null) privilege.setParent(new Privilege(parentid));
			    	this.privilegeManager.savePrivilege(privilege);
			    	request.getSession().setAttribute("message", "添加成功,重新登录后生效！");
		 		}else{
		 			request.getSession().setAttribute("message", "添加失败，权限已经存在");
		 		}
		    	
		    	 
		    }catch (Exception e) {
		    	e.printStackTrace();
		    	request.getSession().setAttribute("message", "添加失败");
			}
			
			 
		 
			 return "redirect:"+URL; 
		 
	}
	
	/**
	 * 删除部门
	 * @param id
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value = "del/{id}")
	public String byIdtoDel(@PathVariable("id") String id, HttpServletRequest request) {
	 
		try{ 
			 
			
			 
			 
		 
		 
			request.getSession().setAttribute("message", "删除成功");
		}catch (Exception e) {
			request.getSession().setAttribute("message", "删除失败"); 
			 
		}
		
		
		 return "redirect:"+URL;  
	}
	
	
	
	
	
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@Valid Privilege p,Long id, HttpServletRequest request,RedirectAttributes redirectAttributes){
	
	
		
		try {
			
			 p.setId(id);
		 this.privilegeManager.updatePrivilege(p);
			redirectAttributes.addFlashAttribute("message", "更改成功");
			
		} catch (Exception e) {
			 
			redirectAttributes.addFlashAttribute("message", "更改不成功");
		}
		 return "redirect:"+URL; 
	}

	 
	
	
}
