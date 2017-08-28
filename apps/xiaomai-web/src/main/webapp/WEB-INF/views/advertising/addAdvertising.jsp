<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>门票管理</title>
<link href="${basePath }/static/jiaoben5131/css/style.css"
	type="text/css" rel="stylesheet">

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/jiaoben5131/js/City_data.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/jiaoben5131/js/areadata.js"></script>
<script type="text/javascript"
	src="${basePath }/static/jiaoben5131/js/auto_area.js"></script>

<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
	
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


</head>
<body>


	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">广告管理</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form id="ticketForm" class="form-horizontal"
			action="${basePath }/admin/advertising/saveOrUpdateAdvertising"
			method="post">
			<input type="hidden" value="${data.id}" name="id" id="id">
			<div class="box-body">
				<div class="form-group">
					<label for="content" class="col-sm-2 control-label">内容</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="content"
							value="${data.content}" placeholder="请输入" required>
					</div>
				</div>


 					<div class="form-group">
					<label for="sort" class="col-sm-2 control-label">模块</label>
					<div class="col-sm-3">
					<select class="form-control" name="sort">
					<c:forEach items="${sort }" var="sr">
					<option value="${sr.key}" <c:if test="${sr.key==data.sort}">selected</c:if> >${sr.value}</option>
					</c:forEach>
					</select>
					</div>
				</div>

				<div class="form-group">
					<label for="type" class="col-sm-2 control-label">类型</label>
					<div class="col-sm-3">
						<select class="form-control" name="type">
							<c:forEach items="${type }" var="tp">
								<option value="${tp.key}"
									<c:if test="${tp.key==data.type}">selected</c:if>>${tp.value}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="flag" class="col-sm-2 control-label">是否显示</label>
					<div class="col-sm-5">
						<label class="radio-inline"> <input type="radio"
							name="flag" id="flag2" value="0"
							<c:if test="${0==data.flag}">checked</c:if> checked> 否 </label>
						<label class="radio-inline"> <input type="radio"
							name="flag" id="flag1" value="1"
							<c:if test="${1==data.flag}">checked</c:if>> 是 </label>


					</div>
				</div>

				<div class="form-group">
					<label for="content" class="col-sm-2 control-label">创建时间</label>
					<div class="col-sm-3">
					<label class="radio-inline">${data.createTime} </label>
					</div>
					
						<label for="content" class="col-sm-2 control-label">修改时间</label>
					<div class="col-sm-3">
						<label class="radio-inline">${data.updateTime} </label>
					</div>
				</div>
				
				<div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">图片：</label>
  <div class="col-sm-8">
	<div class="img-box full">
			<section class=" img-section">
				 
				<div class="z_photo upimg-div clear" >
			
		               		<c:forEach items="${data.imgs}" var="entry"
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
				<p class="check-p"><span class="del-com wsdel-ok " onclick="delImg()"><a >确定</a></span><span class="wsdel-no"><a>取消</a></span></p>
			</div>
		</aside>
 </div>
 </div> 

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="submit" class="btn btn-info pull-center">保存</button>
			</div>
			<!-- /.box-footer -->
		</form>
	</div>


	<script type="text/javascript">
		$("#file").takungaeImgup({
	      formData: {
	     	 "module": $("#id").val()
	      },
	      url:  "${basePath }/admin/advertising/saveOrUpdateImg",
	      success: function(data) {
	     	$("#id").val(data);
	      	location = "${basePath}/admin/advertising/skipSaveOrUpdateAdvertising?id="+data;
	      },
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
		$("#delImgId").val("");
   }
   
   
	</script>
</body>

</html>
