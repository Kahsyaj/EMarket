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
    <title><s:text name="update_product.title"/></title>
</head>
<body>
<s:include value="../header.jsp"/>
    <h1><s:text name="update_product.title"/></h1>

    <s:form action="update_product">
        <s:textfield name="product.label" key="create_product.label.field" requiredLabel="true" />
        <s:textfield name="product.price" key="create_product.price.field" requiredLabel="true" />
        <s:hidden name="product.id"/>

        <s:submit key="update.form.validate"/>
    </s:form>
</body>
</html>
