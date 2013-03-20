<%--
  Created by IntelliJ IDEA.
  User: xuxiaoming
  Date: 13-3-1
  Time: 下午5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row banner">
    <div class="span12">
        <div class="row">
            <div class="span2">
                <a href="#" class="logo">
                    <img src="${ctx}/static/imgs/logo.png" alt="">
                </a>
            </div>
            <div class="span10">
                <ul class="nav nav-tabs">
                    <li class="dropdown"><a href="/admin/users">用户管理</a></li>
                    <li class="dropdown"><a href="/admin/cookbooks">食谱管理</a></li>
                    <li class="dropdown"><a href="/admin/cookmaterials">食材管理</a></li>
                    <li class="dropdown"><a href="/admin/orders">订单管理</a></li>
                    <li class="dropdown"><a href="#">系统设置</a></li>
                    <%--<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Services<b--%>
                    <%--class="caret"></b></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<li class="dropdown"><a href="#">食谱大全</a></li>--%>
                    <%--<li class="dropdown"><a href="#">我的配菜</a></li>--%>
                    <%--<li class="dropdown"><a href="#">关于我们</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <li class="dropdown visible-phone"><a href="tel:1234567890"><i class="icon-phone"></i> 123-456-7890</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>