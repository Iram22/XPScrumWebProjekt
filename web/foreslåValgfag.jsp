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
        <link rel="stylesheet" href="/XPScrumWebProjekt/style/css/default.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
        <script>
             $(document).ready(function(){
            $("#gem").click(function(){
            gemForslag();
         
    });
    });
        function gemForslag(){
            
            $.ajax({
                
                url:"gemValgfagForslag",
                cache: false,
                data:{id: document.getElementsByTagName("LI").length, titel: $("#titel").val(), underviser: $("#underviser").val(), beskrivelse: $("#beskrivelse").val()},
                datatype: "text"
                
            }).done(function(data){
             
              $("#titel").val("");
              $("#underviser").val("");
              $("#beskrivelse").val("");
              $("#besked").val("")
              document.location.reload();
            });
             
        }
        
        
        
            
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valgfag Forslag</title>
    </head>
    <body>
        <div id="banner"></div>
        <div id="main_menubar">log ud</div>
        <div id="mid">
            <div id="valgfagList" >
         
            <list id="list">
         <c:forEach var="v" items="${valgfag}">
             <li class="li">${v.fag.fag}</li>
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
        <label id="besked" style="margin-right: 18em">Lave en forslag til et valgfag</label> <button type="button" id="gem">Gem</button>
       
        </div>
        <div id="leftside-spacer"></div>
        <div id="leftside-panel">
            <a href="main.jsp">Back to main page</a><br/>
        </div>
        <div id="spacer"></div>
        <div id="footer">Cph Business Academy, Lundtoftevej 93, DK-2800 Kgs. Lyngby  Telefon: +45 12 34 56 67  kontakt@cphbank.dk  CVR: 4545 8181  EAN: 5798 000 56 0550</div>
    </body>
</html>
