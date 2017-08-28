package snippet;

public class Snippet {
	<bean id="shiroAdminFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
			<property name="securityManager" ref="securityManager" />
			<property name="loginUrl" value="/account/login" />
			<property name="successUrl" value="/admin/main/index" />
			<property name="filterChainDefinitions">
				<value>
					/static/** = anon
					 /admin/** = authc
					 /account/login = authc
				</value>
			</property>
		</bean>
}

