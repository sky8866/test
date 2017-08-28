<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>约伴管理</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
</head>


<div class="row " style="margin-bottom: 10px;">


	<div class="col-lg-12 col-xs-12 col-sm-12 ">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">约伴管理</h3>
				<div class="box-tools ">
					<form class="form-horizontal">
						<div class="box-body">
							<div class="form-group">
								<div class="col-sm-20">
									
								</div>

							</div>
						</div>
					</form>
				</div>
			</div>
			
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding" id="quilvQuery"
				style="margin: 10px;">
				<div class="col-xs-3">
						<button type="button" class="btn btn-primary btn-sm" onclick="updateStatus(1)">通过</button>
						&nbsp;
						<button type="button" class="btn btn-primary btn-sm" onclick="updateStatus(3)">撤回</button>
				</div>
				<div class="col-xs-2">
					<select class="form-control" name="status" id="status">
					<option value="0"  ${status==0?'selected':'' } onclick="topage(1)">全部</option>
					<option value="1" ${status==1?'selected':'' } onclick="topage(1)">已发布</option>
					<option value="2" ${status==2?'selected':'' }  onclick="topage(1)">未发布</option>
					<option value="3" ${status==3?'selected':'' }  onclick="topage(1)">撤回</option>
					</select>

				</div>
			</div>
			<!-- /.box-body -->

			<table class="table table-hover">
				<tr>
				 <th width="2%">
					 <div class="checkbox">
						<label>
							<input type="checkbox" onclick="selectAll()" > 
						</label>
					</div>
				  </th>
					<th width="10%">序号</th>
					<th width="10%">邀约对象</th>
					<th width="10%">邀约人数</th>
					<th width="10%">费用</th>
					<th width="10%">时间</th>
					<th width="10%">说明</th>
					<th width="10%">状态</th>
				</tr>
				<c:choose>
					<c:when test="${!empty pageView.records }">
						<c:forEach items="${pageView.records}" var="entry"
							varStatus="statu">
							<tr>
								<td>
									<div class="checkbox">
										<label> <input type="checkbox" value="${entry.id }"
											name="entryId"> </label>
									</div>
								</td>
								<td>${statu.count }</td>
								<td>${entry.inviteObject }</td>
								<td>${entry.inviteNum }</td>
								<td>${entry.expense }</td>
								<td>${entry.serviceTime }</td>
								<td>${entry.introduce }</td>
								<td>
									<c:choose>
									<c:when test="${entry.status==1}">
										已发布
									</c:when>
									<c:when test="${entry.status==2}">
										未发布
									</c:when>
									<c:when test="${entry.status==3}">
										撤回
									</c:when>
									<c:otherwise>
									</c:otherwise>
									</c:choose>
								</td>
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
		<!-- /.box -->
	</div>
</div>
<script type="text/javascript">
		//到指定的分页页面
	function topage(page){
		var status=$("#status").val();
		location = "${basePath}/admin/backpacking/list?pageNo="+page+"&status="+status;
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
			location = "${basePath}/admin/backpacking/updateStatus?id="+id; 
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
		var chk_value = [];
		$('input[name="entryId"]:checked').each(function() {
			chk_value.push($(this).val());
		});
		if (chk_value.length == 0) {
			alert("你还没有选择任何内容！");
			return;
		} else {
			if (confirm("确定吗？") == true) {
				location = "${basePath}/admin/backpacking/updateStatus?ids="
						+ chk_value + "" + "&status=" + status;
			} else {
				return false;
			}

		}
	}
</script>
</body>

</html>
