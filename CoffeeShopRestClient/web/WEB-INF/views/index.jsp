<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 1:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
    <div class="row" style="margin-top: 5%">
        <div class="col-sm-3"></div>
        <div onclick="location.href='/persons'" class="col-sm-2" style="border: 1px solid black; padding: 10px">
            <p>
                <i style="font-size: 40px" class="fa fa-user"></i>
                Person
            </p>
        </div>
        <div onclick="location.href='/orders'"  class="col-sm-2" style="border: 1px solid black; padding: 10px">
            <p>
                <i style="font-size: 40px" class="fa fa-sellsy"></i>
                Orders
            </p>
        </div>
        <div onclick="location.href='/products'" class="col-sm-2" style="border: 1px solid black; padding: 10px">
            <p>
                <i style="font-size: 40px" class="fa fa-bullhorn"></i>
                Product
            </p>
        </div>
        <div class="col-sm-3"></div>
    </div>
</body>
</html>
