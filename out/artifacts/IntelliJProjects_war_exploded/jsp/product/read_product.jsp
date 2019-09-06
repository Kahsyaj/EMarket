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
    <title><s:text name="read_product.title"/></title>
</head>
<body>
<s:include value="../header.jsp"/>
    <s:actionmessage />
    <h1><s:text name="read_product.title"/></h1>

    <ul>
        <li><s:text name="read_product.attribute.id"/> : <s:property value="product.id" /></li>
        <li><s:text name="read_product.attribute.label"/> : <s:property value="product.label" /></li>
        <li><s:text name="read_product.attribute.price"/> : <s:property value="product.price" /></li>
    </ul>

</body>
</html>
