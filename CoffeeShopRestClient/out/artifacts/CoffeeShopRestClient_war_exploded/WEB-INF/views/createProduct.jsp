<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<form action="/createProduct" method="post">
    <div class="row" style="margin-top: 5%;">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <input class="form-control" type="text" name="productName" placeholder="productName"/>
            <br/>
            <input class="form-control" type="text" name="description" placeholder="description"/>
            <br/>
            <input class="form-control" type="number" name="price" placeholder="price"/>
            <br/>
            <select name="productType">
                <option>
                    BREAKFAST
                </option>
                <option>
                    LUNCH
                </option>
                <option>
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
