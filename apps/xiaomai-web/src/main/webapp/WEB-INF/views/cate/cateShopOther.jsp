<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店管理</title> 
     
  <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$("#cateShopInfoForm").validate();
		});
	</script>
</head>

<body> 
 
  
 
      

	  
       
          
            <!-- /.box-header -->
            <!-- form start -->
            <form id="cateShopInfoForm" class="form-horizontal">
             <input type="hidden" name="parentid" value="${parentid }"/>
             <input type="hidden" name="page" value="${page }">
             <c:if test="${action=='update' }"><input type="hidden" name="id" value="${type.id}"/>
             </c:if>
             
              <div class="box-body">
                  
               
                  <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">人均消费：</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control required" id="consumption" name="consumption"  value="${cateShop.consumption }" placeholder="请输入人均消费">
                  </div>
                </div>
                
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">wifi：</label>

                  <div class="col-sm-8">
                     <div class="radio">
                    <label>
                      <input type="radio" name="wifi" id="wifi" value="1" checked>
                                             有
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="wifi" id="wifi2" value="0">
                      无
                    </label>
                  </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">营业时间：</label>

                  <div class="col-sm-8">
                     <div class="row">
                <div class="col-xs-4">
           <input type="text" placeholder="开始时间，如：10：00"  id="starttime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   ">
                </div>
                <div class="col-xs-4">
                 <input type="text" placeholder="结束时间，如：22：00"
																name="endtime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
                </div>
                 
              </div>
                  </div>
                  
                  
                </div>
                
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">停车位：</label>

                  <div class="col-sm-8">
                     <div class="radio">
                    <label>
                      <input type="radio" name="parkingSpace" id="parkingSpace" value="1" checked>
                                             有
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="parkingSpace" id="parkingSpace2" value="0">
                      无
                    </label>
                  </div>
                  </div>
                </div>
                 
                 
                
                 
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="button" class="btn btn-info pull-left"  onclick="inputVipForm()">提交</button>
              </div>
              <!-- /.box-footer -->
            </form>
           
 
 
           
       
      
      
      

      <script type="text/javascript">
	 

	 
  
            
            	 function  inputVipForm(){ 
		         var consumption=$("#consumption").val();  
          	 
             
               
                  var starttime=$("#starttime").val();
                  var endtime=$("#endtime").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/user/inputForm",                                      
  		 dataType: "text", 
  		   data: {name:userName,id:id},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		   $("#name_"+id).empty();  
  			  art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '提交成功，请等待审核！',
			    time: 3000
			});
          }else{
            art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '操作失败！',
			    time: 3000
			});
          }
  		  
          
  			 
  		 } 
  		 });
            } 
	</script>
      
  
    
    
</body>
</html>
