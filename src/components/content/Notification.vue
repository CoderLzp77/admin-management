<template>
  <div id="notification">
    <div class="notification-top">
      <el-button type="warning">需要我审批的请假</el-button>
      <el-button type="warning">查看我的请假</el-button>
      <el-button type="warning">查看部门的请假</el-button>
      <el-button type="warning">查看下属的请假</el-button>
      <el-button type="warning" @click="to">申请请假</el-button>
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
    to(){
      this.$router.push('/Vacate')
    }
  }
}
</script>

<style scoped>
 button：visited{
   background-color: whitesmoke;
   color: cornflowerblue;
 }
</style>