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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
	<script>
		$(function() {
			var col, el;
			
			$("input[type=radio]").click(function() {
			   el = $(this);
			   col = el.data("col");
			   $("input[data-col=" + col + "]").prop("checked", false);
			   el.prop("checked", true);
			});
		});
	</script>
        <title>JSP Page</title>
    </head>
    <body>

        <form action="PrioritetGemtServlet" method="get" >
            <p>Navn:<input type="text" id="navn" value=""></p>                      
            <table>
                <tr><th style="text-align: left">Fag</th><th>1a</th><th>1b</th><th>2a</th><th>2b</th></tr>    
            <c:forEach var="v" items="${valgfag}">
            <tr>
            <td>${v.fag}</td>
            <td><input type="radio"name="1a" value=${v.fag} data-col="${v.id}"></td>
            <td><input type="radio"name="1b" value=${v.fag} data-col="${v.id}"></td>
            <td><input type="radio"name="2a" value=${v.fag} data-col="${v.id}"></td>
            <td><input type="radio"name="2b" value=${v.fag} data-col="${v.id}"></td>
            </tr>
            </c:forEach>
            </table>
        <button type="submit" onclick="PrioritetGemtServlet" >Gem Priotet</button> 
            
        </form>
    </body>
</html>
