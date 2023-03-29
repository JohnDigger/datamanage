$.ajax({
    url: "http://36.133.200.169:8098/back/frontmonth/list",
    type: "GET",
    data: {
        "addressName": "云州区",
        "t": Date.now(),
        "page": 1,
        "limit": 100,
        "key": ""
    },
    dataType: "json",
    success: function(data) {
        let allDate = data.page.list;
        let dateLength = data.page.list.length;
        setDate(allDate,dateLength);
    },
    error: function(xhr, status, error) {
        console.log(error);
    }
});

function setDate(allDate,dateLength){
    // 遍历日期范围内的每个月份
    for (let d = 0; d <= dateLength-1; d++) {
        // 创建div元素
        const monthCheckDiv = document.createElement('div');
        const monthDiv = document.createElement('div');
        const cheakMark = document.createElement('div');
        const markSpan = document.createElement('span');


        // 获取年份和月份
        console.log(allDate[d].frontDate);
        const year = new Date(allDate[d].frontDate).getFullYear();
        const month = new Date(allDate[d].frontDate).getMonth() + 1;

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

        monthDiv.addEventListener("click", function() {
            if (cheakMark.style.display == "none"){
                cheakMark.style.display = "block";
            }else {
                cheakMark.style.display = "none";
            }
        });

    }
}

