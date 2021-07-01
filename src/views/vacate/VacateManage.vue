<template>
 <div id="vacate-manage">
   <notification>
     <div class="vacate-manage-table" slot="notification-vacate">
       <p>需要我审批的请假</p>
       <hr>
       <template>
         <el-table
             :data="tableData"
             border
             style="width: 100%">
           <el-table-column prop="username" label="请假人姓名" align="center" >
           </el-table-column>
           <el-table-column prop="vacateDept" label="请假人部门"   align="center">
           </el-table-column>
           <el-table-column prop="endDate" label="申请请假结束时间"   align="center">
           </el-table-column>
           <el-table-column prop="vacateDay" label="请假天数"   align="center">
           </el-table-column>
           <el-table-column prop="vacateSub" label="请假科目"   align="center">
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
   </notification>
   <el-dialog
       title="详情"
       :visible.sync="dialogVisible"
       width="50%">
     <label for="username" class="details">出差人姓名</label>
     <el-input id="username" v-model="showDate.staff.userName" disabled></el-input>
     <label for="boss" class="details">上司</label>
     <el-input id="boss" v-model="showDate.staff.directBoss" disabled></el-input>
     <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
   </el-dialog>
 </div>
</template>

<script>
import Notification from "@/components/content/Notification";
export default {
  name: "VacateManage",
  components: {
    Notification
  },
  data(){
    return {
      tableData: [],
      showDate: {
        staff:{}
      },
      dialogVisible: false,
      pageNum: 1,
      pageSize: 3
    }
  },
  methods: {
    async getData(){

    },
    disAgree(row){

    },
    agree(row){

    },
    handleClick(row){
      console.log(row)
      this.showDate=row
      this.dialogVisible=true
    },
    handleCurrentChange(val){
      this.pageNum = val
      this.getDate()
    },
    handleSizeChange(val){
      this.pageSize = val
      this.getDate()
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
.details{
  font-size: 16px;
}
</style>