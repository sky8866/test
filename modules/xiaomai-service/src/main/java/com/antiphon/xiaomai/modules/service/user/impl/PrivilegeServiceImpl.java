package com.antiphon.xiaomai.modules.service.user.impl;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable; 
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.user.PrivilegeDao;
import com.antiphon.xiaomai.modules.dao.user.RoleDao;
import com.antiphon.xiaomai.modules.dao.user.RolePrivilegeDao;
import com.antiphon.xiaomai.modules.dao.user.UserDao;
import com.antiphon.xiaomai.modules.dao.user.UserRoleDao;
import com.antiphon.xiaomai.modules.entity.hotel.HotelOrder;
import com.antiphon.xiaomai.modules.entity.user.Privilege;
import com.antiphon.xiaomai.modules.entity.user.Role;
import com.antiphon.xiaomai.modules.entity.user.RolePrivilege;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.entity.user.UserRole;
import com.antiphon.xiaomai.modules.service.user.PrivilegeService;
 
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired private PrivilegeDao privilegeDao;
	@Autowired private RoleDao roleDao;
 
	@Autowired private UserRoleDao urDao;
	@Autowired private  UserDao userDao;
    @Autowired private RolePrivilegeDao rolePrivilegeDao;
	@Override
	public void saveRole(Role role){
		this.roleDao.save(role);
	}
 
	@Override
	public Role findRoles(Long userid){
		PageView<Role> pv =new PageView<Role>(1,1);
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
        filters.add(new PropertyFilter("userId", MatchType.EQ, userid));
		List<Role> r=this.roleDao.findPage(pv, filters).getResultlist();
		if(!r.isEmpty()){
			return r.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public List<Role> findRoleAll(){
		List<Role> roles=this.roleDao.findLists();
		return roles;
	}
	@Override
	public Role findRole(Long id){
		return this.roleDao.find(id);
	}
 
	
	
	public void savePrivilege(Privilege privilege){
		this.privilegeDao.save(privilege);
	}
	 
	@Override
	public void saveRoletoUser(UserRole pr){
		this.urDao.save(pr);
	}
	public List<Privilege> findPrivilegeAll(){
		String hql="from Privilege p where p.visible=1 and p.parent is null";
 
		return this.privilegeDao.findAllPage(hql);
	}
	
	public Privilege findPrivilege(String p,String v){
	    return this.privilegeDao.findProperty(p, v);
	}

	@Override
	public boolean exsitDepartment(String name) {
		// TODO Auto-generated method stub
		return this.privilegeDao.exsit(name);
	}
	
	@Override
	public boolean exsitRole(Long userid,String name) {
		// TODO Auto-generated method stub
		return this.roleDao.exsitRole(userid,name);
	}
	 @Cacheable(value="departCache") 
	 public QueryResult<Privilege> findPage(PageView<Privilege> pv,List<PropertyFilter> filters){
			return this.privilegeDao.findPage(pv, filters);
		}

	@Override
	public Privilege find(Long id) {
		// TODO Auto-generated method stub
		return this.privilegeDao.find(id);
	}
	
	   @Override
	    public Privilege find(Long id,Integer v) {
	       Object[] op=new Object[2];
	       op[0]="id";
	       op[1]="visible";
	       
	       
	       Object[] vo=new Object[2];
	       vo[0]=id;
	       vo[1]=v;
	       return  this.privilegeDao.findPropertys(op, vo);
	    }
	@Override
	public QueryResult<Role> findRolePage(PageView<Role> pv,
			List<PropertyFilter> filters) { 
		return this.roleDao.findPage(pv, filters);
	}
	@Override
	public void updateRole(Role role) {
		this.roleDao.update(role);
		
	}
	 
	
 
 
	@Override
	public void delUserRole(Serializable... entityids) {
		this.urDao.delete(entityids);
		
	}
	
	@Override
	public void delRole(Serializable... entityids){
		this.roleDao.delete(entityids);
	}
	@Override
	public void updatePrivilege(Privilege p) {
		this.privilegeDao.update(p);
		
	}
 

public List<RolePrivilege> findRP(Long id){
	List<RolePrivilege> rp=this.rolePrivilegeDao.findPropertyList("roleId", id);
	 
	return rp;
}
 

 
@Override
public void saveRoletoPrivilege(RolePrivilege rp) {
     this.rolePrivilegeDao.save(rp);
	
}

@Override
public void delRolePrivilege(Serializable... entityids) {
	this.rolePrivilegeDao.delete(entityids);
	
}

 
@Override
public Role queryRole(Long userId,Integer type) {
    Object[] op=new Object[2];
    op[0]="userId";
    op[1]="type";
    
    
    Object[] v=new Object[2];
    v[0]=userId;
    v[1]=type;
    return this.roleDao.findPropertys(op, v);
}

@Override
public List<Role> findGroups(String inset) {
    String hql="from Role a where a.id in("+inset+")";
    return this.roleDao.findAllPage(hql);
}

 
@Override
public boolean exsitUser(Long roleId, Long userId) {
  
    return this.urDao.exsitUser(roleId, userId);
}
 
@Override
public Role queryRole(Long userId,String p, String v) {
    
    Object[] op=new Object[2];
    op[0]="userId";
    op[1]=p;
    
    
    Object[] ov=new Object[2];
    ov[0]=userId;
    ov[1]=v;
    // TODO Auto-generated method stub
    return this.roleDao.findPropertys(op, ov);
}

@Override
public UserRole findUserRole(Long userid) {  
	return this.urDao.findProperty("userId", userid);
}

public UserRole findRoleUser(Long roleId){
	PageView<UserRole> pageView = new PageView<UserRole>();
	 
	List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
	filters.add(new PropertyFilter("roleIds", MatchType.LIKE, roleId+",")); 
	List<UserRole> urs=this.urDao.findPage(pageView, filters).getResultlist();
	if(!urs.isEmpty()) return urs.get(0);
	return null;
}

@Override
public List<Role> findByRoleToUser(Long userId) {
	List<Role> roles=findRoleAll();
 
	  UserRole urs=findUserRole(userId);
	   
      if(urs!=null){
   	   for(Role r:roles){
   		   String[] ss=urs.getRoleIds().split(",");
   		   
		   
		   for(String ur:ss){
			   String id=r.getId()+"";
			   if(id.equals(ur)){
				   r.setUserId(userId); 
			   }
			  
		   }
	   }
      }
	return roles;
}

@Override
public void updateUserRole(UserRole u) {
	 this.urDao.update(u);
	
}
 

 
}
