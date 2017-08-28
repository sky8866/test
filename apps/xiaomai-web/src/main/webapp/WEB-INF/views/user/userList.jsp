<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>




</head>

<body>

    <table class="table table-hover">
                <tr>
                  <th width="6%">序号</th>
                   
                  <th width="10%">昵称</th> 
                   <th width="10%">头像</th> 
                  <th width="10%">手机号</th> 
                   <th width="10%">注册时间</th> 
                    <th width="10%">登录时间</th> 
                  <th width="20%">操作</th>
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                    <td  >${entry.name }</td>
                  <td  ><img src="${basePath }${entry.imagePath}" width="30" height="30" ></td>
                    <td >${entry.mobile }</td>
                     <td  >${entry.createTime }</td>
                    <td >${entry.updateTime }</td>
                    
                  <td>
 
				<i class="fa fa-gears fa-fw"></i> <a href="###"
								onclick="userToRole('${entry.id}','${pageView.currentpage }')" data-target="#userToRoleModal"   data-toggle="modal">用户授权</a>
								 
								 
</td>
                </tr>
                  	</c:forEach>



				</c:when>
				<c:otherwise>

					<tr>
						<td colspan="5"><div align="center">暂无数据！</div>
						</td>

					</tr>
				</c:otherwise>
			</c:choose>   
              </table>
<%@include file="/WEB-INF/share/fenye.jsp"%>

<div class="modal fade" id="userToRoleModal">
<div class="modal-dialog" role="document">
      <form id="roomForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath}/admin/role/saveUserToRole">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用户授权</h4>
      </div>
      <div class="modal-body" >
   

          <div class="form-group" id="roleListModal">
           
        
      </div>
      <div class="modal-footer">
      <input  type="hidden" name="userid" id="userid">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button  type="submit" class="btn btn-primary" >确定</button>
      </div>
    </div>
    </form>
  </div>
  
  </div>
     
<script type="text/javascript">
	 

		function userToRole(id,page) {
		$("#userid").val(id);
		        $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/role/userToRoles",                                      
  		 dataType: "html",  
  		  data: {userid:id,page:page},
  		 success: function(html){  
              
  			 $("#roleListModal").empty();
  			 $("#roleListModal").append(html);
  			 
  		 } 
  		 });
		}
		
		 
  
             
	</script>
</div>
</body>
</html>
