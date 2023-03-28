<template>
    <div>
        <!-- 背景 -->
        <Bgd></Bgd>
        <!-- 登录框部分 -->
        <div class="login-title title">蔚洋电子商务大数据管理系统</div>
        <div class="login-box">
            <!-- <div class="login-title">登录</div> -->

            <div class="login-content">
                <div>
                    <label for="username"><b>用户名：</b></label>
                    <input type="text" id="username" placeholder="请输入用户名"
                        class="login-input" autocomplete="off" v-model="username">
                </div>
                <div>
                    <label for="password">&nbsp;&nbsp;&nbsp;<b>密码：</b></label>
                    <input type="password" id="password" placeholder="请输入密码"
                        class="login-input" autocomplete="off" v-model="password">
                </div>
                <button class="login-button" @click="login">登录</button>
            </div>
        </div>
    </div>
</template>

<script>
    import Bgd from '../components/bgd.vue'
    import request from '../utils/request'
    export default {
        name: 'login',
        components: {
            Bgd
        },
        data() {
            return {
                username: '',
                password: ''
            }
        },
        methods: {
            // 登录
            login() {
              if (this.username === "admin"){
                if (this.password === "admin"){
                  this.$router.push('/index')
                }else {
                  this.$message({
                    type: 'Warning',
                    message: '密码错误'
                  })
                }
              }else{
                this.$message({
                  message: '用户不存在',
                  type: 'Warning'
                })
              }
            }
            //     request.request({
            //         url: '/login',
            //         method: 'POST',
            //         data: {
            //             username: this.username,
            //             password: this.password
            //         }
            //     }).then(res => {
            //         console.log('请求成功')
            //         console.log(res)
            //         this.$message({
            //             type: 'success',
            //             message: '登录成功'
            //         });
            //         this.$router.push('/index')
            //     }).catch(err => {
            //         console.log(err)
            //         this.$router.push('/index')
            //     })
            // }
        },
    }
</script>

<style lang="less" scoped>
    .title {
        position: absolute;
        top: 18%;
        left: 50%;
        transform: translate(-50%, 50%);
        font-size: 42px;
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
    .login-box {
        height: 300px;
        width: 450px;
        position: absolute;
        left: 50%;
        top: 45%;
        transform: translate(-50%, -50%);
        border-radius: 10px;
        background: rgba(255, 255, 255, 0);
        & > div {
            color: white;
        }
        .login-content {
            position: absolute;
            left: 50%;
            top: 58%;
            width: 100%;
            transform: translate(-50%, -50%);
            border-radius: 10px;
            .login-input {
                width: 60%;
                height: 32px;
                border: 0px;
                border-radius: 10px;
                margin: 10px 0 0 0;
                text-indent: 10px;
                color: white;
                border: 1px #2746aa solid;
                background: linear-gradient(0deg, #2847ab, rgba(0, 0, 0, 0) 30%,
                    rgba(0, 0, 0, 0) 70%, #3f6bfc);
            }
            .login-input:hover {
                background: linear-gradient(0deg, #233e97, rgba(0, 0, 0, 0) 30%,
                    rgba(0, 0, 0, 0) 70%, #345ad6);
            }
            .login-button {
                font-size: 18px;
                color: white;
                border: 2px #2746aa solid;
                width: 100px;
                height: 42px;
                background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 25%, rgba(0, 0, 0, 0) 75%, #2746ab);
                // background: #364fc7;
                border-radius: 5px;
                margin: 20px 0 0 0;
                padding: 0;
            }
            .login-button:hover {
                background: #2847ab;
            }
        }
    }


</style>
