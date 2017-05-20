<%@ page import="org.springframework.test.context.web.WebAppConfiguration" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.tz.ioc.core.KeKe" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/19
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 注：它必须要到 web.xml 进行注册。
    //1：web.xml进行注册
//    WebApplicationContext context = (WebApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    // 也可以通过它来 拿到 spring 容器。
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
    KeKe ke = (KeKe)context.getBean("keke");
    ke.responseAsk("讲课");
%>

<html>
<head>
    <title>容器</title>
</head>
<body>

    <h1>//</h1>
</body>
</html>
