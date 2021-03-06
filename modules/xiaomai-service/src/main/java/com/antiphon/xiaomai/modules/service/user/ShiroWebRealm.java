/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.antiphon.xiaomai.modules.service.user;

import java.io.Serializable;  

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken; 
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;   

import com.antiphon.xiaomai.common.web.Encodes;
import com.antiphon.xiaomai.modules.entity.user.User;

 
 

   


public class ShiroWebRealm extends AuthorizingRealm {
	 
	
	protected MemberManager memberManager;
	@Autowired
	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		 
		
	     User user = memberManager.validate( token.getUsername());
	     
		if (user != null) {
		 
			byte[] salt = Encodes.decodeHex(user.getSalt());
			return new SimpleAuthenticationInfo(new ShiroUser(user),
					user.getPassword(), ByteSource.Util.bytes(salt), getName());
			
		} else {
		     
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	     
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		 String loginname=shiroUser.loginname;
		
		
		 
		 
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		 
		 
	 
			//
			 
		 
		
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(MemberManager.HASH_ALGORITHM);
		matcher.setHashIterations(MemberManager.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}


	
	 

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public Long id;
		public String loginname;
		public String name;
	      
     
         
        public User user; 
		public ShiroUser(User user) {
			this.id = user.getId();
			this.loginname = user.getMobile();
			this.name = user.getName(); 
			 
			 this.user=user;
			 
			 
			
		}

		public String getName() {
			return name;
		}
		
	 
		
		
	 
		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginname;
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this, "loginname");
		}

		/**
		 * 重载equals,只比较loginName
		 */
		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(this, obj, "loginname");
		}
 
	}
}
