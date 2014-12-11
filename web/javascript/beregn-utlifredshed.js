/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#btn").click(function() {
        beregn();
        var value = hentPulje("#puljeA");
                //$("#test").html(value.length);
        
        
    });

    function beregn() {
        $.ajax({
            url: "AjaxServlet",
            cache: false,
            //data: {puljeA: hentPulje("#puljeA"), puljeB: hentPuljeB("#puljeB")},
            datatype: "json"
        }).done(function(data) {         
                $("#test").html("data");
        });
    }     

});
    function hentPulje(id)
    {
        var values = $(id).children('option').map(function(i,e){
       return e.innerText;
    }).get();
    //$("#test").html(JSON.stringify(values));
     alert(values);
        return values;
    }

    
