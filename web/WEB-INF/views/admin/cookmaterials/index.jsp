<%--
  Created by IntelliJ IDEA.
  User: xuxiaoming
  Date: 13-3-12
  Time: 上午9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
<div class="row-fluid">
    <div class="span4 offset7">
        <form class="form-search" action="#">
            <label>名称：</label> <input type="text" name="search_LIKE_name" class="input-medium" value="${param.search_LIKE_name}">
            <button type="submit" class="btn" id="search_btn">Search</button>
        </form>
    </div>
    <tags:sort/>
    <div class="row-fluid">
        食材管理
        <a href="/admin/cookmaterials/new" class="btn btn-primary">新增食材</a>
    </div>
    <div>
        <table class="table">
            <tbody>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${cookMaterials.content}" var="cookbook">
                <tr>
                    <td><a href="${ctx}/admin/cookMaterials/update/${cookMaterial.id}">${cookMaterial.name}</a></td>
                    <td>${cookMaterial.createdAt}</td>
                    <td><a href="#" class="btn btn-danger">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <tags:pagination page="${cookMaterials}" paginationSize="5"/>
</div>
