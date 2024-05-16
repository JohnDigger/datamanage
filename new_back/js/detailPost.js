
// request url
var url = "http://118.24.31.24:8098"
// var url = "http://36.133.200.169:8098"
var token =  "Bearer " +  window.localStorage.getItem("token")

// handle data
$(function() {
    var that = this;
    // click commit
    $(".commit-button").click(function(){
        var isCommit = confirm("是否提交该表单？");
        var ik = $("input[type='number']");
        for (var i=0; i<ik.length; i++){
            if (ik[i].value == '' || ik[i].value < 0){
                ik[i].value = 0
            }
        }

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
            var now = strings[1].split("=")[1];
            var date = strings[2].split("=")[1];
            // index data
            const indexData = {
                time: now,
                totalSaleMoney: Number($("div#qwlse")[0].lastChild.data).toFixed(1),
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
                        objectNum: children[2].innerText,
                        objectMoney: children[1].innerText,
                        objectName: children[0].innerText,
                        objectAddress: area,
                        objectDate: now,
                    }
                )
            }
            console.log("实物型数据==> ", swData)
            // sw import detail
            const swImDetail = {
                dataAddress: area,
                dataDate: now,
                type: "sale",
                detailMoney: $("input#swxzdqdsj").val(),
                detailCount: $("input#swlslzdqd").val()
            }
            console.log("实物型重点渠道详情数据==> ", swImDetail)
            // sw import data list
            let swImData = [];
            var swImDivs = $(".detail-slider-text-2");
            for (var i=0; i<swImDivs.length; i++){
                var children = swImDivs[i].children;
                swImData.push(
                    {
                        channelName: children[0].innerText,
                        channelMoney: children[1].innerText,
                        channelCount: children[2].innerText,
                        channelNum: parseFloat(parseInt(children[3].innerText) / 100),
                        channelDate: now,
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
                dataDate: now,
                dataAddress: area,
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
                        dataDate: now,
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
                        serviceNum: children[2].innerText,
                        serviceMoney: children[1].innerText,
                        serviceName: children[0].innerText,
                        serviceAddress: area,
                        serviceDate: now
                    }
                )
            }
            console.log("服务型数据==> ", fwData)
            // fw import detail
            const fwImDetail = {
                dataAddress: area,
                dataDate: now,
                type: "service",
                detailMoney: $("input#fwxzdqdsj").val(),
                detailCount: $("input#fwlslzdqd").val()
            }
            console.log("服务型重点渠道详情数据==> ", fwImDetail)
            // fw import data list
            let fwImData = [];
            var fwImDivs = $(".detail-slider-text-5");
            for (var i=0; i<fwImDivs.length; i++){
                var children = fwImDivs[i].children;
                fwImData.push(
                    {
                        channelName: children[0].innerText,
                        channelNum: parseFloat(parseInt(children[3].innerText) / 100),
                        channelDate: now,
                        channelArea: area,
                        channelMoney: children[1].innerText,
                        channelCount: children[2].innerText,
                        type: "service"
                    }
                )
            }
            console.log("服务型重点渠道数据==> ", fwImData)
            // fw detail
            const fwDetail = {
                detailCount: $("input#fwlsl").val(),
                detailMoney: $("input#fwxze").val(),
                dataDate: now,
                dataAddress: area,
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
                        dataDate: now,
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
                        farmCount: parseFloat(parseInt(children[2].innerText) / 10000),
                        farmNum: parseFloat(parseInt(children[3].innerText) / 100),
                        farmName: children[0].innerText,
                        farmAddress: area,
                        farmDate: now
                    }
                )
            }
            console.log("农业数据==> ", nongData)
            // nong detail
            const nongDetail = {
                saleMoney: $("input#ncpjyze").val(),
                saleNum: $("input#ncplsl").val(),
                saleDate: now,
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
                        dataDate: now
                    }
                )
            }
            console.log("农业店铺TOP30==> ", nongTop30)

            // shop top30
            let shopTop30 = []
            for (var i=0; i<30; i++){
                var select = $("select#sspt-4")[i];
                var qd = "";
                for (var j=0; j<select.length; j++){
                    if (select[j].selected){
                        qd = select[j].value
                    }
                }
                shopTop30.push(
                    {
                        shopTime: now,
                        shopIndex: i+1,
                        name: $("input#mc-4")[i].value,
                        saleMoney: $("input#lse-4")[i].value,
                        saleNum: $("input#lsl-4")[i].value,
                        belongTo: qd,
                        dataAddress: area,
                        shopUrl: $("input#wz-4")[i].value
                    }
                )
            }
            console.log("重点店铺TOP30==> ", shopTop30)

            // -------------------------------------------------------

            // commit index data
            $.ajax({
                url: `${url}/back/indata/save`,
                type: "POST",
                async: false,
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
                async: false,
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
            // commit sw import detail
            $.ajax({
                url: `${url}/back/indetailimportant/save`,
                type: "POST",
                async: false,
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(swImDetail),
                success: res => {
                    console.log("实物型重点渠道详情数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("实物型重点渠道详情数据提交成功 ==> ", xhr, status, error);
                }
            })
            // commit sw import data
            $.ajax({
                url: `${url}/back/inchannel/save`,
                type: "POST",
                async: false,
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
                async: false,
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
                async: false,
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
                async: false,
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
            // commit fw import detail
            $.ajax({
                url: `${url}/back/indetailimportant/save`,
                type: "POST",
                async: false,
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(fwImDetail),
                success: res => {
                    console.log("服务型重点渠道详情数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("服务型重点渠道详情数据提交成功 ==> ", xhr, status, error);
                }
            })
            // commit fw import data
            $.ajax({
                url: `${url}/back/inchannel/save`,
                type: "POST",
                async: false,
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
                async: false,
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
                async: false,
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
                async: false,
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
                async: false,
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
                async: false,
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
            // commit shop top30
            $.ajax({
                url: `${url}/back/inshop/save`,
                type: "POST",
                async: false,
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: JSON.stringify(shopTop30),
                success: res => {
                    console.log("重点店铺TOP30数据提交成功");
                    len++;
                },
                error: (xhr, status, error) => {
                    console.log("重点店铺TOP30数据提交失败 ==> ", xhr, status, error);
                }
            })
        }
        if (len == 15){
            alert("表单提交成功！")
            // edit isSelect
            $.ajax({
                url: `${url}/back/frontmonth/update`,
                type: "GET",
                async: false,
                headers: {
                    'Authorization': token,
                    'Content-Type': "application/json"
                },
                data: {
                    dataDate: now,
                    dataAddress: area
                },
                success: res => {
                    console.log("提交成功 --> 修改月份完成情况");
                },
                error: (xhr, status, error) => {
                    console.log("提交失败 ==> ", xhr, status, error);
                }
            })
            // to month
            window.location.href = `/dateEdit.html?areaName=${areaName}`;
        }
        else if (len > 0){
            alert("部分信息出现错误！")
        }
        else {
            alert("表单提交失败！")
            window.location.href = '/login.html';
        }
    })
});
