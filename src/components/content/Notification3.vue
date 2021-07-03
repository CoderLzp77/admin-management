<template>
  <div id="notification3">
    <div class="notification-top">
      <el-button type="warning" @click="to9" :class="{active: this.$route.path === '/reiManage'}">需要我审批的报销</el-button>
      <el-button type="warning" @click="to10" :class="{active: this.$route.path === '/viewDeptRei'}">查看部门的报销</el-button>
      <el-button type="warning" @click="to11" :class="{active: this.$route.path === '/viewSubordinateRei'}">查看下属的报销</el-button>
      <el-button type="warning" @click="to12">申请报销</el-button>
      <el-button type="warning" @click="handleClick">添加报销科目</el-button>
    </div>
    <br>
    <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="类型值:">
          <el-input v-model="form.subjectId"></el-input>
        </el-form-item>
        <el-form-item label="报销类型:">
          <el-input v-model="form.subjectName"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="AddReimbursementSub">确 定</el-button>
  </span>
    </el-dialog>
    <div>
      <slot name="notification-reimbursement"></slot>
    </div>
  </div>
</template>

<script>
import {post} from "@/network/request";

export default {
  name: "Notification3",
  data(){
    return {
      dialogVisible: false,
      form: {
        subjectId: '',
        subjectName: ''
      }
    }
  },
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
    },
    handleClick(){
      this.dialogVisible = true
    },
    AddReimbursementSub(){
      this.dialogVisible = false
      post('/Reimburse/AddReimbursementSub',{
        reimbursementVo: this.form
      }).then(res => {
        if (res.data.status===200){
          this.$message.success("添加成功")
        }else {
          this.$message.error(res.data.message)
        }
      })
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