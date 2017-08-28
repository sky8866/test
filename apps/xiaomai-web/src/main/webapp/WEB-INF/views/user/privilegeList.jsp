<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title1> </title1> 
     

 

</head>

<body> 
 
            
                     
                  <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="27%">权限名</th>
                                            <th width="27%">父权限名</th>
                                            <th width="27%">权限值</th>
                                            <th width="19%">操作</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <c:choose>
			<c:when test="${!empty pageView.records }">
   <c:forEach items="${pageView.records}" var="entry" varStatus="statu">
     
                                      <tr >
                                            <td>${entry.name }</td>
                                             <td>${entry.parent.name }</td>
                                            <td>${entry.privilegevalue }</td> 
                                            <td class="center">
                                            <c:if test="${empty entry.parent }">
                                            <a href="#privilegeModal"  data-target="#privilegeModal"   data-toggle="modal" onclick="inputPrivilege('save','${entry.id}')">添加子权限</a>|
                                            </c:if>
                                            <a href="#privilegeModal"  data-target="#privilegeModal"   data-toggle="modal" onclick="inputPrivilege('update','${entry.id}')">修改权限</a>
                                            </td> 
                                        </tr>
                                        
                                         </c:forEach>
                                         
                                          

    </c:when>
				<c:otherwise>
				 	 
				 <tr>
      <td colspan="4" ><div align="center"> 暂无数据！ </div></td>
       
    </tr> 
				 </c:otherwise>
				</c:choose>
                                    </tbody>
                                </table>
      <%@include file="/WEB-INF/share/fenye.jsp" %>    
</body>
</html>
