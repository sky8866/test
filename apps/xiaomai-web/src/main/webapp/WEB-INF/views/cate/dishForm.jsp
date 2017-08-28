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
              <li class="active"><a href="#cateShopInfo"  data-toggle="tab">菜品管理</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  active " id="cateShopInfo">
                 <form id="dishForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath}/admin/cate/dish/saveAndUpdateDish">
                <input type="hidden" name="id" id="dish_id" value="${dish.id }">
              <input type="hidden" name="page" id="dish_page" value="${page }">
             
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">菜品名：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="dish_name" name="name" value="${dish.name }"    placeholder="请输入菜品名">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">菜品分类：</label>

                  <div class="col-sm-8">
                     <select class="form-control" id="dish_type" name="type" value="${dish.type }"  >
                    <option  value="未分类" <c:if test="${dish.type=='未分类' }"> selected</c:if>  >未分类</option>
                    <option value="火锅" <c:if test="${dish.type=='火锅' }"> selected</c:if>  >火锅</option>
                    <option value="锅底" <c:if test="${dish.type=='锅底' }"> selected</c:if> >锅底</option>
                    <option value="肉类" <c:if test="${dish.type=='肉类' }"> selected</c:if> >肉类</option>
                     <option value="素菜" <c:if test="${dish.type=='素菜' }"> selected</c:if> >素菜</option>
                      <option value="酒水" <c:if test="${dish.type=='酒水' }"> selected</c:if> >酒水</option>
                       <option value="饮料" <c:if test="${dish.type=='饮料' }"> selected</c:if> >饮料</option>
                       <option value="主食" <c:if test="${dish.type=='主食' }"> selected</c:if> >主食</option>
                       <option value="盖饭" <c:if test="${dish.type=='盖饭' }"> selected</c:if> >盖饭</option>
                       <option value="热菜" <c:if test="${dish.type=='热菜' }"> selected</c:if> >热菜</option>
                       <option value="凉菜" <c:if test="${dish.type=='凉菜' }"> selected</c:if> >凉菜</option>
                       <option value="甜点" <c:if test="${dish.type=='甜点' }"> selected</c:if> >甜点</option>
                       <option value="汤" <c:if test="${dish.type=='汤' }"> selected</c:if> >汤</option>
                       <option value="小吃" <c:if test="${dish.type=='小吃' }"> selected</c:if> >小吃</option>
                       <option value="套餐" <c:if test="${dish.type=='套餐' }"> selected</c:if> >套餐</option>
                  </select>
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">菜品价格：</label>

                   
                     <div class="form-inline col-md-9">
  <input type="number"   name="price" id="dish_price" value="${dish.price }" class="form-control col-xs-3 required" placeholder="请输入菜品价格，如49" />
  <label >元/</label>
  <div style="display:inline-block;vertical-align:middle;" >
  <select class="form-control col-xs-3" id="dish_unit" name="unit" style="color:#999;" >
   <option value="份" <c:if test="${dish.unit=='份' }"> selected</c:if> >份</option>
   <option value="位" <c:if test="${dish.unit=='份' }"> selected</c:if> >位</option>
    <option value="杯" <c:if test="${dish.unit=='杯' }"> selected</c:if> >杯</option>
    <option value="听" <c:if test="${dish.unit=='听' }"> selected</c:if> >听</option>
    <option value="扎" <c:if test="${dish.unit=='扎' }"> selected</c:if> >扎</option>
    <option value="瓶" <c:if test="${dish.unit=='瓶' }"> selected</c:if> >瓶</option>
  </select>
  </div>
                  </div>
               
   </div>
           <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">说明：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control " rows="3" id="info" name="info"  placeholder="请输入介绍">${dish.info }</textarea>
                  </div>
                </div>       
 
                
            <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">门店图片：</label>
  <div class="col-sm-8">
	<div class="img-box full">
			<section class=" img-section">
				 
				<div class="z_photo upimg-div clear" >
			
		               		<c:forEach items="${dish.imgs}" var="entry"
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
			$("#dishForm").validate();
		});	
		$("#file").takungaeImgup({
      formData: {
          "module": "dish",
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
   
   var dishId='${dish.id}';
  
      if(dishId!=null&&dishId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/dish/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,dishId:dishId},
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


