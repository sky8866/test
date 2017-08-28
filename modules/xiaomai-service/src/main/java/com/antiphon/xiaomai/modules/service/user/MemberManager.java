package com.antiphon.xiaomai.modules.service.user;




  
import java.io.Serializable;  
import java.util.ArrayList; 
import java.util.List; 

import org.apache.shiro.SecurityUtils; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.common.utils.MD5Utils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.security.Digests;
import com.antiphon.xiaomai.common.web.Encodes;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.user.UserDao;
import com.antiphon.xiaomai.modules.entity.user.User; 
import com.antiphon.xiaomai.modules.service.user.ShiroWebRealm.ShiroUser;
 
     
 




/**
 * 创建用户等相关操作
 * @author sky
 *
 */
@Service
public class MemberManager {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	 
 
	 
	
	@Autowired 
	private  UserDao userDao; 
 
	public void delUser(Serializable... entityids){
		this.userDao.delete(entityids);
	}
	/**
	 * 用户登录
	 */
	
	public User validate(String name, String password){

		return this.userDao.validate(name, MD5Utils.getMD5Str(password));
	}
 
	
	public User validate(String name){

		return this.userDao.validate(name);
	}
 

	public Boolean isPwd(String pwd){
		boolean flag = false;
		 
		
		 User user = findUser(getUserId());
		
		byte[] hashPassword = Digests.sha1(pwd.getBytes(),Encodes.decodeHex(user.getSalt()), HASH_INTERATIONS);
		String password=Encodes.encodeHex(hashPassword);
	
	 
	    if(user.getPassword().equals(password)){
	    	flag=true;
	    }
		
		return flag;
	}
	
 
	/**
	 * 判断邮箱是否存在
	 */
	public boolean checkEmailorMobile(String property,String name){
		return this.userDao.exsit(property, name);
	}
	
	/**
	 * 判断邮箱是否存在
	 */
	public boolean checkMobile(String name,Long uid){
		return this.userDao.exsitMobile(name,uid);
	}
	
	
	 
	public boolean checkMobile(String name){
		return this.userDao.exsitMobile(name);
	}
	 
	/**
	 * 根据登录名字查询用户
	 * @param name
	 * @return
	 */
	 
	@Cacheable(value="departCache") 
    public User findUserByMobile(String mobile){
        return this.userDao.findUserByMobile(mobile);
    }
	
	public QueryResult<User> findPageUser(PageView<User> pv,List<PropertyFilter> filters ){
		return this.userDao.findPage(pv, filters);
	}
	 @Cacheable(value="departCache") 
		public QueryResult<User> findPageUser(PageView<User> pv,String query,String starttime,String endtime){
		 
		 StringBuffer hql = new StringBuffer("");
		 hql.append("1=1  ");
		 List<Object> queryParams = new ArrayList<Object>();
		 
        if(StringUtils.isNotEmpty(query)){
			 
        	hql.append(" and ( o.name like ?").append(queryParams.size()+1);
        	queryParams.add("%"+query+ "%");
        	hql.append(" or o.mobile like ?").append(queryParams.size()+1);
        	queryParams.add("%"+query+ "%");
        	  
        	hql.append(" )");
        	
		 }
        String start="";
        String end=""; 
        if (!StringUtils.isNotEmpty(starttime)) {
            start = "2014-01-01";
        }else{
            start=starttime+" 00:00:00";
        }
        if (!StringUtils.isNotEmpty(endtime)) {
            end = "2100-12-31";
        }else{
            end = endtime+" 23:59:59"; 
        }
        String  date=" and o.createTime between '"+start+"' and '"+end+"'";
        hql.append(date); 
        
			 return findPageUser(pv,hql.toString(),  queryParams.toArray());
		}
	 
	 
	 
	 @Cacheable(value="departCache") 
     public QueryResult<User> findPageUser(PageView<User> pv,String hql, Object[] queryParams){
         return this.userDao.findPage(pv,   hql, queryParams);
     }
	 
    public List<User> findList(){
    	return this.userDao.findLists();
    }
	
	@Cacheable(value="departCache") 
	public User findUserToken(String token,String value){
		return this.userDao.findProperty(token, value);
	}
	
	public User findUser(Object p,Object v){
		return this.userDao.findProperty(p, v);
	}
	public List<User> findUsers(Object p,Object v){
		return this.userDao.findPropertyList(p, v);
	}
	
	@Cacheable(value="departCache") 
	public User findUser(Long id){ 
		return this.userDao.find(id);
	}
	 
	 @Cacheable(value="departCache") 
		public List<User> findList(Object property,Object value){
		 Object[] op=new Object[2];
	       op[0]=property;
	       op[1]="visible";
	       
	       
	       Object[] vo=new Object[2];
	       vo[0]=value;
	       vo[1]=1;
			return this.userDao.findPropertyList(op, vo);
		}
	 
 
	  
		 
		 
	public void saveUser(User user){
		 
		entryptPassword(user);
		 
		this.userDao.save(user);
	}
	
	public void updateUser(User user){
		if (StringUtils.isNotEmpty(user.getPlainPassword())) {
			entryptPassword(user);
		}
		this.userDao.update(user);
	}
	
 
	
 
	
 
 
	/**
	 * 设定安全的密码
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	public Long getUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
	
	
	public User getUser(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.user;
	}
	 
public void disableToUser(Integer visible,Long[] userids){
	this.userDao.disableToUser(visible, userids);
}

public void delToUser(Long[] userids){
	this.userDao.delToUser(userids);
}

public boolean exsitTokenid(String token_id){
	return this.userDao.exsitTokenid(token_id);
}
 
 
 

 
  
 

}
