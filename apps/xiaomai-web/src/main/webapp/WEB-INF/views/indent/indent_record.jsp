<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>订单</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/js/bootbox.min.js"></script>
	
</head>
		        	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" id="quilvQuery" style="margin: 10px;">
           
            </div>
            <!-- /.box-body -->
            
             <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                   <th width="10%">时间</th> 
                    <th width="10%">人数</th> 
                  <th width="10%">金额</th> 
                   <th width="10%">用户</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td >${entry.withdrawalTime }</td>
                   <td >${entry.money }</td>
                  <td >${entry.userId }</td>
                  <td >${entry.status }</td>
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
              
              
              
              <div class="modal fade" id="indentModal">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">订单</h4>
						</div>
						<div class="modal-body">
						
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="saveRecord()">确定</button>
						</div>

					</div>
				</div>

				<script type="text/javascript">
	 
	</script>
</div>




          </div>
          <!-- /.box -->
        </div>
      </div>
<script type="text/javascript">
		//到指定的分页页面
	function topage(page){
		location = "${basePath}/admin/indent/getPageWithdrawalRecord?pageNo="+page;
	}

	
		
	
</script>
</body>

</html>
