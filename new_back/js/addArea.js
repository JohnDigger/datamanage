
let checkAreaButton = window.document.getElementById("nextButton");
let areaNameInput = window.document.getElementById("addressName");
let areaName = areaNameInput;
checkAreaButton.addEventListener("click", function (){
    window.location.href="dateEdit.html?areaName="+areaName.valueOf().value;

})