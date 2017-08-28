<%@ page contentType="text/html;charset=UTF-8" %>
 
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>登录</title> 
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                
      <shiro:guest> 
                          <div class="panel-heading">
                        <h3 class="panel-title">用户登录</h3>
                    </div>
                    <div class="panel-body">
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
                            <fieldset>
                                <div class="form-group">
                                    
                                    
                                    <input type="text" id="username" placeholder="请输入用户名" name="username" value="${username}" class="form-control required" autofocus/>
                                </div>
                                <div class="form-group">
                                
                                    <input type="password" id="password" name="password" class="form-control required" placeholder="请输入密码"/>
                                </div>
                                 
                                <!-- Change this to a button or input when using this as a form -->
                                <input id="submit_btn" class="btn btn-primary" type="submit" value="登录"/> <span>用户名：admin 密码：admin110120</span>
                            </fieldset>
                        </form>
                    </div>
                    
        </shiro:guest>
    

                     <shiro:user>
                          <a href="${basePath}/web/logout">进入系统</a>    
                            </shiro:user>    
                    
                </div>
                
                
                
            </div>
        </div>
    </div>

</body>

</html>
