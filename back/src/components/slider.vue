<template>
    <div>
        <div class="slider-box">
            <div v-for="i in sliderNum" :key="i"
                class=""
                :style="`width: ${percentList[i-1]}%; background: ${colorList[i-1]}; height: 12px;`"
                >
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'slider',
        props: {
            sliderNum: Number,
            percentList: Array,
            colorList: Array
        },
        data() {
            return {
                max: 100,
                min: 1
            }
        },
    }
</script>

<style lang="less" scoped>
    .slider-box {
        width: 100%;
        height: 32px;
        background: #bbbbbb;
        display: flex;
    }
</style>