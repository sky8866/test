<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店管理</title>  
 <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>  
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
              <li class="active"><a href="#cateShopInfo"  data-toggle="tab">会员卡管理</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  active " id="cateShopInfo">
                 <form id="memebershipForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath}/admin/cate/memebership/saveAndUpdateMemebership">
                <input type="hidden" name="id" id="memebership_id" value="${memebership.id }">
              <input type="hidden" name="page" id="memebership_page" value="${page }">
             
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">会员卡名：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="memebership_name" name="name" value="${memebership.name }"    placeholder="请输入会员卡名">
                  </div>
                </div>
 
            <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">面值：</label>

                  <div class="col-sm-8">
                     <input type="number" class="form-control required" id="memebership_faceValue" name="faceValue" value="${memebership.faceValue }"    placeholder="请输入面值">
                  </div>
                </div>
                 
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">总额：</label>

                  <div class="col-sm-8">
                     <input type="number" class="form-control required" id="memebership_money" name="money" value="${memebership.money }"    placeholder="请输入总额">
                    注：面值加送的金额的总额：如充100送50，即总额为：150
                  </div>
                </div>
                                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">有效时间：</label>

                  <div class="col-sm-8">
                      <div class="row">
                <div class="col-xs-4">
           <input type="text" placeholder="开始时间，如：2017-5-3"  id="starttime"  value="${memebership.starttime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   ">
                </div>
                <div class="col-xs-4">
                 <input type="text" placeholder="结束时间，如：2017-7-3"
																name="endtime" value="${memebership.endtime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
                </div>
                 
              </div>
                  </div>
                </div>
                
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">其他说明：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control required" rows="3" id="info" name="info"  placeholder="请输入其他说明">${memebership.info }</textarea>
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
			$("#memebershipForm").validate();
		});	
		$("#file").takungaeImgup({
      formData: {
          "module": "memebership",
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
   
   var memebershipId='${memebership.id}';
  
      if(memebershipId!=null&&memebershipId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/memebership/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,memebershipId:memebershipId},
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


