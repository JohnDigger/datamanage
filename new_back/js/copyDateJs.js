
let areaName = decodeURIComponent(location.search.substring(1).split("&")[0].split("=")[1]);
let editMonth = decodeURIComponent(location.search.substring(1).split("&")[1].split("=")[1]);
let currentArea = window.document.getElementById("currentArea");
currentArea.innerText = "当前区域："+areaName;

// let token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MDE2MDE3MywiZXhwIjoxNj" +
//     "gwMTc4MTczfQ.pY5zSfKpE-d6wabNMNiZbNudtlu1F57C0m3zxeYTcPY";
let token = window.localStorage.getItem("token");

var allDate = "";
var dateLength = "";
window.onload = function (){
    if (localStorage.getItem("token") === null){
        window.location.href='login.html'
    }
}
$.ajax({
    // url: "http://36.133.200.169:8098/back/frontmonth/list",
    url: "http://117.50.183.219:8098/back/frontmonth/list",
    type: "GET",
    headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json"
    },
    data: {
        "addressName":areaName,
        "t": Date.now(),
        "page": 1,
        "limit": 100,
        "key": ""
    },
    success: function(data) {

        allDate = data.page.list;
        dateLength = data.page.list.length;
        setDate(allDate,dateLength);
    },
    error: function(xhr, status, error) {
        console.log(`Bearer ${token}`)
    }
});

var lastCheck = null;
let editNextButton = window.document.getElementById("editNextButton");

function mouseDown(event){
    let monthDiv = event.target;
    if (monthDiv.style.backgroundColor != "skyblue"){
        window.document.getElementById("error").style.display = "none";

        monthDiv.style.backgroundColor = "skyblue";
        monthDiv.removeEventListener("mouseenter", mouseEnter);
        monthDiv.removeEventListener("mouseleave", mouseLeave);


        if (lastCheck != null){
            lastCheck.style.backgroundColor = "transparent";
            lastCheck.addEventListener("mouseenter", mouseEnter);
            lastCheck.addEventListener("mouseleave", mouseLeave);

        }
        lastCheck = monthDiv;
    }else {
        monthDiv.style.backgroundColor = "transparent";
        monthDiv.addEventListener("mouseenter", mouseEnter);
        monthDiv.addEventListener("mouseleave", mouseLeave);
        lastCheck = null;
    }


}


function mouseEnter(event){
    let monthDiv = event.target;
    monthDiv.style.backgroundColor = "#d7f7ff";
}

function mouseLeave(event){
    let monthDiv = event.target;
    monthDiv.style.backgroundColor = "transparent";
}



function setDate(allDate,dateLength){
    // 遍历日期范围内的每个月份
    for (let d = 0; d <= dateLength-1; d++) {
        if (allDate[d].isEdited == "1"){
            // 创建div元素
            const monthCheckDiv = document.createElement('div');
            const monthDiv = document.createElement('div');
            const cheakMark = document.createElement('div');
            const markSpan = document.createElement('span');


            // 获取年份和月份
            const year = new Date(allDate[d].frontDate).getFullYear();
            const month = new Date(allDate[d].frontDate).getMonth() + 1;
            monthDiv.setAttribute("id",`${year}年${month}月`);

            // 设置div的内容为年份和月份
            monthDiv.textContent = `${year}年${month}月`;

            monthCheckDiv.className = "monthCheckDiv";
            monthDiv.className = "monthDiv";
            cheakMark.className = "checkMark";
            cheakMark.setAttribute("id",allDate[d].frontDate);

            let parent = document.getElementById('monthCheckBoxId');
            parent.appendChild(monthCheckDiv);
            monthCheckDiv.appendChild(monthDiv);
            monthCheckDiv.appendChild(cheakMark);
            cheakMark.appendChild(markSpan);

            cheakMark.className = "cheakMark span:before"
            // 将div添加到文档中

            monthDiv.addEventListener("mousedown", mouseDown);
            monthDiv.addEventListener("mouseenter", mouseEnter);
            monthDiv.addEventListener("mouseleave", mouseLeave);

        }


    }
}

editNextButton.addEventListener("click", function (){
    // 获取年份和月份

    var checkDate = null;

    for(let d = 0; d <= dateLength-1; d++){
        const year = new Date(allDate[d].frontDate).getFullYear();
        const month = new Date(allDate[d].frontDate).getMonth() + 1;
        if (allDate[d].isEdited == "1") {
            if (window.document.getElementById(`${year}年${month}月`).style.backgroundColor == "skyblue") {
                checkDate = allDate[d].frontDate
            }
        }
    }

    if (checkDate){
        console.log(checkDate);
        window.location.href="detail.html?areaName="+areaName+"&editDate="+editMonth+"&copyMonth="+checkDate;
    }
    else {
        window.document.getElementById("error").style.display = "flex";
    }

})

function back(){
    window.history.back();
}

function skip(){
    window.location.href="detail.html?areaName="+areaName+"&editDate="+editMonth+"&copyMonth="+editMonth;
}
