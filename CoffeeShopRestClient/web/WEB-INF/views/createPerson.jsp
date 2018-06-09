<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Person</title>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
    <form action="/createPerson" method="post">
        <div class="row" style="margin-top: 2%;">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <h2>Create Person</h2>
                <br/>
                <input class="form-control" type="text" name="firstName" placeholder="firstName" required/>
                <br/>
                <input class="form-control" type="text" name="lastName" placeholder="lastName" required/>
                <br/>
                <input class="form-control" type="text" name="email" placeholder="email" required/>
                <br/>
                <input class="form-control" type="text" name="address.city" placeholder="city" required/>
                <br/>
                <input class="form-control" type="text" name="address.country" placeholder="country" required/>
                <br/>
                <input class="form-control" type="text" name="address.state" placeholder="state" required/>
                <br/>
                <input class="form-control" type="text" name="address.zipcode" placeholder="zipcode" required/>
                <br/>
                <input class="form-control" type="number" name="phone" placeholder="phone" required/>
                <br/>
                <input type="radio" name="enable" value="true"/> Yes
                <input type="radio" name="enable" value="false"/> No
                <br/>
                <input type="submit" class="btn btn-success" style="float: right" value="Submit"/>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </form>
</body>
</html>
