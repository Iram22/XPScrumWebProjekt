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
        <link rel="stylesheet" href="style/css/default_CphBusiness_layout.css"/>
        <link rel="shortcut icon" href="style/gfx/favicon.ico" type="image/x-icon" />
      
        <title>Angiv valgfagsprioriteter 2. runde</title>
    </head>
    <body>
     <div id="banner"></div>
        <div id="main_menubar">log ud</div>
        <div id="mid">
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
        </div>
        <div id="leftside-spacer"></div>
        <div id="leftside-panel">
            <a href="main.jsp">Back to main page</a><br/>
        </div>
        <div id="spacer"></div>
        <div id="footer">Cph Business Academy, Lundtoftevej 93, DK-2800 Kgs. Lyngby  Telefon: +45 12 34 56 67  kontakt@cphbank.dk  CVR: 4545 8181  EAN: 5798 000 56 0550</div>
    </body>
</html>
