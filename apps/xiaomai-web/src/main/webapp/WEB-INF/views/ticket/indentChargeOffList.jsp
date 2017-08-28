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
              <h3 class="box-title">我的上月销售总金额(<a data-toggle="modal" data-target="#wordTypeModal"
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
                   <th width="10%">门票名称</th> 
                    <th width="10%">数量</th> 
                  <th width="10%">总金额</th> 
                   <th width="10%">核销时间</th> 
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td >${entry.resourceName }</td>
                   <td >${entry.numberOfPeople }</td>
                  <td >${entry.totalMoney }</td>
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
									<div class="input-group">
										<div class="input-group-addon">
											上月销售总金额（人名币）：<span id="money"></span>
										</div>
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
		location = "${basePath}/admin/ticket/indent/indentTotalList?pageNo="+page;
	}
	//上月核销单总金额统计
 	function queryPrice(){
	            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ticket/indent/indentTotal",                                      
  		 dataType: "json", 
  		 data:"" ,
  		 success: function(data){ 
  		 $("#money").text(data.total);
  		 if (data.flag==='true') {
					document.getElementById('Dbutton').style.display = 'none';
					$("#spanId").text("已提交，请耐心等待");
				} else {
					document.getElementById('Dbutton').style.display = '';
						$("#spanId").text("");
				}
  		 } 
  		 });
	}  
	
	
		
	function saveRecord() {
		var myDate = new Date();
		var date = myDate.getDate();
		if (date == 15 || date == 6) {
			var money = $("#money").text();
			$.ajax({
				type : "post",
				url : "${basePath}/admin/indent/withdrawalRecordList",
				dataType : "json",
				data : {
					money : money
				},
				success : function(data) {
					alert(data);
				}
			});
		} else {
			alert("请在每月5至6号申请提现！");
		}
	}
</script>
</body>

</html>
