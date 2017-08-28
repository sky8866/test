<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店管理</title>  
  
	<script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	<link rel="stylesheet"
	href="${basePath }/static/kindEditor/themes/default/default.css" />
<link rel="stylesheet"
	href="${basePath }/static/kindEditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="${basePath }/static/kindEditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${basePath }/static/kindEditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="${basePath }/static/kindEditor/plugins/code/prettify.js"></script>
<script>
	KindEditor
			.ready(function(K) {
				var editor1 = K
						.create(
								'textarea[name="remark"]',
								{
									cssPath : '${basePath }/static/kindEditor/plugins/code/prettify.css',
									uploadJson : '${basePath }/jsp/upload_json.jsp',
									fileManagerJson : '${basePath }/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['myform'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['myform'].submit();
										});
									}
								});
				 
								
				prettyPrint();
			});
			
		
</script>
	
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
              <li class="active"><a href="#cateShopInfo"  data-toggle="tab">代金券管理</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  active " id="cateShopInfo">
                 <form id="couponsForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath}/admin/cate/coupons/saveAndUpdateCoupons">
                <input type="hidden" name="id" id="coupons_id" value="${coupons.id }">
              <input type="hidden" name="page" id="coupons_page" value="${page }">
             
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">代金券名：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="coupons_name" name="name" value="${coupons.name }"    placeholder="请输入代金券名">
                  </div>
                </div>
 
            <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">面值：</label>

                  <div class="col-sm-8">
                     <input type="number" class="form-control required" id="coupons_faceValue" name="faceValue" value="${coupons.faceValue }"    placeholder="请输入面值">
                  </div>
                </div>
                 
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">团购价：</label>

                  <div class="col-sm-8">
                     <input type="number" class="form-control required" id="coupons_buy" name="buy" value="${coupons.buy }"    placeholder="请输入团购价">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">人均消费参考价：</label>

                  <div class="col-sm-8">
                     <input type="number" class="form-control required" id="coupons_consumption" name="consumption" value="${coupons.consumption }"    placeholder="请输入人均消费">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">有效时间：</label>

                  <div class="col-sm-8">
                      <div class="row">
                <div class="col-xs-4">
           <input type="text" placeholder="开始时间，如：2017-5-3"  id="starttime"  value="${coupons.starttime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   ">
                </div>
                <div class="col-xs-4">
                 <input type="text" placeholder="结束时间，如：2017-7-3"
																name="endtime" value="${coupons.endtime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
                </div>
                 
              </div>
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">使用时间：</label>

                  <div class="col-sm-8">
                      <div class="row">
                <div class="col-xs-4">
           <input type="text" placeholder="开始时间，如：10：00"  id="usagestarttime"  value="${coupons.usagestarttime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="usagestarttime"  class="form-control   ">
                </div>
                <div class="col-xs-4">
                 <input type="text" placeholder="结束时间，如：22：00"
																name="usageendtime" value="${coupons.usageendtime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="usageendtime"   class="form-control  " /> 
                </div>
                 
              </div>
                  </div>
                </div>
                
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label" >预约：</label>

                  <div class="col-sm-8">
                   <div class="row">
                 <div class="col-lg-6">
                  <div class="input-group">
                        <span class=" ">
                          <input type="radio" name="isAppointment" value="0" <c:if test="${coupons==null }">checked</c:if> <c:if test="${coupons.isAppointment==0 }">checked</c:if>> 无需预约，消费高峰时可能需要等位
                      <input type="hidden" class="form-control" name="appointment"   value="无需预约，消费高峰时可能需要等位">
                        </span>
                    
                  </div>
                  <!-- /input-group -->
                </div>
                <!-- /.col-lg-6 -->
                <div class="col-lg-6">
                  <div class="input-group">
                        <span class="input-group-addon">
                          <input type="radio" name="isAppointment" value="1" <c:if test="${coupons.isAppointment==1 }">checked</c:if>> 其他：
                        </span>
                    <input type="text" class="form-control" name="appointment1" value="${coupons.appointment1 }">
                  </div>
                  <!-- /input-group -->
                </div>
                <!-- /.col-lg-6 -->
              </div>
                  </div>
                </div>
                
                                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label" >范围：</label>

                  <div class="col-sm-8">
                   <div class="row">
                 <div class="col-lg-2">
                  <div class="input-group">
                        <span class=" ">
                          <input type="radio" name="isScope" value="0" <c:if test="${coupons==null }">checked</c:if> <c:if test="${coupons.isScope==0 }">checked</c:if>> 全场 
                      <input type="hidden" class="form-control" name="scope" value="全场">
                        </span>
                    
                  </div>
                  <!-- /input-group -->
                </div>
                <!-- /.col-lg-6 -->
                 <div class="col-lg-5">
                  <div class="input-group">
                        <span class="input-group-addon">
                          <input type="radio" name="isScope" value="1" <c:if test="${coupons.isScope==1 }">checked</c:if>> 仅适用于
                        </span>
                    <input type="text" class="form-control" name="scope1" value="${coupons.scope1 }">
                  </div>
                  <!-- /input-group -->
                </div>
                <div class="col-lg-5">
                  <div class="input-group">
                        <span class="input-group-addon">
                          <input type="radio" name="isScope" value="2" <c:if test="${coupons.isScope==2 }">checked</c:if>> 除之外
                        </span>
                    <input type="text" class="form-control" name="scope2" value="${coupons.scope2 }">
                  </div>
                  <!-- /input-group -->
                </div>
                <!-- /.col-lg-6 -->
              </div>
                  </div>
                </div>
                
                    <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">数量：</label>

                  <div class="col-sm-3">
                     <input type="number" class="form-control required" id="amount" name="amount" value="${coupons.amount }"    placeholder="请输入数量">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">简介：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control required" rows="3" id="info" name="info"  placeholder="请输入简介">${coupons.info }</textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">菜品价格介绍：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control required" rows="3" id="dishInfo" name="dishInfo"  placeholder="请输入菜品价格介绍">${coupons.dishInfo }</textarea>
                  </div>
                </div>
                
                
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">其他说明：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control required" rows="3" id="remark" name="remark"  placeholder="请输入其他说明">${coupons.remark }</textarea>
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
			$("#couponsForm").validate();
		});	
		$("#file").takungaeImgup({
      formData: {
          "module": "coupons",
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
   
   var couponsId='${coupons.id}';
  
      if(couponsId!=null&&couponsId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/coupons/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,couponsId:couponsId},
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


