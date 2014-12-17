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
        <link rel="stylesheet" type="text/css" href="style/css/css.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <link rel="stylesheet" href="style/css/default_CphBusiness_layout.css"/>
        <script type="text/javascript" src='javascript/radiobuttonkontrol.js'></script>
        <title>Angiv valgfagsprioriteter 2. runde</title>
    </head>
    <body>
        <div id="main">
            <div id="banner"></div>
            <div id="main_menubar"></div>
            <div id="mid">
                <div id="back">
                    <a href="main.jsp">Back to main page</a><br/>
                </div><br/>


                <form id="myform" action="GemPrioriteterRunde2Servlet" class="andenP">
                    <h1>Anden Valgfagsrunde</h1>

                    <table>
                        <tr>
                            <td><b>Navn</b></td>
                            <td> <input type="text" name="studentNavn"></td>	
                        </tr>
                        <tr>
                            <td><b>Pulje A</b></td>
                            <td><b>1 prioritet </b></td>		
                            <td><b>2 prioritet</b></td>
                        </tr>

                        <c:forEach var="p" items="${puljeA}">
                            <tr>
                                <td><label>${p.fag}</label></td> 
                                <td><input type="radio" name="foersteprioritetA" value=${p.id} data-col="${p.id}"> </td>
                                <td><input type="radio" name="andenprioritetA" value=${p.id} data-col="${p.id}"> </td>
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
                                <td><input type="radio" name="foersteprioritetB" value=${p.id} data-col="${p.id}"> </td>
                                <td><input type="radio" name="andenprioritetB" value=${p.id} data-col="${p.id}"></td>
                            </tr>
                        </c:forEach>

                        <tr> <td><input type="submit" name="gem" value="Gem prioritet"> <td></tr>
                        <tr><td id="err">${error}</td></tr>
                    </table>
                </form>
            </div>
                <div id="spacer"></div>

                <div id="footer">Cph Business Academy, Nørgårdsvej 30, DK-2800 Kgs. Lyngby  Telefon: +45 12 34 56 67   CVR: 4545 8181  EAN: 5798 000 56 0550</div>


                </body>
                </html>