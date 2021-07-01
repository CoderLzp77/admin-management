<template>
  <div id="view-personage">
    <p style="color: #31708f"><i class="el-icon-user-solid"></i>个人考勤查看</p>
    <div class="view-personage-table">
      <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link">
          日考勤<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>月考勤</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <div class="block">
        <span class="demonstration">选择时间点： </span>
        <el-date-picker
            v-model="date1"
            type="date"
            placeholder="选择日期">
        </el-date-picker>
        <el-button type="primary"><i class="el-icon-search"></i>查看</el-button>
      </div>
      <el-table
          :data="tableData"
          border
          style="width: 100%"
          :row-class-name="tableRowClassName">
        <el-table-column
            prop="date"
            label="打卡时间">
        </el-table-column>
        <el-table-column
            prop="name"
            label="备注">
        </el-table-column>
      </el-table>
      <div class="block1">
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
    <hr>
    <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
      <i class="el-icon-search"></i>查看个人的请假、出差记录
    </el-button>
  </div>
</template>

<script>
import {get} from "@/network/request";

export default {
  name: "ViewPersonage",
  data(){
    return {
      date1: '',
      region: '',
      tableData: [],
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    async getData(){
     await get('/',{

     }).then(res => {
       this.tableData = res.data.data
     })
    },
    handleCommand(){
      console.log("sdf");
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
  },
  created() {
    //this.getData()
  }
}
</script>

<style scoped>
p{
  margin-top: 5px;
  padding-left: 10px;
  font-size: 20px;
  line-height: 65px;
  background-color: rgb(217,237,247);
}
.el-dropdown-link{
  padding: 12px;
  border: 1px solid gray;
  border-radius: 4px;
}
.block{
  float: right;
  margin-right: 500px;
}
.el-dropdown{
  margin-top: 10px;
  margin-left: 50px;
}
.el-table .warning-row {
  background: whitesmoke;
}
.el-table{
  margin-top: 40px;
}
.demonstration{
  font-size: 20px;
}
.block1{
  margin-top: 10px;
}
</style>