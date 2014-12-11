<%-- 
    Document   : sætPrioritetFørsteRunde
    Created on : 10-12-2014, 22:06:05
    Author     : Ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <table>
            <c:forEach var="v" items="${valgfag}">
            <tr>
            <td>${v.fag}</td>
            <td><input type="number" min="0" max="2" step="1" value="0" size="3" id=${v.id}></td>
            </tr>
            </c:forEach>
            </table>
    </body>
</html>
