import axios from "axios";

const instance = axios.create({
   baseURL: 'http://8.140.107.62:8081',
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