<template>
    <div>
        <Bgd></Bgd>
        <!-- 导航栏 -->
        <Banner :isBack="true"></Banner>
        <!-- 内容部分 -->
        <div class="month-content">
            <div class="month-text">
                新增/编辑月份
                <div class="month-button" @click="openBox">新增</div>
                <div class="month-button" @click="openBox" style="margin-left: 10px;">编辑</div>
            </div>
            <hr style="width: 80%;">
            <div class="month-items">
                <div v-for="item, index in month" :key="index">
                    <div class="service" @click="toData(item.name)">{{ item.name }}</div>
                </div>
            </div>
            <!-- <hr style="width: 80%;"> -->
        </div>
        <!-- 弹出框 -->
        <div v-if="block" class="block-box">
            <div class="block-box-input">
                <div class="block-box-title">添加日期</div>
                <div>
                    <label for="name">日期：</label>
                    <input type="text" v-model="inputYear"> 年
                    <input type="text" v-model="inputMonth"> 月
                </div>
                <div style="float: right; display: flex;">
                    <div @click="block = false" class="input-button">取消</div>
                    <div @click="addDate" class="input-button">添加</div>
                </div>
            </div>
            <div class="block-box-bg"></div>
        </div>
    </div>
</template>

<script>
    import Bgd from '../components/bgd.vue'
    import Banner from '../components/banner.vue'
    import { useRoute } from 'vue-router'
    import request from "@/utils/request";
    export default {
        name: 'month',
        components: {
            Banner,
            Bgd
        },
        data() {
            const route = useRoute()
            return {
                block: false,
                inputYear: '',
                inputMonth: '',
                areaName: '',
                month: []
            }
        },
        methods: {
            toData(time) {
                this.$router.push({path: '/data', query: {areaName: this.areaName, selectMonth: time}})
            },
            openBox() {
                this.block = true
            },
          init(address) {
            request.request({
              url: '/back/frontmonth/list?addressName='+address+'&t='+Date.now()+'&page='+1+'&limit='+100+'&key='+'',
              method: 'GET',
              data: {

              }
            }).then(res => {
              if (res.status === 200){
                res.data.page.list.map((item)=>{
                  this.month.push({name:item.frontDate,isSelect: true})
                })
              }
            }).catch(err => {
              console.log(err)
              // this.$router.push('/month')
            })
          },
          addDate(){
            request.request({
              url: '/back/frontmonth/save?addressName='+this.areaName,
              method: 'POST',
              data: {
                frontDate: this.inputYear+"-"+this.inputMonth.toString().padStart(2, '0'),
                dataAddressId: ''
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
          }
        },
      mounted() {
        this.areaName = this.$route.query.areaName
        this.init(this.areaName)
      }
    }
</script>

<style lang="less" scoped>
.input-button {
    user-select: none;
    margin: 0 0 0 10px;
    padding: 2px 10px;
    border: 2px #2746aa solid;
    background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 25%, rgba(0, 0, 0, 0) 75%, #2746ab);
    &:hover {
        background: #2746aa;
    }
}

.service {
    color: white;
    user-select: none;
    padding: 12px 32px;
    background: url("../assets/s2.png");
    background-size: 100% 100%;
}
.service:hover {
    padding: 12px 32px;
    background: url("../assets/s1.png");
    background-size: 100% 100%;
}
.month-button {
    user-select: none;
    margin: 0 0 0 40px;
    padding: 2px 10px;
    border: 2px #2746aa solid;
    background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 25%, rgba(0, 0, 0, 0) 75%, #2746ab);
    &:hover {
        background: #2746aa;
    }
}

.month-content {
    width: 80%;
    margin: 0 auto;

    .month-text {
        color: white;
        text-align: left;
        margin: 20px 0 0 15%;
        font-size: 18px;
        display: flex;
        align-items: center;
    }

    .month-items {
        width: 80%;
        margin: 0 auto;
        padding: 10px 0 0 80px;
        display: flex;
        flex-wrap: wrap;

        &>* {
            margin: 0 0 10px 10px;
            color: #0078d4;
        }
    }
}

.block-box{
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    .block-box-bg {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5);
        z-index: 98;
    }
    .block-box-input {
        position: absolute;
        z-index: 99;
        color: white;
        // background: white;
        border: 2px #2746aa solid;
        background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 10%, rgba(0, 0, 0, 0) 90%, #2746ab);
        border-radius: 10px;
        padding: 10px 15px 15px 15px;
        width: 400px;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        .block-box-title {
            font-size: 20px;
            float: none;
        }
        & > * {
            margin: 10px 0 0 0;
            float: left;
        }
        .block-box-button {
            margin: 5px 0 0 5px;
        }
        input {
            height: 24px;
            border-radius: 3px;
            border: 1px #2746aa solid;
            text-indent: 10px;
            background: rgba(0, 0, 0, 0.2);
            color: white;
            width: 72px;
        }
        input:focus {
            outline: none;
        }
    }
}
</style>
