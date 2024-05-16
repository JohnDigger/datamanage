let areaName = decodeURIComponent(location.search.substring(1).split("&")[0].split("=")[1]);
// var host = "http://36.133.200.169:8098"
var host = "http://118.24.31.24:8098"

var token = window.localStorage.getItem("token");
function back(){
    window.history.back();
}

function pushImg(){
    const form = new FormData();
    // const blob = new Blob([]);
    form.append("file", $("#imgFile")[0].files[0])

    $.ajax({
        type: 'POST',
        headers: {
            "Authorization": `Bearer ${token}`,
            // "Content-Type": "multipart/form-data"
        },
        url: host + "/back/file/uploadimages",
        data: form,
        contentType: false,
        processData: false,
        success: function (response){
            // window.location.href="dateEdit.html?areaName="+areaName;
            console.log(response)
            // 保存结果
            var url = response.fileList[0]
            $.ajax({
                type: "GET",
                headers: {
                    "Authorization": `Bearer ${token}`,
                    "Content-Type": "Application/json"
                },
                url: host + `/back/frontaddress/update`,
                data: {
                    address: areaName,
                    image_url: url
                },
                success: res => {
                    alert("保存成功")
                    window.location.href = "areaSelect.html";
                },
                error: err => {
                    alert("出现错误")
                }
            })
        },
        error: function(xhr, status, error) {
            // 请求失败的回调函数
            console.log(error);
        }
    });
}
