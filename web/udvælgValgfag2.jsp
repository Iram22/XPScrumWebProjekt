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
        <script src="javascript/beregn-og-gem.js"></script>
        <script src="javascript/flyt-fag.js"></script>
        <link rel="stylesheet" type="text/css" href="style/css/udvælgfag_runde2.css">
    </head>
    <body>
        <div id="main">
            <h1>Udvælg valgfag for 2. runde</h1>

            <div class="list">
                <label><b>Valgfag</b></label>
                <br/>
                <select size=10 id = "valgfag" style="min-width: 180px;">
                    <c:forEach var="v" items="${valgfag}">
                        <option>${v}</table></option>
                    </c:forEach> 
                </select>
            </div>
            <div id="flyt">

                <button onclick="flytTilPuljeA()"> >>Pulje A </button>
                <br/><br/>

                <button onclick="flytTilPuljeB()"> >>Pulje B </button>
            </div>

            <div>
                <div class ="list">
                    <label><b>Pulje A</b></label>
                    <br/>
                    <select size=10 id="puljeA" style="min-width: 180px;" >


                    </select> 
                </div>
                <div id="flyt">
                    <button onclick="flytTilValgfag()"><<</button> <br/><br/>
                    <button onclick="flytTilB()">></button> <br/><br/>
                    <button onclick="flytTilA()"><</button> <br/><br/>
                </div>

                <div class ="list">
                    <label><b>Pulje B</b></label>
                    <br/>
                    <select size=10 id="puljeB" style="min-width: 180px;">

                    </select>  

                </div>
                <div id="beregn">

                    <button id="btn"> Beregn Utilfredshed </button>
                </div>


                <div id="tab">
                    <br/><br/>
                    <table id="beregning" border="1">
                        <tr id="header"><th>Navn</th><th>1a</th><th>1b</th><th>2a</th><th>2b</th><th>Tilfredshed</th></tr>
                    </table>
                    <br/>
                    <button id="gem">Gem</button>
                    <p id="besked"></p>

                </div>


            </div>

        </div>

    </body>
</html>
