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
<form action="${ctx}/admin/cookbooks/update" method="post">
    <fieldset>
        <legend><small>新增食材</small></legend>
        <div class="control-group">
            <label for="name" class="control-label">名称:</label>
            <div class="controls">
                <input type="text" id="name" name="name" class="input-large required" minlength="3"/>
            </div>
        </div>
        <div class="control-group">
            <label for="intro" class="control-label">食材简介:</label>
            <div class="controls">
                <input type="text" id="intro" name="intro" class="input-large required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="materialUnit" class="control-label">计价单位</label>
            <div class="controls">
                <input type="text" id="materialUnit" name="materialUnit" class="input-small" />
            </div>
        </div>
        <div class="control-group">
            <label for="materialNumber" class="control-label">库存:</label>
            <div class="controls">
               <input type="text" id="materialNumber" name="materialNumber" class="input-small" />
            </div>
        </div>
        <div class="control-group">
            <label for="warnNumber" class="control-label">库存报警数量:</label>
            <div class="controls">
                <input type="text" id="warnNumber" name="warnNumber" class="input-small" />
            </div>
        </div>
        <div class="control-group">
            <label for="marketPrice" class="control-label">市场定价:</label>
            <div class="controls">
                <input type="text" id="marketPrice" name="marketPrice" class="input-small" />
            </div>
        </div>
        <div class="control-group">
            <label for="intro_image" class="control-label">介绍图片:</label>
            <div class="controls">
                <input type="file" id="intro_image" name="intro_image" class="input-large required" />
            </div>
        </div>
        <div class="form-actions">
            <input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;
            <input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
        </div>
    </fieldset>
</form>