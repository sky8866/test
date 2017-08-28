<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>酒店房间管理</title> 
      

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
              
              <li   class="active" ><a href="#cateroom" data-toggle="tab" onClick="roomList(1)">房间管理</a></li>
        
                
            </ul>
        
              <!-- /#门店信息管理 -->

              <!-- 菜品-->
              <div class="active" id="cateroom">
              
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
		    	 
		    	  var page='${page }';
		    	 
		    	  
		    	  roomList(page) ; 
		      
		      });
		    
		    })(jQuery);
	

	 
	
	
 
			
		 function  roomList(page){
		  
		   var qu=""+
            "<div class='col-xs-10 col-md-10'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给加载，请稍等...</p></div>";
		 
		  $("#cateroom").empty();
		  $("#cateroom").append(qu); 
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/hotel/room",                                      
  		 dataType: "html", 
  		 data: {page:page},
  		 success: function(html){  
           
  			 $("#cateroom").empty();
  			 $("#cateroom").append(html);
  		 } 
  		 });
            } 
 
			function topage(page){
				 
				
				roomList(page);
				  
				   
			 
				}
	
	</script>
      
      
    
    
    
</body>
</html>
