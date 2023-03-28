<template>
  <div>
    <div class="view-title">
      <!-- 时间 -->
      <div class="view-time">{{ month }}</div>
      <!-- 备注 -->
    </div>
    <div class="view-total">
      <div class="total-box">
        <div class="little-title">服务站数据</div>
        <div>
          <label for="total-money">交易额</label>
          <input type="text" id="total-money" v-model="totalMoney"/> 元
        </div>
        <div>
          <label for="shop-buy">代买:</label>
          <input type="text" id="shop-buy" v-model="totalNum"/> 万元
        </div>
        <div>
          <label for="shop-sale">代卖:</label>
          <input type="text" id="shop-sale" v-model="shopNum"/> 个
        </div>
      </div>
      <!-- 服务站大数据部分 -->
      <div class="total-box">
        <div class="little-title">服务站数量</div>
        <div>
          <label for="total-town-service-num">乡镇服务站数量：</label>
          <input type="text" id="total-town-service-num" v-model="serviceAddMoney"/> 个
        </div>
        <div>
          <label for="total-village-service-num">村级服务站数量：</label>
          <input type="text" id="total-village-service-num" v-model="totalServiceNum"/> 个
        </div>
        <div>
          <label for="total-service-area">服务站覆盖率：</label>
          <input type="text" id="total-service-area" v-model="totalServiceNum"/> 个
        </div>
      </div>
    </div>
    <br/>
  </div>
  <div>
    <div class="view-title">
      <div class="view-time">代买/卖占比</div>
    </div>

    <div class="view-obj" style="justify-content: center">
      <hr>
      <div class="view-obj-bing" v-for="item, index in objList" :key="index">
        <div class="view-obj-type">
          <div style="display: flex;">
            <div class="view-obj-rect" :style="`background: ${item.color};`"></div>
            <div>&nbsp;{{ item.name }}</div>
          </div>
          <input type="text" :value="item.num">
          <div>{{ item.percent }}%</div>
        </div>
      </div>
      <!-- 百分条 -->
      <div style="width: 100%;">
        <div class="block" v-for="item, index in objList" :key="index" style="display: flex;">
          <div style="white-space: nowrap;">{{ item.name }}：</div>
          <el-slider v-model="item.percent"></el-slider>
        </div>
      </div>
      <div class="obj-percent">
        <div v-for="item,index in objList"
             :style="`background: ${item.color}; width: ${item.percent}%;`"
             class="percent-rect">
          <div style="color: white; line-height: 32px;">{{ item.percent }}%</div>
        </div>
      </div>
    </div>
    <br>
    <div>
      <div class="view-title">
        <div class="view-time">订单展示</div>
      </div>

      <div class="view-obj" style="justify-content: center">
        <hr>
        <div>
          <el-button type="primary" @click="add">添加+</el-button>
          <el-button type="danger" @click="remove">删除-</el-button>

<!--            <li v-for="(item, index) in items" :key="index">-->
<!--              {{ index + 1 }}. {{ item }}-->
<!--            </li>-->
            <div v-for="(item, index) in items" :key="index" class="order">
               {{ item }}
              <label style="min-width: auto">订单编号:</label>
              <input type="text" style="min-width: auto"/>
              <label style="min-width: auto">商品类型</label>
              <input type="text"/>
              <label style="min-width: auto">订单类型</label>
              <input type="text"/>
              <label style="min-width: auto">订单金额</label>
              <input type="text"/>
              <label style="min-width: auto">站点名称</label>
              <input type="text"/>
              <br>
            </div>


        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { reactive } from 'vue'
import request from "@/utils/request";
export default {
  name: 'data2',
  props: {
    month: String
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
          name: '代买',
          num: 0,
          percent: 30,
          color: '#04b0ff'
        },
        {
          name: '代卖',

          num: 0,
          percent: 40,
          color: '#fcce4b'
        }
      ]
    }
  },
  setup() {
    const state = reactive({
      items: ['订单1'],
      counter: 1
    })

    const add = () => {
      state.counter++
      state.items.push(`订单${state.counter}`)
    }

    const remove = () => {
      if (state.items.length > 0) {
        state.items.pop()
        state.counter--
      }
    }

    return {
      items: state.items,
      add,
      remove
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
  justify-content: center;
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

    & > div {
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
.order{
  padding-top: 20px;
}
.view-obj {
  display: flex;
  flex-wrap: wrap;

  & > div {
    margin: 10px 0 0 20px;
  }

  .view-obj-bing {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;

    .view-obj-type {
      display: flex;
      flex-wrap: wrap;
      flex-direction: column;
      line-height: 26px;
      margin: 0 20px 0 0;

      .view-obj-rect {
        height: 24px;
        width: 24px;
        border: 1px #999999 solid;
        box-shadow: 2px 2px 3px 0 #999999;
      }

      & > input {
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

    .percent-rect {
      height: 32px;
    }
  }
}
</style>
