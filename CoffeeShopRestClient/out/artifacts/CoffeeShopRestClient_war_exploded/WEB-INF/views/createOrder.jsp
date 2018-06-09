<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aimal
  Date: 6/8/2018
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
          rel="stylesheet">

    <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />"
          rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>

    <script src="<c:url value="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.js" />"></script>

    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript"
            src="<c:url value="/resources/js/moment-with-locales.js" />"></script>
    <script type="text/javascript"
            src="<c:url value="/resources/js/bootstrap-datetimepicker.js" />"></script>
    <link rel="stylesheet"
          href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css" />"/>
    <script type="text/javascript"
            src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>

</head>
<body>
<div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-3" id="cartItems">
        <br/><br/>
        <h2>Cart Items:</h2>
    </div>
    <div class="col-sm-7">
        <form action="/createOrder" method="post">
            <br/><br/>
            <h2>Create Order</h2>
            <div class="form-group">
                <h3>DateTime:</h3>
                <br/>
                <div class='input-group date' id='datetimepicker1'>
                    <input name="txtDT" type='text' class="form-control" required/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            <div>
                <h3>
                    OrderLine
                </h3>
                <br/>
                <table id="example" class="display" style="width:100%">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="prod">
                        <tr>
                            <td>${prod.productName}</td>
                            <td>${prod.description}</td>
                            <td>${prod.price}</td>
                            <td>
                                <a href="#" onclick="addToCart('${prod.id}', '${prod.productName}', '${prod.price}', '${prod.description}', '${prod.productType}')"><img height="33px" width="33px" src="/resources/images/cart.png"></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <h3>
                    Person
                </h3>
                <br/>
                <select name="ddlPerson" class="form-control"  required>
                   <c:forEach items="${persons}" var="person">
                       <option value="${person.id}">${person.lastName}, ${person.firstName}</option>
                   </c:forEach>
                </select>
                <br/>
                <input style="float: right" type="submit" value="Create Order" class="btn btn-success">
            </div>
        </form>
    </div>
    <div class="col-sm-1"></div>
</div>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker();
        $('#example').DataTable();
    });

    function addToCart(prodId, prodName, prodPrice, prodDesc, prodType) {

        var product = {
            'id' : prodId,
            'productName' : prodName,
            'price' : prodPrice,
            'description' : prodDesc,
            'productType' : prodType
        };

        $.ajax({
            url: '/addProductToCart',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(product)
        });

        $('#cartItems')
            .append($('<p>', {
                'text' : prodName + '........' + prodPrice
            }));
    }
</script>
</body>
</html>
