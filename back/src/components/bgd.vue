<template>
  <div class="bgd">
    <div class="kong"></div>
    <div id="stars">
      <!-- <div class="star" style="top: 0px;left: 500px;"></div> -->

      <template v-for="n in 7">
        <div class="star"
          :style="{ 'top': randomDistance(500, 100), 'left': randomDistance(1920, 300), 'animationDelay': n % 6 == 0 ? '0s' : n * 0.8 + 's' }">
        </div>
      </template>
    </div>
  </div>
</template>

<script>
export default {
  name: "bgd",
  data() {
    return {
      liuXIng: [
        {
          top: "100",
          left: "200"
        },
        {
          top: "200",
          left: "300"
        }, {
          top: "300",
          left: "400"
        }
      ]
    }
  },
  mounted() {

  },
  methods: {

    // 随机数方法
    randomDistance(max, min) {
      var distance = Math.floor(Math.random() * (max - min + 1) + min)
      return distance + 'px'
    }
  },
}

</script>

<style lang="less" scoped>
.bgd {
  .kong {
    position: absolute;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background: #01103c;
    z-index: -101;
    background: url("../assets/bg.jpg");
    background-size: 100% 100%;
  }
}

html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  overflow: hidden;
  // background: linear-gradient(rgba(0, 108, 172, 1), rgba(0, 122, 195, 0.7));
}

#stars {
  margin: 0 auto;
  // max-width: 1600px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: -1;
}

.star {
  display: block;
  width: 10px;
  background: transparent;
  position: relative;
  opacity: 0;
  animation: star-fall 2s linear infinite;
  -webkit-animation: star-fall 2s linear infinite;
  -moz-animation: star-fall 2s linear infinite;
  z-index: -1;
}

.star::after {
  content: "";
  display: block;
  border: 0px solid #fff;
  border-width: 0px 90px 2px 90px;
  border-color: transparent transparent transparent rgba(255, 255, 255, 1);
  box-shadow: 0 0 1px 0 rgba(255, 255, 255, 0.1);
  /*变形*/
  transform: rotate(-45deg) translate3d(1px, 3px, 0);
  -webkit-transform: rotate(-45deg) translate3d(1px, 3px, 0);
  -moz-transform: rotate(-45deg) translate3d(1px, 3px, 0);
  transform-origin: 0% 100%;
  -webkit-transform-origin: 0% 100%;
  -moz-transform-origin: 0% 100%;
}

@keyframes star-fall {
  0% {
    opacity: 0;
    transform: scale(0.5) translate3d(0, 0, 0);
    -webkit-transform: scale(0.5) translate3d(0, 0, 0);
    -moz-transform: scale(0.5) translate3d(0, 0, 0);
  }

  50% {
    opacity: 1;
    transform: translate3d(-200px, 200px, 0);
    -webkit-transform: translate3d(-200px, 200px, 0);
    -moz-transform: translate3d(-200px, 200px, 0);
  }

  100% {
    opacity: 0;
    transform: scale(1.2) translate3d(-300px, 300px, 0);
    -webkit-transform: scale(1.2) translate3d(-300px, 300px, 0);
    -moz-transform: scale(1.2) translate3d(-300px, 300px, 0);
  }
}</style>
