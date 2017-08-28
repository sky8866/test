<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>广告管理</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/js/bootbox.min.js"></script>
	
</head>

		        	<div class="row " style="margin-bottom: 10px;">
	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">广告列表</h3>
    
            </div>
               <div class="box-footer">
                <a href="${basePath}/admin/advertising/skipSaveOrUpdateAdvertising" class="btn btn-primary ">添加广告</a>
             </div>
          
             
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" id="quilvQuery" style="margin: 10px;">
           
            </div>
            <!-- /.box-body -->
            
             <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                  <th width="10%">模块</th> 
                  <th width="15%">类型</th>
                   <th width="40%">内容</th> 
                  <th width="10%">是否显示</th>
                  <th width="15%">操作</th>
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                   <td >
                   <c:forEach items="${sort }" var="sr">
						<c:if test="${sr.key==entry.sort}">${sr.value}</c:if>
					</c:forEach>
                   </td>
                   
                    <td >
                   <c:forEach items="${type }" var="tp">
						<c:if test="${tp.key==entry.type}">${tp.value}</c:if>
					</c:forEach>
                   </td>
                   <td >${entry.content }</td>
                  <td >
                  <c:if test="${1==entry.flag}">是</c:if>
                  <c:if test="${0==entry.flag}">否</c:if>
                  </td>
                   <td >
                   <a href="${basePath}/admin/advertising/skipSaveOrUpdateAdvertising?id=${entry.id}">修改</a>
                   &nbsp;
                   <a href="javascript:void(0)" onclick="del(${entry.id})">删除</a>
                   </td>
                  <td >
                   <c:forEach var="var" items="${indentStatus}" >
						<c:if test="${var.key==entry.status}">${var.value}</c:if>
					</c:forEach>
					</td>
                </tr>
                  	</c:forEach>
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
		location = "${basePath}/admin/advertising/list?pageNo="+page;
	}
	
	//删除
	function del(id){
	 if (confirm("确定吗？")==true){ 
 	 	location ="${basePath}/admin/advertising/deleteAdvertising?id="+id;
 	 }else{ 
 		 return false; 
 	 } 
	}
	</script>
</body>

</html>
