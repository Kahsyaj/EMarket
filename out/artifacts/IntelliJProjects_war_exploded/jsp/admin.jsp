<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsyaj
  Date: 06/09/2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:include value="header.jsp"/>
    <h1><s:text name="admin.title"/></h1>

    <button><s:a action="new_customer"><s:text name="create_customer.title"/></s:a></button>
    <button><s:a action="new_product"><s:text name="create_product.title"/></s:a></button>
    <button><s:a action="list_customers"><s:text name="list_customers.title"/></s:a></button>
    <button><s:a action="list_products"><s:text name="list_products.title"/></s:a></button>

</body>
</html>
