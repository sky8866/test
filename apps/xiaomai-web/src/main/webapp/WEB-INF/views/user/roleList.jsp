<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<script src="${basePath }/static/js/toUser.js" type="text/javascript"></script>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>


<title1> </title1>




</head>

<body>



	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="75%">权限组名</th>

				<th width="25%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">

						<tr id="del_${entry.id }">
							<td>${entry.rolename }</td>

							<td class="center">
							 
							<i class="fa fa-edit fa-fw"></i> <a
								href="${basePath}/admin/role/toroleEdit/${entry.id}">修改</a>
								  
							  
								<i class="fa fa-trash-o fa-fw"></i> <a  onclick="delId('${entry.id}')"  data-toggle="modal" data-target="#delModal"
								href="###"  >删除</a>	       </td>
						</tr>

					</c:forEach>



				</c:when>
				<c:otherwise>

					<tr>
						<td colspan="2"><div align="center">暂无数据！</div>
						</td>

					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<%@include file="/WEB-INF/share/fenye.jsp"%>
 
      
<script type="text/javascript">
 
		 
 function delId(id){
 $("#delId").val(id); 
 $("#delUrl").val("/admin/role/del"); 
 }
 </script>
 
</body>
</html>
