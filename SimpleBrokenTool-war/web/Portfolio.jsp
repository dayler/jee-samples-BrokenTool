<%-- 
    Document   : Portfolio
    Created on : Oct 29, 2013, 9:34:53 PM
    Author     : ariel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolio</title>
    </head>
    <body>
        <table cellpadding='4' border='1'>
            <tr>
                <td>
                    <a href='CustomerDetails'>Customer Details</a>
                </td>
                <td>
                    <a href='CustomerController'>All Customers</a></td>
                <td>
                    <a href='Stocks.jsp'>Stocks</a>
                </td>
            </tr>
        </table>
        <br />

    <c:choose>
        <c:when test="${requestScope.message == null}">

            ${requestScope.customer.name}'s Stocks
            <br />

            <table border="1" cellpadding="4">
                <thead>
                    <tr>
                        <th>Stock Symbol</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="share" items="${requestScope.shares}">
                        <tr>
                            <td>${share.stockSymbol}</td>
                            <td>${share.quantity}</td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div style="color:red;">${requestScope.message}</div>    
        </c:otherwise>
    </c:choose>
    </body>
</html>
