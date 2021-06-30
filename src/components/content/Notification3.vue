<template>
  <div id="notification3">
    <div class="notification-top">
      <el-button type="warning">需要我审批的报销</el-button>
      <el-button type="warning">查看我的报销</el-button>
      <el-button type="warning">查看部门的报销</el-button>
      <el-button type="warning">查看下属的报销</el-button>
      <el-button type="warning">申请报销</el-button>
      <el-button type="warning">报销科目管理</el-button>
    </div>
    <br>
    <div>
      <slot name="notification-reimbursement"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notification3"
}
</script>

<style scoped>

</style>