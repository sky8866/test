<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>美食酒店订单管理</title> 
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
              
              <li   class="active" ><a href="#cateorder" data-toggle="tab" onClick="orderList(1)">美食订单管理</a></li>
        
                
            </ul>
        
              <!-- /#门店信息管理 -->

              <!-- 菜品-->
              <div class="active" >
                   <div class="col-xs-12">
          <h2 class="page-header">
            
              <div class="box-tools text-right ">
                
            <form class="form-inline">
				 
             <div class="form-group">
                  
                    <select class="form-control" name="status" id="status">
                    <option  value=""  >全部</option>
                    <option value="1"  >已付款</option>
                    <option value="0"   >未付款</option>
                    <option value="2"  >已取消</option>
                   
                  </select>
                  
                </div>

			<!-- 	<div class="form-group">
					 
						<input type="text" class="form-control" placeholder="名称"
							id="query" name="query">
					 
				</div> -->
			<!-- 	<div class="form-group">
					 
						<input type="text" class="form-control" placeholder="入住时间"
							id="checkinTime" name="checkinTime" onClick="WdatePicker()">
					 
				</div> -->
				 
				
				<div class="form-group">
    
     
      <input type="text" placeholder="订单创建时间" id="starttime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   " />
													  <small>至</small> <input type="text" placeholder="结束时间"
																name="endtime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
                                
  
  </div>

				<button type="button" class="btn btn-default" onclick="orderList(1)">查询</button>
			</form>
                	
                
              </div>
        </div>
          <div id="cateorder"></div>
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
		    	 
		    	  
		    	  orderList(page) ; 
		      
		      });
		    
		    })(jQuery);
	

	 
	
	
 
			
		 function  orderList(page){
		  
		   var qu=""+
            "<div class='col-xs-10 col-md-10'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给加载，请稍等...</p></div>";
		 
		  $("#cateorder").empty();
		  $("#cateorder").append(qu); 
		   
             var status=$("#status").val(); 
              var starttime=$("#starttime").val();
               var endtime=$("#endtime").val(); 
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/order",                                      
  		 dataType: "html", 
  		 data: {page:page,status:status,starttime:starttime,endtime:endtime},
  		 success: function(html){  
           
  			 $("#cateorder").empty();
  			 $("#cateorder").append(html);
  		 } 
  		 });
            } 
 
 
 
			function topage(page){
				 
				
				orderList(page);
				  
				   
			 
				}
	
	</script>
      
      
    
    
    
</body>
</html>
