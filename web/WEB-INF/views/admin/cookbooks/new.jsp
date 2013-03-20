<%--
  Created by IntelliJ IDEA.
  User: xuxiaoming
  Date: 13-3-7
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('#cookeryBook');
    });
</script>
<form id="inputForm" action="${ctx}/admin/cookbooks/create" method="post" enctype="multipart/form-data" class="form-horizontal">
    <fieldset>
        <legend><small>新增食谱</small></legend>
        <div class="control-group">
            <label for="name" class="control-label">名称:</label>
            <div class="controls">
                <input type="text" id="name" name="name" class="input-large required" minlength="3"/>
            </div>
        </div>
        <div class="control-group">
            <label for="intro" class="control-label">食谱简介:</label>
            <div class="controls">
                <input type="text" id="intro" name="intro" class="input-large required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="cookeryBook" class="control-label">烹饪说明:</label>
            <div class="controls">
                <textarea id="cookeryBook" name="cookeryBook" style="width:700px;height:300px;">

                </textarea>
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