
// let checkAreaButton = window.document.getElementById("checkAreaButton");
let addAreaButton = window.document.getElementById("addAreaButton");
// let areaName = checkAreaButton.innerText;
// checkAreaButton.addEventListener("click", function (){
//     window.location.href="dateEdit.html?areaName="+areaName;
// })
let token = window.localStorage.getItem("token")
addAreaButton.addEventListener("click", function (){
    window.location.href="addArea.html";
})

window.onload =  function (){

    if (localStorage.getItem("token") === null){
        window.location.href='login.html'
    }

    $.ajax({
        // url: "http://36.133.200.169:8098/back/frontaddress/list",
        url: "http://117.50.183.219:8098/back/frontaddress/list",
        type: "GET",
        headers: {
            "Authorization": `Bearer ${token}`,
            "Content-Type": "application/json"
        },
        data: {
            "t": Date.now(),
            "page": 1,
            "limit": 100,
            "key": ""
        },
        success: function(data) {
            console.log(data);
            let areaList = data.page.list;
            let length = data.page.list.length;
            const boxDiv = window.document.getElementById("button-list");
            // for (let d=0;d<=length-1;d++){
            //     const areaDiv = window.document.createElement("button");
            //     areaDiv.innerText = areaList[d].dataAddress;
            //     areaDiv.classList.add("button-green");
            //     areaDiv.classList.add("margins");
            //     areaDiv.classList.add("button:hover");
            //     boxDiv.appendChild(areaDiv);
            //     boxDiv.addEventListener("click", function (event){
            //         console.log(event);
            //         let areaName = event.innerText;
            //         window.location.href="dateEdit.html?areaName="+areaName;
            //     })

            // }
            for (let d = 0; d <= length - 1; d++) {
                const areaDiv = window.document.createElement("button");
                areaDiv.innerText = areaList[d].dataAddress;
                areaDiv.classList.add("button-green");
                areaDiv.classList.add("margins");
                areaDiv.classList.add("button:hover");
                boxDiv.appendChild(areaDiv);

                // 将回调函数定义在立即执行函数中，保存当前按钮的文本内容
                areaDiv.addEventListener(
                    "click",
                    (function (areaName) {
                        return function (event) {
                            console.log(event);
                            window.location.href = "dateEdit.html?areaName=" + areaName;
                        };
                    })(areaList[d].dataAddress)
                );
            }

        },
        error: function(xhr, status, error) {
            console.log(`Bearer ${token}`)
        }
    });
}
