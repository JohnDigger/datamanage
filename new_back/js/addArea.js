
let checkAreaButton = window.document.getElementById("nextButton");
let areaNameInput = window.document.getElementById("addressName");
let token = window.localStorage.getItem("token");
let areaName = areaNameInput;
// checkAreaButton.addEventListener("click", function (){
//     window.location.href="dateEdit.html?areaName="+areaName.valueOf().value;
// })
window.onload = function (){
    if (localStorage.getItem("token") === null){
        window.location.href='login.html'
    }
}

// request url
var host = "http://118.24.31.24:8098"

function submit(){
    var requestData = {
        dataAddress: $("#addressName").val(),
        level2Url: $("#level2Url").val(),
        platformService: $("#platform").val(),
        startTime: $("#startTime").val(),
        endTime: $("#endTime").val(),
        imageUrl: window.urls


    };

    $.ajax({
        type: 'POST',
        contentType: "application/json",
        headers: {
            "Authorization": `Bearer ${token}`,
            "Content-Type": "application/json"
        },
        url: host + "/back/frontaddress/save",
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

function back(){
    window.history.back();
}

function pushImg(){
    const form = new FormData();
    form.append("file", $("#imgFile")[0].files[0])

    $.ajax({
        type: 'POST',
        contentType: false,
        headers: {
            "Authorization": `Bearer ${token}`
        },
        url: host + "/back/file/uploadimages",
        data: form,
        processData: false,
        success: function (response){
            window.urls = response.fileList[0]
            alert("上传成功")
        },
        error: function(xhr, status, error) {
            // 请求失败的回调函数
            console.log(error);
        }
    });
}

