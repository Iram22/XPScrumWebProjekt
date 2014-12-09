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
        <title>Udvælg valgfag 2. runde</title>
        <script>
            function flytTilPuljeA()
            {
                flytFag("valgfag", "puljeA");
            }

            function flytTilPuljeB()
            {
                flytFag("valgfag", "puljeB");
            }

            function flytFag(fra, til)
            {
                var select = document.getElementById(fra);
                var x = document.getElementById(til);
                var option = document.createElement("option");
                option.text = select.value;
                x.add(option);

                select.remove(select.selectedIndex);

            }

        
            

        </script>
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

        <button onclick="beregn()"> Beregn Utilfredshed </button>

    </body>
</html>
