$(function(){
    // initvar s_money, s_num, f_money, f_num
    // init data
    s_money = parseInt($("input#swxze").val())
    s_num = parseInt($("input#swlsl").val())
    f_money = parseInt($("input#fwxze").val())
    f_num = parseInt($("input#fwlsl").val())
    // set data
    $("div#qwlse")[0].lastChild.data = s_money + f_money
    $("div#lsl")[0].lastChild.data = s_num + f_num
    $("input#swxzdqdsj")[0].max = s_money
    $("input#swlslzdqd")[0].max = s_num
    $("input#ncpjyze")[0].max = s_money
    $("input#ncplsl")[0].max = s_num
    $("input#fwxzdqdsj")[0].max = f_money
    $("input#fwlslzdqd")[0].max = f_num
    
    // check input
    $('input#swxze').on('input propertychange',function(){
        s_money = parseInt($(this).val())
        $("div#qwlse")[0].lastChild.data = s_money + f_money
        // calc percent
        // children's input
        $("input#swxzdqdsj")[0].max = s_money
        if (parseInt($("input#swxzdqdsj")[0].value) > s_money){
            $("input#swxzdqdsj")[0].value = s_money
        }
        $("input#ncpjyze")[0].max = s_money
        if(parseInt($("input#ncpjyze")[0].value) > s_money){
            $("input#ncpjyze")[0].value = s_money
        }
    })
    $("input#swxzdqdsj").on("input propertychange", function(){
        if (parseInt($("input#swxzdqdsj")[0].value) > parseInt($("input#swxze")[0].value)){
            $("input#swxzdqdsj")[0].value = $("input#swxze")[0].value
        }
    })
    $("input#ncpjyze").on("input propertychange", function(){
        if (parseInt($("input#ncpjyze")[0].value) > parseInt($("input#swxze")[0].value)){
            $("input#ncpjyze")[0].value = $("input#swxze")[0].value
        }
    })
    $('input#fwxze').on('input propertychange',function(){
        f_money = parseInt($(this).val())
        $("div#qwlse")[0].lastChild.data = s_money + f_money
        // children's input
        $("input#fwxzdqdsj")[0].max = f_money
        if (parseInt($("input#fwxzdqdsj")[0].value) > f_money) {
            $("input#fwxzdqdsj")[0].value = f_money
        }
    })
    $("input#fwxzdqdsj").on("input propertychange", function(){
        if (parseInt($("input#fwxzdqdsj")[0].value) > parseInt($('input#fwxze')[0].value)) {
            $("input#fwxzdqdsj")[0].value = $('input#fwxze')[0].value
        }
    })
    
    $('input#swlsl').on('input propertychange',function(){
        s_num = parseInt($(this).val())
        $("div#lsl")[0].lastChild.data = s_num + f_num
        // children's input
        $("input#swlslzdqd")[0].max = s_num
        if (parseInt($("input#swlslzdqd")[0].value) > s_num){
            $("input#swlslzdqd")[0].value = s_num
        }
        $("input#ncplsl")[0].max = s_num
        if (parseInt($("input#ncplsl")[0].value) > s_num){
            $("input#ncplsl")[0].value = s_num
        }
    })
    $("input#swlslzdqd").on("input propertychange", function(){
        if (parseInt($("input#swlslzdqd")[0].value) > parseInt($('input#swlsl')[0].value)){
            $("input#swlslzdqd")[0].value = $('input#swlsl')[0].value
        }
    })
    $("input#ncplsl").on("input propertychange", function(){
        if (parseInt($("input#ncplsl")[0].value) > parseInt($('input#swlsl')[0].value)){
            $("input#ncplsl")[0].value = $('input#swlsl')[0].value
        }
    })
    $('input#fwlsl').on('input propertychange',function(){
        f_num = parseInt($(this).val())
        $("div#lsl")[0].lastChild.data = s_num + f_num
        // children's input
        $("input#fwlslzdqd")[0].max = f_num
        if (parseInt($("input#fwlslzdqd")[0].value) > f_num){
            $("input#fwlslzdqd")[0].value = f_num
        }
    })
    $("input#fwlslzdqd").on("input propertychange", function(){
        if (parseInt($("input#fwlslzdqd")[0].value) > parseInt($('input#fwlsl')[0].value)){
            $("input#fwlslzdqd")[0].value = $('input#fwlsl')[0].value
        }
    })
})