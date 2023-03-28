<template>
  <div>
    <!-- 头部 -->
    <Bgd></Bgd>
    <Banner :isBack="false"></Banner>
    <!-- 内容部分 -->
    <div class="index-content">
      <div class="index-text">
        <div>选择区域</div>
        <div class="index-button" @click="openBox">添加</div>
        <div class="index-button" @click="openBox" style="margin-left: 10px;">编辑</div>
      </div>
      <hr style="width: 80%;">
      <div class="index-items">
        <div v-for="item, index in area" :key="index">
          <div class="service" @click="nextStep(item.name)">
            {{ item.name }}
          </div>
        </div>
      </div>
    </div>
    <!-- 弹出框 -->
    <div v-if="block" class="block-box">
      <div class="block-box-input">
        <div class="block-box-title">添加区域</div>
        <div>
          <label for="name">区域名称：</label>
          <input style="width: 250px;" type="text" id="name" v-model="form.name">
        </div>
        <div>
          <label for="host">二级域名：</label>
          <input style="width: 150px;" type="text" id="host" v-model="form.host">.weutech.com
        </div>
        <div>
          <label for="serice">平台服务：</label>
          <input style="width: 250px;" class="long-input" type="text" id="serice" v-model="form.service">
        </div>
        <div>
          <label for="startTime">服务期限：</label>
          <!--                    <input style="width: 110px; text-indent: 0px;" type="date" id="startTime" v-model="form.startTime">-->
          <input style="width: 110px; text-indent: 0px;" id="startTime" v-model="form.startTime" type="month" required>
          <label for="endTime"> 至 </label>
          <input style="width: 110px; text-indent: 0px;" type="month" id="endTime" v-model="form.endTime" required>
        </div>
        <div style="float: right; display: flex;">
          <div @click="block = false" class="input-button">取消</div>
          <div @click="addNewAddress" class="input-button">添加</div>
        </div>
      </div>
      <div class="block-box-bg"></div>
    </div>
  </div>
</template>

<script>
import Banner from '../components/banner.vue'
import Bgd from '../components/bgd.vue'
import request from "@/utils/request";

export default {
  name: 'index',
  components: {
    Banner,
    Bgd
  },
  data() {
    return {
      block: false,
      area: [],
      formLabelAlign: {
        name: '',
        region: '',
        type: ''
      },
      form: {
        name: '',
        host: '',
        service: '',
        startTime: '',
        endTime: ''
      }
    }
  },
  methods: {
    init() {
      request.request({
        url: 'back/frontaddress/list',
        method: 'GET',
        data: {
          t: Date.now(),
          key: '',
          page: 1,
          limit: 10
        }
      }).then(res => {
        if (res.status === 200){
          res.data.page.list.map((item)=>{
            this.area.push({name:item.dataAddress})
          })
        }
      }).catch(err => {
        console.log(err)
        // this.$router.push('/month')
      })
    },
    openBox() {
      this.block = true
    },
    addArea() {
      this.$message({
        type: 'success',
        message: '添加成功'
      });
      this.block = false
    },
    // 进入月份设置
    nextStep(name) {
      this.$router.push({path: '/month', query: {areaName: name}})
    },
    addNewAddress() {
      request.request({
        url: '/back/frontaddress/save?startTime=' + this.form.startTime + '&endTime=' + this.form.endTime,
        method: 'POST',
        data: {
          dataAddress: this.form.name,
          level2Url: this.form.host,
          platformService: this.form.service,
        }
      }).then(res => {
        this.$message({
          type: 'success',
          message: '添加成功'
        });
        this.$router.push('/month')
      }).catch(err => {
        console.log(err)
        // this.$router.push('/month')
      })
    }
  },mounted() {
    this.init()
  }
}
</script>

<style lang="less" scoped>
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

.index-button {
  user-select: none;
  margin: 0 0 0 40px;
  padding: 2px 16px;
  border: 2px #2746aa solid;
  background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 25%, rgba(0, 0, 0, 0) 75%, #2746ab);

  &:hover {
    background: #2746aa;
  }
}

input[type="month"]::-webkit-calendar-picker-indicator {
  filter: invert(100%);
}

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

.index-content {
  width: 80%;
  margin: 0 auto;

  .index-text {
    color: white;
    text-align: left;
    margin: 20px 0 0 15%;
    font-size: 18px;
    display: flex;
    align-items: center;
  }

  .index-items {
    width: 80%;
    margin: 0 auto;
    padding: 10px 0 0 80px;
    display: flex;
    flex-wrap: wrap;

    & > * {
      margin: 0 0 10px 10px;
      color: #0078d4;
    }
  }
}

.block-box {
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
    }

    input:focus {
      outline: none;
    }
  }
}
</style>
