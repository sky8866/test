package com.antiphon.xiaomai.apps.action.web.user;
 
 
  
import java.util.List;

import javax.servlet.http.HttpServletRequest;   
import javax.validation.Valid;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody;
  
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.user.Role;
import com.antiphon.xiaomai.modules.entity.user.RolePrivilege; 
import com.antiphon.xiaomai.modules.entity.user.UserRole;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
import com.antiphon.xiaomai.modules.service.user.PrivilegeService;
  
 

/**
 *  权限组实现
 * sky
 */
@Controller
@RequestMapping(value = "/admin/role")
public class RoleController {
	private final static String BASE_PATH = "user/";
	
	private final static String URL="redirect:/admin/role";
	@Autowired
      MemberManager accountService;
	@Autowired
	private PrivilegeService privilegeManager;  
	   /**
	    * 跳转到权限组页面
	    * @param active
	    * @param request
	    * @return
	    */
	@RequestMapping(value = "")
	public String role( @RequestParam(value = "active", required = false) String active , HttpServletRequest request) {
		 request.setAttribute("user_active", "active");
		 request.setAttribute("role_active", "active");       
		if("roleUserlist".equals(active)){
	            	request.setAttribute("roleUserlist", "active");
	            }else{
	            	
	            	 request.setAttribute("roleGroup", "active");
	            }
	       	 request.setAttribute("role", "active"); 
		
		return BASE_PATH+"role";
	}
	
 /**
  * 跳转到权限组编辑
  * @param request
  * @return
  */
	@RequestMapping(value = "toroleEdit")
	public String rolesave(HttpServletRequest request) {
		request.setAttribute("user_active", "active");
		 request.setAttribute("role_active", "active");   
		request.setAttribute("privilegeList",this.privilegeManager.findPrivilegeAll() ); 
		return BASE_PATH+"roleEdit";
	}
	
	@RequestMapping(value = "toroleEdit/{roleid}")
	public String roleUpdate(@PathVariable("roleid") Long roleid,HttpServletRequest request) {
		request.setAttribute("privilegeList",this.privilegeManager.findPrivilegeAll() );
		 
		
		 if(roleid!=null){
			 Role role=this.privilegeManager.findRole(roleid);
			 request.setAttribute("role", role);
			 request.setAttribute("rolePrivilege", this.privilegeManager.findRP(role.getId()));
		 }
		 
		
		return BASE_PATH+"roleEdit";
	}
	
	
	
	
	
 
	
	@RequestMapping(value = "save")
	public String save(@Valid  Role role,HttpServletRequest request) {
  
		    try{
 
		 		if (!this.privilegeManager.exsitRole(this.accountService.getUserId(), role.getRolename())) {
		 			 
                    role.setUserId(this.accountService.getUserId());
                   
			    	this.privilegeManager.saveRole(role);
			    	request.getSession().setAttribute("message", "操作成功");
		 		}else{
		 			request.getSession().setAttribute("message", "数据已经存在");
		 		}
		    	
		    	 
		    }catch (Exception e) {
		    	 
		    	request.getSession().setAttribute("message", "操作失败");
			}
			
			
			 return URL; 
		 
	}
	
	
	
	
	@RequestMapping(value = "update")
	public String update(@Valid Role role,Long aesid,HttpServletRequest request) {
	  
		 
		    try{
		            if(aesid!=null){
		            	role.setId(aesid);
		            		
		            	
		            	 this.privilegeManager.updateRole(role);
		                    request.getSession().setAttribute("message", "操作成功");  
		            }
		            
		    	 
		    }catch (Exception e) {
		    	request.getSession().setAttribute("message", "操作失败");
			}
			 
			 return URL; 
		 
	}
	
 
	
	
	@RequestMapping(value = "del")
	@ResponseBody
	public String del(  Long id,HttpServletRequest request) {
	  
		 
		    try{
		        
		        
		        
		     UserRole ur=this.privilegeManager.findRoleUser(id);
		     if(ur!=null){
		    	 String st[]=ur.getRoleIds().split(",");
		    	 StringBuffer sb=new StringBuffer();
		    	 
		    	 for(String s:st){
		    		 if(!id.equals(s)){
		    			 if(StringUtils.isNotEmpty(s)){
		    				 sb.append(s).append(",");
		    			 }
		    			 
		    		 }
		    	 }
		    	 if(sb.length()>1){
		    		 ur.setRoleIds(sb.toString());
		    		 this.privilegeManager.updateUserRole(ur);
		    	 }else{
		    		 this.privilegeManager.delUserRole(ur.getId()); 
		    	 }
		    	 
		     }
		       
		       
		             
                
                Long[] strRP=null;
                List<RolePrivilege> rps=this.privilegeManager.findRP(id);
                
                if(!rps.isEmpty()){
                    strRP=new Long[rps.size()];
                    for(int i=0;i<rps.size();i++){
                        strRP[i]=rps.get(i).getId();
                    }
                }
             
            if(strRP!=null){
                this.privilegeManager.delRolePrivilege(strRP);
            }  
               
                 
                      this.privilegeManager.delRole(id);
              
               
		        
	    	
		    	
                return "true"; 
		    	 
		    }catch (Exception e) {
		    	 
		    	 
		    	 return "false"; 
			}
			 
	}
	
 
	
	
 	@RequestMapping(value = "toAddPrivilege")
	public String toAddPrivilege(@Valid Role role, Long roleid,Long[] parents,HttpServletRequest request) {

 		
		    try{
		    	   
		    	   if(roleid!=null){
		    		   role.setId( roleid);
		    		   this.privilegeManager.updateRole(role);
		    	   }else{
		    		   role.setUserId(this.accountService.getUserId()); 
		    		   this.privilegeManager.saveRole(role);
		    	   }
		            
		    	   if(roleid!=null){
		    		   List<RolePrivilege> gps=this.privilegeManager.findRP(role.getId());
		                Long[] str=new Long[gps.size()];
		                for(int i=0;i<gps.size();i++){
		                    str[i]=gps.get(i).getId();
		                }
		                
		                if(str.length>0){
		                    this.privilegeManager.delRolePrivilege(str);
		                } 
		    	   }
		            
	                
	                 for(Long p:parents){
	                     RolePrivilege rp=new RolePrivilege();
	                        rp.setPrivilegeId(p);
	                        rp.setRoleId(role.getId());
	                        this.privilegeManager.saveRoletoPrivilege(rp);
	                     String childs[] = request.getParameterValues("parents_" + p);
	                        if (childs.length > 0) {
	                            for (String sid : childs) {
	                                RolePrivilege pr=new RolePrivilege();
	                                pr.setPrivilegeId(Long.parseLong(sid));
	                               
	                                pr.setRoleId(role.getId());
	                                this.privilegeManager.saveRoletoPrivilege(pr);
	                            }
	                        }
	                 }
	              
	                 request.getSession().setAttribute("message", "操作成功");
		        
		        
		         
		    }catch (Exception e) {
		    	request.getSession().setAttribute("message", "操作失败");
			}
			
		
		 
			 return URL; 
		 
	} 
 	
 	
 	@RequestMapping(value = "saveUserToRole")
	public String saveUserToRole(Long userid,Long[] roleid,String page,HttpServletRequest request) {
	    
		    try{
		     
		    	 StringBuffer sb=new StringBuffer();
            	 for(Long r:roleid){
            		 sb.append(r).append(",");	 
            	 }
            	 
		    	   UserRole ur=this.privilegeManager.findUserRole(userid);
		             if(ur==null){
		            	 ur=new UserRole();
		            	
		            	  ur.setRoleIds(sb.toString());
		            	 ur.setUserId(userid); 
	                      this.privilegeManager.saveRoletoUser(ur); 
		             }else{
		            	 ur.setRoleIds(sb.toString());
		            	 this.privilegeManager.updateUserRole(ur);
		             }
		         
		        	
		        	 
		         
		    	
	                
	                 request.getSession().setAttribute("message", 	"操作成功"); 
		    	 
		      
		    	 
		    }catch (Exception e) {
		       
		    	request.getSession().setAttribute("message","操作失败");
			}
			
		 
		 
			 return  "redirect:/admin/user?page="+page ; 
		 
	}
 	
 	
 	
 
	
 
	
}
