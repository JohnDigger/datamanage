
// request url
// var url = "http://36.133.200.169:8098/"
var url = "http://172.17.49.59:8081"
var token =  "Bearer " +  window.localStorage.getItem("token")

// handle data
$(function() {
    // initvar s_money, s_num, f_money, f_num;
    // init data
    s_money = parseInt($("input#swxze").val());
    s_num = parseInt($("input#swlsl").val());
    f_money = parseInt($("input#fwxze").val());
    f_num = parseInt($("input#fwlsl").val());
    // set data
    $("div#qwlse")[0].lastChild.data = s_money + f_money;
    $("div#lsl")[0].lastChild.data = s_num + f_num;
    $("input#swxzdqdsj")[0].max = s_money;
    $("input#swlslzdqd")[0].max = s_num;
    $("input#ncpjyze")[0].max = s_money;
    $("input#ncplsl")[0].max = s_num;
    $("input#fwxzdqdsj")[0].max = f_money;
    $("input#fwlslzdqd")[0].max = f_num;
    
    // check input
    $('input#swxze').on('input propertychange',function(){
        s_money = parseInt($(this).val());
        $("div#qwlse")[0].lastChild.data = s_money + f_money;
        // calc percent
        // children's input
        $("input#swxzdqdsj")[0].max = s_money;
    });
    $('input#fwxze').on('input propertychange',function(){
        f_money = parseInt($(this).val());
        $("div#qwlse")[0].lastChild.data = s_money + f_money;
        // children's input
        $("input#fwxzdqdsj")[0].max = f_money;
    });
    $('input#swlsl').on('input propertychange',function(){
        s_num = parseInt($(this).val());
        $("div#lsl")[0].lastChild.data = s_num + f_num;
        // children's input
        $("input#swlslzdqd")[0].max = s_num;
    });
    $('input#fwlsl').on('input propertychange',function(){
        f_num = parseInt($(this).val());
        $("div#lsl")[0].lastChild.data = s_num + f_num;
        // children's input
        $("input#fwlslzdqd")[0].max = f_num;
    });

    var that = this;
    // click commit
    $(".commit-button").click(function(){
        var isCommit = confirm("是否提交该表单？");
        var len = 0;
        if(isCommit) {
            var reqUrl = decodeURI(location.search);
            var strings = reqUrl.split("&");
            if(strings.length < 2){
                alert("信息不正确");
            }
            // get area
            var area = strings[0].split("=")[1];
            // get date
            var date = strings[1].split("=")[1];
            // index data
            const indexData = {
                time: date,
                totalSaleMoney: $("div#qwlse")[0].lastChild.data,
                totalSaleNum: $("div#lsl")[0].lastChild.data,
                shopNum: $("input#dpsl").val(),
                wlSaleMoney: "0",
                wlDevelopment: $("input#wlzs").val(),
                wlShopNum: "0",
                wlSaleNum: "0",
                wlWorkNum: $("input#cyry").val(),
                dataAddress: area
            }
            // sw data list
            let swData = [];
            var swDivs = $(".detail-slider-text-1");
            for(var i=0; i<swDivs.length; i++){
                var children = swDivs[i].children;
                swData.push(
                    {
                        objectPercent: parseFloat(parseInt(children[3].innerText) / 100),
                        objectName: children[0].innerText,
                        objectAddress: area,
                        objectDate: date
                    }
                )
            }
            console.log("实物型数据==> ", swData)
            // sw import data list
            let swImData = [];
            var swImDivs = $(".detail-slider-text-2");
            for (var i=0; i<swImDivs.length; i++){
                var children = swImDivs[i].children;
                swImData.push(
                    {
                        channelName: children[0].innerText,
                        channelNum: parseFloat(parseInt(children[3].innerText) / 100),
                        channelDate: date,
                        channelArea: area,
                        type: "sale"
                    }
                )
            }
            console.log("实物型重点渠道数据==> ", swImData)
            // sw detail
            const swDetail = {
                detailCount: $("input#swlsl").val(),
                detailMoney: $("input#swxze").val(),
                detailDate: date,
                detailAddress: area,
                type: "sale"
            }
            console.log("实物型详情数据==> ", swDetail)
            // sw top10
            let swTop10 = []
            for (var i=0; i<10; i++){
                var select = $("select#qd-1")[i];
                var qd = "";
                for (var j=0; j<select.length; j++){
                    if (select[j].selected){
                        qd = select[j].value
                    }
                }
                swTop10.push(
                    {
                        detailNum: i+1,
                        detailMoney: $("input#ls-1")[i].value,
                        platform: qd,
                        type: "sale",
                        dataAddress: area,
                        dataDate: date,
                        shopName: $("input#mc-1")[i].value,
                        detailUrl: $("input#wz-1")[i].value
                    }
                )
            }
            console.log("实物型店铺TOP10==> ", swTop10)

            // fw data list
            let fwData = [];
            var fwDivs = $(".detail-slider-text-4");
            for(var i=0; i<fwDivs.length; i++){
                var children = fwDivs[i].children;
                fwData.push(
                    {
                        servicePercent: parseFloat(parseInt(children[3].innerText) / 100),
                        serviceName: children[0].innerText,
                        serviceAddress: area,
                        serviceDate: date
                    }
                )
            }
            console.log("服务型数据==> ", fwData)
            // sw import data list
            let fwImData = [];
            var fwImDivs = $(".detail-slider-text-5");
            for (var i=0; i<fwImDivs.length; i++){
                var children = fwImDivs[i].children;
                fwImData.push(
                    {
                        channelName: children[0].innerText,
                        channelNum: parseFloat(parseInt(children[3].innerText) / 100),
                        channelDate: date,
                        channelArea: area,
                        type: "sale"
                    }
                )
            }
            console.log("服务型重点渠道数据==> ", fwImData)
            // fw detail
            const fwDetail = {
                detailCount: $("input#fwlsl").val(),
                detailMoney: $("input#fwxze").val(),
                detailDate: date,
                detailAddress: area,
                type: "service"
            }
            console.log("服务型详情数据 ==> ", fwDetail)
            // fw top10
            let fwTop10 = []
            for (var i=0; i<10; i++){
                var select = $("select#qd-2")[i];
                var qd = "";
                for (var j=0; j<select.length; j++){
                    if (select[j].selected){
                        qd = select[j].value
                    }
                }
                fwTop10.push(
                    {
                        detailNum: i+1,
                        detailMoney: $("input#ls-2")[i].value,
                        platform: qd,
                        type: "service",
                        dataAddress: area,
                        dataDate: date,
                        shopName: $("input#mc-2")[i].value,
                        detailUrl: $("input#wz-2")[i].value
                    }
                )
            }
            console.log("实物型店铺TOP10==> ", swTop10)

            // nong data list
            let nongData = [];
            var nongDivs = $(".detail-slider-text-3");
            for(var i=0; i<nongDivs.length; i++){
                var children = nongDivs[i].children;
                nongData.push(
                    {
                        farmMoney: parseFloat(parseInt(children[1].innerText) / 10000),
                        farmNum: parseFloat(parseInt(children[3].innerText) / 100),
                        farmName: children[0].innerText,
                        farmAddress: area,
                        farmDate: date
                    }
                )
            }
            console.log("农业数据==> ", nongData)
            // nong detail
            const nongDetail = {
                saleMoney: $("input#ncpjyze").val(),
                saleNum: $("input#ncplsl").val(),
                saleDate: date,
                dataAddress: area
            }
            console.log("农业详情数据==> ", nongDetail)
            // nong top30
            let nongTop30 = []
            for (var i=0; i<30; i++){
                var select = $("select#qd-3")[i];
                var qd = "";
                for (var j=0; j<select.length; j++){
                    if (select[j].selected){
                        qd = select[j].value
                    }
                }
                nongTop30.push(
                    {
                        goodsName: $("input#dp-3")[i].value,
                        shopName: $("input#mc-3")[i].value,
                        saleMoney: $("input#lse-3")[i].value,
                        saleNum: $("input#lsl-3")[i].value == "" ? 0 : parseInt($("input#lsl-3")[i].value),
                        saleChannel: qd,
                        dataAddress: area,
                        shopUrl: $("input#wz-3")[i].value,
                        shopNum: i+1,
                        dataDate: date
                    }
                )
            }
            console.log("农业店铺TOP30==> ", nongTop30)
            
            // -------------------------------------------------------

            // commit index data
            $.ajax({
                url: `${url}/back/indata/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(indexData),
                success: res => {
                    console.log("首页数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("首页数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit sw data
            $.ajax({
                url: `${url}/back/inobject/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(swData),
                success: res => {
                    console.log("实物型数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("实物型数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit sw import data
            $.ajax({
                url: `${url}/back/inchannel/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(swImData),
                success: res => {
                    console.log("实物型重点渠道数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("实物型重点渠道数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit sw detail
            $.ajax({
                url: `${url}/back/indetailpanel/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(swDetail),
                success: res => {
                    console.log("实物型详情数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("实物型详情数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit sw top10
            $.ajax({
                url: `${url}/back/indetailtop/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(swTop10),
                success: res => {
                    console.log("实物型TOP10数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("实物型TOP10数据提交失败 ==> ", xhr, status, error);
                }
            })

            // commit fw data
            $.ajax({
                url: `${url}/back/inservice/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(fwData),
                success: res => {
                    console.log("服务型数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("服务型数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit fw import data
            $.ajax({
                url: `${url}/back/inchannel/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(fwImData),
                success: res => {
                    console.log("服务型重点渠道数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("服务型重点渠道数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit fw detail
            $.ajax({
                url: `${url}/back/indetailpanel/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(fwDetail),
                success: res => {
                    console.log("服务型详情数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("服务型详情数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit fw top10
            $.ajax({
                url: `${url}/back/indetailtop/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(fwTop10),
                success: res => {
                    console.log("服务型TOP10数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("服务型TOP10数据提交失败 ==> ", xhr, status, error);
                }
            })

            // commit nong data
            $.ajax({
                url: `${url}/back/infarmproduct/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(nongData),
                success: res => {
                    console.log("农业数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("农业数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit nong detail
            $.ajax({
                url: `${url}/back/infarmscale/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(nongDetail),
                success: res => {
                    console.log("农业详情数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("农业详情数据提交失败 ==> ", xhr, status, error);
                }
            })
            // commit nong top30
            $.ajax({
                url: `${url}/back/intopthirty/save`,
                type: "POST",
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(nongTop30),
                success: res => {
                    console.log("农业TOP30数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("农业TOP30数据提交失败 ==> ", xhr, status, error);
                }
            })
        }
        setTimeout(() => {
            if (len == 12){
                alert("表单提交成功！")
            }
            else if (len > 0){
                setTimeout(() => {
                    if (len == 12){
                        alert("表单提交成功！")
                    }
                    else {
                        alert("部分信息出现错误！")
                    }
                }, 3000)
            }
            else {
                alert("表单提交失败！")
            }
        }, 2000)
    })
});

// calc percent
function calcPercent(){
    
}