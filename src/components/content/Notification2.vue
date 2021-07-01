<template>
  <div id="notification2">
    <div class="notification-top">
      <el-button type="warning">需要我审批的出差</el-button>
      <el-button type="warning">查看部门的出差</el-button>
      <el-button type="warning">查看下属的出差</el-button>
      <el-button type="warning">申请出差</el-button>
    </div>
    <br>
    <div>
      <slot name="notification-trip"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notification2"
}
</script>

<style scoped>

</style>