window.onload =  function (){
    if (localStorage.getItem("userInfo")){
        console.log(localStorage.getItem("userInfo"))
        const userInfo = JSON.parse(localStorage.getItem("userInfo"));
        $("#username")[0].value = userInfo.username
        $("#password")[0].value = userInfo.password
    }
}
var host = "http://118.24.31.24:8098"
function submit(){
    var requestData = {
        username: $("#username").val(),
        password: $("#password").val()
    };
    $.ajax({
        type: 'POST',
        contentType: "application/json",
        url:  host + "/back/login/authenticate",
        data: JSON.stringify(requestData),
        success: function (response){

            window.localStorage.setItem("token",response.token);
            if ($("#remember").val()){
                localStorage.setItem("userInfo", JSON.stringify({
                    username: $("#username").val(),
                    password: $("#password").val()
                }));
            }
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


