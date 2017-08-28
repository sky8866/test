<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>权限管理</title> 
       <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>  

</head>

<body> 
 
  
 
   

	  
        <div class="row col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
       
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" >
                  <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              
              <li   class="active" ><a href="#cateorder" data-toggle="tab" onClick="orderList(1)">权限管理</a></li>
        
                
            </ul>
        
              <!-- /#门店信息管理 -->

              <!-- 菜品-->
              <div class="active" >
                   <div class="col-xs-12">
          <h2 class="page-header">
            
              <div class="box-tools text-right ">
                
                <small >  <a class="text-muted" href="###" data-toggle="modal" data-target="#privilegeModal" onclick="inputPrivilege('save','')"  > <i class="glyphicon glyphicon glyphicon-plus"></i>  添加权限</a></small> 


                	
                
              </div>
        </div>
          <div id="privilegelist"></div>
              </div>
              <!-- /#菜品 -->
               
    
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
            </div>
            <!-- /.box-body -->
          </div>
    
                    
           
                              <!-- 添加权限 -->
                            <div class="modal fade" id="privilegeModal"    >
                            
                            <%@include file="/WEB-INF/share/loader.jsp" %>
                                
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.添加权限 --> 
     
  <script type="text/javascript">
  
   (function ($) {
      $(document).ready(function() {
     
       privlegeList(1);
      });
    
    })(jQuery);
  
  
           function  privlegeList(page){ 
           
           
           var parent='${parentId}';
          $.ajax({                                                 
		  type: "post",                                     
		 url: "${basePath }/admin/ajax/privilege/toList",                                      
		 dataType: "html",
		  data: {parent:parent,page:page},
		 success: function(html){  
			 $("#privilegelist").empty();
			 $("#privilegelist").append(html);
		 } 
		 });
          }
  
  
  function inputPrivilege(action,id){
     
    	 $.ajax({                                                 
		                                  
		 url: "${basePath }/admin/ajax/privilege/toPrivilegeEdit",                                      
		 dataType: "html",
		  data: {action:action,privilegeId:id},
		 success: function(html){  
			 $("#privilegeModal").empty();
			 $("#privilegeModal").append(html);
		 } 
		 });
  
    
   
 
 
  
  } 
 
 
 	//到指定的分页页面
	function topage(page){
	 
	  privlegeList(page);
	   
 
	}
  </script> 
    
    
    
</body>
</html>
