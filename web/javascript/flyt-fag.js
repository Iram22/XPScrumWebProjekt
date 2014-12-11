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

            function flytFag(fra, til)
            {
                var select = document.getElementById(fra);
                var x = document.getElementById(til);
                var option = document.createElement("option");
                option.text = select.value;
                x.add(option);
                select.remove(select.selectedIndex);
            }

          
