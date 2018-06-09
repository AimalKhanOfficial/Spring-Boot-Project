<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<form action="/editProduct" method="post">
    <div class="row" style="margin-top: 2%;">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <h2>Edit Product</h2>
            <br/>
            <input type="hidden" name="id" value="${product.id}">
            <input class="form-control" type="text" name="productName" value="${product.productName}" placeholder="productName" required/>
            <br/>
            <input class="form-control" type="text" name="description" value="${product.description}" placeholder="description" required/>
            <br/>
            <input class="form-control" type="number" name="price" value="${product.price}" placeholder="price" required/>
            <br/>
            <select name="productType">
                <option ${product.productType == "BREAKFAST" ? 'selected' : ''}>
                    BREAKFAST
                </option>
                <option ${product.productType == "LUNCH" ? 'selected' : ''}>
                    LUNCH
                </option>
                <option ${product.productType == "DINNER" ? 'selected' : ''}>
                    DINNER
                </option>
            </select>
            <br/>
            <input type="submit" class="btn btn-success" style="float: right" value="Submit"/>
        </div>
        <div class="col-sm-3"></div>
    </div>
</form>
</body>
</html>
