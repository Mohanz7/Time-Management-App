import Vue from 'vue'
import axios from 'axios'
import { Message } from 'element-ui'

axios.defaults.withCredentials = true
const service = axios.create({
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    baseURL: "http://localhost:8888/",// || process.env.VUE_APP_API,
    withCredentials: true,
    timeout: 300000,
    errorToast: true,
})
// http request 拦截器
service.interceptors.request.use(
    config => {
        // 用于计算接口耗时
        config.startTime = +new Date()
        
        // 鉴权参数设置
        if (config.method === 'get') {
            // get请求下 参数在params中，其他请求在data中
            config.params = config.params || {}
        } else {
            config.data = config.data || {}
        }
        return config
    },
    err => {
        console.log('request err')
        handleError(err)
        return Promise.reject(err)
    }
)
// response拦截器
service.interceptors.response.use(
    response => {
        const { status, data, config } = response
        // 兼容导出数据情况
        if (status === 200 && config.responseType == 'arraybuffer') {
            const enc = new TextDecoder('utf-8')
            let jsonData
            try {
                // 只有返回错误时，才能parse，正常返回二进制文件时 jsonData 是 undefined
                jsonData = JSON.parse(enc.decode(new Uint8Array(data)))
                response.data = jsonData
            } catch (error) {}
            if (jsonData.code && jsonData.code != 200) {
                
                return Promise.reject(data)
            }
            return response
        }
        if (status === 200 && data.code == 200) {
            return data
        } else {
            console.log('response reject')
            const msg = data.message ||  '请求失败' ;
                Message.error(msg)
            return Promise.reject(data)
        }
    },
    error => {
        console.log('response error')
        if (axios.isCancel(error)) {
            // 中断promise链接
            return new Promise(() => {})
        }
        handleError(error)
        if (error.response) {
            const { status, data } = error.response
            
        }
        return Promise.reject(error)
    }
)

/**
 * 报错提示
 * @param {Object} error 报错对象
 */
function handleError(error) {
    console.log('request.js handleError', { error })
    if (error.handled) return
    error.handled = true
    const _err = error.response
    error.__sentry_captured__ = true
    if (error.response.data) error.response.data.__sentry_captured__ = true
    // 报错信息
    error.errorMsg = _err.data.msg || _err.data.message || error.message || '请求异常'
    // 错误码
    const code = _err.data.code || _err.status
    // id
    const headers = error.config.headers
    // 忽略的状态
    Message.error()
}

/**
 * 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function post(url, data = {}, config = {}) {
    const user_id = sessionStorage.getItem('userId')
    const noIdUrl = ['/loginInformation/queryLoginInfo','/loginInformation/addingLoginInfo']
    if(!noIdUrl.includes(url)){
        if(user_id)
            data.user_id = user_id;
        else{
            // this.$router.push("/Login");
             console.log("False Completely")
            let loginUrl = window.location.origin + '/#/Login';
            window.open(loginUrl,"_self")
        }
    }
    return service.post(url, data, config).then(response => response.data)
}

export function get(url, params = {}) {
    return new Promise((resolve, reject) => {
        service
            .get(url, { params })
            .then(response => {
                if (response && (response.code === 200 || response.code === '200')) {
                    // 返回成功处理  这里传的啥 后续调用的时候 res就是啥
                    resolve(response.data)
                } else {
                    // resolve(response.data)
                    // 错误处理
                    reject(response)

                    Message.error(response.message || response.msg || '请求异常')
                }
            })
            .catch(err => {
                let message = '请求失败！请检查网络'
                if (err.response) message = err.response.data.msg || err.response.data.message
                Message.error(message || '请求异常')
                reject(err)
            })
    })
}
export default service

// 报错弹窗
function errorToast(errorMsg, { config, response }) {
    let msg = {
        request: {
            url: config.baseURL + config.url,
            headers: config.headers,
            data: config.data,
        },
        response: {
            headers: response.headers,
            data: response.data,
        },
    }
    const instance = new Vue()
    const h = instance.$createElement
    Message.error(msg)
}
