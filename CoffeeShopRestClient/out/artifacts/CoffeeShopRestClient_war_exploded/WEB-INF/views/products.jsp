<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 2:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="row" style="margin-top: 5%">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <a href="/createProduct" style="float: right"><img height="80px" width="80px" src="/resources/images/new_4.png"/></a>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="prod">
                <tr>
                    <td>${prod.id}</td>
                    <td>${prod.productName}</td>
                    <td>${prod.description}</td>
                    <td>${prod.price}</td>
                    <td>
                        <a href="#"><img height="23px" width="23px"  src="/resources/images/Edit-validated-icon.png"></a>
                        <a href="#"><img height="23px" width="23px"  src="/resources/images/Delete_Icon.png"></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>

</body>
</html>
