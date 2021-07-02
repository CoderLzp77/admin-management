<template>
  <div id="notification2">
    <div class="notification-top">
      <el-button type="warning" @click="to5" :class="{active: this.$route.path === '/tripManage'}">需要我审批的出差</el-button>
      <el-button type="warning" @click="to6" :class="{active: this.$route.path === '/viewDeptTrip'}">查看部门的出差</el-button>
      <el-button type="warning" @click="to7" :class="{active: this.$route.path === '/viewSubordinateTrip'}">查看下属的出差</el-button>
      <el-button type="warning"@click="to8">申请出差</el-button>
    </div>
    <br>
    <div>
      <slot name="notification-trip"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notification2",
  methods: {
    to5(){
      this.$router.push('/tripManage')
    },
    to6(){
      this.$router.push('/viewDeptTrip')
    },
    to7(){
      this.$router.push('/viewSubordinateTrip')
    },
    to8(){
      this.$router.push('/trip')
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