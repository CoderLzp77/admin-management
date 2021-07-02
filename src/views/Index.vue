<template>
   <div id="index">
     <el-container  style="height: 100%; border: 1px solid #eee">
       <el-header height="160px" style="padding: 0">
           <div class="header-top">
             <span>Administrative Management System</span><el-input class="el-input" v-model="search" placeholder="Search"></el-input>
           </div>
         <div class="header-admin">
           <img src="@/assets/img/头像.svg" alt=""> <span>Welcome back[{{userCode}}]</span>
           <div class="header-admin-right">
             <el-button type="danger">打卡</el-button>
             <el-dropdown split-button type="info">
               Notifications
               <el-dropdown-menu slot="dropdown">
                 <el-dropdown-item>请假消息</el-dropdown-item>
                 <el-dropdown-item>出差消息</el-dropdown-item>
                 <el-dropdown-item>报销消息</el-dropdown-item>
               </el-dropdown-menu>
             </el-dropdown>
             <el-button type="primary" @click="logout">登出</el-button>
           </div>
         </div>
       </el-header>
       <el-container>
         <el-aside width="15%" style="background-color: rgb(238, 241, 246)">
         <el-menu  router>
           <el-menu-item index="/home">
             <i class="el-icon-s-home"></i><span slot="title">首页</span>
           </el-menu-item>
           <el-submenu index="2">
             <template slot="title"><i class="el-icon-s-custom"></i>员工信息<span>(管理员)</span></template>
             <el-menu-item-group>
               <el-menu-item index="/empNotice">最新通知</el-menu-item>
               <el-menu-item index="/addEmp">添加员工</el-menu-item>
               <el-menu-item index="/empManage">员工管理</el-menu-item>
             </el-menu-item-group>
           </el-submenu>
           <el-menu-item index="/companyOrg" >
             <i class="el-icon-menu"></i><span slot="title">公司组织<span>(管理员)</span></span>
           </el-menu-item>
           <el-menu-item index="/companyPos">
             <i class="el-icon-s-management"></i><span slot="title">公司岗位<span>(管理员)</span></span>
           </el-menu-item>
           <el-submenu index="5">
             <template slot="title"><i class="el-icon-s-data"></i>考勤<span>(管理员)</span></template>
             <el-menu-item-group>
               <el-menu-item index="/viewPersonage">个人考勤查看</el-menu-item>
               <el-menu-item index="/viewSubordinate">查看直接下属考勤情况</el-menu-item>
               <el-menu-item index="/holidayManage">节假日修改</el-menu-item>
             </el-menu-item-group>
           </el-submenu>
           <el-submenu index="6">
             <template slot="title"><i class="el-icon-cloudy"></i>请假<span>(员工)</span></template>
             <el-menu-item-group>
               <el-menu-item index="/vacateNotice">最新通知</el-menu-item>
               <el-menu-item index="/vacate">申请请假</el-menu-item>
               <el-menu-item index="/vacateManage">请假管理</el-menu-item>
             </el-menu-item-group>
           </el-submenu>
           <el-submenu index="7">
             <template slot="title"><i class="el-icon-s-promotion"></i>出差<span>(员工)</span></template>
             <el-menu-item-group>
               <el-menu-item index="/tripNotice">最新通知</el-menu-item>
               <el-menu-item index="/trip">申请出差</el-menu-item>
               <el-menu-item index="/tripManage">出差管理</el-menu-item>
             </el-menu-item-group>
           </el-submenu>
           <el-submenu index="8">
             <template slot="title"><i class="el-icon-s-finance"></i>报销<span>(员工)</span></template>
             <el-menu-item-group>
               <el-menu-item index="/reiNotice">最新通知</el-menu-item>
               <el-menu-item index="/reimbursement">申请报销</el-menu-item>
               <el-menu-item index="/reiManage">报销管理</el-menu-item>
             </el-menu-item-group>
           </el-submenu>
         </el-menu>
         </el-aside>
         <el-main>
             <router-view></router-view>
         </el-main>
       </el-container>
     </el-container>
   </div>
</template>

<script>
export default {
  name: "Index",
  data(){
    return {
      value: '',
      search: '',
      userCode: localStorage.getItem('userCode')
    }
  },
  methods:{
    logout(){
      localStorage.clear()
      this.$router.push("/Login")
    }
  }
}
</script>

<style scoped>
.header-top{
  background-color: cornflowerblue;
  height: 80px;
}
.header-top span{
  line-height: 80px;
  font-size: 40px;
  color: white;
}
.header-admin{
  height: 80px;
  background-color: rgba(0,0,0,0.6);
}
.header-admin span{
  font-size: 20px;
  margin-left: 20px;
  color: white;
}
.el-input{
  padding-top: 25px;
  padding-right: 30px;
  width: 300px;
  float: right;
}
img{
  margin-top: 10px;
  margin-left: 20px;
  width: 60px;
  height: 60px;
}
.header-admin-right{
  position: absolute;
  top: 100px;
  left: 78%;
}
</style>