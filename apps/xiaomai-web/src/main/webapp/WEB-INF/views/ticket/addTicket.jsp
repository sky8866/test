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
								'textarea[name="ticketIntroduce"]',
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
								'textarea[name="bookings"]',
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


 	<style type="text/css">
#allmap {width: 100%;height: 500px;overflow: hidden;margin:0;} 
#divId {width: 100%;height: 500px;overflow: hidden;margin:0;} 
</style> 

</head>
<body>


	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">门票管理</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form id="ticketForm" enctype="multipart/form-data" class="form-horizontal" action="${basePath }/admin/ticket/saveOrUpdateTicket" method="post">
			<input type="hidden" value="${data.id}" name="id">
			<div class="box-body">
				<div class="form-group">
					<label for="ticketPhotoUrl" class="col-sm-2 control-label">门票封面</label>
					<div class="col-sm-5">
						<input type="hidden" name="ticketPhotoUrl" value="${data.ticketPhotoUrl}">
							 <img
							src="${data.imagePath}" alt="请上传封面"
							class="img-rounded" width="280px" height="140px"> <input
							type="file" name="filename">
					</div>
				</div>


				<div class="form-group">
					<label for="playName" class="col-sm-2 control-label">门票名称</label>
					<div class="col-sm-3">
						<input type="text"  class="form-control" name="ticketName" value="${data.ticketName}" placeholder="请输入" required>
					</div>
				</div>

				<div class="form-group">
					<label for="playTypes" class="col-sm-2 control-label">门票价格</label>
					<div class="col-sm-3">
					<input type="number" name="ticketPrice" value="${data.ticketPrice}" required>
					</div>
				</div>
				
				<div class="form-group">
					<label for="presetTime" class="col-sm-2 control-label">预定时间</label>
					<div class="col-sm-3">
					<input type="text" placeholder="时间" id="presetTime"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){presetTime.focus();}})"
							name="presetTime" class="form-control "
							value='${data.presetTime}' required />
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="ticketType" class="col-sm-2 control-label">类型</label>
					<div class="col-sm-3">
						<select class="form-control" name="ticketType">
						<c:forEach var="data1" items="${ticketType}" >
						<option value="${data1.key}" <c:if test="${data1.key==data.ticketType}">selected</c:if> >${data1.value}</option>
						</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="usageMode" class="col-sm-2 control-label">使用方式(票种说明)</label>
					<div class="col-sm-8">
					<textarea class="form-control" rows="3" placeholder="请输入"
							name="usageMode" required>${data.usageMode}</textarea>
					</div>
				</div> 

<%-- 
				<div class="form-group">
					<label for="unsubscribeRules" class="col-sm-2 control-label">退订规则</label>
					<div class="col-sm-8">
					<textarea class="form-control" rows="3" placeholder="请输入"
							name="unsubscribeRules">${data.unsubscribeRules}</textarea>
					</div>
				</div> --%>






				<div class="form-group">
					<label for="openTime" class="col-sm-2 control-label">开放时间</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="openTime" required>${data.openTime}</textarea>
					</div>
				</div>


 				<div class="form-group">
					<label for="policy" class="col-sm-2 control-label">人群政策</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="policy">${data.policy}</textarea>
					</div>
				</div>
				<%--
				<div class="form-group">
					<label for="presetRemind" class="col-sm-2 control-label">预定提醒</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="presetRemind">${data.presetRemind}</textarea>
					</div>
				</div> --%>
				
		<%-- 		<div class="form-group">
					<label for="warmRemind" class="col-sm-2 control-label">温馨提示</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="warmRemind">${data.warmRemind}</textarea>
					</div>
				</div>
				--%>
				<div class="form-group">
					<label for="specialDateDescription" class="col-sm-2 control-label">特殊日期说明</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="specialDateDescription" required>${data.specialDateDescription}</textarea>
					</div>
				</div> 
				
				<div class="form-group">
					<label for="reserveDate" class="col-sm-2 control-label">需提前预定</label>
					<div class="col-sm-8">
					<input type="number" name="reserveDate" value="${data.reserveDate}">
					</div>
				</div>
				
				<div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">景点介绍</label>
					<div class="col-sm-8">
								<textarea class="form-control" rows="3" placeholder="请输入"
							name="ticketIntroduce"  >${data.ticketIntroduce}</textarea>
					</div>
				</div> 
				
				
				<div class="form-group">
					<label for="bookings" class="col-sm-2 control-label">预定须知</label>
					<div class="col-sm-8">
							<textarea class="form-control" rows="3" placeholder="请输入"
							name="bookings" >${data.bookings}</textarea>
					</div>
				</div>
					<input type="hidden" name="status" value="${data.status}">
			<%-- 	<div class="form-group">
					<label for="bookings" class="col-sm-2 control-label">状态</label>
					<div class="col-sm-8">
					<select class="form-control" name="status">
							<c:forEach var="var" items="${ticketStatus}" >
								<option value="${var.key}" <c:if test="${var.key==data.status}">selected</c:if> >${var.value}</option>
							</c:forEach>
						</select>				
					</div>
				</div>
 --%>
 				<div class="form-group">
					<label for="ticketCity" class="col-sm-2 control-label">门票所在城市</label>
					<div class="col-sm-3">
						<input type="text" class="form-control"  placeholder="在地图中选择"
							name="ticketCity" id="ticketCity" value="${data.ticketCity}"  required >
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
				
				<div class="form-group">
					<input type="hidden" name="ticketAddress" id="ticketAddress"> 
					<label for="ticketCity" class="col-sm-2 control-label">门店地点：</label>
				<div class="col-sm-8" >
				<span id="showTicketCity"></span>
				</div>
				</div>
				
				
				<div class="form-group" id="divId">
					<label for="inputEmail3" class="col-sm-2 control-label"></label>
					<div class="col-sm-8">
						<input type="hidden"  name="longitude" id="longitude" value="${data.longitude}">
						 <input type="hidden"  name="latitude" id="latitude" value="${data.latitude}">
						<div id="r-result">
							<input type="text" id="suggestId" class="form-control"  placeholder="搜索门店"/>
						</div>
						<div id="searchResultPanel"
							style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
						<div id="allmap" style="margin-top: 10px;"></div>
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
		var lang='${data.longitude}';
		var lat='${data.latitude}';	
		if(lat==null || lat==""){
			lang=113.338065;
			lat=23.127248;
		}
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(lang, lat);
		var geoc = new BMap.Geocoder(); //城市名称
		
		geoc.getLocation(point, function(rs){ //获取地市名称
				var addComp = rs.addressComponents;
				$("#ticketCity").val(addComp.city);
				$("#ticketAddress").val(addComp.province+addComp.city+addComp.district+addComp.street+addComp.streetNumber);
				$("#showTicketCity").text(addComp.province + "-" + addComp.city + "-" + addComp.district + "-" + addComp.street + "-" + addComp.streetNumber);
			}); 
			
		map.centerAndZoom(point, 15);
		map.addControl(new BMap.MapTypeControl({
			mapTypes : [ BMAP_NORMAL_MAP, BMAP_HYBRID_MAP ]
		}));

		map.addControl(new BMap.MapTypeControl({
			anchor : BMAP_ANCHOR_TOP_LEFT
		}));
		map.addControl(new BMap.NavigationControl()); // 添加平移缩放控件
		map.addControl(new BMap.ScaleControl()); // 添加比例尺控件
		map.addControl(new BMap.OverviewMapControl()); //添加缩略地图控件
		map.enableScrollWheelZoom(); // 启用滚轮放大缩小。
		map.enableKeyboard(); // 启用键盘操作。
		$(document).ready(function() {

			addMarker(lang, lat);

		});
		function addMarker(lng, lat) {
			$("#longitude").val(lng);
			$("#latitude").val(lat);
			var point = new BMap.Point(lng, lat);

			var marker = new BMap.Marker(point);
			map.addOverlay(marker);

		}

		map.addEventListener("click", showInfo);
		function showInfo(e) {
			map.clearOverlays();
			var pt = e.point;
			addMarker(pt.lng, pt.lat);

			geoc.getLocation(pt, function(rs){ //获取地市名称
				var addComp = rs.addressComponents;
				$("#ticketCity").val(addComp.city);
				$("#ticketAddress").val(addComp.province+addComp.city+addComp.district+addComp.street+addComp.streetNumber);
				$("#showTicketCity").text(addComp.province + "-" + addComp.city + "-" + addComp.district + "-" + addComp.street + "-" + addComp.streetNumber);
			}); 
		}

		function G(id) {
			return document.getElementById(id);
		}

		var ac = new BMap.Autocomplete( //建立一个自动完成的对象
		{
			"input" : "suggestId",
			"location" : map
		});

		ac.addEventListener("onhighlight", function(e) { //鼠标放在下拉列表上的事件
			var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province + _value.city + _value.district
						+ _value.street + _value.business;
			}
			str = "FromItem<br />index = " + e.fromitem.index
					+ "<br />value = " + value;
			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province + _value.city + _value.district
						+ _value.street + _value.business;
			}
			str += "<br />ToItem<br />index = " + e.toitem.index
					+ "<br />value = " + value;
			G("searchResultPanel").innerHTML = str;
		});

		var myValue;
		ac.addEventListener("onconfirm", function(e) { //鼠标点击下拉列表后的事件
			var _value = e.item.value;
			myValue = _value.province + _value.city + _value.district
					+ _value.street + _value.business;
			G("searchResultPanel").innerHTML = "onconfirm<br />index = "
					+ e.item.index + "<br />myValue = " + myValue;

			setPlace();
		});

		function setPlace() {
			map.clearOverlays(); //清除地图上所有覆盖物
			function myFun() {
				var pp = local.getResults().getPoi(0).point; //获取第一个智能搜索的结果
				map.centerAndZoom(pp, 18);
				$("#longitude").val(pp.lng);
				$("#latitude").val(pp.lat);
				map.addOverlay(new BMap.Marker(pp)); //添加标注
			}
			var local = new BMap.LocalSearch(map, { //智能搜索
				onSearchComplete : myFun
			});
			local.search(myValue);
		}
		
		
	</script>
</body>

</html>
