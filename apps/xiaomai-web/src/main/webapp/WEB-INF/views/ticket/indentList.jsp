<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>门票订单管理</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/js/bootbox.min.js"></script>
	
</head>
		        	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">订单管理</h3>
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
           
            </div>
            <!-- /.box-body -->
            
             <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                  <th width="10%">用户名称</th> 
                  <th width="10%">用户电话</th> 
                  <th width="10%">购票时间</th> 
                  <th width="10%">使用时间</th> 
                   <th width="10%">门票名称</th> 
                    <th width="10%">数量</th> 
                  <th width="10%">总金额</th> 
                  <th width="10%">状态</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td >${entry.userName }</td>
                  <td >${entry.userPhone }</td>
                  <td >${entry.createTime }</td>
                  <td >${entry.serviceTime }</td>
                  <td >${entry.resourceName }</td>
                   <td >${entry.numberOfPeople }</td>
                  <td >${entry.totalMoney }</td>
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
						<td colspan="9"><div align="center">暂无数据！</div>
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
		location = "${basePath}/admin/ticket/indent/indentList"?pageNo="+page;
	}
/* 	function query(page,status){
		location = "${basePath}/admin/custom/indent/indentList?page="+page+"&status="+status;
	} */

	</script>
</body>

</html>
