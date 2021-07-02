<template>
  <div id="notification3">
    <div class="notification-top">
      <el-button type="warning" @click="to9" :class="{active: this.$route.path === '/reiManage'}">需要我审批的报销</el-button>
      <el-button type="warning" @click="to10" :class="{active: this.$route.path === '/viewDeptRei'}">查看部门的报销</el-button>
      <el-button type="warning" @click="to11" :class="{active: this.$route.path === '/viewSubordinateRei'}">查看下属的报销</el-button>
      <el-button type="warning" @click="to12">申请报销</el-button>
    </div>
    <br>
    <div>
      <slot name="notification-reimbursement"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notification3",
  methods: {
    to9(){
      this.$router.push('/reiManage')
    },
    to10(){
      this.$router.push('/viewDeptRei')
    },
    to11(){
      this.$router.push('/viewSubordinateRei')
    },
    to12(){
      this.$router.push('/reimbursement')
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