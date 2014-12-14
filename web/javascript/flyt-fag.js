/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function flytTilPuljeA()
{
    flytFag("valgfag", "puljeA");
}

function flytTilPuljeB()
{
    flytFag("valgfag", "puljeB");
}

function flytTilValgfag()
{
    var fra = "puljeB";
    if(!!document.getElementById("puljeA").value)
    {
        fra = "puljeA";
    }
    flytFag(fra, "valgfag");
    
}

function flytTilA()
{
    flytFag("puljeB", "puljeA");
}

function flytTilB()
{
    flytFag("puljeA", "puljeB");
}


function flytFag(fra, til)
{
    var select = document.getElementById(fra);
    var x = document.getElementById(til);
    var option = document.createElement("option");
    option.text = select.value;
    option.value = select.value;
    x.add(option);
    select.remove(select.selectedIndex);
}




