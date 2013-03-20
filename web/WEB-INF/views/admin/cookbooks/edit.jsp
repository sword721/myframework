<%--
  Created by IntelliJ IDEA.
  User: xuxiaoming
  Date: 13-3-7
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<form id="inputForm" action="${ctx}/admin/cookbooks/update" method="post" class="form-horizontal">
    <input type="hidden" name="id" value="${cookbook.id}"/>
    <fieldset>
        <legend><small>更新食谱</small></legend>
        <div class="control-group">
            <label for="name" class="control-label">名称:</label>
            <div class="controls">
                <input type="text" id="name" name="name" value="${cookbook.name}" class="input-large required" minlength="3"/>
            </div>
        </div>
        <div class="control-group">
            <label for="intro" class="control-label">食谱简介:</label>
            <div class="controls">
                <input type="text" id="intro" name="intro" value="${cookbook.intro}" class="input-large required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="cookbookMaterials" class="control-label">材料:</label>
            <div class="controls">
                <input type="text" id="cookbookMaterials" name="cookbookMaterials" value="" class="input-large required" />
            </div>
        </div>
        <div class="control-group">
            <label for="cookeryBook" class="control-label">烹饪说明:</label>
            <div class="controls">
                <input type="text" id="cookeryBook" name="cookeryBook" value="${cookbook.cookeryBook}"
                       class="input-large required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="intro_img" class="control-label">介绍图片:</label>
            <div class="controls">
                <img src="${ctx}/${cookbook.intro_img}" alt="" />
                <input type="text" id="intro_img" name="intro_img" class="input-large required" equalTo="#plainPassword"/>
            </div>
        </div>
        <div class="form-actions">
            <input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;
            <input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
        </div>
    </fieldset>
</form>