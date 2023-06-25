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
                        <div class="view-obj-rect" :style="`background: ${colorList[index]};`">
                        </div>
                        <div>&nbsp;{{ item.name }}</div>
                    </div>
                    <input type="text" :value="item.money">
                    <input type="text" :value="item.num">
                    <div>{{ item.percent }}%</div>
                </div>
            </div>
            <!-- 百分条 -->
            <Slider :data-list="objList"></Slider>
        </div><br><br>
        <!-- 重点渠道 -->
        <!-- <div class="view-title">
            <div class="view-time">实物型重点渠道</div>
        </div><br><br> -->

        <!-- 服务型行业 -->
        <div class="view-title">
            <div class="view-time">服务型行业</div>
            <div class="view-beizhu">注：各个品类数据依次为总额，总量，比例</div>
        </div>
        <div class="view-obj">
            <div>
                <label for="obj-sale-money">网络零售额：</label>
                <input type="text" id="obj-sale-money" v-model="service.serviceSaleMoney" /> 元
            </div>
            <div>
                <label for="obj-sale-num">网络零售量：</label>
                <input type="text" id="obj-sale-num" v-model="service.serviceSaleNum" /> 件
            </div>
            <hr>
            <div class="view-obj-bing" v-for="item, index in serviceList" :key="index">
                <div class="view-obj-type">
                    <div style="display: flex;">
                        <div class="view-obj-rect" :style="`background: ${colorList[index]};`">
                        </div>
                        <div>&nbsp;{{ item.name }}</div>
                    </div>
                    <input type="text" :value="item.money">
                    <input type="text" :value="item.num">
                    <div>{{ item.percent }}%</div>
                </div>
            </div>
            <!-- 百分条 -->
            <!-- <Slider :data-list="serviceList"></Slider> -->
        </div><br><br>

        <!-- 重点网商列表 -->
        <div class="view-title">
            <div class="view-time">重点网商列表</div>
        </div><br>

        <div class="key-netproviders">
            <br>

            <div class="data-operate">
                <div class="add-data" @click="addData" style="white-space: nowrap; padding: 5px 15px; user-select: none; border-radius: 5px;">
                    增加
                </div>
                <div class="delete-data" @click="deleteData" style="white-space: nowrap; padding: 5px 15px; user-select: none; border-radius: 5px;">
                    删除
                </div>
            </div>

            <div class="add-key-netprovider" v-for="(div, index) in divs" :key="index">
                <label for="providerName">店铺名称：</label>
                <input type="text" id="providerName" v-model="div.name">

                <label for="providerPlatform">所属平台：</label>
                <input type="text" id="providerPlatform" v-model="div.belongTo">

            </div><br>
        </div><br><br>
        <!-- 农产品列表 -->
        <div class="view-title">
            <div class="view-time">农产品行业交易分析</div>
        </div><br>
        <div class="annual-data">
            <div class="grid-container" style="height: 370px;">
                <div v-for="(item, index) in 6" :key="index" class="grid-item">
                    <div class="item-content">
                        <div class="add-annual-data">
                            <label for="providerName">名字：</label>
                            <input type="text" id="providerName" v-model="item.retailSales">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <br>
                            <label for="providerName">零售额：</label>
                            <input type="text" id="providerName" v-model="item.retailSales"> 万元
                            <br>
                            <label for="providerName">零售量：</label>
                            <input type="text" id="providerName" v-model="item.countSales"> 万件
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br>

        <!-- 年度趋势分析 -->
        <div class="view-title">
            <div class="view-time">年度零售数据趋势分析</div>
        </div><br>
        <div class="annual-data">
            <div class="grid-container">
                <div v-for="(item, index) in items" :key="index" class="grid-item">
                    <div class="item-content">
                        <h3>{{ item.month }}月</h3>
                        <div class="add-annual-data">
                            <label for="providerName">零售额：</label>
                            <input type="text" id="providerName" v-model="item.retailSales"> 万元
                            <br><br>
                            <label for="providerName">零售量：</label>
                            <input type="text" id="providerName" v-model="item.countSales"> 万件
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 提交按钮 -->
        <div style="width: 100px; height: 36px; background: #2746aa;
            margin: 20px auto; line-height: 36px; border-radius: 5px;" @click="submit">
            提交
        </div>
    </div>
</template>

<script>
import Slider from '../slider.vue'
import request from "@/utils/request";
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
                devlopment: 0.0,
                saleMoney: 0,
                shopNum: 0,
                saleNum: 0,
                worker: 0
            },
            colorList: [
                '#f03e3e', '#d6336c', '#ae3ec9', '#7048e8', '#4263eb', '#1c7ed6',
                '#1098ad', '#0ca678', '#37b24d', '#74b816', '#f59f00', '#f76707'
            ],
            obj: { // 实物型
                objSaleMoney: 1000,
                objSaleNum: 10
            },
            objList: [
                {
                    name: '母婴',
                    money: 100,
                    percent: 10,
                    num: 1
                },
                {
                    name: '食品酒水',
                    money: 200,
                    percent: 20,
                    num: 2
                },
                {
                    name: '家具家装',
                    money: 300,
                    percent: 30,
                    num: 3
                },
                {
                    name: '户外运动',
                    money: 400,
                    percent: 40,
                    num: 4
                }
            ],
            service: { // 服务型
                serviceSaleMoney: 3200,
                serviceSaleNum: 32
            },
            serviceList: [
                {
                    name: '在线餐饮',
                    money: 400,
                    percent: 10,
                    num: 4
                },
                {
                    name: '拍卖',
                    money: 400,
                    percent: 15,
                    num: 4
                },
                {
                    name: '虚拟商品',
                    money: 400,
                    percent: 5,
                    num: 4
                },
                {
                    name: '休闲娱乐',
                    money: 400,
                    percent: 20,
                    num: 4
                },
                {
                    name: '医疗健康',
                    money: 400,
                    percent: 25,
                    num: 4
                },
                {
                    name: '在线旅游',
                    money: 400,
                    percent: 15,
                    num: 4
                },
                {
                    name: '生活服务',
                    money: 400,
                    percent: 5,
                    num: 4
                },
                {
                    name: '教育培训',
                    money: 400,
                    percent: 5,
                    num: 4
                }
            ],

            divs: [], // 存放动态创建的 div 元素
            nextId: 1, // 用于生成每个 div 的唯一标识符

            provider: {
                name: "",
                flatform: ""
            },
            items: [
                {
                    month: 1,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 2,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 3,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 4,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 5,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 6,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 7,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 8,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 9,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 10,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 11,
                    retailSales: "",
                    countSales: ""
                },
                {
                    month: 12,
                    retailSales: "",
                    countSales: ""
                },
            ]
        }
    },
    mounted() {

        this.calcPercent()
    },

    created() {
        // 创建一个初始的 div 元素对象，并添加到 divs 数组中
        const initialDiv = {
          index: this.nextId++,
          name: "",
          belongTo: "",
          time: this.$route.query.selectMonth,
          dataAddress: this.$route.query.areaName,
        }
        this.divs.push(initialDiv)
        // var annualData = {
        //   month:0,
        //   retailSales:"",
        //   countSales:""
        // }

        // for (let i=1;i<=12;i++){
        // 	annualData.month++;
        // 	this.annualDatas.push(annualData);
        // 	console.log(annualData);
        // }

        // console.log(this.annualDatas)
    },

    methods: {
        calcPercent() {
            for (var i = 0; i < this.objList.length; i++) {
                this.objList[i].percent = this.objList[i].money / this.obj.objSaleMoney * 100
            }
        },
        submit(){
          this.submitPanel()
          request.request({
            url: '/back/inshop/save',
            method: 'POST',
            data: {
              list: this.divs
            }
          }).then(res => {
            if (res.status === 200){
              this.$message({
                type: 'success',
                message: '添加成功'
              });
            }
          }).catch(err => {
            console.log(err)
            // this.$router.push('/month')
          })
          let data = []
          this.items.forEach((ele)=>{
            data.push({dateTime:this.$route.query.selectMonth.substring(0,4)+ele.month.toString().padStart(2, '0'),yearMoney: ele.retailSales,yearCount: ele.countSales,dataAddress:this.$route.query.areaName})
          })
          request.request({
            url: '/back/inallyeartrend/save',
            method: 'POST',
            data: {
              list: data
            }
          }).then(res => {
            if (res.status === 200){
              this.$message({
                type: 'success',
                message: '添加成功'
              });
            }
          }).catch(err => {
            console.log(err)
            // this.$router.push('/month')
          })

        },
        addData() {
            console.log("添加数据");

            const newDiv = {
                id: this.nextId++,
                name: "",
                flatform: ""
            }
            this.divs.push(newDiv)
        },

        deleteData() {
            console.log("删除数据");
            if (this.divs.length > 0) {
                this.divs.pop()
            }
        },
      submitPanel(){
        request.request({
          url: '/back/indata/save',
          method: 'POST',
          data: {
            time: this.$route.query.selectMonth,
            dataAddress: this.$route.query.areaName,
            totalSaleMoney:this.totalMoney,
            totalSaleCount: this.totalNum,
            shopNum: this.shopNum,
            wlSaleMoney: this.wl.saleMoney,
            wlSaleNum: this.wl.saleNum,
            wlDevelopment: this.wl.devlopment,
            wlShopNum: this.wl.shopNum,
            wlWorkNum: this.wl.worker

          }
        }).then(res => {
          if (res.status === 200){
            this.$message({
              type: 'success',
              message: '添加成功'
            });
          }
        }).catch(err => {
          console.log(err)
          // this.$router.push('/month')
        })

        request.request({
          url: '/back/indetailpanel/save',
          method: 'POST',
          data: {
            time: this.$route.query.selectMonth,
            dataAddress: this.$route.query.areaName,
            detailMoney: this.obj.objSaleMoney,
            detailNum: this.obj.objSaleNum,
            type: 'sale'
          }
        }).then(res => {
          if (res.status === 200){
            this.$message({
              type: 'success',
              message: '添加成功'
            });
          }
        }).catch(err => {
          console.log(err)
          // this.$router.push('/month')
        })

        request.request({
          url: '/back/indetailpanel/save',
          method: 'POST',
          data: {
            time: this.$route.query.selectMonth,
            dataAddress: this.$route.query.areaName,
            detailMoney: this.service.serviceSaleMoney,
            detailNum: this.service.serviceSaleNum,
            type: 'service'
          }
        }).then(res => {
          if (res.status === 200){
            this.$message({
              type: 'success',
              message: '添加成功'
            });
          }
        }).catch(err => {
          console.log(err)
          // this.$router.push('/month')
        })

      },

    },
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

    &>div {
        margin: 10px 20px 0 20px;
    }

    .view-obj-bing {
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

            &>input {
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

.key-netproviders {
    border: 1px white solid;

    .data-operate {
        display: flex;
        flex: rows;
        margin: auto;
        width: 13%;


        .add-data {

            background-color: #2057aa;
            color: white;

        }

        .delete-data {

            margin-left: 30%;
            background-color: #aa103e;
            color: white;
        }
    }

    .add-key-netprovider {
        display: flex;
        flex: rows;
        width: 60%;
        margin: auto;
        margin-top: 10px;

    }
}

.annual-data {
    border: 1px white solid;

    .grid-container {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-template-rows: repeat(6, 1fr);
        gap: 10px;

    }

    .grid-item {
        padding: 10px;

    }

    .item-content {

        padding: 10px;
        text-align: center;
    }
}</style>
