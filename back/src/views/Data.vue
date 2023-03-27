<template>
    <div>
        <Bgd></Bgd>
        <!-- 导航栏 -->
        <Banner :isBack="true"></Banner>
        <div>
            <!-- 数据输入 -->
            <div class="data-nav">
                <div @click="chageData(0)" class="nav-div1">电商交易大数据</div>
                <div @click="chageData(1)" class="nav-div2">服务站大数据</div>
                <div @click="chageData(2)" class="nav-div3">电商扶贫大数据</div>
            </div>
            <!-- 页面部分 -->
            <div class="scroll-div">
                <div class="data-content">
                    <V1 v-if="index == 0" :month="selectMonth"></V1>
                    <V2 v-if="index == 1" :month="selectMonth"></V2>
                    <V3 v-if="index == 2" :month="selectMonth"></V3>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Banner from '../components/banner.vue'
    import Bgd from '../components/bgd.vue'
    import V1 from '../components/dataViews/DataView1.vue'
    import V2 from '../components/dataViews/DataView2.vue'
    import V3 from '../components/dataViews/DataView3.vue'
    import { useRoute } from 'vue-router'
    export default {
        name: 'data',
        components: {
            Banner, Bgd,
            V1, V2, V3,
        },
        data() {
            const route = useRoute()
            return {
                index: 0, // 位置
                areaName: route.query.areaName,
                selectMonth: route.query.selectMonth
            }
        },
        methods: {
            chageData(index) {
                this.index = index
            }
        },
    }
</script>

<style lang="less" scoped>
    .data-nav {
        display: flex;
        justify-content: center;
        margin: 10px 0 20px 0;
        & > div {
            border: 0px;
            padding: 10px;
            user-select: none;
        }
        .nav-div1 {
            color: white;
            user-select: none;
            padding: 12px 32px;
            background: url("../assets/s2.png");
            background-size: 100% 100%;
            &:hover {
                padding: 12px 32px;
                background: url("../assets/s1.png");
                background-size: 100% 100%;
            }
        }
        .nav-div2 {
            color: white;
            user-select: none;
            margin-left: 3%;
            padding: 12px 32px;
            border: 3px #2746aa solid;
            background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 25%, rgba(0, 0, 0, 0) 75%, #2746ab);
            background-size: 100% 100%;
            &:hover {
                background: #2746aa;
            }
        }
        .nav-div3 {
            color: white;
            user-select: none;
            margin-left: 3%;
            padding: 12px 32px;
            background: url("../assets/s2-2.png");
            background-size: 100% 100%;
            &:hover {
                padding: 12px 32px;
                background: url("../assets/s1-2.png");
                background-size: 100% 100%;
            }
        }
    }
    .scroll-div {
        width: 100%;
        height: 540px;
        overflow: auto;
        &::-webkit-scrollbar{
            display: none;
        }
        
        .data-content {
            width: 60%;
            margin: 20px auto;
            color: white;
        }
    }
</style>