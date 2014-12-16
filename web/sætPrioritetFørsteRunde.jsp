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
        <link rel="stylesheet" href="style/css/default_CphBusiness_layout.css"/>
        <link rel="shortcut icon" href="style/gfx/favicon.ico" type="image/x-icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <script type="text/javascript" src='javascript/radiobuttonkontrol.js'></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="banner"></div>
        <div id="main_menubar">log ud</div>
         <div id="mid">
        <form action="PrioritetGemtServlet" method="get" >
            <p>Navn:<input type="text" name="navn" value=""></p>                      
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
        <p style="color: red; font-weight: bold">${error}</p>
            
        </form>
         </div>
        <div id="leftside-spacer"></div>
        <div id="leftside-panel">
            <a href="main.jsp">Back to main page</a><br/>
        </div>
        <div id="spacer"></div>
        <div id="footer">Cph Business Academy, Lundtoftevej 93, DK-2800 Kgs. Lyngby  Telefon: +45 12 34 56 67  kontakt@cphbank.dk  CVR: 4545 8181  EAN: 5798 000 56 0550</div>
    </body>
</html>
