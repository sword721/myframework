<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    $('document').ready(function(){

    });

</script>

<div class="row-fluid">

        <div class="span3">

        </div>
    <c:forEach items="${cookbooks}" var="cookbook">
        <div class="span2">
            ${cookbook.name}
            <a href="${ctx}/cookbooks/show/${cookbook.id}">
                <img src="${ctx}/${cookbook.intro_img}" alt="" />
            </a>

        </div>
    </c:forEach>
</div>
