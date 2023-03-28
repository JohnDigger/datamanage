<template>
    <div class="box">
        <div class="f-mb40">
            <p class="f-range-msg" v-for="item, index in dataList" :key="index">
                <span class="f-color f-color1">&nbsp;</span>
                <span class="f-color-text">{{item.name }}</span>
                <span class="f-color-area"><span class="f-valMax">100%</span>~<span class="f-valMin">70%</span></span>
            </p>
            <p class="f-range-msg">
                <span class="f-color f-color1">&nbsp;</span>
                <span class="f-color-text">选项1</span>
                <span class="f-color-area"><span class="f-valMax">100%</span>~<span class="f-valMin">70%</span></span>
            </p>
            <p class="f-range-msg">
                <span class="f-color f-color2">&nbsp;</span>
                <span class="f-color-text">选项2</span>
                <span class="f-color-area"><span class="f-valMax">70%</span>~<span class="f-valMin">55%</span></span>
            </p>
            <div class="clear"></div>
            <p class="f-range-msg">
                <span class="f-color f-color3">&nbsp;</span>
                <span class="f-color-text">选项3</span>
                <span class="f-color-area"><span class="f-valMax">55%</span>~<span class="f-valMin">45%</span></span>
            </p>
            <p class="f-range-msg">
                <span class="f-color f-color4">&nbsp;</span>
                <span class="f-color-text">选项4</span>
                <span class="f-color-area"><span class="f-valMax">45%</span>~<span class="f-valMin">35%</span></span>
            </p>
            <div class="clear"></div>
        </div>
        <!--滑动选区-->
        <div class="f-range">
            <div class="f-hk f-hk1" src="../assets/slider/hk1.png"><span class="f-range-tips">80%</span></div>
            <div class="f-hk f-hk2" src="../assets/slider/hk2.png"><span class="f-range-tips">35%</span></div>
            <div class="f-hk f-hk3" src="../assets/slider/hk3.png"><span class="f-range-tips">25%</span></div>
            <div class="f-hk f-hk4" src="../assets/slider/hk4.png"><span class="f-range-tips">0%</span></div>
        </div>
        <!--滑动选区-->
        <p class="f-rangeArea clearfix">
            <span class="left">0%</span>
            <span class="right">100%</span>
        </p>
    </div>
</template>

<script>
import $ from 'jquery'
export default {
    name: 'slider',
    props: {
        dataList: Array,
    },
    data() {
        return {
            colorList: [
                '#f03e3e', '#d6336c', '#ae3ec9', '#7048e8', '#4263eb', '#1c7ed6',
                '#1098ad', '#0ca678', '#37b24d', '#74b816', '#f59f00', '#f76707'
            ]
        }
    },
    created() {
        var index, maxLeft;
        $(function () {
            //range值提示
            $(".f-hk").mouseenter(function () {
                $(this).find(".f-range-tips").css("display", "block");
            });
            $(".f-hk").mouseleave(function () {
                $(this).find(".f-range-tips").css("display", "none");
            });

            //拖动开始X值
            var startX, preLeft, minLeft;
            var handle = false;

            $(".f-hk").mousedown(function (e) {
                //拖动开始的X坐标
                startX = e.pageX;
                //判断是否拖动的变量
                handle = true;
                index = $(".f-hk").index(this);
                //获取滑块下标
                preLeft = parseInt($(".f-hk").eq(index).css("left"));
                //获取滑块最左的值
                minLeft = parseInt($(".f-hk").eq(index - 1).css("left")) + 8;
            })

            $(document).mousemove(function (e) {
                e.stopPropagation();
                //是否点击滑块
                if (handle) {
                    //显示提示值
                    $(".f-hk").eq(index).find(".f-range-tips").css("display", "block");
                    //是否第一个
                    if (index == 0) {
                        //是否最后一个
                        if (index != $(".f-hk").length - 1) {
                            maxLeft = parseInt($(".f-hk").eq(index + 1).css("left")) - 8;
                        } else {
                            maxLeft = $('.box').width();
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
                        $(".f-hk").eq(index).css("left", newLeft);
                        //动态改变提示的值
                        var myVal = parseInt((1 - (parseFloat($(".f-hk").eq(index).css("left")) - 8 * (index)) / ($('.box').width() - 8 * (index + ($(".f-hk ").length - index - 1)))) * 100) + "%";
                        $(".f-hk").eq(index).find(".f-range-tips").html(myVal);
                        //改变 信息表最小值
                        $(".f-range-msg").eq(index).find(".f-valMin").html(myVal);
                        //改变信息表最大值
                        if (index != $(".f-hk ").length - 1) {
                            var max = $(".f-range-msg").eq(index + 1).find(".f-valMax").html(myVal);
                        }
                    } else {
                        //是否最后一个
                        if (index != $(".f-hk").length - 1) {
                            maxLeft = parseFloat($(".f-hk").eq(index + 1).css("left")) - 8;
                        } else {
                            maxLeft = $('.box').width();
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
                        $(".f-hk").eq(index).css("left", newLeft);
                        //动态改变提示的值
                        var myVal = parseInt((1 - (parseFloat($(".f-hk").eq(index).css("left")) - 8 * (index)) / ($('.box').width() - 8 * (index + ($(".f-hk ").length - index - 1)))) * 100) + "%";
                        $(".f-hk").eq(index).find(".f-range-tips").html(myVal);
                        //改变信息表最小值
                        $(".f-range-msg").eq(index).find(".f-valMin").html(myVal);
                        //改变信息表最大值
                        if (index != $(".f-hk ").length - 1) {
                            var max = $(".f-range-msg").eq(index + 1).find(".f-valMax").html(myVal);
                        }
                    }


                }
            })
            $(document).mouseup(function () {
                handle = false;
                //隐藏值
                $(".f-range-tips").css("display", "none");
            })

            //初始化
            for (var i = 0; i < $(".f-hk").length; i++) {
                //获取百分比
                var getVal = parseInt($(".f-hk").eq(i).find(".f-range-tips").html());
                var totalWidth = $('.box').width() - 8 * (i + 4 - 1 - i);
                var setLeft = parseInt((1 - getVal / 100) * (totalWidth)) + 8 * (i);
                //初始化left值
                $(".f-hk").eq(i).css("left", setLeft);
                //初始化最小值
                $(".f-range-msg").eq(i).find(".f-valMin").html(getVal + "%");
                //初始化最大值
                if (i != $(".f-hk").length - 1) {
                    $(".f-range-msg").eq(i + 1).find(".f-valMin").html(getVal + "%");
                }

            }

        })
    },
}
</script>

<style scoped>
.box {
    width: 100%;
    color: white;
}

/* CSS Document */
/*range*/
.clearfix {
    *zoom: 1;
}

.clearfix:after {
    display: block;
    overflow: hidden;
    clear: both;
    height: 0;
    visibility: hidden;
    content: "";
}

.clear {
    clear: both;
}

.left {
    float: left;
}

.right {
    float: right;
}

.f-range {
    height: 20px;
    width: 100%;
    position: relative;
    background: #70BAFF;
}

.f-hk {
    position: absolute;
    top: -3px;
    height: 26px;
    width: 8px;
    z-index: 1;
    cursor: move;
}

.f-hk1 {
    left: 0px;
    background-image: url(../assets/slider/hk1.png);
    background-repeat: no-repeat;
    background-size: cover;
}

.f-hk2 {
    left: 8px;
    background-image: url(../assets/slider/hk2.png);
    background-repeat: no-repeat;
    background-size: cover;
}

.f-hk3 {
    left: 16px;
    background-image: url(../assets/slider/hk3.png);
    background-repeat: no-repeat;
    background-size: cover;
}

.f-hk4 {
    left: 24px;
    background-image: url(../assets/slider/hk4.png);
    background-repeat: no-repeat;
    background-size: cover;
}

.f-rangeArea {
    margin-top: 10px;
    color: white;
    font-size: 16px;
    width: 100%;
}

.f-color {
    border-radius: 50%;
    width: 10px;
    height: 10px;
    display: inline-block;
    position: relative;
    top: 7px;
    *top: -7px;
}

.f-color1 {
    background-color: #2FB9C5;
}

.f-color2 {
    background-color: #E3B21E;
}

.f-color3 {
    background-color: #A246DB;
}

.f-color4 {
    background-color: #DB5D44;
}

.f-range-tips {
    display: none;
    color: #fff;
    width: 35px;
    font-size: 12px;
    height: 22px;
    line-height: 17px;
    z-index: 2;
    position: relative;
    top: -30px;
    left: -15px;
    text-align: center;
    background-image: url(../assets/slider/rangeNum.png);
    background-size: cover;
    background-repeat: no-repeat;
}

.f-rangeArea {
    margin-bottom: 10px;
}

.f-range-msg {
    margin-top: 10px;
    font-size: 16px;
    text-align: left;
    color: white;
    float: left;
}

.f-color-text {
    display: inline-block;
    margin-left: 10px;
    width: 105px;
}

.f-color-area {
    display: inline-block;
    width: 150px;
    color: #ff7916;
}

.f-mb40 {
    margin-bottom: 40px;
}
</style>