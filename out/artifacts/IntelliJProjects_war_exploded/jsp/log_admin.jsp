<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsyaj
  Date: 06/09/2019
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="admin.title"/></title>
</head>
<body>
<s:include value="header.jsp"/>
<h1><s:text name="admin.title"/></h1>

    <s:form action="log_admin">
        <s:textfield name="pseudo" key="admin.pseudo.field" requiredLabel="true" />
        <s:textfield name="password" key="admin.password.field" requiredLabel="true" />

        <s:submit key="login.button"/>
    </s:form>
</body>
</html>
