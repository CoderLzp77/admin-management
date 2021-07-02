<template>
  <div id="emp-manage">
    <div class="emp-table-body">
      <div class="emp-table-header">
      <span><i class="el-icon-user-solid"></i>添加员工信息</span>
      <el-button type="success" style="margin-left: 80px" @click="to"><i class="el-icon-plus" ></i>增加员工</el-button>
      <el-form :inline="true"  class="demo-form-inline">
        <el-form-item>
          <el-input v-model="empMessage" placeholder=""></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="searchForEmp">搜索</el-button>
        </el-form-item>
      </el-form>
      </div>
      <div class="emp-table-main">
        <p><i class="el-icon-user-solid"></i>员工信息列表</p>
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="staffId" label="员工编码"  align="center" >
          </el-table-column>
          <el-table-column prop="userName" label="员工姓名"  align="center" >
          </el-table-column>
          <el-table-column prop="organization.name" label="部门"  align="center" >
          </el-table-column>
          <el-table-column prop="jobId" label="岗位"  align="center" >
          </el-table-column>
          <el-table-column prop="directBoss" label="直接领导"  align="center" >
          </el-table-column>
          <el-table-column prop="phoneNumber" label="电话"  align="center" >
          </el-table-column>
          <el-table-column prop="email" label="邮箱"  align="center" >
          </el-table-column>
          <el-table-column label="!!!" align="center">
            <template slot-scope="scope">
              <el-button type="warning" icon="el-icon-edit-outline" @click="handleClick(scope.row)"></el-button>
              <el-button type="danger" icon="el-icon-delete" circle @click="deleteEmp(scope.row)"></el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block">
          <span class="demonstration">每页显示条数</span>
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :page-sizes="[1, 2, 3, 4, 5]"
              :page-size="3"
              layout="sizes,prev, pager, next"
              :total="30">
          </el-pagination>
        </div>
      </div>
      <el-dialog
          title="修改员工信息"
          :visible.sync="dialogVisible"
          width="30%">
        <el-form ref="form" :model="Staff" label-width="80px">
          <el-form-item label="员工编号:">
            <el-input v-model="Staff.staffId"></el-input>
          </el-form-item>
          <el-form-item label="员工姓名:">
            <el-input v-model="Staff.userName"></el-input>
          </el-form-item>
          <el-form-item label="部门:">
            <el-input v-model="Staff.organization.name"></el-input>
          </el-form-item>
          <el-form-item label="岗位:">
            <el-input v-model="Staff.jobId"></el-input>
          </el-form-item>
          <el-form-item label="直接领导:">
            <el-input v-model="Staff.directBoss"></el-input>
          </el-form-item>
          <el-form-item label="电话:">
            <el-input v-model="Staff.phoneNumber"></el-input>
          </el-form-item>
          <el-form-item label="邮箱:">
            <el-input v-model="Staff.email"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
           <el-button @click="dialogVisible = false">取 消</el-button>
           <el-button type="primary" @click="modify">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {get} from "@/network/request";
import axios from "axios";
import Qs from "qs";

export default {
  name: "EmpManage",
  data() {
    return {
      dialogVisible: false,
      empMessage: '',
      tableData: [],
      pageNum: 1,
      pageSize: 3,
      Staff: {
        organization:{
        }
      }
    }
  },
  methods: {
    async getData(){
       await  get('/Staff/queryAll' ,{
         params: {
           userName: this.empMessage,
           pageNum: this.pageNum,
           pageSize: this.pageSize
         }
      }).then(res => {
         this.tableData = res.data.data
       })
    },
    to(){
      this.$router.push('/addEmp')
    },
    searchForEmp(){
      this.getData()
    },
    handleSizeChange(val){
      this.pageSize = val
      this.getData()
    },
    handleCurrentChange(val){
      this.pageNum = val
      this.getData()
    },
    handleClick(row){
      this.Staff = row
      this.dialogVisible = true
    },
    deleteEmp(row){
      axios.delete('http://8.140.107.62:8081/Staff/deleteStaff/'+row.staffId).then(res =>{
         if (res.data.status === 200){
           this.$message.success('删除成功')
           this.getData()
         }else {
           this.$message.error('删除失败')
         }
       })
    },
    modify(){
      this.dialogVisible = false
      axios.post('http://8.140.107.62:8081/Staff/dateStaffInfo',Qs.parse(this.Staff)).then(res => {
        if (res.data.status === 200){
          this.$message.success('修改成功')
          this.getData()
        }else {
          this.$message.error('修改失败')
        }
      })
    }
  },
  created() {
    this.getData()
  }
}
</script>

<style scoped>
.demo-form-inline{
   float: right;
  padding-top: 10px;
}
span{
  font-size: 22px;
  height: 65px;
  line-height: 65px;
  padding-left: 10px;
}
.emp-table-header{
   background-color: rgba(0,0,0,.1);
}
p{
  height: 60px;
  background-color: #add8e6;
  font-size: 20px;
  line-height: 60px;
  margin-bottom: 0;
  padding-left: 10px;
  color: cornflowerblue;
}
</style>