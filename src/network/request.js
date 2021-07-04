import axios from "axios";

const instance = axios.create({
   baseURL: 'http://localhost:8081',
   timeout: 10000
})

export function post(url,data){
    return instance.post(url,data)
}

export function get(url,params){
    return instance.get(url,params)
}

export function getAll(url){
    return instance.get(url)
}

axios.interceptors.request.use(config=>{
    config.headers.token=window.localStorage.getItem('token');
    return config;
})