<template>
  <div id="rei-manage">
     <notification3>
       <div class="rei-manage-table" slot="notification-reimbursement">
         <p>需要我审核的报销</p>
         <hr>
         <template>
           <el-table
               :data="tableData"
               border
               style="width: 100%">
             <el-table-column prop="username" label="申请人姓名" align="center" >
             </el-table-column>
             <el-table-column prop="vacateDept" label="申请人部门"   align="center">
             </el-table-column>
             <el-table-column prop="endDate" label="申请时间"   align="center">
             </el-table-column>
             <el-table-column prop="vacateDay" label="报销金额"   align="center">
             </el-table-column>
             <el-table-column prop="vacateSub" label="报销科目"   align="center">
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
     </notification3>
    <el-dialog
        title="详情"
        :visible.sync="dialogVisible"
        width="50%">
      <label for="username" class="details">出差人姓名</label>
      <el-input id="username" v-model="showDate.staff" disabled></el-input>
      <label for="boss" class="details">上司</label>
      <el-input id="boss" v-model="showDate.staff" disabled></el-input>
      <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
    </el-dialog>
  </div>
</template>

<script>
import Notification3 from "@/components/content/Notification3";
import axios from "axios";
export default {
  name: "ReiManage",
  components: {
    Notification3
  },
  data(){
    return {
      tableData: [],
      showDate: {

      },
      dialogVisible: false
    }
  },
  methods: {
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
}
</script>

<style scoped>

</style>