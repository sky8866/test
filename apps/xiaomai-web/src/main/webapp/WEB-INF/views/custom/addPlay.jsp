<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>玩法管理</title>
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
	KindEditor.ready(function(K) {
				var editor1 = K.create(
								'textarea[name="playContent"]',
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
								
				var editor1 = K.create(
								'textarea[name="playBookings"]',
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


	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">定制玩法</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal" action="${basePath }/admin/custom/play/saveOrUpdatePlay" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${customPlayInfo.id}" name="id">
			<input type="hidden" value="${customPlayInfo.customId}" name="customId">
			<div class="box-body">
				<div class="form-group">
					<label for="playName" class="col-sm-2 control-label">玩法名称</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="playName" value="${customPlayInfo.playName}" placeholder="请输入" required>
					</div>
				</div>

				<div class="form-group">
					<label for="playTypes" class="col-sm-2 control-label">玩法类型</label>
					<div class="col-sm-3">
						<select class="form-control" name="playType">
						<c:forEach var="data" items="${playTypes}" >
						<option value="${data.key}" <c:if test="${data.key==customPlayInfo.playType}">selected</c:if> >${data.value}</option>
						</c:forEach>
						<%-- 	<option value="留学生" <c:if test="${customPlayInfo.playType=='一日游'}">selected</c:if> >一日游</option>
							<option value="职业兼职" <c:if test="${customPlayInfo.playType=='职业兼职'}">selected</c:if> >经典路线</option>
							<option value="留学生" <c:if test="${customPlayInfo.playType=='留学生'}">selected</c:if> >跟团游</option>
							<option value="职业兼职" <c:if test="${customPlayInfo.playType=='职业兼职'}">selected</c:if> >特色游</option> --%>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="playCity" class="col-sm-2 control-label">玩法所在城市</label>
					<div class="col-sm-3">
						<input type="text" class="area-danxuan form-control" name="playCity" value="${customPlayInfo.playCity}" 
							data-value="" placeholder="请选择" />
					</div>
				</div>

				<div class="form-group">
					<label for="nickname" class="col-sm-2 control-label">玩法封面图</label>
					<div class="col-sm-5">
					<input type="hidden" name="playCoverUrl" value="${customPlayInfo.playCoverUrl}">
						<img src="${customPlayInfo.imagePath}" alt="请上传封面"
							class="img-rounded" width="280px" height="140px">
							<input type="file" name="filename">
					</div>
				</div>


	<%-- 			<div class="form-group">
					<label for="customLabel" class="col-sm-2 control-label">主题标签</label>
					<div class="col-sm-3">
						<input name="customLabel" type="checkbox" value="摄影控"
							<c:forEach var="data" items="${customLabelList}" >
						<c:if test="${data.name=='摄影控'}">checked</c:if>
						</c:forEach>>摄影控
						<input name="customLabel" type="checkbox" value="旅行定制师"
							<c:forEach var="data" items="${customLabelList}" >
						<c:if test="${data.name=='旅行定制师'}">checked</c:if>
						</c:forEach>>旅行定制师
						<input name="customLabel" type="checkbox" value="商务接待"
							<c:forEach var="data" items="${customLabelList}" >
						<c:if test="${data.name=='商务接待'}">checked</c:if>
						</c:forEach>>商务接待

					</div>
				</div> --%>


				<div class="form-group">
					<label for="playLightspot" class="col-sm-2 control-label">玩法亮点</label>
					<div class="col-sm-8">
							<textarea class="form-control" rows="3" placeholder="请输入"
							name="playLightspot">${customPlayInfo.playLightspot}</textarea>
					</div>
				</div>


				<div class="form-group">
					<label for="playPrice" class="col-sm-2 control-label">参考价格</label>
					<div class="col-sm-3">
						<input type="number" class="form-control" name="playPrice"
							value="${customPlayInfo.playPrice}" placeholder="请输入">
					</div>
				</div>

				<div class="form-group">
					<label for="playPriceExplain" class="col-sm-2 control-label">价格说明</label>
					<div class="col-sm-3">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="playPriceExplain">${customPlayInfo.playPriceExplain}</textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="playBookings" class="col-sm-2 control-label">预定须知</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="playBookings">${customPlayInfo.playBookings}</textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="playContain" class="col-sm-2 control-label">费用包含</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="playContain">${customPlayInfo.playContain}</textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="playNotContain" class="col-sm-2 control-label">费用不包含</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="playNotContain">${customPlayInfo.playNotContain}</textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="playPrompt" class="col-sm-2 control-label">温馨提示</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="playPrompt">${customPlayInfo.playPrompt}</textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="playContent" class="col-sm-2 control-label">玩法详细内容</label>
					<div class="col-sm-3">
						<textarea class="form-control" rows="20" placeholder="请输入"
							name="playContent">${customPlayInfo.playContent}</textarea>
					</div>
				</div>



			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="submit" class="btn btn-info pull-center">保存并上线</button>
			</div>
			<!-- /.box-footer -->
		</form>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>
