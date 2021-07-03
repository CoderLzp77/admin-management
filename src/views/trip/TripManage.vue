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
      tableData: []
    }
  },
  methods: {
    getData(){
      axios.get("http://localhost:8081/Trip/queryApprove").then(res=>{
        console.log(res)
        this.tableData=res.data.data
      })
    },
    agree(row){
    axios.put("http://localhost:8081/Trip/updateStaffById/1/"+row.tripId)
      .then(res=>{
        if (res.data.status === 200){
          this.$message.success("已审批")
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