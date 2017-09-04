<%--
  Created by IntelliJ IDEA.
  User: steven
  Date: 04/09/17
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="edu.ap.ProductRegistration.ProductRegistrationClient" %>
<%@page import="org.json.simple.*"%>
<%@ page import="org.restlet.resource.ClientResource" %>
<%
    JSONArray arr = new JSONArray();
    arr = ProductRegistrationClient.getProducts();



%>

<html>
<head>
    <title>List products</title>
</head>
<body>
<h2>Products</h2>

<table>
    <th>Name</th>
    <th>Producer</th>
    <th>Price</th>

<%
    for (Object o : arr) {

        JSONObject object = (JSONObject) o;
        System.out.println("<tr><td>" + object.get("Name") + "</td><td>" + object.get("producer") + "</td><td>" + object.get("price").toString() + "</td></tr>");

    }

%>
</table>
</body>
</html>
