<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>提现记录</title>


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
            <button type="button" onclick="updateStatus(2)"  class="btn btn-default btn-sm">审核通过</button>
             <button type="button" onclick="updateStatus(3)"  class="btn btn-default btn-sm">审核不通过</button>
              <button type="button" onclick="updateStatus(4)"  class="btn btn-default btn-sm">已打款</button>
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
                   <th width="10%">提现时间</th> 
                    <th width="10%">提现金额</th> 
                    <th width="10%">提现状态</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
              	 <td>
                <div class="checkbox"   >
					<label >
						<input type="checkbox" value="${entry.id }" data-value="${entry.status}" name="entryId"> 
					</label>
				</div>
				</td>
                  <td>${statu.count }</td>
                  <td >${entry.withdrawalTime }</td>
                   <td >${entry.money }</td>
                  <td ><c:if test="${entry.status==1 }">审批中 </c:if>
                  <c:if test="${entry.status==2 }">审批通过 </c:if>
                   <c:if test="${entry.status==3 }">审批不通过 </c:if>
                   <c:if test="${entry.status==4 }">已打款 </c:if>
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
	
		//上月核销单总金额统计
 	function queryIndent(){

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
		var val = "";
		var tempStatus = "";//状态
		$('input[name="entryId"]:checked').each(function() {
			val = $(this).val();
			tempStatus = $(this).data("value");
			if (status == 4) {
				if (tempStatus != 2) {
					return;
				}
			}
			chk_value.push(val);
		});

		var ids = chk_value + "";
		if (chk_value.length == 0) {
			alert("你还没有选择任何内容！");
			return;
		}

		else {
			if (confirm("确定吗？") == true) {
				$.ajax({
							type : "post",
							url : "${basePath}/admin/indent/updateWithdrawalRecordStatus",
							dataType : "json",
							data : {
								ids : ids,
								status : status
							},
							success : function(data) {
								alert(data.msg);
								location = "${basePath}/admin/indent/getPageWithdrawalRecord?pageNo=1";
							}
						});
			} else {
				return false;
			}

		}
	}
</script>
</body>

</html>
