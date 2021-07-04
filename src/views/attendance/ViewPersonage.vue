<template>
  <div id="view-personage">
    <p style="color: #31708f"><i class="el-icon-user-solid"></i>个人考勤查看</p>
    <div class="view-personage-table">
        <el-select v-model="commod" placeholder="考勤列表">
          <el-option label="月考勤" value="1"></el-option>
          <el-option label="日考勤" value="2"></el-option>
        </el-select>
      <div class="block">
        <span class="demonstration">选择时间点： </span>
        <el-date-picker
            v-model="date1"
            type="month"
            placeholder="选择日期">
        </el-date-picker>
        <el-button type="primary" @click="getOwn"><i class="el-icon-search"></i>查看</el-button>
      </div>
      <el-table
          :data="tableData"
          border
          style="width: 100%"
          :row-class-name="tableRowClassName">
        <el-table-column
            prop="checkInTime"
            label="打卡时间">
        </el-table-column>
        <el-table-column
            prop="remark"
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
import axios from "axios";

export default {
  name: "ViewPersonage",
  data(){
    return {
      date1: '',
      region: '',
      commod:'',
      tableData: [],
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    async getData(){
     await axios.get("http://localhost:8081/Attendance/queryAttendanceDay",{
       params:{
         staffId:localStorage.getItem("staffId"),
         pageNum:this.pageNum,
         pageSize:this.pageSize
       }
     }).then(res => {
       console.log(res)
     })
    },
    handleCommand(){
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
    },
    getOwn(){
      axios.get("http://localhost:8081/Attendance/queryAttendanceMonthByTime",{
        params:{
          staffId:localStorage.getItem("staffId"),
          date:this.date1,
          pageNum:1,
          pageSize:5
        }
      }).then(res=>{
        console.log(res.data.data.attendanceVos)
        this.tableData=res.data.data.attendanceVos
      })
    }
  },
  created() {
    this.getOwn()
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