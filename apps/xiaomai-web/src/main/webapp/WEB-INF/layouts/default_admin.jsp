<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
 <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
       
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
     <title>小麦旅行_<sitemesh:title /></title>
        <meta name="keywords" content="小麦旅行" />
		<meta name="description" content="小麦旅行" />
          <script type="text/javascript" src="http://api.map.baidu.com/getscript?v=1.5&ak=HoLM2sbQ5xSaojvXowVwMLLTtHiXp4AI&services=&t=sss"></script> 
        <!--style
        =====================================================-->
      <link type="image/x-icon" href="${basePath}/static/images/favicon.ico" rel="shortcut icon">
     <link href="${basePath}/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" /> 
   <!-- Font Awesome -->
   <link href="${basePath}/static/components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${basePath}/static/js/ionicons.min.css">
   
   <link rel="stylesheet" href="${basePath}/static/lte/css/AdminLTE.min.css">
   
    <link rel="stylesheet" href="${basePath}/static/lte/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${basePath}/static/lte/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="${basePath}/static/lte/morris/morris.css">

 
     <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
   <script src="${basePath}/static/jquery/jquery.min.js" type="text/javascript"></script>
  <link href="${basePath}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
  <link href="${basePath}/static/artDialog/skins/default.css" rel="stylesheet" />
    
        <sitemesh:head />
    </head>


  <body   class="hold-transition skin-blue sidebar-mini"  >
   <div class="wrapper"> 
    <%@ include file="/WEB-INF/layouts/header.jsp"%>  
    <%@ include file="/WEB-INF/layouts/left.jsp"%>   
      <div class="content-wrapper" style="padding-left: 13px;">
        
      <sitemesh:body /> 
    </div> 
        <%@ include file="/WEB-INF/layouts/footer.jsp"%>   
   </div>    
    </body>
</html>
 