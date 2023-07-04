// ---------------------------- init ------------------------
// request url
var url = "http://114.117.162.189:8098"
// var url = "http://36.133.200.169:8098"
// request token
var token =  "Bearer " +  window.localStorage.getItem("token")
// area and date
var reqUrl = decodeURI(location.search)
var strings = reqUrl.split("&")
// get area
var area = strings[0].split("=")[1]
// get date
var date = strings[2].split("=")[1]
var now = strings[1].split("=")[1]
var rate = strings[3].split("=")[1]
// set date
var nowList = now.split("-")
$(".detail-date")[0].outerText = nowList[0] + "年" + nowList[1] + "月"

// ----------------------------- get ------------------------
$(function(){
    // get index data
    $.ajax({
        url: `${url}/back/indata/getPanel`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            dateTime: date
        },
        success: res => {
            console.log("获取首页数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data[0]
                $("div#qwlse")[0].lastChild.data = (data.totalSaleMoney*rate).toFixed(2)
                // set data
                $("div#lsl")[0].lastChild.data = Math.round(data.totalSaleNum*rate)
                $("input#dpsl")[0].value = Math.round(data.shopNum*rate)
                $("input#cyry")[0].value = Math.round(data.wlWorkNum*rate)
                $("input#wlzs")[0].value = (data.wlDevelopment*rate).toFixed(2)

            }
        },
        error: (xhr, status, error) => {
            console.log("获取首页数据失败 ==> ", xhr, status, error)
        }
    })

    // get sw detail
    $.ajax({
        url: `${url}/back/indetailpanel/panel`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "sale"
        },
        success: res => {
            console.log("获取实物详情数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data[0]
                // set data
                $("input#swxze")[0].value = (data.detailMoney*rate).toFixed(2)
                $("input#swlsl")[0].value = Math.round(data.detailCount*rate)
            }
        },
        error: (xhr, status, error) => {
            console.log("获取实物详情数据失败 ==> ", xhr, status, error)
        }
    })
    // get sw list
    $.ajax({
        url: `${url}/back/inobject/getObj`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date
        },
        success: res => {
            console.log("获取实物列表数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                var swDivs = $(".f-hk-1 .f-range-tips-1")
                // set data
                var percent = 100
                for (var i=0; i<data.length; i++){
                    swDivs[i].textContent = percent + '%'
                    percent -= parseInt(parseFloat(data[i].objectPercent) * 100)
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取实物列表数据失败 ==> ", xhr, status, error)
        }
    })

    // get sw import detail
    $.ajax({
        url: `${url}/back/indetailimportant/getImportant`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "sale"
        },
        success: res => {
            console.log("获取实物重点渠道详情数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data[0]
                // set data
                $("input#swxzdqdsj")[0].value = (data.detailMoney*rate).toFixed(2)
                $("input#swlslzdqd")[0].value = Math.round(data.detailCount*rate)
            }
        },
        error: (xhr, status, error) => {
            console.log("获取实物重点渠道详情数据成功 ==> ", xhr, status, error)
        }
    })
    // get sw import list
    $.ajax({
        url: `${url}/back/inchannel/getChannel`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "sale"
        },
        success: res => {
            console.log("获取实物重点渠道列表数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                var swDivs = $(".f-hk-2 .f-range-tips-2")
                // set data
                var percent = 100
                for (var i=0; i<data.length; i++){
                    swDivs[i].textContent = percent + '%'
                    percent -= parseInt(data[i].channelNum*100)
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取实物重点渠道列表数据成功 ==> ", xhr, status, error)
        }
    })

    // get nong detail
    $.ajax({
        url: `${url}/back/infarmscale/getPanel`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date
        },
        success: res => {
            console.log("获取农产品详情数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data[0]
                // set data
                $("input#ncpjyze")[0].value = (data.saleMoney*rate).toFixed(2)
                $("input#ncplsl")[0].value = Math.round(data.saleNum*rate)
            }
        },
        error: (xhr, status, error) => {
            console.log("获取农产品详情数据失败 ==> ", xhr, status, error)
        }
    })
    // get nong list
    $.ajax({
        url: `${url}/back/infarmproduct/product`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date
        },
        success: res => {
            console.log("获取农产品列表数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                var swDivs = $(".f-hk-3 .f-range-tips-3")
                // set data
                var percent = 100
                for (var i=0; i<data.length; i++){
                    swDivs[i].textContent = percent + '%'
                    percent -= parseInt(data[i].farmNum*100)
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取农产品列表数据失败 ==> ", xhr, status, error)
        }
    })

    // get fw detail
    $.ajax({
        url: `${url}/back/indetailpanel/panel`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "service"
        },
        success: res => {
            console.log("获取服务详情数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data[0]
                // set data
                $("input#fwxze")[0].value = (data.detailMoney*rate).toFixed(2)
                $("input#fwlsl")[0].value = Math.round(data.detailCount*rate)
            }
        },
        error: (xhr, status, error) => {
            console.log("获取服务详情数据失败 ==> ", xhr, status, error)
        }
    })
    // get fw list
    $.ajax({
        url: `${url}/back/inservice/getServiceList`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date
        },
        success: res => {
            console.log("获取服务列表数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                var swDivs = $(".f-hk-4 .f-range-tips-4")
                // set data
                var percent = 100
                for (var i=0; i<data.length; i++){
                    swDivs[i].textContent = percent + '%'
                    percent -= parseInt(parseFloat(data[i].servicePercent) * 100)
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取服务列表数据失败 ==> ", xhr, status, error)
        }
    })
    // get fw import detail
    $.ajax({
        url: `${url}/back/indetailimportant/getImportant`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "service"
        },
        success: res => {
            console.log("获取服务重点渠道详情数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data[0]
                // set data
                $("input#fwxzdqdsj")[0].value = (data.detailMoney*rate).toFixed(2)
                $("input#fwlslzdqd")[0].value = Math.round(data.detailCount*rate)
            }
        },
        error: (xhr, status, error) => {
            console.log("获取服务重点渠道详情数据成功 ==> ", xhr, status, error)
        }
    })
    // get fw import list
    $.ajax({
        url: `${url}/back/inchannel/getChannel`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "service"
        },
        success: res => {
            console.log("获取服务重点渠道列表数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                var swDivs = $(".f-hk-5 .f-range-tips-5")
                // set data
                var percent = 100
                for (var i=0; i<data.length; i++){
                    swDivs[i].textContent = percent + '%'
                    percent -= parseInt(data[i].channelNum*100)
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取服务重点渠道列表数据成功 ==> ", xhr, status, error)
        }
    })

    // get sw top10
    $.ajax({
        url: `${url}/back/indetailtop/getTenByOrder`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "sale"
        },
        success: res => {
            console.log("获取实物TOP10数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                // set data
                var mcDivs = $("input#mc-1")
                var wzDivs = $("input#wz-1")
                var lsDivs = $("input#ls-1")
                var qdDivs = $("select#qd-1")
                for (var i=0; i<10; i++){
                    mcDivs[i].value = data[i].shopName
                    wzDivs[i].value = data[i].detailUrl
                    lsDivs[i].value = (data[i].detailMoney*rate).toFixed(2)
                    for (var j=0; j<qdDivs[i].length; j++){
                        if (qdDivs[i][j].value == data[i].platform){
                            qdDivs[i][j].selected = true
                        }
                    }
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取实物TOP10数据失败 ==> ", xhr, status, error)
        }
    })
    // get fw top10
    $.ajax({
        url: `${url}/back/indetailtop/getTenByOrder`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date,
            type: "service"
        },
        success: res => {
            console.log("获取服务TOP10数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                // set data
                var mcDivs = $("input#mc-2")
                var wzDivs = $("input#wz-2")
                var lsDivs = $("input#ls-2")
                var qdDivs = $("select#qd-2")
                for (var i=0; i<10; i++){
                    mcDivs[i].value = data[i].shopName
                    wzDivs[i].value = data[i].detailUrl
                    lsDivs[i].value = (data[i].detailMoney*rate).toFixed(2)
                    for (var j=0; j<qdDivs[i].length; j++){
                        if (qdDivs[i][j].value == data[i].platform){
                            qdDivs[i][j].selected = true
                            break
                        }
                    }
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取服务TOP10数据失败 ==> ", xhr, status, error)
        }
    })
    // get nong top30
    $.ajax({
        url: `${url}/back/intopthirty/getThirtyOrder`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date
        },
        success: res => {
            console.log("获取农业TOP30数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                // set data
                var dpDivs = $("input#dp-3")
                var mcDivs = $("input#mc-3")
                var wzDivs = $("input#wz-3")
                var lseDivs = $("input#lse-3")
                var lslDivs = $("input#lsl-3")
                var qdDivs = $("select#qd-3")
                for (var i=0; i<30; i++){
                    dpDivs[i].value = data[i].goodsName
                    mcDivs[i].value = data[i].shopName
                    wzDivs[i].value = data[i].shopUrl
                    lseDivs[i].value = (data[i].saleMoney*rate).toFixed(2)
                    lslDivs[i].value = Math.round(data[i].saleNum*rate)
                    for (var j=0; j<qdDivs[i].length; j++){
                        if (qdDivs[i][j].value == data[i].platform){
                            qdDivs[i][j].selected = true
                            break
                        }
                    }
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取农业TOP30数据失败 ==> ", xhr, status, error)
        }
    })
    // get shop top30
    $.ajax({
        url: `${url}/back/inshop/getList`,
        type: "GET",
        async: false,
        headers: {
            'Authorization': token,
            'Content-Type': "application/json"
        },
        data: {
            address: area,
            date: date
        },
        success: res => {
            console.log("获取重点店铺TOP30数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                // set data
                var mcDivs = $("input#mc-4")
                var wzDivs = $("input#wz-4")
                var lseDivs = $("input#lse-4")
                var lslDivs = $("input#lsl-4")
                var qdDivs = $("select#sspt-4")
                for (var i=0; i<30; i++){
                    mcDivs[i].value = data[i].name
                    wzDivs[i].value = data[i].shopUrl
                    lseDivs[i].value = (data[i].saleMoney*rate).toFixed(2)
                    lslDivs[i].value = Math.round(data[i].saleNum*rate)
                    for (var j=0; j<qdDivs[i].length; j++){
                        if (qdDivs[i][j].value == data[i].belongTo){

                            qdDivs[i][j].selected = true
                            break
                        }
                    }
                }
            }
        },
        error: (xhr, status, error) => {
            console.log("获取重点店铺TOP30数据失败 ==> ", xhr, status, error)
        }
    })
})
