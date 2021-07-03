<template>
  <div id="Login">
    <img src="@/assets/img/banner.4994397e.jpg" alt="">
    <div class="main">
       <div class="login-top">
         <i class="el-icon-office-building" style="color: orangered"/><span>行政管理账户</span>
       </div>
       <div class="login-form" :model="LoginForm" ref="loginForm"  @keyup.enter="Login">
         <input v-model="LoginForm.username" placeholder="用户名" ></input><br>
         <input v-model="LoginForm.password" placeholder="密码" type="password"></input><br>
         <button @click="Login">登录</button>
       </div>
    </div>
  </div>
</template>

<script>
import {post} from "@/network/request";
import  Qs from 'qs';

export default {
  name: "Login",
  data(){
    return {
     LoginForm: {
       username: '',
       password: ''
     }/*,
      rules: {
       username: [
         {required: true,message: '请输入用户名',trigger: 'blur' }
       ],
       password: [
         {require: true,message: '请输入密码',trigger: 'blur' }
       ]
      }*/
    }
  },
  methods: {
   async Login(){
         post('/Staff/Login',Qs.stringify(this.LoginForm))
         .then(res => {
          /* console.log(res);*/
           if (res.data.status === 200) {
             if(res.data.data.state === 1){
               localStorage.setItem('userCode','Admin')
             }else{
               localStorage.setItem('userCode','user')
             }
             localStorage.setItem("staffId",res.data.data.staffId)
             localStorage.setItem("token",res.data.data.token)
             this.$message.success("登录成功")
             this.$router.replace({path:'/Index',query:{name:this.LoginForm.username}})
           }else if (res.data.status === 404){
             this.$message.error("账号或密码错误!")
           } else {
             return this.$message.error("登录失败!")
           }
         })
    },
    verifyToken() {
     /* if(localStorage.getItem('token')){
        this.$message.success("登录成功")
        this.$router.replace('/Index')
      }else{
        this.$message.error("身份验证以过期，请重新登录")
      }*/
    }
  },
  created() {
    /*this.verifyToken()*/
  }
}
</script>

<style scoped>
body{
  margin: 0;
  padding: 0;
}
img{
  position: fixed;
  width: 375px;
  height: 100%;
}
.main{
  position: absolute;
  top: 0;
  left: 375px;
}
.login-top{
  padding-top: 25px;
  padding-left: 20px;
  height: 50px;
  font-size: 30px;
}

.login-form{
  width: 400px;
  height: 500px;
  background-color: rgba(245,245,245,0.65);
  position: relative;
  margin-top: 120px;
  margin-left: 480px;
  padding: 100px 50px 0 100px;

}
input{
  display: block;
  width: 300px;
  height: 39px;
  border-style: none;
  margin-bottom: 20px;
  border-bottom: 1px solid rgba(255,69,0,0.2);
  border-radius: 4px;
}
input:focus {
  outline:none;
  border: 1px solid  rgba(255,69,0,0.65);
}
button{
  display: block;
  width: 300px;
  height: 39px;
  border-style: none;
  background-color: orangered;
  border-radius: 4px;
}
</style>