import axios from "axios";

// 地址
var url = 'http://localhost:8081'

const service = axios.create({
    baseURL: url,
    timeout: 2000
})

// 请求拦截器
service.interceptors.request.use(
    function(config) {
        return config
    },
    function(error) {
		return Promise.reject(error)
	}
)

//响应拦截器
service.interceptors.response.use(
    res => {
        // 在请求成功后的数据处理
        if (res.status === 200) {
            return res;
        } else {
            return res;
        }

    },
    err => {
        return Promise.reject(err)
    }
);

export default service
