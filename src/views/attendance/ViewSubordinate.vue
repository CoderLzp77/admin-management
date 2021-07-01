<template>
  <div id="view-subordinate">
   <div class="view-subordinate-header">
     <span style="color: #31708f"><i class="el-icon-user-solid"></i>下属列表</span>
     <el-form :inline="true"  class="demo-form-inline">
       <el-form-item>
         <el-input v-model="subordinateMessage" placeholder="" style="width: 500px"></el-input>
       </el-form-item>
       <el-form-item>
         <el-button type="primary" icon="el-icon-search" @click="searchForSub">搜索</el-button>
       </el-form-item>
     </el-form>
   </div>
    <div class="view-subordinate-main">
      <el-table :data="tableData" border style="width: 100%" :row-class-name="tableRowClassName">
        <el-table-column prop="staffId" label="员工ID"  align="center" >
        </el-table-column>
        <el-table-column prop="staffName" label="姓名"  align="center" >
        </el-table-column>
        <el-table-column prop="organization.name" label="部门"  align="center" >
        </el-table-column>
        <el-table-column prop="phoneNumber" label="电话"  align="center" >
        </el-table-column>
        <el-table-column prop="email" label="邮箱"  align="center" >
        </el-table-column>
        <el-table-column label="查看该员工考勤情况" align="center">
          <template slot-scope="scope">
            <el-button type="warning" icon="el-icon-user-solid" @click="viewPerson"></el-button>
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
export default {
  name: "ViewSubordinate",
  data(){
    return {
      subordinateMessage: '',
      tableData: [],
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    searchForSub(){

    },
    viewPerson(){

    },
    tableRowClassName({row, rowIndex}) {
      if (rowIndex%2 === 1) {
        return 'warning-row';
      }
    },
    handleSizeChange(val){
      this.pageSize = val
      this.getData()
    },
    handleCurrentChange(val){
      this.pageNum = val
      this.getData()
    }
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
.view-subordinate-header{
  background-color: rgb(217,237,247);
}
</style>