<template>
    <div class="box">
        <!--滑动选区-->
        <div class="f-range">
            <div class="f-hk" 
                v-for="item, index in dataList"
                :key="index" 
                :class="`${index == 0 ? 'first-block' : ''}`">
                <span class="f-range-tips">{{ Math.round(percentList[index]) }}%</span>
            </div>
            <div class="f-rect">
                <div v-for="item, index in dataList" 
                    :key="index"
                    :style="`background: ${colorList[index]}; width: ${divWidthList[index]}%;`">
                    {{ item.percent }}%
                </div>
            </div>
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
        dataList: [],
    },
    data() {
        return {
            percentList: [],
            divWidthList: [],
            colorList: [
                '#f03e3e', '#d6336c', '#ae3ec9', '#7048e8', '#4263eb', '#1c7ed6',
                '#1098ad', '#0ca678', '#37b24d', '#74b816', '#f59f00', '#f76707'
            ]
        }
    },
    methods: {
        clacPercent(){
             // 处理百分比
            var firstPercent = 0;
            this.percentList.push(firstPercent)
            for (var i=0; i<this.dataList.length - 1; i++){
                // 位置百分比
                firstPercent += this.dataList[i].percent
                this.percentList.push(firstPercent)
                // div宽度百分比
                this.divWidthList.push(this.dataList[i].percent)
            }
            this.divWidthList.push(this.dataList[this.dataList.length - 1].percent)
        }
    },
    mounted() {
        this.clacPercent()
    },
    created() {
        // jQuery滑块部分
        const that = this;
        var index; // 当前的滑块
        $(function() {
            // ----------------------- 初始化 -------------------------------
            for (var i = 0; i<$(".f-hk").length; i++) {
                // 获取百分比
                var getVal = parseInt($(".f-hk").eq(i).find(".f-range-tips").html());
                var setLeft = parseInt(getVal / 100 * $('.box').width());
                // 初始化left值
                $(".f-hk").eq(i).css("left", setLeft);
            }

            // ------------------------- 拖动部分 ------------------------
            var startX; // 鼠标点击的X坐标
            var preLeft; // 滑块坐标
            var minLeft; // 滑块左侧的滑块坐标
            var maxLeft; // 滑块右侧滑块的坐标
            var handle = false; // 是否点击滑块
            var divWidth = $(".f-hk").width() + 2; // 滑块宽 + 边框

            // 鼠标点击
            $(".f-hk").mousedown(function (e) {
                // 拖动开始的X坐标
                startX = e.pageX;
                // 判断是否拖动的变量
                handle = true;
                index = $(".f-hk").index(this);
                // 获取滑块的left
                preLeft = parseFloat($(".f-hk").eq(index).css("left"));
                // 获取滑块左侧的滑块的left
                if (index > 0){
                    minLeft = parseFloat($(".f-hk").eq(index - 1).css("left"));
                }
                else {
                    minLeft = 0;
                }
                // 获取滑块右侧的滑块的left
                if (index != $(".f-hk").length - 1) {
                    maxLeft = parseFloat($(".f-hk").eq(index + 1).css("left"));
                } else {
                    maxLeft = $(".box").width();
                }
            })

            // 鼠标拖动
            $(document).mousemove(function (e) {
                e.stopPropagation();
                // 是否点击滑块
                if (handle) {
                    // 是否第一个
                    if (index != 0) {
                        // 计算鼠标拖动位置
                        var newLeft = e.pageX - startX + preLeft;
                        // 超出边界就不赋值
                        if (newLeft > maxLeft - divWidth) {
                            newLeft = maxLeft - divWidth;
                        }
                        if (index > 1){
                            if (newLeft < minLeft + divWidth) {
                                newLeft = minLeft + divWidth;
                            }
                        }
                        else {
                            if (newLeft < minLeft) {
                                newLeft = minLeft;
                            }
                        }
                        // 拖动 --> 设置新的left
                        $(".f-hk").eq(index).css("left", newLeft);

                        // 改变提示的值
                        var myTip = (parseFloat($(".f-hk").eq(index).css("left"))) / parseFloat($('.box').width()) * 100;
                        that.percentList[index] = myTip
                        
                        // 百分比列表赋值
                        if (index != $(".f-hk").length - 1) {
                            that.dataList[index].percent = Math.round(that.percentList[index + 1] - myTip < 1 ? 0 : that.percentList[index + 1] - myTip);
                            that.dataList[index - 1].percent = Math.round(myTip - that.percentList[index - 1] < 1 ? 0 : myTip - that.percentList[index - 1]);
                            that.divWidthList[index] = that.percentList[index + 1] - myTip;
                            that.divWidthList[index - 1] = myTip - that.percentList[index - 1];
                        }
                        else {
                            that.dataList[index].percent = Math.round(100 - myTip < 1 ? 0 : 100 - myTip);
                            that.dataList[index - 1].percent = Math.round(myTip - that.percentList[index - 1] < 1 ? 0 : myTip - that.percentList[index - 1]);
                            that.divWidthList[index] = 100 - myTip;
                            that.divWidthList[index - 1] = myTip - that.percentList[index - 1];
                        }
                    }
                }
            })
            
            // 百分比弹出框提示
            $(".f-hk").mouseenter(function () { // 移入
                $(this).find(".f-range-tips").css("display", "block");
            });
            $(".f-hk").mouseleave(function () { // 移出
                $(this).find(".f-range-tips").css("display", "none");
            });

            // 避免无法取消拖动
            $(document).mouseup(function () {
                handle = false;
                //隐藏值
                $(".f-range-tips").css("display", "none");
            })
        })
    },
}
</script>

<style scoped>

/* mine */
.box {
    width: 100%;
    color: white;
    padding: 15px 0 0 0;
}
.f-rect {
    display: flex;
    align-items: flex-start;
}
.f-rect > div {
    height: 20px;
    overflow: hidden;
    width: 0px;
}
.first-block {
    display: none;
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
    border-radius: 2px;
    background: transparent;
}

.f-hk {
    position: absolute;
    top: -3px;
    height: 24px;
    width: 6px;
    z-index: 1;
    cursor: move;
    left: 8px;
    background: white;
    border: 1px black solid;
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