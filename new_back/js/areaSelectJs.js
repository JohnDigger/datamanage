
let checkAreaButton = window.document.getElementById("checkAreaButton");
let areaName = checkAreaButton.innerText;
checkAreaButton.addEventListener("click", function (){
    window.location.href="dateEdit.html?areaName="+areaName;
})