<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>角色管理</title> 
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
              
              <li   class="active" ><a href="#cateorder" data-toggle="tab" onClick="orderList(1)">角色管理</a></li>
        
                
            </ul>
        
              <!-- /#门店信息管理 -->

              <!-- 菜品-->
              <div class="active" >
                   <div class="col-xs-12">
          <h2 class="page-header">
            
              <div class="box-tools text-right ">
                
                <small >  <a class="text-muted" href="###"   onclick="inputrole()"  > <i class="glyphicon glyphicon glyphicon-plus"></i>  添加角色</a></small> 


                	
                
              </div>
        </div>
          <div id="rolelist"></div>
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
     
     
  <script type="text/javascript">
  
   (function ($) {
      $(document).ready(function() {
     
       roleList(1);
      });
    
    })(jQuery);
  
  
                     function  roleList(page){
           
           
           var parent='${parentId}';
          $.ajax({                                                 
		  type: "post",                                     
		 url: "${basePath }/admin/ajax/role/toList",                                      
		 dataType: "html",
		  data: {parent:parent },
		 success: function(html){  
			 $("#rolelist").empty();
			 $("#rolelist").append(html);
		 } 
		 });
          }
  
  
     function inputrole(){
      location = "${basePath}/admin/role/toroleEdit"; 
  
  } 
 
 
 	//到指定的分页页面
	function topage(page){
	 
	  roleList(page);
	   
 
	}
  </script> 
    
    
    
</body>
</html>
