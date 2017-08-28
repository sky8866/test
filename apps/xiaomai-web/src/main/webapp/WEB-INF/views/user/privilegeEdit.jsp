<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="basePath" value="${pageContext.request.contextPath}" />
  <p>
               
           <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">
                                             <c:if test="${action=='update' }">修改权限</c:if>    
      <c:if test="${action=='save' }">添加权限 </c:if>
</h4>
                                        </div>
                                        <form class="form-horizontal" name="saveprivilege_form" id="saveprivilege_form" action="${basePath}/admin/privilege/${action}" method="post">
                                         <c:if test="${action=='update' }">
               <input type="hidden" name="aesid" value="${privilege.id }"  />
                </c:if>
                 <c:if test="${action!='update' }">
               <input type="hidden" name="parentid" id="parentid" value="${parentid }">
               </c:if>
                                        <div class="modal-body">
			 
			
			
  <div class="form-group">
    <label class="col-sm-2 control-label">上级名称:</label>
    <div class="col-sm-5">
     <input class="form-control" id="parent_name" type="text" value="${privilege_name }"  disabled>
    </div>
  </div>
  <div class="form-group">
    <label  class="col-sm-2 control-label">权限名称:</label>
    <div class="col-sm-5">
      <input type="text" placeholder="请输入名称" id="name" name="name" value="${privilege.name }" class="form-control required"/>
                                
    </div>
  </div>
  <%--  <div class="form-group">
    <label  class="col-sm-2 control-label">url:</label>
    <div class="col-sm-5">
      <input type="text" placeholder="请输入URL" id="action" name="action" value="${privilege.action }" class="form-control "/>
                                
    </div>
  </div> --%>
   <div class="form-group">
    <label  class="col-sm-2 control-label">权限值:</label>
    <div class="col-sm-5">
       <input type="text" placeholder="请输入权限值" id="privilegevalue" name="privilegevalue" value="${privilege.privilegevalue }" class="form-control required"/>
                                
    </div>
  </div>

			
		</div>
                                        <div class="modal-footer">
                                          <button type="reset" class="btn" data-dismiss="modal"  >取消</button>
                                              <button type="submit" class="btn btn-primary"  >确定</button>
              
                                        </div>
                                        </form>
                                    </div>
                                     
                                </div>  

                      </p>
                      
                      
                      
        <script>
		$(document).ready(function() {
			$("#saveprivilege_form").validate();
		});	 
	</script>
                         
                      