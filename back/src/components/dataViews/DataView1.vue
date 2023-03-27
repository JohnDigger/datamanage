<template>
    <div>
        <div class="view-title">
            <!-- 时间 -->
            <div class="view-time">{{ month }}</div>
            <!-- 备注 -->
            <div class="view-beizhu">注：全网零售额=实物型总额+服务型总额，全网零售量=实物型零售量+服务型零售量</div>
        </div>
        <!-- 统计部分 -->
        <div class="view-total">
            <div class="total-box">
                <div class="little-title">全站数据</div>
                <div>
                    <label for="total-money">全网销售额：</label>
                    <input type="text" id="total-money" v-model="totalMoney" /> 元
                </div>
                <div>
                    <label for="total-num">全网销售量：</label>
                    <input type="text" id="total-num" v-model="totalNum" /> 件
                </div>
                <div>
                    <label for="shop-num">店铺数量：</label>
                    <input type="text" id="shop-num" v-model="shopNum" /> 个
                </div>
            </div>
            <!-- 服务站大数据部分 -->
            <div class="total-box">
                <div class="little-title">服务站大数据部分</div>
                <div>
                    <label for="service-add-money">服务站累计交易额：</label>
                    <input type="text" id="service-add-money" v-model="serviceAddMoney" /> 元
                </div>
                <div>
                    <label for="total-service-num">服务站总数量：</label>
                    <input type="text" id="total-service-num" v-model="totalServiceNum" /> 个
                </div>
            </div>
            <!-- 网零发展指数 -->
            <div class="total-box">
                <div class="little-title">网零发展指数</div>
                <div>
                    <label for="wl-development">网零发展指数：</label>
                    <input type="text" id="wl-development" v-model="wl.devlopment" />
                </div>
                <div>
                    <label for="wl-sale-money">零售额：</label>
                    <input type="text" id="wl-sale-money" v-model="wl.saleMoney" /> 元
                </div>
                <div>
                    <label for="wl-shop-num">店铺数量：</label>
                    <input type="text" id="wl-shop-num" v-model="wl.shopNum" /> 个
                </div>
                <div>
                    <label for="wl-sale-num">零售量：</label>
                    <input type="text" id="wl-sale-num" v-model="wl.saleNum" /> 件
                </div>
                <div>
                    <label for="wl-worker">从业人数：</label>
                    <input type="text" id="wl-worker" v-model="wl.worker" /> 人
                </div>
            </div>
        </div><br><br>
        <!-- 实物型行业 -->
        <!-- 实物型标题 -->
        <div class="view-title">
            <div class="view-time">实物型行业</div>
            <div class="view-beizhu">注：各个品类数据依次为总额，总量，比例</div>
        </div>
        <div class="view-obj">
            <div>
                <label for="obj-sale-money">网络零售额：</label>
                <input type="text" id="obj-sale-money" v-model="obj.objSaleMoney" /> 元
            </div>
            <div>
                <label for="obj-sale-num">网络零售量：</label>
                <input type="text" id="obj-sale-num" v-model="obj.objSaleNum" /> 件
            </div>
            <hr>
            <div class="view-obj-bing" v-for="item, index in objList" :key="index">
                <div class="view-obj-type">
                    <div style="display: flex;">
                        <div class="view-obj-rect"
                            :style="`background: ${colorList[index]};`">
                        </div>
                        <div>&nbsp;{{ item.name }}</div>
                    </div>
                    <input type="text" :value="item.money">
                    <input type="text" :value="item.num">
                    <div>{{ item.percent }}%</div>
                </div>
            </div>
            <!-- 百分条 -->
            <div style="width: 100%; margin-right: 20px;">
                <div class="block" v-for="item, index in objList" :key="index" style="display: flex;">
                    <div style="white-space: nowrap;">{{ item.name }}：</div>
                    <el-slider v-model="item.percent"></el-slider>
                </div>
            </div>
            <div class="obj-percent">
                <div v-for="item, index in objList" 
                    :style="`background: ${colorList[index]}; width: ${item.percent}%;`" 
                    class="percent-rect" :key="index">
                    <div style="color: white; line-height: 32px;">{{ item.percent }}%</div>
                </div>
            </div>
        </div><br><br>
        <!-- 重点渠道 -->
        <div class="view-title">
            <div class="view-time">实物型重点渠道</div>
        </div><br><br>
        <!-- 服务型行业 -->
        <div class="view-title">
            <div class="view-time">服务型行业</div>
            <div class="view-beizhu">注：各个品类数据依次为总额，总量，比例</div>
        </div><br><br>
        <!-- 重点网商列表 -->
        <!-- 农产品列表 -->
    </div>
</template>

<script>
    import Slider from '../slider.vue'
    export default {
        name: 'data1',
        props: {
            month: String
        },
        components: {
            Slider
        },
        data() {
            return {
                totalMoney: 0, // 全网销售额
                totalNum: 0, // 全网销售量
                shopNum: 0, // 店铺数量
                serviceAddMoney: 0, // 服务站累计交易额
                totalServiceNum: 0, // 服务站总数量
                wl: { // 网零发展指数部分
                    devlopment: 0,
                    saleMoney: 0,
                    shopNum: 0,
                    saleNum: 0,
                    worker: 0
                },
                obj: { // 实物型
                    objSaleMoney: 1000,
                    objSaleNum: 50
                },
                objList: [
                    {
                        name: '母婴',
                        money: 100,
                        percent: 0,
                        num: 1
                    },
                    {
                        name: '食品酒水',
                        money: 200,
                        percent: 0,
                        num: 2
                    },
                    {
                        name: '家具家装',
                        money: 300,
                        percent: 0,
                        num: 3
                    },
                    {
                        name: '户外运动',
                        money: 400,
                        percent: 0,
                        num: 4
                    }
                ],
                colorList: [
                    '#f03e3e',
                    '#d6336c',
                    '#ae3ec9',
                    '#7048e8',
                    '#4263eb',
                    '#1c7ed6',
                    '#1098ad',
                    '#0ca678',
                    '#37b24d',
                    '#74b816',
                    '#f59f00',
                    '#f76707'
                ]
            }
        },
        mounted() {
            this.calcPercent()
        },
        methods: {
            calcPercent(){
                for(var i=0; i<this.objList.length; i++){
                    this.objList[i].percent = this.objList[i].money / this.obj.objSaleMoney * 100
                }
            },
            calcWatch(newVal, oldVal) {
                
            }
        },
        watch: {
            objList: {
                handler(newVal, oldVal) {
                    console.log(newVal, '---', oldVal)
                },
                deep: true,
                immediate: true
            }
        }
    }
</script>

<style lang="less" scoped>
    label {
        font-size: 16px;
        font-weight: 600;
        display: inline-block;
        min-width: 150px;
    }
    hr {
        width: 120%;
    }

    .view-title {
        display: flex;
        justify-content: space-between;
        align-content: center;
        .view-time {
            font-size: 28px;
            font-weight: 600;
        }
        .view-beizhu {
            border: 1px #fff solid;
            background: #2746aa;
            padding: 5px 15px 5px 15px;
        }
    }

    .view-total {
        display: flex;
        justify-content: space-evenly;
        margin: 10px 0 0 0;
        .total-box {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            width: 34%;
            border: 1px white solid;
            // transform: skewX(10deg);
            padding: 0 0 15px 0;
            
            &>div {
                // transform: skewX(-10deg);
                margin: 10px 0 0 10px;
            }

            .little-title {
                font-size: 18px;
                font-weight: 900;
                width: 100%;
                text-align: center;
                margin: 10px 0 10px 0;
            }
        }
    }

    .view-obj {
        display: flex;
        flex-wrap: wrap;
        border: 1px white solid;
        padding: 5px 0 10px 0;
        margin: 10px 0 0 0;
        &> div {
            margin: 10px 0 0 20px;
        }
        .view-obj-bing{
            display: flex;
            flex-wrap: wrap;
            .view-obj-type {
                display: flex;
                flex-wrap: wrap;
                flex-direction: column;
                line-height: 26px;
                margin: 0 20px 0 0;
                .view-obj-rect {
                    height: 24px;
                    width: 24px;
                    // border: 1px #999999 solid;
                    box-shadow: 1px 1px 3px 0 #b3beff;
                }
                &> input {
                    margin-top: 3px;
                    width: 90px;
                }
            }
        }
        .obj-percent {
            width: 100%;
            height: 32px;
            border-radius: 5px;
            overflow: hidden;
            display: flex;
            margin-right: 20px;
            .percent-rect {
                height: 32px;
            }
        }
    }
</style>