<%--
  Created by IntelliJ IDEA.
  User: xuxiaoming
  Date: 13-1-8
  Time: 上午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>QuickStart示例:<sitemesh:title/></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <%--<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">--%>
    <link href="${ctx}/static/stylesheet/bootstrap.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/stylesheet/mystylesheet.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/static/stylesheet/bootstrap-responsive.css" type="text/css" />
    <link href="${ctx}/static/javascript/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
    <script src="${ctx}/static/javascript/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/static/javascript/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/javascript/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
    <script charset="utf-8" src="${ctx}/static/editor/kindeditor-4.1.5/kindeditor.js"></script>
    <script charset="utf-8" src="${ctx}/static/editor/kindeditor-4.1.5/lang/zh_CN.js"></script>
    <sitemesh:head/>

</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/admin_header.jsp"%>

        <sitemesh:body/>

    <%@ include file="/WEB-INF/layouts/footer.jsp"%>
</div>

</body>
</html>