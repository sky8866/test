<%@ page language="java" pageEncoding="UTF-8"%>

 

<nav class="text-right">
  <ul class="pagination">
    <li  <c:if test="${pageView.currentpage==pageView.pageindex.startindex}">  class="disabled"  </c:if>>
      
      
     <a href="javascript:topage('${pageView.pageindex.startindex}')" aria-label="Previous">
        <span aria-hidden="true">首页</span>
      </a> 
      
      
      
    </li>
    
      <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
    <c:if test="${pageView.currentpage==wp}"> <li class="active"><a >${wp}</a></li></c:if>
    <c:if test="${pageView.currentpage!=wp}"> <li><a href="javascript:topage('${wp}')">${wp}</a></li></c:if>
</c:forEach>
    
    <li <c:if test="${pageView.currentpage==pageView.pageindex.endindex}">  class="disabled"  </c:if>>
        <a href="javascript:topage('${pageView.pageindex.endindex}')" aria-label="Next">
        <span aria-hidden="true">尾页</span>
      </a> 
      
    </li>
  </ul>
</nav>