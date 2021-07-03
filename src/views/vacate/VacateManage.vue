<template>
 <div id="vacate-manage">
   <notification>
     <div class="vacate-manage-table" slot="notification-vacate">
       <p>需要我审批的请假</p>
       <hr>
       <template>
         <el-table
             :data="alldata"
             border
             style="width: 100%">
           <el-table-column prop="name" label="请假人姓名" align="center" >
           </el-table-column>
           <el-table-column prop="organization" label="请假人部门"   align="center">
           </el-table-column>
           <el-table-column prop="endTime" label="申请请假结束时间"   align="center">
           </el-table-column>
           <el-table-column prop="duration" label="请假天数"   align="center">
           </el-table-column>
           <el-table-column prop="startTime" label="申请请假开始时间"   align="center">
           </el-table-column>
           <el-table-column prop="endTime" label="申请请假结束时间"   align="center">
           </el-table-column>
           <el-table-column prop="duration" label="请假天数"   align="center">
           </el-table-column>
           <el-table-column prop="category" label="请假科目"   align="center">
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
               @current-change="handleCurrentChange"
               :page-sizes="[1, 2, 3, 4, 5]"
               :page-size="3"
               layout="prev, pager, next"
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
import axios from "axios";
export default {
  name: "VacateManage",
  components: {
    Notification
  },
  data(){
    return {
      tableData: [],
      alldata: [],
      showDate: {
        staff:{}
      },
      askforleave: [],
      dialogVisible: false,
      pageNum: 1,
      pageSize: 1
    }
  },
  methods: {
 /*   async getData(){
      this.alldata=[];
        axios.get("http://192.168.1.103:8081/Staff/Approve",{
          params:{
            pageNum:this.pageNum,
            pageSize:3,
          }
        }).then(res=>{
          console.log(res)
          this.tableData=res.data.data
          for (let i = 0; i < this.tableData.length; i++) {
            this.askforleave=this.tableData[i].askforleave
            for (let k = 0; k <this.askforleave.length ; k++) {
              this.$set(this.askforleave[k],'name',this.tableData[i].userName)
              this.$set(this.askforleave[k],'organization',this.tableData[i].organization.name)
            }
            for (let j = 0; j < this.askforleave.length; j++) {
               this.alldata.push(this.askforleave[j])
            }
          }

          console.log(this.alldata)
        })
    },*/
    disAgree(row){
      axios.put("http://192.168.1.103:8081/Askforleave/updateStateById/3/"+row.leaveId).then(res=>{
        console.log(res)
        if (res.data.status === 200){
          this.$message.success("已拒绝")
          this.getData()
        }else{
          this.$message.error(res.data.message)
        }
      })
    },
    agree(row){
      console.log(row.leaveId)
    axios.put("http://192.168.1.103:8081/Askforleave/updateStateById/2/"+row.leaveId).then(res=>{
      console.log(res)
      if (res.data.status === 200){
        this.$message.success("已批准")
        this.getData()
      }else{
        this.$message.error(res.data.message)
      }
    })
    },
     getData(){
        axios.get('http://192.168.1.103:8081/Staff/Approve',{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
/*        console.log(res);*/
        this.alldata=[]
        this.tableData = res.data.data
        for (let i = 0; i < this.tableData.length; i++) {
          this.askforleave=this.tableData[i].askforleave
          /*console.log(this.askforleave)*/
          for (let k = 0; k <this.askforleave.length ; k++) {
           /* console.log(this.askforleave[k])*/
            this.$set(this.askforleave[k],'name',this.tableData[i].userName)
            this.$set(this.askforleave[k],'organization',this.tableData[i].organization.name)
          }
          for (let j = 0; j < this.askforleave.length; j++) {
            this.alldata.push(this.askforleave[j])
          }
        }

        console.log(this.alldata)
      })
    },
 /*   disAgree(row){

    },
    agree(row){

    },*/
    handleClick(row){
      this.dialogVisible=true
      console.log(row)
      this.showDate=row
      //this.getData()
    },
    handleCurrentChange(val){
      this.pageNum = val
      this.getData()
    },
 /*   handleSizeChange(val){
      this.pageSize = val
      this.getData()
    }*/
    },
  created() {
    this.getData()
  },

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