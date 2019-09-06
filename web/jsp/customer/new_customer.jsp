<%--
  Created by IntelliJ IDEA.
  User: mahsyaj
  Date: 06/09/2019
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="create_customer.title"/></title>
</head>
<body>
<s:include value="../header.jsp"/>
    <s:actionerror/>
    <s:actionmessage/>
    <h1><s:text name="create_customer.title"/></h1>

    <s:form action="create_customer">
        <s:textfield name="customer.name" key="create_customer.name.field" requiredLabel="true" />
        <s:textfield name="customer.email" key="create_customer.email.field" requiredLabel="true" />
        <s:textfield name="customer.password" key="create_customer.password.field" requiredLabel="true" />

        <s:submit key="create.form.validate"/>
    </s:form>

</body>
</html>
