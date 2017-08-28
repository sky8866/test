<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
 <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
       <title>小麦旅行_<sitemesh:title /></title>
        <meta name="keywords" content="" />
		<meta name="description" content=" " />
       
        <!--style
        =====================================================-->
      <link type="image/x-icon" href="${basePath}/static/images/favicon.ico" rel="shortcut icon">
     <link href="${basePath}/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" /> 
 
   
   <!-- MetisMenu CSS -->
    <link href="${basePath}/static/components/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="${basePath}/static/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${basePath}/static/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${basePath}/static/components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${basePath}/static/components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
     <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  
    <!-- jQuery -->
   <script src="${basePath}/static/jquery/jquery.min.js" type="text/javascript"></script>
  <link href="${basePath}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
        <sitemesh:head />
    </head>


  <body    >
      
                
                  <div style="margin:15px;"></div>
            <sitemesh:body />
            
           
    <%@ include file="/WEB-INF/layouts/footer.jsp"%>    
        
    </body>
</html>
 