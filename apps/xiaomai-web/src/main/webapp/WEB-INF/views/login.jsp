<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
    
             
             
             
     <form class="form-horizontal" action="${basePath}/web/login" id="login_form" name="login_form" method="post">   
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">登录</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
               
               <fieldset>
             
                               
                         
                        
                                
                        <div class="form-group">
                        
                        <label for="username" class="col-sm-3 control-label">手机号:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control required" id="username" name="username" placeholder="请输入手机号">
    </div>
    
  </div>
                       
                        
                        <div class="form-group">
                        
                        <label for="password"" class="col-sm-3 control-label">密码:</label>
    <div class="col-sm-5">
      <input type="password" class="form-control required" id="password" name="password" placeholder="输入密码">
    </div>
    
  </div>

                    </fieldset>
                    <button type="button" class="btn btn-link" onclick="showLossPasswordModel()" style="margin-left: 280px;" ><i class="icon-info-sign"></i> 忘记密码 </button>
            </div>
             
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="submit"  class="btn btn-primary" form="login_form">确定</button>
      </div>
      
    </div>
  </div>
     
    </form>          
             
             
       <script>
		$(document).ready(function() {
			$("#login_form").validate();
		});




		 
	</script>