<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Person</title>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<form action="/editPerson" method="post">
    <div class="row" style="margin-top: 5%;">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <input type="hidden" name="id" value="${person.id}">
            <input class="form-control" type="text" name="firstName" value="${person.firstName}" placeholder="firstName"/>
            <br/>
            <input class="form-control" type="text" name="lastName" value="${person.lastName}" placeholder="lastName"/>
            <br/>
            <input class="form-control" type="text" name="email" value="${person.email}" placeholder="email"/>
            <br/>
            <input class="form-control" type="text" name="address.city" value="${person.address.city}" placeholder="city"/>
            <br/>
            <input class="form-control" type="text" name="address.country" value="${person.address.country}" placeholder="country"/>
            <br/>
            <input class="form-control" type="text" name="address.state" value="${person.address.state}" placeholder="state"/>
            <br/>
            <input class="form-control" type="text" name="address.zipcode" value="${person.address.zipcode}" placeholder="zipcode"/>
            <br/>
            <input class="form-control" type="text" name="phone" value="${person.phone}" placeholder="phone"/>
            <br/>
            <input type="radio" name="enable" value="true" ${person.enable ? 'checked' : ''}/> Yes
            <input type="radio" name="enable" value="false" ${!person.enable ? 'checked' : ''}/> No
            <br/>
            <input type="submit" class="btn btn-success" style="float: right" value="Submit"/>
        </div>
        <div class="col-sm-3"></div>
    </div>
</form>
</body>

</html>
