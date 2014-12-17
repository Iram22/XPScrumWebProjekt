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
        <link rel="stylesheet" href="style/css/default_CphBusiness_layout.css"/>
        <link rel="shortcut icon" href="style/gfx/favicon.ico" type="image/x-icon" />
    </head>
    <body>
          <div id="main">
            <div id="banner"></div>
            <div id="main_menubar"></div>
            <div id="mid">
                <div id="back">
                    <a href="main.jsp">Back to main page</a><br/>
                </div><br/>
        <div>
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

                <button onclick="flytTilPuljeA()" class="flytBtn"> >>Pulje A </button>
                <br/><br/>

                <button onclick="flytTilPuljeB()" class="flytBtn"> >>Pulje B </button>
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
                    <button id="gem">Gem</button>
                    <br/>
                    
                    <table id="beregning" border="1">
                        <tr id="header"><th>Navn</th><th>1a</th><th>1b</th><th>2a</th><th>2b</th><th>Tilfredshed</th></tr>
                    </table>
                    
                    
                    <p id="besked"></p>

                </div>

            </div>

        </div>
            
        </div>
        <div id="spacer"></div>
            <div id="footer">Cph Business Academy, Nørgårdsvej 30, DK-2800 Kgs. Lyngby  Telefon: +45 12 34 56 67   CVR: 4545 8181  EAN: 5798 000 56 0550</div>
</body>
</html>
