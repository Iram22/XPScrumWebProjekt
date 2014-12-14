/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("table").hide();
    $("#btn").click(function() {
        beregn();
    });
    $("#gem").click(function() {
        gem();
    });


});

function gem()
{
     $.ajax({
        url: "GemPuljerServlet",
        cache: false,
        data: {puljeA: hentPulje("#puljeA option"), puljeB: hentPulje("#puljeB option")},
        datatype: "text"
    }).done(function(data) {
        $("#besked").html(data);   
    });

}

function beregn() {
    $.ajax({
        url: "AjaxServlet",
        cache: false,
        data: {puljeA: hentPulje("#puljeA option"), puljeB: hentPulje("#puljeB option")},
        datatype: "json"
    }).done(function(data) {
        $("tr:not(#header)").remove();

        var len = data.length;

        var table = document.getElementById("beregning");
        for (i = 0; i < len; i++)
        {
            var tr = document.createElement("tr");
            var parts = data[i].split(" ");
            for (j = 0; j < 6; j++)
            {
                //alert("I got here");
                var td = document.createElement("td");
                td.innerHTML = parts[j];
                tr.appendChild(td);
            }

            table.appendChild(tr);
            $("table").show();
        }



    });
}

function hentPulje(id)
{
    var values = [];
    $(id).each(function()
    {
        values.push($(this).val());
    });
    return values;
}





