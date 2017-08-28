<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>定制游个人信息</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/js/bootbox.min.js"></script>

</head>
<div class="row " style="margin-bottom: 10px;">


	<div class="col-lg-12 col-xs-12 col-sm-12 ">
		<div class="box">
			<div class="box-footer">
				<a href="${basePath}/admin/custom/play/skipSaveOrUpdatePlay"
					class="btn btn-primary">创建新玩法</a>
			</div>

			<div class="box-body table-responsive no-padding" id="quilvQuery"
				style="margin: 10px;">
				 <a href="javascript:void(0)" onclick="updateStatus(1)" class="btn btn-primary ">上线</a>
				<a href="javascript:void(0)" onclick="updateStatus(3)" class="btn btn-primary ">撤回</a>
			</div>
			<table class="table table-hover">
				<tr>
					<th width="2%">
					<div class="checkbox">
						<label> <input type="checkbox" onclick="selectAll()">
						</label>
					</div></th>
					<th width="15%">序号</th>
					<th width="15%">名称</th>
					<th width="15%">封面</th>
					<th width="15%">所在地</th>
					<th width="15%">价格</th>
					<th width="15%">状态</th>
					<th width="15%">操作</th>
				</tr>
				<c:choose>
					<c:when test="${!empty pageView.records }">
						<c:forEach items="${pageView.records}" var="entry"
							varStatus="statu">
							<tr>
								<td>
									<div class="checkbox">
										<label>
										 <input type="checkbox" value="${entry.id }" name="entryId">
										 </label>
									</div></td>
								<td>${statu.count }</td>
								<td>${ entry.playName }</td>
								<td><img
									class="profile-user-img img-responsive img-rounded"
									src="${entry.imagePath }" alt="无"></td>
								<td>${entry.playCity }</td>
								<td>${entry.playPrice }</td>
								<td>${entry.status==1?"上线":"撤回" }</td>
								<td><a
									href="${basePath}/admin/custom/play/skipSaveOrUpdatePlay?id=${entry.id}">修改</a>
									&nbsp; <a href="javascript:void(0)"
									onclick="del('${entry.id}')">删除</a></td>
								<td><c:forEach var="var" items="${indentStatus}">
										<c:if test="${var.key==entry.status}">${var.value}</c:if>
									</c:forEach></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="9"><div align="center">暂无数据！</div></td>

						</tr>
					</c:otherwise>
				</c:choose>
			</table>


			<%@include file="/WEB-INF/share/fenye.jsp"%>
		</div>
	</div>
</div>
<script type="text/javascript">
	
		//到指定的分页页面
	function topage(page){
		location = "${basePath}/admin/custom/play/playList?page="+page;
	}
	
	function del(id){
	bootbox.confirm({
    message: "确定要删除吗?",
    buttons: {
        confirm: {
            label: '确定',
            className: 'btn-danger'
        },
        cancel: {
            label: '取消',
            className: 'btn-success'
        }
    },
	    callback: function (result) {
	    if(result){
		location = "${basePath}/admin/custom/play/delPlay?id="+id; 
		}
	    }
	});

 }
 
 
 	//全选
	function selectAll() {
		$("input[type='checkbox']").each(function() {
			if ($(this).prop("checked") == true) {
				$("input[type='checkbox']").prop('checked', true);
				return;
			} else {
				$("input[type='checkbox']").prop('checked', false);
				return;
			}
		});
	}
	

	function updateStatus(status) { //jquery获取复选框值
	   $("#status").val(status);
		var chk_value = [];
		$('input[name="entryId"]:checked').each(function() {
			chk_value.push($(this).val());
		});
		if(chk_value.length == 0){
			alert("你还没有选择任何内容！");
			return;
		}else{
		
			$.ajax({
				type : "post",
				url : "${basePath}/admin/custom/play/updateStatus",
				dataType : "json",
				data : {ids:chk_value+"",status:status},
				success : function(data) {
					alert(data.msg);
					location = "${basePath}/admin/custom/play/playList";
				}
			});
			
		}
	}
	
	</script>
</body>

</html>
