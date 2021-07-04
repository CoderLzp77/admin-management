<template>
  <div id="reimbursement">
    <p>报销申请填写</p>
    <div>
      报销科目 ：  <el-select v-model="reimbursement.contentId">
      <el-option v-for="item in reimbursementSub" :key="item.subjectId" :value="item.subjectId" :label="item.subjectName"></el-option>
    </el-select>
    </div>
     <div class="reimbursement-main">
       <el-form  :model="reimbursement" class="demo-form-inline">
         <el-form-item label="报销内容：">
<!--           <el-input v-model="reimbursement.content" placeholder="报销内容"></el-input>-->
           <el-select v-model="reimbursement.subjectId">
             <el-option v-for="item in reimbursementcontent" :key="item.contentId" :value="item.contentId" :label="item.contentName"></el-option>
           </el-select>
         </el-form-item>
         <el-form-item label="报销金额：">
           <el-input v-model="reimbursement.totalAmount" placeholder="单位/元"></el-input>
         </el-form-item>
         <el-form-item label="消费时间：">
           <el-date-picker
               v-model="reimbursement.consumeTime"
               placeholder="选择时间">
           </el-date-picker>
         </el-form-item>
         <el-form-item label="备注：">
           <el-input v-model="reimbursement.remark" placeholder=""></el-input>
         </el-form-item>
       </el-form>
     </div>
       报销总额：<input type="text" v-model="reimbursement.cost" style="height: 30px" placeholder="单位/元"><br><br>
    <el-button type="primary" @click="onSubmit">提交申请</el-button>
    <el-button type="info" @click="cancel">取消申请</el-button>
  </div>
</template>

<script>
import axios from "axios";
import Qs from "qs";

export default {
  name: "Reimbursement",
  data(){
    return {
      options: [
        {
          label: '',
          value: ''
        }],
      value: '',
      reimbursementSub:'',
      reimbursementcontent:'',
      reimbursement: {
        applicant:localStorage.getItem("staffId"),
        contentId:'',
        subjectId:'',
        totalAmount:'',
        consumeTime:'',
        remark:'',
        cost:'',
        approvalId:'xz'
      },
    }
  },
  methods: {

    onSubmit(){
    axios.post("http://localhost:8081/Reimburse/AddReimburse",Qs.parse(this.reimbursement))
      .then(res=>{
        if (res.data.status === 200){
          this.$message.success("申请成功")
          this.$router.push('/reiNotice')
        }else {
          this.$message.error(res.data.message)
        }
      })
    },
    cancel(){

    },
    getRei(){
      axios.get("http://localhost:8081/Reimburse/queryAllSub").then(res=>{
        this.reimbursementSub=res.data.data
    })
    },
    getContent(){
      axios.get("http://localhost:8081/Reimburse/queryAllContent").then(res=>{
        this.reimbursementcontent=res.data.data
      })
    }
  },
  created() {
    this.getRei()
    this.getContent()
  }
}
</script>

<style scoped>
.reimbursement-main{
  margin-top: 10px;
  margin-bottom: 30px;
}
.rei-table{
  padding-top: 18px;
}
p{
  font-size: 20px;
}
</style>