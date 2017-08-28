<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />


 <form class="form-horizontal" action="${basePath}/web/register" name="regist_form" id="regist_form" method="post">   
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">快速注册</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
               
               <fieldset>
             
                                      <div class="form-group">
                        
                        <label for="groupName" class="col-sm-3 control-label">企业名称:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control required" id="groupName" name="groupName" placeholder="请输入企业名称">
    </div>
    
  </div>
            
          
                       
  
    
  
             
                 <div class="form-group">
                        
                        <label for="loginName" class="col-sm-3 control-label">手机:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control required" id="loginName" name="loginName" placeholder="请输入手机">
    </div>
    
  </div>          
                          
                        
                 <div class="form-group">
                        
                        <label for="username" class="col-sm-3 control-label">我的名字:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control required" id="name" name="name" placeholder="请输入我的名字">
    </div>
    
  </div>      
                
                         
                 <div class="form-group">
                        
                        <label for="plainPassword" class="col-sm-3 control-label">密码:</label>
    <div class="col-sm-5">
      <input type="password" class="form-control required" id="plainPassword" name="plainPassword" placeholder="请输入密码">
    </div>
    
  </div>           
                        <div class="form-group">
                        
                        <label for="confirmPassword"" class="col-sm-3 control-label">确认密码:</label>
    <div class="col-sm-5">
      <input type="password" class="form-control required" id="confirmPassword" name="confirmPassword" equalTo="#plainPassword" placeholder="请确认密码">
    </div>
    
  </div>
     <div class="form-group">
                        
                        <label for="regist_gender"" class="col-sm-3 control-label">性别:</label>
    <div class="col-sm-5">
        
                                    <input type="radio" name="gender" value="1"  checked="checked"/>男
                                
                                    <input type="radio" name="gender" value="0" />女
                               
    </div>
    
  </div>

                    </fieldset>
                    
            </div>
             
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="submit"  class="btn btn-primary" form="regist_form">确定</button>
      </div>
      
    </div>
  </div>
     
    </form>      


 
             
             
             
             <script type="text/javascript">
$(document).ready(function() {
	 // 手机号码验证      
	  jQuery.validator.addMethod("ismaxlength", function(value, element) {    
	      var i,sum;
	      sum=0;
	      for(i=0;i<value.length;i++) { 
	        if ((value.charCodeAt(i)>=0) && (value.charCodeAt(i)<=255)) {
	          sum=sum+1;
	        }else {
	          sum=sum+2;
	        }
	      }
	      return this.optional(element) || (sum <=38);      
	  }, "名字最多只能中文5个字，英文38个字符！"); 
	  
	  jQuery.validator.addMethod("isMobile", function(value, element) {      
	      var length = value.length;  
	      var mobile = /^(((13[0-9]{1})|(14[5,7])|(15[0-9]{1})|(17[6,8])|(18[0-9]{1}))+\d{8})$/;  
	      return this.optional(element) || (length == 11 && mobile.test(value));      
	  }, "请正确填写您的手机号码！");
	  
	  jQuery.validator.addMethod("isChineseChar",function(value, element){
	  	  var reg = /[\u4E00-\u9FA5\uF900-\uFA2D]/;
	  	  return this.optional(element) || (!reg.test(value));
	  },"不能含有中文字符！");
	  
	  jQuery.validator.addMethod("isTrimChar",function(value, element){
	      var reg = /([ ]+)/g;
	  	  return this.optional(element) || (!reg.test(value));
	  },"不能含有空格字符！");
});
</script>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#groupName").focus();
			//为inputForm注册validate函数
			$("#regist_form").validate({
				rules: {
					 
					loginName: { 
					remote: "${basePath}/web/register/checkAccount",
					    isMobile:true 
					}
				},
				messages: {
					 
					loginName: {
						 
						remote: "手机号已存在", 
					    isMobile:"手机号格式不对！"
				 
					}
				}
			});
		});
		

	</script>