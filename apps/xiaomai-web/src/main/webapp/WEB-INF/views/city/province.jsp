<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
    <select class="form-control"  name="province"   onchange="citySelect(this.value)"    >
 <c:forEach items="${provinceList}" var="e">
  <option value="${e.provincecode }"  <c:if test="${e.provincecode==provincecode }"> selected</c:if> >${e.provincename }</option>
</c:forEach>
 
</select>
   