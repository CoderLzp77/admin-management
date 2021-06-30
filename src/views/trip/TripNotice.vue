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
          <el-table-column prop="state" label="状态"   align="center">
          </el-table-column>
          <el-table-column label="查看详情" align="center">
            <template slot-scope="scope">
              <el-button type="warning" @click="handleClick(scope.row)">详情</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
    </notification2>
    <el-dialog
        title="详情"
        :visible.sync="dialogVisible"
        width="35%">
      <el-form ref="form" :model="showData" label-width="100px">
        <el-form-item label="申请时间:">
          <span>{{showData.applyTime}}</span>
        </el-form-item>
        <el-form-item label="申请原因:">
          <span>{{showData.reason}}</span>
        </el-form-item>
      </el-form>
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
    }
  }
},
methods: {
  getData(){
    get('/Trip/queryTripInfoById',{
      params: {
        id: localStorage.getItem("staffId")
      }
    }).then(res =>{
      this.tableData = res.data.data
    })
  },
  handleClick(row){
   /* console.log(row);*/
    this.dialogVisible = true
    this.showData = row
  },
  modify(){
    this.dialogVisible = false
  }
},
  created() {
    this.getData()
  }
}
</script>

<style scoped>

</style>