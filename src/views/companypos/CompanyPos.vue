<template>
  <div id="company-pos">
    <div class="company-table-body">
      <div class="company-table-header">
        <span><i class="el-icon-s-tools"></i>岗位设定</span>
        <el-button type="success" style="margin-left: 80px" @click="dialogVisible2 = true"><i class="el-icon-plus" ></i>增加岗位</el-button>
        <el-form :inline="true"  class="demo-form-inline">
          <el-form-item>
            <el-input v-model="empMessage" placeholder="" style="width: 500px"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="searchForPost">搜索</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div class="emp-table-main">
        <p><i class="el-icon-user-solid"></i>岗位信息列表</p>
        <template>
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="jobId" label="岗位编码"  align="center" >
          </el-table-column>
          <el-table-column prop="jobName" label="岗位名称"  align="center" >
          </el-table-column>
          <el-table-column prop="responsibilities" label="岗位描述"  align="center" >
          </el-table-column>
          <el-table-column label="!!!" align="center">
            <template slot-scope="scope">
              <el-button type="warning" icon="el-icon-edit-outline" @click="handleClick(scope.row)"></el-button>
              <el-button type="danger" icon="el-icon-delete" circle @click="deleteJob(scope.row)"></el-button>
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
     </template>
    </div>
  </div>
    <el-dialog
        title="详情"
        :visible.sync="dialogVisible"
        width="30%">
      <el-form ref="form" :model="showData" label-width="80px">
        <el-form-item label="岗位编号:">
          <el-input v-model="showData.JobId"></el-input>
        </el-form-item>
        <el-form-item label="岗位名称:">
          <el-input v-model="showData.Job"></el-input>
        </el-form-item>
        <el-form-item label="岗位描述:">
          <el-input v-model="showData.describe"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="modify">确 定</el-button>
          </span>
    </el-dialog>
    <el-dialog
        title="详情"
        :visible.sync="dialogVisible2"
        width="30%">
      <el-form :model="submitTable"  ref="ruleForm" label-width="90px" class="demo-Staff" >
        <el-form-item label="岗位编号：" prop="JobId">
          <el-input v-model="submitTable.jobId"></el-input>
        </el-form-item>
        <el-form-item label="岗位名称：" prop="Job">
          <el-input v-model="submitTable.jobName"></el-input>
        </el-form-item>
        <el-form-item label="岗位描述：" prop="describe">
          <el-input v-model="submitTable.responsibilities"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible2 = false">取 消</el-button>
            <el-button type="primary" @click="addJob(submitTable)">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
import {get} from "@/network/request";
export default {
  name: "CompanyPos",
  data(){
    return {
      dialogVisible: false,
      dialogVisible2: false,
      empMessage: '',
      tableData: [],
      showData: [],
      submitTable: {},
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    async getData(){
      await axios.get('http://192.168.1.103:8081/Job/ShowJobInfoLimit',{
        params: {
          pageNum: this.pageNum
        }
      }).then(res => {
        console.log(res);
        this.tableData = res.data.data
      })
    },
    searchForPost(){

    },
    handleClick(row){
      this.dialogVisible=true
      console.log(row)
      this.showData = row
    },
    handleCurrentChange(val){
      this.pageNum = val
    },
    handleSizeChange(val){
      this.pageSize = val
    },
    addJob(submitTable){
      this.dialogVisible2 = false
      /*console.log(submitTable);*/
    },
    deleteJob(row){
      axios.delete('http://8.140.107.62:8081/DeleteJob/'+row.JobId).then(res => {
        console.log(res);
      })
    },
    modify(){

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
.company-table-header{
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