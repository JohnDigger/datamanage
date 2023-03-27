<template>
    <div>
        <Slider :sliderNum="6" :percentList="percentList" :colorList="colorList"></Slider>
    </div>
</template>

<script>
    import Slider from '../slider.vue'
    export default {
        name: 'data2',
        components: {
            Slider
        },
        data() {
            return {
                percentList: [
                    10, 20, 10, 20, 25, 15
                ],
                colorList: [
                    '#001199', '#009999', '#110099', '#990099', '#991100', '#999900'
                ]
            }
        },
    }
</script>