<%-- 
    Document   : UdvælgValgfag2
    Created on : Dec 9, 2014, 2:29:52 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Udvælg valgfag 2 runde</title>
    </head>
    <body>

        <p>${count}</p>

        <select size=${count}>
            <c:forEach var="v" items="${valgfag}">
                <option>${v}</option>
            </c:forEach> 
        </select>

        <table border="1">
            <tr><th>Valgfag</th></tr>
                    <c:forEach var="v" items="${valgfag}">
                <tr><td>${v}</td></tr>
            </c:forEach>                           
        </table>

    </body>
</html>
