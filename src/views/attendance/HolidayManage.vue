<template>
  <div id="holiday-manage">
    <div class="holiday-manage-header">
      <span>选择放假时间段：</span>
      <div class="block">
        <el-date-picker
            v-model="allTime"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
        </el-date-picker>
        <el-button type="success" style="margin-left: 10px" @click="addHolidays"><i class="el-icon-plus" ></i>添加假期</el-button>
      </div>
      <div class="block2">
        <el-date-picker
            v-model="holidayVo.date"
            type="year"
            placeholder="选择年">
        </el-date-picker>
        <el-button type="primary" @click="viewYearHoliday" style="margin-top: 10px;margin-left: 10px"> <i class="el-icon-search"></i>查看该年假期</el-button>
      </div>
    </div>
    <div class="holiday-manage-table">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="holidayStartTime" label="放假开始日期">
        </el-table-column>
        <el-table-column prop="holidayEndTime" label="放假结束日期">
        </el-table-column>
        <el-table-column label="" align="center">
          <template slot-scope="scope">
            <el-button type="danger" icon="el-icon-close" @click="deleteHoliday(scope.row)"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
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

<script>
import {getAll} from "../../network/request";
import axios from "axios";
import Qs from "qs";

export default {
  name: "HolidayManage",
  data(){
    return {
      value1: '',
      value2: '',
      tableData: [],
      allTime:'',
      holidayVo:{
        pageNum:1,
        pageSize:3,
        date:'',
      },
      holidays:{
        holidayStartTime:'',
        holidayEndTime:''
      }
    }
  },
  methods: {
    viewYearHoliday(){
     axios.post("http://localhost:8081/Holidays/queryHolidayTimeByYear",Qs.parse(this.holidayVo))
      .then(res=>{
        console.log(res)
        this.tableData=res.data.data
      })
    },
    addHolidays(){
    axios.post("http://localhost:8081/Holidays/addHolidayTimeByTime",Qs.parse(this.holidays))
      .then(res=>{
        if (res.data.status === 200){
          this.$message.success("添加成功")
          this.getData()
        }else{
          this.$message.error(res.data.message)
        }
      })
    },
    getData(){
      axios.get('http://localhost:8081/Holidays/queryHolidayTime',{
        params:{
          pageNum:this.holidayVo.pageNum,
          pageSize:this.holidayVo.pageSize
        }
      }).then( res =>{
        console.log(res)
        this.tableData = res.data.data
      })
    },
    deleteHoliday(row){
     axios.delete("http://localhost:8081/Holidays/delectHolidayTimeById/"+row.holidayId)
      .then(res=>{
        if (res.data.status === 200){
          this.$message.success("删除成功")
        }else{
          this.$message.error(res.data.message)
          this.getData()
        }
      })
    },
    handleSizeChange(val){
      this.holidayVo.pageSize = val
      this.getData()
    },
    handleCurrentChange(val){
      this.holidayVo.pageNum = val
      this.getData()
    },

  },
  created() {
    this.getData();
  },
  watch:{
    "allTime":{
      handler(old){
        this.holidays.holidayStartTime=this.allTime[0]
        this.holidays.holidayEndTime=this.allTime[1]
      /*  console.log(this.holidays.holidayStartTime)
        console.log(this.holidays.holidayEndTime)*/
      }
    }
  }
}
</script>

<style scoped>
.holiday-manage-table{
  margin-top: 20px;
}
</style>