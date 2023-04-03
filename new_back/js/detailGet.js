// ---------------------------- init ------------------------
// request url
// var url = "http://36.133.200.169:8098"
var url = "http://117.50.183.219:8098"
// request token
var token =  "Bearer " +  window.localStorage.getItem("token")
// area and date
var reqUrl = decodeURI(location.search)
var strings = reqUrl.split("&")
// get area
var area = strings[0].split("=")[1]
// get date
var date = strings[2].split("=")[1]

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
                // set data
                $("div#qwlse")[0].lastChild.data = data.totalSaleMoney
                $("div#lsl")[0].lastChild.data = data.totalSaleNum
                $("input#dpsl")[0].value = data.shopNum
                $("input#cyry")[0].value = data.wlWorkNum
                $("input#wlzs")[0].value = data.wlDevelopment

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
                $("input#swxze")[0].value = data.detailMoney
                $("input#swlsl")[0].value = data.detailCount
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
                $("input#swxzdqdsj")[0].value = data.detailMoney
                $("input#swlslzdqd")[0].value = data.detailCount
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
    var nongMoney;
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
                $("input#ncpjyze")[0].value = data.saleMoney
                $("input#ncplsl")[0].value = data.saleNum
                nongMoney = parseInt(data.saleMoney)
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
                    percent -= parseInt(nongMoney == 0 ? 0 : parseInt(data[i].farmMoney*10000) / nongMoney * 100)
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
                $("input#fwxze")[0].value = data.detailMoney
                $("input#fwlsl")[0].value = data.detailCount
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
                $("input#fwxzdqdsj")[0].value = data.detailMoney
                $("input#fwlslzdqd")[0].value = data.detailCount
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
            type: "sale"
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
                    lsDivs[i].value = data[i].detailMoney
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
                    lsDivs[i].value = data[i].detailMoney
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
            console.log("获取服务TOP10数据成功 ==> ", res)
            if (res.data.length > 0){
                var data = res.data
                // set data
                var dpDivs = $("input#dp-3")
                var mcDivs = $("input#mc-3")
                var wzDivs = $("input#wz-3")
                var lseDivs = $("input#lse-3")
                var lslDivs = $("input#lsl-3")
                var qdDivs = $("select#qd-3")
                for (var i=0; i<10; i++){
                    dpDivs[i].value = data[i].goodsName
                    mcDivs[i].value = data[i].shopName
                    wzDivs[i].value = data[i].shopUrl
                    lseDivs[i].value = data[i].saleMoney
                    lslDivs[i].value = data[i].saleNum
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
})