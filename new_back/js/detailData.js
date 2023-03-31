$(function(){
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
        if ($("input#swxzdqdsj")[0].value > s_money){
            $("input#swxzdqdsj")[0].value = s_money;
        }
        $("input#ncpjyze")[0].max = s_money;
        if($("input#ncpjyze")[0].value > s_money){
            $("input#ncpjyze")[0].value = s_money;
        }
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
        if ($("input#swlslzdqd")[0].value > s_num){
            $("input#swlslzdqd")[0].value = s_num
        }
        $("input#ncplsl")[0].max = s_num;
        if ($("input#ncplsl")[0].value > s_num){
            $("input#ncplsl")[0].value = s_num
        }
    });
    $('input#fwlsl').on('input propertychange',function(){
        f_num = parseInt($(this).val());
        $("div#lsl")[0].lastChild.data = s_num + f_num;
        // children's input
        $("input#fwlslzdqd")[0].max = f_num;
    });
})