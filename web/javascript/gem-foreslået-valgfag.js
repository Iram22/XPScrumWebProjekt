/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 
           
            $(document).ready(function(){
            $("#gem").click(function(){
            // $("#date").load("DateServlet"); 
           gemForslag();
    });
    });
        function gemForslag(){
            $.ajax({
                url:"ValgfagForslag",
                cache: false,
                data:{titel: $("#titel").val(), underviser: $("#underviser").val(), beskrivelse: $("#beskrivelse").val()},
                datatype: "text"
                
            }).done(function(data){
              $("#date").html(data);
                
            });
        }
        