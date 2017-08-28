<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
 <select class="form-control" name="district">
 <c:forEach items="${districtList}" var="e">
  <option  value="${e.districtcode }"<c:if test="${e.districtcode==districtcode }"> selected</c:if> >${e.districtname }</option>
</c:forEach>
</select>