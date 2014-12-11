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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
        <script src="javascript/beregn-utlifredshed.js"></script>
        <script src="javascript/flyt-fag.js"></script>
    </head>
    <body>

        <select size=${count} id = "valgfag" style="min-width: 180px;">
            <c:forEach var="v" items="${valgfag}">
                <option>${v}</option>
            </c:forEach> 
        </select>

        <button onclick="flytTilPuljeA()"> >>Pulje A </button>

        <button onclick="flytTilPuljeB()"> >>Pulje B </button>

        <select size=${count} id="puljeA" style="min-width: 180px;" >


        </select> 

        <select size=${count} id="puljeB" style="min-width: 180px;">

        </select>  

        <br/>

        <button id="btn"> Beregn Utilfredshed </button>
        <p id="test"></p>

    </body>
</html>
