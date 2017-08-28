<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>订单核销</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/js/bootbox.min.js"></script>
	
</head>
		        	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">我的上月销售总金额</h3>
            </div>
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" id="quilvQuery" style="margin: 10px;">
           
            </div>
            <!-- /.box-body -->
            
             <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                   <th width="10%">玩法名称</th> 
                    <th width="10%">人量</th> 
                  <th width="10%">总金额</th> 
                   <th width="10%">核销时间</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td >${entry.playName }</td>
                   <td >${entry.numberOfPeople }</td>
                  <td >${entry.totalPrices }</td>
                  <td >${entry.chargeTime }</td>
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
              
              
              
              <div class="modal fade" id="wordTypeModal">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">申请提现(每月5,6号)</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal">
								<div class="form-group">
										<div class="input-group-addon">
											上月销售总金额（人名币）：<span id="money"></span>
										</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
						<span id="spanId"></span>
							<input type="hidden" id="userid" name="userid">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button id="Dbutton" type="button" class="btn btn-default"
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
		location = "${basePath}/admin/custom/indent/indentTotalList?pageNo="+page;
	}


</script>
</body>

</html>
