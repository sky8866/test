<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>房间管理</title>  
  <link href="${basePath }/static/imgUp/css/common.css" type="text/css" rel="stylesheet"/>
		<link href="${basePath }/static/imgUp/css/index.css" type="text/css" rel="stylesheet"/>
		 <script src="${basePath }/static/imgUp/js/imgPlugin.js" type="text/javascript"></script>
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
								'textarea[name="roomDesc"]',
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
								
					var editor2 = K.create(
								'textarea[name="amenities"]',
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
								
								var editor3 = K.create(
								'textarea[name="multimedia"]',
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
								
								var editor4 = K.create(
								'textarea[name="drink"]',
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
								
							 var editor5 = K.create(
								'textarea[name="bathroom"]',
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
								
								 var editor6 = K.create(
								'textarea[name="outdoor"]',
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
								
								 var editor7 = K.create(
								'textarea[name="service"]',
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
              <li class="active"><a href="#cateShopInfo"  data-toggle="tab">客户添加</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  active " id="cateShopInfo">
                 <form id="roomForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath}/admin/hotel/room/saveAndUpdateRoom">
                <input type="hidden" name="id" id="room_id" value="${room.id }">
              <input type="hidden" name="page" id="room_page" value="${page }">
             
              <div class="box-body">
                   <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">客房名称：</label>

                  <div class="col-sm-4">
                    <input type="text" class="form-control required" id="roomName" name="roomName"  value="${room.roomName }" placeholder="请输入客房名称">
                  </div>
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">客房面积：</label>

                  <div class="col-sm-4">
                     <div class="input-group">
       
                         <input type="number" class="form-control required" id="roomArea" name="roomArea"  value="${room.roomArea }"   placeholder="客房面积">
                    <div class="input-group-addon">平方米</div>
                    </div>
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">床位类型：</label>

                  <div class="col-sm-4">
                    <input type="text" class="form-control required" id="bedType" name="bedType"  value="${room.bedType }" placeholder="请输入床位类型">
                  </div>
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">是否加床：</label>

                  <div class="col-sm-4">
                     
       
                      <label class="radio-inline">
                         <input type="radio" name="addBed" id="addBed1" value="0"    <c:if test="${room.addBed==0 }"> checked</c:if> > 不能
                       </label>
                      <label class="radio-inline">
                         <input type="radio" name="addBed" id="addBed2" value="1" <c:if test="${ empty room }"> checked</c:if>  <c:if test="${room.addBed==1 }"> checked</c:if>> 可以
                      </label>
              
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">WIFI服务：</label>

                  <div class="col-sm-4">
                    <label class="radio-inline">
                         <input type="radio" name="broadband"  value="0"    <c:if test="${room.broadband==0 }"> checked</c:if> > 没有
                       </label>
                      <label class="radio-inline">
                         <input type="radio" name="broadband"   value="1" <c:if test="${ empty room }"> checked</c:if>  <c:if test="${room.broadband==1 }"> checked</c:if>> 有WIFI
                      </label>
                       
                  </div>
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">早餐服务：</label>

                  <div class="col-sm-4">
                     
       
                      <label class="radio-inline">
                         <input type="radio" name="isBreakfast"   value="0" <c:if test="${ empty room }"> checked</c:if>    <c:if test="${room.isBreakfast==0 }"> checked</c:if> > 无早
                       </label>
                      <label class="radio-inline">
                         <input type="radio" name="isBreakfast"   value="1"  <c:if test="${room.isBreakfast==1 }"> checked</c:if>> 有早
                      </label>
                     <label class="radio-inline">
                         <input type="radio" name="isBreakfast"   value="2"    <c:if test="${room.isBreakfast==2 }"> checked</c:if>> 双早
                      </label>
                  </div>
                </div>
                
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">库存：</label>

                  <div class="col-sm-4">
                    <div class="input-group">
       
                         <input type="number" class="form-control required" id="roomNumber" name="roomNumber"  value="${room.roomNumber }"   placeholder="库存">
                    <div class="input-group-addon">间</div>
                    </div>
                  </div>
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">房间价格：</label>

                  <div class="col-sm-4">
                     <div class="input-group">
       
                         <input type="number" class="form-control required" id="roomPrice" name="roomPrice"  value="${room.roomPrice }"   placeholder="房间价格">
                    <div class="input-group-addon">元</div>
                    </div>
                  </div>
                </div>
                
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">客房楼层：</label>

                  <div class="col-sm-4">
                    <input type="number" class="form-control required" id="floor" name="floor"  value="${room.floor }" placeholder="请输入客房楼层">
                  </div>
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">入住人数：</label>

                  <div class="col-sm-4">
                     <div class="input-group">
       
                         <input type="number" class="form-control required" id="bedNumber" name="bedNumber"  value="${room.bedNumber }"   placeholder="入住人数">
                    <div class="input-group-addon">人</div>
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">客房介绍：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="roomDesc" required>${room.roomDesc}</textarea>
					</div>
				</div> 
				     
              <div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">便利设施：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="amenities" required>${room.amenities}</textarea>
					</div>
				</div> 
                 <div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">媒体/科技：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="multimedia" required>${room.multimedia}</textarea>
					</div>
				</div> 
				
				<div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">食品和饮品：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="drink" required>${room.drink}</textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">浴室：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="bathroom" required>${room.bathroom}</textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">室外/景观：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="outdoor" required>${room.outdoor}</textarea>
					</div>
				</div>
				
				<div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">服务及其他：</label>
					<div class="col-sm-10">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="service" required>${room.service}</textarea>
					</div>
				</div>
            <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">门店图片：</label>
  <div class="col-sm-8">
	<div class="img-box full">
			<section class=" img-section">
				 
				<div class="z_photo upimg-div clear" >
			
		               		<c:forEach items="${room.imgs}" var="entry"
						varStatus="statu">
		               <section class="up-section fl">
		               		<span class="up-span"></span>
		               		<img src="${basePath }/static/imgUp/img/a7.png" class="close-upimg" onclick="delId(${entry.id})">
		               		 
		               		<img src="${basePath }/${entry.imagePath}" class="up-img">
		               	    <p class="img-namep"></p>
		               	    <input id="taglocation" name="taglocation" value="" type="hidden">
		               	    <input id="tags" name="tags" value="" type="hidden">
		               	</section>
		               		</c:forEach>
		              
		               	 <section class="z_file fl">
		              
		               	 	<img src="${basePath }/static/imgUp/img/a11.png" class="add-img">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 </section>
		         </div>
			 </section>
		</div>
        <aside class="mask works-mask">
			<div class="mask-content">
			<input type="hidden" id="delImgId">
				<p class="del-p">您确定要删除图片吗？</p>
				<p class="check-p"><span class="del-com wsdel-ok "><a onclick="delImg()">确定</a></span><span class="wsdel-no"><a>取消</a></span></p>
			</div>
		</aside>
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
			$("#roomForm").validate();
		});	
		$("#file").takungaeImgup({
      formData: {
          "module": "room",
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
   
   var roomId='${room.id}';
  
      if(roomId!=null&&roomId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/hotel/room/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,roomId:roomId},
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


