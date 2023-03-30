var index, maxLeft;
$(function () {
    //range值提示
    $(".f-hk-1").mouseenter(function () {
        $(this).find(".f-range-tips-1").css("display", "block");
    });
    $(".f-hk-1").mouseleave(function () {
        $(this).find(".f-range-tips-1").css("display", "none");
    });

    //拖动开始X值
    var startX, preLeft, minLeft;
    var handle = false;

    $(".f-hk-1").mousedown(function (e) {
        //拖动开始的X坐标
        startX = e.pageX;
        //判断是否拖动的变量
        handle = true;
        index = $(".f-hk-1").index(this);
        //获取滑块下标
        preLeft = parseInt($(".f-hk-1").eq(index).css("left"));
        //获取滑块最左的值
        minLeft = parseInt($(".f-hk-1").eq(index - 1).css("left")) + 8;
    })

    $(document).mousemove(function (e) {
        e.stopPropagation();
        //是否点击滑块
        if (handle) {
            //显示提示值
            $(".f-hk-1").eq(index).find(".f-range-tips-1").css("display", "block");
            //是否第一个
            if (index == 0) {
                //是否最后一个
                if (index != $(".f-hk-1").length - 1) {
                    maxLeft = parseInt($(".f-hk-1").eq(index + 1).css("left")) - 8;
                } else {
                    maxLeft = $(".f-w100-1").width();
                }

                var newLeft = e.pageX - startX + preLeft;
                //设置边界
                if (newLeft > maxLeft) {
                    newLeft = maxLeft;
                }
                if (newLeft < 0) {
                    newLeft = 0;
                }
                //执行拖动
                $(".f-hk-1").eq(index).css("left", newLeft);
                //动态改变提示的值
                var myVal = parseInt((1 - (parseFloat($(".f-hk-1").eq(index).css("left")) - 8 * (index)) / ($(".f-w100-1").width() - 8 * (index + ($(".f-hk-1").length - index - 1)))) * 100) + "%";
                $(".f-hk-1").eq(index).find(".f-range-tips-1").html(myVal);
                //改变信息表值
                var getValNext;
                if (index != $(".f-hk-1").length - 1) {
                    getValNext = parseInt($(".f-hk-1").eq(index + 1).find(".f-range-tips-1").html());
                }
                else {
                    getValNext = 0;
                }
                $(".detail-slider-box-1").eq(index).find(".detail-slider-per-1").html((parseInt(myVal) - getValNext) + "%");
                //设置其他值
                var money = parseInt(parseInt($("input#swxze").val()) * (parseInt(myVal) - getValNext) / 100)
                var num = parseInt(parseInt($("input#swlsl").val()) * (parseInt(myVal) - getValNext) / 100)

                $(".detail-slider-box-1").eq(index).find(".detail-slider-mon-1").html(money);
                $(".detail-slider-box-1").eq(index).find(".detail-slider-num-1").html(num);
            } else {
                //是否最后一个
                if (index != $(".f-hk-1").length - 1) {
                    maxLeft = parseFloat($(".f-hk-1").eq(index + 1).css("left")) - 8;
                } else {
                    maxLeft = $(".f-w100-1").width();
                }

                var newLeft = e.pageX - startX + preLeft;
                //设置边界
                if (newLeft > maxLeft) {
                    newLeft = maxLeft;
                }
                if (newLeft < minLeft) {
                    newLeft = minLeft;
                }

                //执行拖动
                $(".f-hk-1").eq(index).css("left", newLeft);
                //动态改变提示的值
                var myVal = parseInt((1 - (parseFloat($(".f-hk-1").eq(index).css("left")) - 8 * (index)) / ($(".f-w100-1").width() - 8 * (index + ($(".f-hk-1").length - index - 1)))) * 100) + "%";
                $(".f-hk-1").eq(index).find(".f-range-tips-1").html(myVal);
                //改变信息表值
                var getValNext;
                var getValUp;
                if (index != $(".f-hk-1").length - 1) {
                    getValNext = parseInt($(".f-hk-1").eq(index + 1).find(".f-range-tips-1").html());
                }
                else {
                    getValNext = 0;
                }
                $(".detail-slider-box-1").eq(index).find(".detail-slider-per-1").html((parseInt(myVal) - getValNext) + "%");
                getValUp = parseInt($(".f-hk-1").eq(index - 1).find(".f-range-tips-1").html());
                $(".detail-slider-box-1").eq(index - 1).find(".detail-slider-per-1").html((getValUp - parseInt(myVal)) + "%");
                //设置其他值
                var money = parseInt(parseInt($("input#swxze").val()) * (parseInt(myVal) - getValNext) / 100)
                var num = parseInt(parseInt($("input#swlsl").val()) * (parseInt(myVal) - getValNext) / 100)
                var money1 = parseInt(parseInt($("input#swxze").val()) * (getValUp - parseInt(myVal)) / 100)
                var num1 = parseInt(parseInt($("input#swlsl").val()) * (getValUp - parseInt(myVal)) / 100)

                $(".detail-slider-box-1").eq(index).find(".detail-slider-mon-1").html(money);
                $(".detail-slider-box-1").eq(index).find(".detail-slider-num-1").html(num);
                $(".detail-slider-box-1").eq(index - 1).find(".detail-slider-mon-1").html(money1);
                $(".detail-slider-box-1").eq(index - 1).find(".detail-slider-num-1").html(num1);
            }
        }
    })
    
    $(document).mouseup(function () {
        handle = false;
        //隐藏值
        $(".f-range-tips-1").css("display", "none");
    })

    //初始化
    for (i = 0; i < $(".f-hk-1").length; i++) {
        //获取百分比
        var getVal = parseInt($(".f-hk-1").eq(i).find(".f-range-tips-1").html());
        var getValNext;
        if (i != $(".f-hk-1").length - 1) {
            getValNext = parseInt($(".f-hk-1").eq(i + 1).find(".f-range-tips-1").html());
        }
        else {
            getValNext = 0;
        }
        var totalWidth = $(".f-w100-1").width() - 8 * (i + 4 - 1 - i);
        var setLeft = parseInt((1 - getVal / 100) * (totalWidth)) + 8 * (i);
        //初始化left值
        $(".f-hk-1").eq(i).css("left", setLeft);
        //初始化值
        $(".detail-slider-box-1").eq(i).find(".detail-slider-per-1").html((getVal - getValNext) + "%");
        var money = parseInt(parseInt($("input#swxze").val()) * (getVal - getValNext) / 100);
        var num = parseInt(parseInt($("input#swlsl").val()) * (getVal - getValNext) / 100);

        $(".detail-slider-box-1").eq(i).find(".detail-slider-mon-1").html(money);
        $(".detail-slider-box-1").eq(i).find(".detail-slider-num-1").html(num);
    }
})