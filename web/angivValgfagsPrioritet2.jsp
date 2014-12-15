<%-- 
    Document   : angivValgfagsPrioritet2
    Created on : 10-12-2014, 21:02:07
    Author     : Hanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/css/angiv_valg_prioritet2.css">

      
        <title>Angiv valgfagsprioriteter 2. runde</title>
    </head>
    <body>
        
  <form id="myform" action="GemPrioriteterRunde2Servlet">
        <table>
            <tr>
                <td><b>Pulje A</b></td>
                <td><b>1 prioritet </b></td>		
                <td><b>2 prioritet</b></td>
            </tr>
             
            <c:forEach var="p" items="${puljeA}">
                <tr>
                    <td><label>${p.fag}</label></td> 
                    <td><input type="radio" name="førsteprioritetA" value="${p.id}"> </td>
                    <td><input type="radio" name="andenprioritetA" value="${p.id}"></td>
                </tr>
            </c:forEach>

            <tr>
                <td><b>Pulje B</b></td>
                <td><b>1 prioritet</b> </td>		
                <td><b>2 prioritet</b></td>
            </tr> 

            <c:forEach var="p" items="${puljeB}">
                <tr>
                    <td> <label>${p.fag}</label> </td> 
                    <td><input type="radio" name="førsteprioritetB" value="${p.id}"> </td>
                    <td><input type="radio" name="andenprioritetB" value="${p.id}"></td>
                </tr>
            </c:forEach>
                
                <tr> <td><input type="submit" name="gem" value="Gem prioritet"> <td></tr>
        </table>
      </form>

    </body>
</html>
