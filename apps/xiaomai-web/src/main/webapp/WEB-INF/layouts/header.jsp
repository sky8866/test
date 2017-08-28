<%@ page language="java" pageEncoding="UTF-8" %>
 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

  <header class="main-header">
    <!-- Logo -->
    <a href="###" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>小</b>麦</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>小麦</b>旅行</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="###" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
            
          
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${basePath}/static/images/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"><shiro:principal property="name"/></a></span>
            </a>
            
          </li>
          <!-- Control Sidebar Toggle Button -->
        
          
          <li class="dropdown">
           <a href="javascript:exitsystem()"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>   
         <script>

		
		
function exitsystem(){
	if (confirm('您确定要退出系统吗？'))
	  window.parent.location="${basePath}/web/logout"; 
}
	</script>   