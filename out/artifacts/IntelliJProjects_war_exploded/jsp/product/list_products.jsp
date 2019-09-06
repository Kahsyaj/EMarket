<%--
  Created by IntelliJ IDEA.
  User: mahsyaj
  Date: 06/09/2019
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="list_products.title"/></title>
</head>
<body>
<s:include value="../header.jsp"/>
    <h1><s:text name="list_products.title"/></h1>

<s:form action="list_products" method="GET">
    <s:textfield name="filter"/>

    <s:submit key="search.label"/>
</s:form>

    <ul>
        <s:iterator value="products">
            <li>
                <s:a action="list_products">
                    <s:param name="id" value="id" />
                    <s:property value="id" /> - <s:property value="label"/> - <s:property value="price"/>
                </s:a>
                <button><s:a action="delete_product">
                    <s:text name="delete.button"/>
                    <s:param name="id" value="id" />
                </s:a></button>
                <button><s:a action="update_product">
                    <s:text name="update_product.title"/>
                    <s:param name="id" value="id" />
                </s:a></button>
            </li>
        </s:iterator>
    </ul>
</body>
</html>
