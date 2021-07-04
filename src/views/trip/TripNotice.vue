<template>
  <div id="trip-notice">
    <notification2>
    <div class="trip-notice-table" slot="notification-trip">
      <p>我的最新的出差信息</p>
      <hr>
      <template>
        <el-table
            :data="tableData"
            border
            style="width: 100%">
          <el-table-column prop="startTime" label="申请出差开始时间" align="center" >
          </el-table-column>
          <el-table-column prop="endTime" label="申请出差结束时间"  align="center">
          </el-table-column>
          <el-table-column prop="duration" label="出差天数"  align="center">
          </el-table-column>
          <el-table-column prop="category" label="出差科目"   align="center">
          </el-table-column>
          <el-table-column prop="state" label="状态"   align="center" :formatter="state">
          </el-table-column>
          <el-table-column label="查看详情" align="center">
            <template slot-scope="scope">
              <el-button type="warning" @click="handleClick(scope.row)">详情</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-sizes="[1, 2, 3, 4, 5]"
          :page-size="3"
          layout="sizes,prev, pager, next"
          :total="30">
      </el-pagination>
    </div>
    </notification2>
    <el-dialog
        title="详情"
        :visible.sync="dialogVisible"
        width="35%">
     <el-table
         :data="showData"
         stripe
         style="width: 100%">
       <el-table-column prop="cost" label="花费" align="center" >
       </el-table-column>
       <el-table-column prop="departure" label="出发地" align="center" >
       </el-table-column>
       <el-table-column prop="destination" label="目的地" align="center" >
       </el-table-column>
       <el-table-column prop="transport" label="交通工具" align="center" >
       </el-table-column>
     </el-table>
      <el-divider></el-divider>
      <el-table
          :data="otherconsumes"
          stripe
          style="width: 100%">
        <el-table-column prop="consumeTime" label="消费时间" align="center" >
        </el-table-column>
        <el-table-column prop="consumeType" label="消费类型" align="center" >
        </el-table-column>
        <el-table-column prop="cost" label="消费金额" align="center" >
        </el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
           <el-button @click="dialogVisible = false">取 消</el-button>
           <el-button type="primary" @click="modify">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import Notification2 from "@/components/content/Notification2";
import {get, getAll} from "@/network/request";
import axios from "axios";
export default {
  name: "TripNotice",
  components: {
    Notification2
  },
data(){
  return {
    dialogVisible: false,
    tableData: [],
    showData: {
    },
    pageNum:1,
    pageSize:3,
    otherconsumes:[]
  }
},
methods: {
  getData(){
    axios.get('http://localhost:8081/Trip/queryTripInfoById',{
      params: {
        id: localStorage.getItem("staffId"),
        pageNum:this.pageNum,
        pageSize:this.pageSize
      }
    }).then(res =>{
      console.log(res)
      this.tableData = res.data.data
    })
  },
  handleClick(row){
   /* console.log(row);*/
    this.dialogVisible = true
    this.otherconsumes=row.otherconsumes
    this.showData = row.schedules
  },
  modify(){
    this.dialogVisible = false
  },
  state(row){
    switch (row.state){
      case 0:
        return '未审批'
      case 1:
        return '已批准'
      case 2:
        return '未批准'
    }
  },
  handleCurrentChange(val){
    this.pageNum = val
    this.getData()
  },
  handleSizeChange(val){
    this.pageSize = val
    this.getData()
  }
},
  created() {
    this.getData()
  }
}
</script>

<style scoped>
p{
  text-align: center;
}
</style>