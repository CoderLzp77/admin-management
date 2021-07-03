<template>
  <div id="company-org">
    <div class="company-org-header">
      <p>
        <i class="el-icon-s-grid">中软国际&nbsp;&nbsp;</i>
        <el-button type="success" class="button" @click="add"><i class="el-icon-plus"></i></el-button>
        <el-button type="warning" class="button" @click="update"><i class="el-icon-edit-outline"></i></el-button>
        <el-button type="danger" class="button"><i class="el-icon-delete"></i></el-button>
      </p>
      <el-form :inline="true"  class="demo-form-inline">
        <el-form-item>
          <el-input v-model="hello" placeholder="hello world" style="width: 600px"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="onSubmit">搜索</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="company-org-table">
      组织机构信息列表
      <template>
        <el-table
            :data="tableData"
            border
            style="width: 100%">
          <el-table-column prop="organizationId" label="组织机构编码" align="center" >
          </el-table-column>
          <el-table-column prop="name" label="组织机构名称"   align="center">
          </el-table-column>
          <el-table-column prop="remark" label="组织机构备注"   align="center">
          </el-table-column>
          <el-table-column prop="higherOrgId" label="组织机构类型"   align="center">
          </el-table-column>
          <el-table-column label=""  align="center">
            <template slot-scope="scope">
              <el-button type="warning" @click="addOrganization"><i class="el-icon-plus"></i></el-button>
              <el-button type="warning" @click="updateOrganization"><i class="el-icon-edit-outline"></i></el-button>
              <el-button type="warning" @click="deleteOrganization(scope.row)"><i class="el-icon-delete"></i></el-button>
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
</template>

<script>
import axios from "axios";
import Qs from "qs"

export default {
  name: "CompanyOrg",
  data(){
    return {
      hello: '',
      tableData: [],
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    onSubmit(){

    },
    deleteOrganization(){

    },
    handleSizeChange(val){
      this.pageSize = val
    },
    handleCurrentChange(val){
      this.pageNum = val
    },
    add(){

    },
    update(){

    },
    addOrganization(){
      axios.post("http://localhost:8081/Organization/AddOrganization")
    }
  },
  created() {
    axios.get("http://localhost:8081/Organization/ShowOrganizationInfoLimit",{
      params:{
        pageNum:1,
        pageSize:3
      }
    }).then(res=>{
      console.log(res)
      this.tableData=res.data.data
    })
  }
}
</script>

<style scoped>
p{
  margin-top: -20px;
  height: 80px;
  line-height: 80px;
  background-color: rgb(217,234,247);
  font-size: 35px;
  color: rgb(49,112,143);
}
.button{
  margin-left: 0;
  height: 50px;
}
.demo-form-inline{
  position: absolute;
  right: 400px;
  top: 190px;
}
</style>