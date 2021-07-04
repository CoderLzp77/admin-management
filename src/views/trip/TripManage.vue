<template>
   <div id="trip-manage">
     <notification2>
       <div class="trip-manage-table" slot="notification-trip">
         <p>需要我审批的出差</p>
         <hr>
         <template>
           <el-table
               :data="tableData"
               border
               style="width: 100%">
             <el-table-column prop="staff.staffName" label="申请人姓名" align="center" >
             </el-table-column>
             <el-table-column prop="organization.name" label="申请人部门"   align="center">
             </el-table-column>
             <el-table-column prop="startTime" label="申请出差开始时间"   align="center">
             </el-table-column>
             <el-table-column prop="endTime" label="申请出差结束时间"   align="center">
             </el-table-column>
             <el-table-column prop="duration" label="出差天数"   align="center">
             </el-table-column>
             <el-table-column prop="category" label="出差科目"   align="center">
             </el-table-column>
             <el-table-column label="批准"  align="center">
               <template slot-scope="scope">
                 <el-button type="primary" @click="agree(scope.row)">批准</el-button>
               </template>
             </el-table-column>
             <el-table-column label="拒绝"   align="center">
               <template slot-scope="scope">
                 <el-button @click="disAgree(scope.row)">拒绝</el-button>
               </template>
             </el-table-column>
             <el-table-column label="查看详情"  align="center">
               <template slot-scope="scope">
                 <el-button type="warning" @click="handleClick(scope.row)">详情</el-button>
               </template>
             </el-table-column>
           </el-table>
         </template>
         <el-dialog
             title="详情"
             :visible.sync="dialogVisible"
             width="35%">
           >
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
           <span slot="footer" class="dialog-footer">
           <el-button @click="dialogVisible = false">取 消</el-button>
           <el-button type="primary" @click="modify">确 定</el-button>
      </span>
         </el-dialog>
       </div>
     </notification2>
   </div>
</template>

<script>
import Notification2 from "@/components/content/Notification2";
import axios from "axios";
export default {
  name: "TripManage",
  components: {
    Notification2
  },
  data(){
    return {
      tableData: [],
      dialogVisible:false,
      showData:[]
    }
  },
  methods: {
    getData(){
      axios.get("http://localhost:8081/Trip/queryApprove").then(res=>{
        console.log(res)
        this.tableData=res.data.data
      })
    },
    modify(){
      this.dialogVisible = false
    },
    agree(row){
    axios.put("http://localhost:8081/Trip/updateStaffById/1/"+row.tripId)
      .then(res=>{
        if (res.data.status === 200){
          this.$message.success("已批准")
        }else{
          this.$message.error(res.data.message)
        }
        this.getData()
      })
    },
    disAgree(row){
      console.log(row)
      axios.put("http://localhost:8081/Trip/updateStaffById/2/"+row.tripId)
          .then(res=>{
            if (res.data.status === 200){
              this.$message.success("已拒绝")
            }else{
              this.$message.error(res.data.message)
            }
            this.getData()
          })
    },
    handleClick(row){
     this.dialogVisible=true

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
  font-size: 25px;
}
</style>