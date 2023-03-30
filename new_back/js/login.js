function submit(){
    var requestData = {
        username: $("#username").val(),
        password: $("#password").val()
    };
    console.log(requestData)
    $.ajax({
        type: 'POST',
        contentType: "application/json",
        url: "http://36.133.200.169:8098/back/login/authenticate",
        data: JSON.stringify(requestData),
        success: function (response){
            window.localStorage.setItem("token",response.token)
        },
        error: function(xhr, status, error) {
            // 请求失败的回调函数
            console.log(error);
        }
    });

}
