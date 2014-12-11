/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#btn").click(function() {
        beregn();
        var value = hentPulje("#puljeA option");
                //$("#test").html(value.length);
        
        
    });

    function beregn() {
        $.ajax({
            url: "AjaxServlet",
            cache: false,
            data: {puljeA: hentPulje("#puljeA option"), puljeB: hentPulje("#puljeB option")},
            datatype: "json"
        }).done(function(data) {         
                $("#test").html("data");
        });
    }     

});
    function hentPulje(id)
    {
        
            var values=[];
            $(id).each(function()
                {
             values.push($(this).val());
        });
    $("#test").html(JSON.stringify(values));
     
        return values;
    }

    
