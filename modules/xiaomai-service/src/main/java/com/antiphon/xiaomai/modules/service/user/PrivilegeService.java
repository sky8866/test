package com.antiphon.xiaomai.modules.service.user;

import java.io.Serializable; 
import java.util.List; 
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.entity.user.Privilege;
import com.antiphon.xiaomai.modules.entity.user.Role;
import com.antiphon.xiaomai.modules.entity.user.RolePrivilege;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.entity.user.UserRole;
 

public interface PrivilegeService {
	public void savePrivilege(Privilege privilege);
	public List<Privilege> findPrivilegeAll();
	boolean exsitDepartment(String name);
	public QueryResult<Privilege> findPage(PageView<Privilege> pv,List<PropertyFilter> filters);
	public QueryResult<Role> findRolePage(PageView<Role> pv,List<PropertyFilter> filters);
	public Privilege find(Long id);
	public void saveRole(Role role);
	public void updateRole(Role role);
	public Privilege findPrivilege(String p,String v);
	public List<Role> findRoleAll();
	public List<Role> findByRoleToUser(Long userId);
 
	public boolean exsitRole(Long userid,String name);
	public Role findRole(Long id);
	public Role findRoles(Long userid);
	public Role queryRole(Long userid,Integer type);
	public Role queryRole(Long userid,String p,String v);
	public void saveRoletoUser(UserRole pr);
	 
	
	public UserRole findUserRole(Long userid);
	
	public void delUserRole(Serializable... entityids);
	public void delRole(Serializable... entityids);
	public void updatePrivilege(Privilege p);
	 
	
	public List<RolePrivilege> findRP(Long id);
	
   public void saveRoletoPrivilege(RolePrivilege rp);
 
   public UserRole findRoleUser(Long roleId);
   //删除角色与权限的关联ID
   public void delRolePrivilege(Serializable... entityids);
   
   public void updateUserRole(UserRole u);
  
 
/**
 * @param inset
 * @return
 */
List<Role> findGroups(String inset);
   
public  boolean exsitUser(Long roleId,Long userId);
public Privilege find(Long id, Integer v);
   
};
