<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店管理</title> 
      

</head>

<body> 
 
  
 
       	<div class="row "  >

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
           
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding"  >
                  <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="${cate_tab }"><a href="#cateShopInfo"  data-toggle="tab">门店信息管理</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  ${cate_tab }  " id="cateShopInfo">
                                
            </div>
             
    
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
          <!-- /.box -->
        </div>
      </div>
      
      
    
       <script type="text/javascript">
	
	   (function ($) {
		      $(document).ready(function() {
		    	  var cate_tab='${cate_tab }';
		    	  var page='${page }';
		    	  var cate_dish_tab='${cate_dish_tab}';
		    	  
		    	  var cate_img_tab='${cate_img_tab}';
		      if(cate_tab!=""&& cate_tab!=null ){
		    	  cateShopInfo();  
		      }else if(cate_dish_tab!=""&& cate_dish_tab!=null){
		    	  
		    	  dishList(page) ; 
		      }
		      
		      });
		    
		    })(jQuery);
	

		
		 function  cateShopInfo(){
		   
		   var qu=""+
            "<div class='col-xs-10 col-md-10'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给加载，请稍等...</p></div>";
		 
		  $("#cateShopInfo").empty();
		  $("#cateShopInfo").append(qu);
		  
            
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cateshop",                                      
  		 dataType: "html", 
  		 
  		 success: function(html){  
           
  			 $("#cateShopInfo").empty();
  			 $("#cateShopInfo").append(html);
  		 } 
  		 });
            } 
	
	
 
			
		 function  dishList(page){
		  
		   var qu=""+
            "<div class='col-xs-10 col-md-10'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给加载，请稍等...</p></div>";
		 
		  $("#cateDish").empty();
		  $("#cateDish").append(qu); 
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/dish",                                      
  		 dataType: "html", 
  		 data: {page:page},
  		 success: function(html){  
           
  			 $("#cateDish").empty();
  			 $("#cateDish").append(html);
  		 } 
  		 });
            } 
 
			function topage(page){
				 
				
				dishList(page);
				  
				   
			 
				}
	
	</script>
      
      
    
    
    
</body>
</html>
