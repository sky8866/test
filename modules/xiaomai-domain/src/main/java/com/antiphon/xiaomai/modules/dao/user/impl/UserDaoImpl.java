package com.antiphon.xiaomai.modules.dao.user.impl;

 

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
 
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.UserDao;
import com.antiphon.xiaomai.modules.entity.user.User;


@Repository
public class UserDaoImpl extends HibernateDaoImpl<User> implements UserDao {

	 @Override
	    public User validate( String name, String password) {

	 

	        Query q = (Query) em
	                .createQuery("select u from User u where u.mobile=?1 and u.pwd=?2 ")
	                .setParameter(1, name).setParameter(2, password);
	        List list = q.getResultList();
	        if (!list.isEmpty()) {
	            return (User) list.get(0);
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public User validate( String name) {

	        String field = null;
	        /*
	         * if(VaildUtils.isVaildMobile(name)){ field=" u.mobile="; } else
	         * if(VaildUtils.isVaildMobile(name)){ field=" u.mobile="; } else{
	         * field=" u.groupAccount="; }
	         */
	        // select u Userfrom User u where"+field+"?1 and u.password=?2
	        Query q = (Query) em
	                .createQuery("select u from User u where u.mobile=?1 ")
	                .setParameter(1, name);
	        List list = q.getResultList();
	        if (!list.isEmpty()) {
	            return (User) list.get(0);
	        } else {
	            return null;
	        }
	    }

	    
	   
	    @Override
	    public User findUserByMobile(String mobile) {

	     
	        Query q = (Query) em.createQuery("select u from User u where u.mobile=?1 ").setParameter(1, mobile);
	        List list = q.getResultList();
	        if (!list.isEmpty()) {
	            return (User) list.get(0);
	        } else {
	            return null;
	        }
	    }
	    @Override
	    public boolean exsitMobile(String name, Long uid) {
	        try {
	            long count = (Long) em
	                    .createQuery("select count(o) from User o where o.mobile=?1 and o.id!=?2 ")
	                    .setParameter(1, name).setParameter(2, uid).getSingleResult();

	            return count > 0;
	        } catch (Exception e) {
	            return false;
	        }

	    }
	    
	   
	    @Override
	    public boolean exsitTokenid(String token_id) {
	        try {
	            long count = (Long) em.createQuery("select count(o) from Loginlog o where o.token=?1")
	                    .setParameter(1, token_id).getSingleResult();

	            return count > 0;
	        } catch (Exception e) {
	            return false;
	        }

	    }

	    @Override
	    public boolean exsitMobile(String name) {
	        long count = 0;
	        try {
	            count = (Long) em.createQuery("select count(o) from User o where o.mobile=?1")
	                    .setParameter(1, name).getSingleResult();

	            return count > 0;
	        } catch (Exception e) {

	        }
	        return false;
	    }

	    public void disableToUser(Integer visible, Long[] userids) {
	        StringBuffer sb = new StringBuffer();
	        for (Long s : userids) {
	            sb.append(s);
	            sb.append(",");
	        }
	        if (sb.length() > 1) {
	            sb.deleteCharAt(sb.length() - 1);
	            String hql = "update User u set u.visible=" + visible + " where  u.isAdmin!=0 and u.id in(" + sb.toString()
	                    + ")";

	            Query query = em.createQuery(hql);

	            query.executeUpdate();
	        }

	    }

	 

	    public void delToUser(Long[] userids) {
	        StringBuffer sb = new StringBuffer();
	        for (Long s : userids) {
	            sb.append(s);
	            sb.append(",");
	        }
	        if (sb.length() > 1) {
	            sb.deleteCharAt(sb.length() - 1);
	            String hql = "update User u set u.visible=2, u.mobile='', u.departmentId='' where  u.isAdmin!=0 and u.id in("
	                    + sb.toString() + ")";

	            Query query = em.createQuery(hql);

	            query.executeUpdate();

	        }

	    }

		@Override
		public void updatePhone(Long id,String phone) {
			String sql="update User u set u.mobile=? where id=?";
			Query query=this.em.createQuery(sql);
			query.setParameter(1,phone);
			query.setParameter(2,id);
			query.executeUpdate();
		}


}
