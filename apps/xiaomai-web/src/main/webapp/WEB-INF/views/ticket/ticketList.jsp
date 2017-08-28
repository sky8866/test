<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>门票管理</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
	
</head>

 			<div class="box-footer">
                <a href="${basePath}/admin/ticket/skipSaveOrUpdateTicket" class="btn btn-primary ">添加门票</a>
             </div>
		        	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">门票管理</h3>
<%--               <div class="box-tools ">
                          <form class="form-horizontal">
              <div class="box-body">
                <div class="form-group">
                  <div class="col-sm-20">
                   <select class="form-control" name="status">
							<option value="0" <c:if test="${status==0}">selected</c:if> onclick="query(1,0)" >进行中</option>
							<option value="1" <c:if test="${status==1}">selected</c:if> onclick="query(1,1)" >已完成</option>
					</select>
                  </div>
                  
                </div>
              </div>
            </form>
 
              </div> --%>
            </div>
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" id="quilvQuery" style="margin: 10px;">
           		 <a href="javascript:void(0)" onclick="jqchk(3)" class="btn btn-primary ">撤回</a>
           		 <a href="javascript:void(0)" onclick="jqchk(1)" class="btn btn-primary ">上线</a>
            </div>
            <!-- /.box-body -->
            
             <table class="table table-hover" >
                <tr>
                  <th width="2%">
					 <div class="checkbox">
						<label>
							<input type="checkbox" onclick="selectAll()" > 
						</label>
					</div>
				  </th>
                  <th width="10%">序号</th>
                  <th width="10%">门票名称</th> 
                  <th width="10%">门票价格</th> 
                  <th width="10%">预定时间</th> 
                  <th width="10%">创建时间</th> 
                  <th width="10%">销量</th> 
                  <th width="10%">状态</th> 
                   <th width="10%">操作</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
				 <form id="ticketForm" action="${basePath}/admin/ticket/updateStatus" method="post">
				 <input type="hidden" id="status" name="status" >
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                <td>
                <div class="checkbox"   >
					<label >
						<input type="checkbox" value="${entry.id }" name="entryId"> 
					</label>
				</div>
				</td>
                  <td>${statu.count }</td>
                  <td >${entry.ticketName }</td>
                  <td >${entry.ticketPrice }</td>
                  <td >${entry.presetTime }</td>
                  <td ><fmt:formatDate value="${entry.createTime }" pattern="yyyy-MM-dd HH:mm" /></td>
                  <td >${entry.salesVolume }</td>
                   <td >
                    <c:forEach var="var" items="${ticketStatus}" >
						<c:if test="${var.key==entry.status}">${var.value}</c:if>
					</c:forEach>
                   </td>
                   <td >
                 <a href="${basePath}/admin/ticket/skipSaveOrUpdateTicket?id=${entry.id}">修改</a>
                   
                   </td>
                </tr>
                  	</c:forEach>
                  	</form>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6"><div align="center">暂无数据！</div>
						</td>

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
		location = "${basePath}/admin/ticket/ticketList?pageNo="+page;
	}
/* 	function query(page,status){
		location = "${basePath}/admin/ticket/indent/indentList?page="+page+"&status="+status;
	} */
/* 	function updateStatus(page,status){
		location = "${basePath}/admin/custom/indent/indentList?page="+page+"&status="+status;
	} */
 
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
	

	function jqchk(status) { //jquery获取复选框值
	   $("#status").val(status);
		var chk_value = [];
		$('input[name="entryId"]:checked').each(function() {
			chk_value.push($(this).val());
		});

		if (chk_value.length == 0) {
				alert("你还没有选择任何内容！");
				return;
			} else {
				if (confirm("确定吗？") == true) {
					$("#ticketForm").submit();
				} else {
					return false;
				}
			}
	}
</script>
</body>

</html>
