

function submit(){
    var requestData = {
        username: $("#username").val(),
        password: $("#password").val()
    };
    $.ajax({
        type: 'POST',
        contentType: "application/json",
        // url: "http://36.133.200.169:8098/back/login/authenticate",
        url: "http://117.50.183.219:8098/back/login/authenticate",
        data: JSON.stringify(requestData),
        success: function (response){
            window.localStorage.setItem("token",response.token);
            let loginErrorDiv = window.document.getElementById("loginErrorId");
            loginErrorDiv.style.display = "hidden";
            window.location.href="areaSelect.html";

        },
        error: function(xhr, status, error) {
            let loginErrorDiv = window.document.getElementById("loginErrorId");
            console.log(1111111);
            loginErrorDiv.style.visibility = "visible";
            // 请求失败的回调函数
            console.log(error);
        }
    });

}


