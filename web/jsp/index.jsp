<%--
  Created by IntelliJ IDEA.
  User: mahsyaj
  Date: 03/09/2019
  Time: 09:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="index.title"/></title>
</head>
<body>
    <s:include value="header.jsp"/>
    <h1><s:text name="index.title"/></h1>

    <button><s:a action="admin_form"><s:text name="admin.title"/></s:a></button>
    <button><s:a action="list_products"><s:text name="list_products.title"/></s:a></button>

<footer>
    <s:a action="index">
        <s:param name="request_locale">en</s:param>
        [English]
    </s:a>
    <s:a action="index">
        <s:param name="request_locale">fr</s:param>
        [Français]
    </s:a>
</footer>
</body>
</html>
