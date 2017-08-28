<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>登录页</title>
	 
	
	<script>
		$(document).ready(function() {
			$("#loginForm").validate();
		});
	</script>
</head>

<body>

<hr class="soften">
<div style="margin-left: 450px;">


 <shiro:user>
 <div style="margin: 250px;">
             <a href="${basePath}/web/logout" >进入系统</a> 
       </div>
                            </shiro:user>
                             <shiro:guest>
                             <h1>   &nbsp;&nbsp; </h1>
                            <form id="loginForm" action="${basePath}/web/login" method="post" class="form-horizontal">
		<%
			String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
			if(error != null){
		%>
				<div class="alert alert-error controls input-large">
					<button class="close" data-dismiss="alert">×</button>
		<%
				if(error.contains("DisabledAccountException")){
					out.print("用户已被锁定");
				}
				else{
					out.print("登录失败，请重试.");
				}
		%>		
				</div>
		<%
			}
		%>
	 
		<div class="control-group">
			<label for="username" class="control-label">名称:</label>
			<div class="controls">
				<input type="text" id="username" name="username" value="${username}" class="input-medium required"/>
			</div>
		</div>
		<div class="control-group">
			<label for="password" class="control-label">密码:</label>
			<div class="controls">
				<input type="password" id="password" name="password" class="input-medium required"/>
			</div>
		</div>
			<div class="control-group">
			<div class="controls">
				<label class="checkbox" for="rememberMe"><input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
				<input id="submit_btn" class="btn btn-primary" type="submit" value="登录"/>  
			 	 
			</div>
		</div>
		 
	</form>
                             </shiro:guest>
	
	
	</div>
</body>
</html>
