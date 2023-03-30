
let areaName = decodeURIComponent(location.search.substring(1).split("&")[0].split("=")[1]);
let token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MDE2MDE3MywiZXhwIjoxNjgwMTc4MTczfQ.pY5zSfKpE-d6wabNMNiZbNudtlu1F57C0m3zxeYTcPY"

$.ajax({
    // url: "http://36.133.200.169:8098/back/frontmonth/list",
    url: "http://127.0.0.1:8081/back/frontmonth/list",
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
        let allDate = data.page.list;
        let dateLength = data.page.list.length;
        setDate(allDate,dateLength);
    },
    error: function(xhr, status, error) {
        console.log(`Bearer ${token}`)
    }
});

let lastCheck = null;
function mouseDown(event){
    let monthDiv = event.target;
    console.log(lastCheck);
    if (monthDiv.style.backgroundColor != "skyblue"){
        // cheakMark.style.display = "block";
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

let editNextButton = window.document.getElementById("editNextButton");
let checkDate = lastCheck;

editNextButton.addEventListener("click", function (){
    // window.location.href="detail.html?areaName="+areaName+"&editDate="+checkDate;
    console.log(checkDate);
})
