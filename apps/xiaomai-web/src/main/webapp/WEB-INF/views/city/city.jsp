<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
 <select class="form-control" name="city" onchange="districtSelect(this.value)">
 <c:forEach items="${cityList}" var="e">
  <option value="${e.citycode }" <c:if test="${e.citycode==citycode }"> selected</c:if> >${e.cityname }</option>
</c:forEach>
</select>

    <input type="hidden" id="citycode"    value="${citycode }"  > 