<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店管理</title>  
  <link href="${basePath }/static/imgUp/css/common.css" type="text/css" rel="stylesheet"/>
		<link href="${basePath }/static/imgUp/css/index.css" type="text/css" rel="stylesheet"/>
		 <script src="${basePath }/static/imgUp/js/imgPlugin.js" type="text/javascript"></script>
	
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
              <li class="active"><a href="#cateShopInfo"  data-toggle="tab">买单管理</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  active " id="cateShopInfo">
                 <form id="payBillForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath}/admin/cate/payBill/saveAndUpdatepayBill">
                <input type="hidden" name="id" id="payBill_id" value="${payBill.id }">
              <input type="hidden" name="page" id="payBill_page" value="${page }">
             
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">折扣：</label>

                  <div class="col-sm-8">
                     <input type="number" class="form-control required" id="payBillDiscount" name="payBillDiscount" value="${payBill.payBillDiscount }"    placeholder="请输入要打的折扣，如:8.5">
                  </div>
                </div>
               
  
            
 
                
 
                
 
                 
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-left">提交</button>
              </div>
              <!-- /.box-footer -->
            </form>
           
                 
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
 
		$(document).ready(function() {
			$("#payBillForm").validate();
		});	
		$("#file").takungaeImgup({
      formData: {
          "module": "payBill",
          "name": "imgId"
      },
      url:  "${basePath }/admin/ajax/img/upload",
      success: function(data) {},
      error: function(err) {
          alert(err);
      }
});
 function  delId(id){
    $("#delImgId").val(id);
   }
 
      function delImg(){
   var id=$("#delImgId").val();
  
   if(id!=null&&id!=""){
                  $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/img/del",                                      
  		 dataType: "text", 
  		   data: {id:id},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 
  			  art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '删除图片成功！',
			    time: 3000
			});
		updateShopImg(id);	 
          }else{
            art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '删除图片失败！',
			    time: 3000
			});
          } 
  		 } 
  		 });
   }

   }
   
   
         function updateShopImg(id){
   
   var payBillId='${payBill.id}';
  
      if(payBillId!=null&&payBillId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/payBill/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,payBillId:payBillId},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 
  			 
          }else{
           
          } 
  		 } 
  		 });
   }
   
   }
   
	</script>
 
    
</body>
</html>


