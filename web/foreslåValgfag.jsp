<%-- 
    Document   : foreslåValgfag
    Created on : 11-12-2014, 13:47:37
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valgfag Forslag</title>
    </head>
    <body>
        <div style=" border: 1px solid; width: 15em; height: 18em ">
         
         <list>
         <c:forEach var="v" items="${valgfag}">
                <li>${v.fag.fag}</li>
            </c:forEach> 
            
        </list>
        </div>
        <p>
            Nyt valgfag
        </p>
        <p>
            Titel <input type="text" id="titel"></input> 
            Underviser <input type="text" id="underviser"></input>
        </p>
        <p>Beskrivelse</p>
        <textarea id="beskrivelse" type="text" style="width: 30em; height: 15em; border: 1px solid;"></textarea>
        <p></p>
        <label style="margin-right: 18em">Besked</label> <button type="button" id="gem">Gem</button>
       
        
        
    </body>
</html>
