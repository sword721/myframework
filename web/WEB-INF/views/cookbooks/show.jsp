<%--
  Created by IntelliJ IDEA.
  User: xuxiaoming
  Date: 13-3-11
  Time: 下午3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="row-fluid">
    ${cookbook.name}
    <img src="${ctx}/${cookbook.intro_img}" alt="">
    材料:
    <br/>
    ${cookbook.cookeryBook}
</div>