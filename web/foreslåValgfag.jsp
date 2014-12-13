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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
        <script>
             $(document).ready(function(){
            $("#gem").click(function(){
            // $("#date").load("DateServlet"); 
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
             // $("#date").html(data);
             
             
              $("#titel").val("");
              $("#underviser").val("");
              $("#beskrivelse").val("");
              
              
              
            });
        }
        
        function reload(){
            
        $.ajax({
                
                url:"ValgfagForslag",
                cache: false,
                datatype:'text',
                success: function(data){
                list = document.getElementById("list")
                var valgfag = data;
                for(var i in valgfag)
                {
                    var li = document.createE
                    list.appendChild(document.createElement("LI"): i.fag.fag);
                }
                
            }
        });
            
            
        }
            
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valgfag Forslag</title>
    </head>
    <body>
        <div style=" border: 1px solid; width: 15em; height: 18em ">
         
            <list id="list">
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
