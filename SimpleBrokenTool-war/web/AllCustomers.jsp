<%-- 
    Document   : AllCustomers
    Created on : Oct 28, 2013, 12:52:13 AM
    Author     : ariel
--%>

<%@page import="trader.Customer"%>
<%@page import="trader.web.CustomerController" %>
<%@page import="trader.web.CustomerDetails" %>
<%@page import="trader.web.PortfolioController" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Customers</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table cellpadding="4" border="1">
            <td><a href="CustomerDetails">Customer Details</a></td>
            <td><a href="CustomerDetails">Customer Details</a></td>
            <td><a href="CustomerController">All Customers</a></td>
        </table>
        
        <table cellpadding="4" border="1">
            <thead>
                <tr>
                    <th>Customer Id</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Portfolio</th>
                </tr> 
            </thead>
            <tbody>
                <%
                    Customer[] customers = (Customer[]) request.getAttribute("customers");
                    
                    for (Customer simpleCustomer : customers) { 
                %>
                <tr>
                    <td><a href="CustomerController?customerIdentity=<%=simpleCustomer.getId()%>&submit=Get Customer"><%=simpleCustomer.getId()%></a></td>
                    <td><%=simpleCustomer.getName()%></td>
                    <td><%=simpleCustomer.getAddr()%></td>
                    <td>
                        Get Customer
                        <a href="PortfolioController?customerIdentity=<%=simpleCustomer.getId()%>">View</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
        String message = (String)request.getAttribute("message");
        
        if(message != null) {
            out.println("<font color='red'>" + message + "</font>");            
        }    
        %>
    </body>
</html>
