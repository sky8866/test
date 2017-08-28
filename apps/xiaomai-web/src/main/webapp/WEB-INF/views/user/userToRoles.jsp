<%@ page contentType="text/html;charset=UTF-8"%>
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
  
  
  <p>
  
            <label for="recipient-name" class="control-label">权限组:</label>
          <div class="row">
           <c:forEach items="${roles}" var="entry"  >
                <div class="col-xs-4">
                
                    <input type="checkbox" <c:if test="${entry.userId==userid }">checked</c:if> name="roleid" value="${entry.id  }"> ${entry.rolename  } 
                </div>
             
              </c:forEach> 
              </div>
      

 </p>
