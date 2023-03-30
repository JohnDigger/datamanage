
let checkAreaButton = window.document.getElementById("nextButton");
let areaNameInput = window.document.getElementById("addressName");
let areaName = areaNameInput;
// checkAreaButton.addEventListener("click", function (){
//     window.location.href="dateEdit.html?areaName="+areaName.valueOf().value;
// })
let token = window.localStorage.getItem("token");
function submit(){
    var requestData = {
        dataAddress: $("#addressName").val(),
        level2Url: $("#level2Url").val(),
        platformService: $("#platform").val(),
        startTime: $("#startTime").val(),
        endTime: $("#endTime").val()
    };

    $.ajax({
        type: 'POST',
        contentType: "application/json",
        headers: {
            "Authorization": `Bearer ${token}`,
            "Content-Type": "application/json"
        },
        url: "http://36.133.200.169:8098/back/frontaddress/save",
        data: JSON.stringify(requestData),
        success: function (response){
            window.location.href="dateEdit.html?areaName="+areaName.valueOf().value;
        },
        error: function(xhr, status, error) {
            // 请求失败的回调函数
            console.log(error);
        }
    });

}
