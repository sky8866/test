<%@ page language="java" pageEncoding="UTF-8" %>
 
  <div class="row" style="display:none;" id="touserModal"> 
  
  </div>
   
        	<div class="modal fade" id="delModal"> 
      <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">确认删除！</h4>
      </div>
      <div class="modal-body">
       <input type="hidden" id="delId">
       <input type="hidden" id="delUrl">
         确定要删除吗?
           
            
      </div>
      <div class="modal-footer">
     
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="dish_button"  onclick="goDels()"  class="btn btn-default"  data-dismiss="modal"  form="del_form" >确定</button>
      </div>
      
    </div>
  </div>
            </div>


    <!-- Bootstrap Core JavaScript -->
    <script src="${basePath}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    
<!-- Morris.js charts -->
<script src="${basePath}/static/js/raphael-min.js"></script>
<script src="${basePath}/static/lte/morris/morris.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="${basePath}/static/lte/js/app.min.js"></script>  
     
<script src="${basePath}/static/lte/js/demo.js"></script>
    <script src="${basePath}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${basePath}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
		<script src="${basePath}/static/artDialog/jquery.artDialog.min.js"></script>
<script src="${basePath}/static/artDialog/artDialog.min.js"></script>
<script src="${basePath}/static/artDialog/artDialog.plugins.min.js"></script>
	
	     
     <script type="text/javascript">
        
               function goDels(){
      		      var id=$("#delId").val();  
                  var delUrl=$("#delUrl").val();  
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}"+delUrl,                                      
  		 dataType: "text", 
  		   data: {id:id},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 $("#del_"+id).empty();  
  			  art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '删除成功！',
			    time: 3000
			});
			
          }else{
            art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '删除失败！',
			    time: 3000
			});
          }
  		  
          
  			 
  		 } 
  		 });
       
       }
	   </script>
	
 
              	<c:if test="${!empty  message}"> 
	<script type="text/javascript">
		$(function(){
			 art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '${message }',
			    time: 3000
			});
		});
		
		
	</script> 
	<% request.getSession().removeAttribute("message");%>
</c:if>  
 

 