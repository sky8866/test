<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>门票订单核销</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="${basePath }/static/js/bootbox.min.js"></script>
	
</head>
		        	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">月结账单(<a data-toggle="modal" data-target="#wordTypeModal"
								href="###" onclick="queryPrice()">申请提现</a>)</h3>
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
                  <th width="10%">时间</th> 
                  <th width="10%">总金额</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td >${entry.createTime }</td>
                  <td >${entry.money }</td>
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
							<h4 class="modal-title">金额管理</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											可提现金额（人民币）：<span id="money"></span>
										</div>
										<form >
										<div class="input-group-addon">
											提取金额：<input value="0.00" type="text" id="withdrawalMoney">
										</div>
										</form>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
						<span id="spanId"></span>
							<input type="hidden" id="userid" name="userid">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button  id="Dbutton" type="button" class="btn btn-default"
								 onclick="saveRecord()">确定</button>
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
		location = "${basePath}/admin/ticket/indent/indentTotalList?pageNo="+page;
	}
	
	//得到金额
 	function queryPrice(){
	            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/withdrawalMoney/getWithdrawalMoney",                                      
  		 dataType: "json", 
  		 data:"" ,
  		 success: function(data){ 
  		 	$("#money").text(data.extractableMoney);
  		 } 
  		 });
	}  
	
	
		
	function saveRecord() {
		var withdrawalMoney=$("#withdrawalMoney").val()*1;
		var totalMoney=$("#money").text()*1;
		if (withdrawalMoney!=null && withdrawalMoney!=""&& withdrawalMoney!=0) {
		if(withdrawalMoney>totalMoney){
			alert("提取金额大于可提取金额，请重新输入！");
			return;
		}
			$.ajax({
				type : "post",
				url : "${basePath}/admin/indent/withdrawalRecordList",
				dataType : "json",
				data : {
					money : withdrawalMoney,
					totalMoney:totalMoney
				},
				success : function(data) {
					alert(data.message);
					$("#withdrawalMoney").val(0);
				},
				error: function(e) {
					alert(e.responseText);
				} 
			});
			
			$('#wordTypeModal').modal('hide')
		}
	}
	

	$("#withdrawalMoney").keyup(function() {
		var reg = $(this).val().match(/\d+\.?\d{0,2}/);
		var txt = '';
		if (reg != null) {
			txt = reg[0];
		}
		$(this).val(txt);
	}).change(function() {
		$(this).keypress();
		var v = $(this).val();
		if (/\.$/.test(v)) {
			$(this).val(v.substr(0, v.length - 1));
		}
	});
</script>
</body>

</html>
