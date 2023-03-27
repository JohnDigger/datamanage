<template>
    <div class="top">
        <!-- <img src="../assets/head@2x.png" class="top-bgd" alt /> -->
        <div class="title">蔚洋电子商务大数据管理系统</div>
    </div>
</template>

<script>
export default {
    name: 'banner',
    props: {
        isBack: Boolean
    },
    methods: {
        back() {
            this.$router.go(-1)
        }
    },
}
</script>

<style lang="less" scoped>
.top {
    position: relative;
    height: 9.2vh;
    box-sizing: border-box;
    color: #ffffff;
    background: url("../assets/head.png");
    background-size: 100% 100%;
}

.title {
    font-size: 2.5rem;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);

    font-family: PangMenZhengDao;
    font-weight: bold;
    color: rgba(255, 255, 255, 1);
    background: linear-gradient(
    0deg,
    rgba(180, 226, 255, 1) 0%,
    rgba(255, 255, 255, 1) 100%
    );
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}
</style>