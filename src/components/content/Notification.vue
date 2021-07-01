<template>
  <div id="notification">
    <div class="notification-top">
      <el-button type="warning" @click="to1" :class="{active: this.$route.path === '/vacateManage'}">需要我审批的请假</el-button>
      <el-button type="warning" @click="to2" :class="{active: this.$route.path === '/viewDeptVacate'}">查看部门的请假</el-button>
      <el-button type="warning" @click="to3" :class="{active: this.$route.path === '/viewSubordinateVacate'}">查看下属的请假</el-button>
      <el-button type="warning" @click="to4">申请请假</el-button>
    </div>
    <br>
    <div>
      <slot name="notification-vacate"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notification",
  methods: {
    to1(){
      this.$router.push('/vacateManage')
    },
    to2(){
      this.$router.push('/viewDeptVacate')
    },
    to3(){
      this.$router.push('/viewSubordinateVacate')
    },
    to4(){
      this.$router.push('/Vacate')
    }
  }
}
</script>

<style scoped>
 .active{
   background-color: whitesmoke;
   color: cornflowerblue;
 }
</style>