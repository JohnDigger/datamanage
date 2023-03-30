
let checkAreaButton = window.document.getElementById("checkAreaButton");
let addAreaButton = window.document.getElementById("addAreaButton");
let areaName = checkAreaButton.innerText;
checkAreaButton.addEventListener("click", function (){
    window.location.href="dateEdit.html?areaName="+areaName;
})

addAreaButton.addEventListener("click", function (){
    window.location.href="addArea.html";
})
