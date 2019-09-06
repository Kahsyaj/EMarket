<%--
  Created by IntelliJ IDEA.
  User: mahsyaj
  Date: 06/09/2019
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="read_customer.title"/></title>
</head>
<body>
<s:include value="../header.jsp"/>
    <s:actionmessage />
    <h1><s:text name="read_customer.title"/></h1>

    <ul>
        <li><s:text name="read_customer.attribute.id"/> : <s:property value="customer.id" /></li>
        <li><s:text name="read_customer.attribute.name"/> : <s:property value="customer.name" /></li>
        <li><s:text name="read_customer.attribute.email"/> : <s:property value="customer.email" /></li>
    </ul>

</body>
</html>
