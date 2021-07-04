<template>
  <div id="emp-notice">
    <div  class="emp-notice-header">
      <span> <i class="el-icon-warning"></i>最新通知</span>
      <el-form :inline="true"  class="demo-form-inline">
        <el-form-item>
          <el-input v-model="empMessage" placeholder=""></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="onSubmit">搜索</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="emp-notice-table">
       <p><i class="el-icon-user-solid"></i>申请修改密码</p>
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="staffId" label="员工编码"  align="center" >
          </el-table-column>
          <el-table-column prop="userName" label="员工姓名"  align="center" >
          </el-table-column>
          <el-table-column prop="organization.name" label="部门"  align="center" >
          </el-table-column>
          <el-table-column prop="jobId" label="岗位"  align="center" :formatter="job">
          </el-table-column>
          <el-table-column prop="directBoss" label="直接领导"  align="center" >
          </el-table-column>
          <el-table-column prop="phoneNumber" label="电话"  align="center" >
          </el-table-column>
          <el-table-column prop="email" label="邮箱"  align="center" >
          </el-table-column>
          <el-table-column label="重置密码" align="center">
            <template>
              <el-button type="primary" icon="el-icon-refresh-right" @click="resetPwd"></el-button>
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
  </div>
</template>

<script>
import {get} from "@/network/request";
import axios from "axios";

export default {
  name: "EmpNotice",
  data(){
    return {
      jobmap:new Map,
      empMessage: '' ,
      tableData: [],
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    getJob(){
      axios.get("http://localhost:8081/Job/ShowJobInfoLimit",{
        params:{
          pageNum:1
        }
      }).then(res=>{
        console.log(this.Jobdata)
        this.Jobdata=res.data.data
        let map=new Map
        for (let i = 0; i < this.Jobdata.length; i++) {
          map.set(this.Jobdata[i].jobId,this.Jobdata[i].jobName)
          this.jobmap=map
        }
        console.log(this.Jobdata)
      })
    },
    onSubmit() {
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
    resetPwd(){
      console.log('reset');
    },
     async getData(){
        await get('/Staff/queryAll',{
          params: {
            userName: this.empMessage,
            pageNum: this.pageNum,
            pageSize: this.pageSize
          }
        }).then(res =>{
          console.log(res);
          this.tableData = res.data.data
        })
    },
    job(row){
      return this.jobmap.get(row.jobId)
    },
  },
  created() {
    this.getJob()
    this.getData()
  }
}
</script>

<style scoped>
.emp-notice-header{
   background-color: whitesmoke;
  height: 65px;
  border: 1px solid rgba(0,0,0,.1);
}
.demo-form-inline{
  float: right;
  padding-top: 10px;
}
span{
  line-height: 65px;
  font-size: 25px;
  padding-left: 10px;
}
p{
  height: 60px;
  background-color: #add8e6;
  font-size: 20px;
  line-height: 60px;
  margin-bottom: 0;
  padding-left: 10px  ;
}
</style>