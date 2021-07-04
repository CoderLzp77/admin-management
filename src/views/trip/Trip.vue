<template>
  <div id="trip">
    <p>出差申请填写</p>
    <el-container>
      <el-aside width="50%" style="border-right: 1px solid  black">
        <div class="trip-left">
        <span>基础信息填写</span>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="开始时间" required>
            <el-form-item prop="startTime">
              <el-date-picker type="date" placeholder="请选择日期开始时间" v-model="ruleForm.startTime" style="width: 30%;"></el-date-picker>
            </el-form-item>
          </el-form-item>
          <el-form-item label="结束时间" required>
            <el-form-item prop="endTime">
              <el-date-picker type="date" placeholder="请选择日期结束时间" v-model="ruleForm.endTime" style="width: 30%;"></el-date-picker>
            </el-form-item>
          </el-form-item>
          <el-form-item label="出差天数" prop="duration" required>
            <el-input v-model="ruleForm.duration" style="width: 280px"></el-input>
          </el-form-item>
          <el-form-item label="预计费用" prop="amount" required>
            <el-input v-model="ruleForm.amount" style="width: 280px"></el-input>
          </el-form-item>
          <el-form-item label="出差类别" prop="category" required>
            <el-input v-model="ruleForm.category" style="width: 280px"></el-input>
          </el-form-item>
          <el-form-item label="出差原因叙述" prop="reason">
            <el-input type="textarea" rows="8" v-model="ruleForm.reason" style="font-size: 18px;width: 500px"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交申请</el-button>
            <el-button @click="resetForm('ruleForm')">取消申请</el-button>
          </el-form-item>
        </el-form>
      </div>
      </el-aside>
      <el-main>
        <div class="trip-right">
        <span>详细信息填写</span><br>
        行程：<br>
        <trip-child @schedules="schedules"></trip-child>
        <trip-child @schedules="schedules"></trip-child>
        <trip-child @schedules="schedules"></trip-child>
        <trip-child @schedules="schedules"></trip-child>
        其他消费: <br>
        <other-cost @otherconsume="otherconsume"></other-cost>
        <other-cost @otherconsume="otherconsume"></other-cost>
      </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import TripChild from "@/views/trip/childcomponents/TripChild";
import OtherCost from "@/views/trip/childcomponents/OtherCost";
import axios from "axios";
import Qs from "qs";
export default {
  name: "Trip",
  components: {
    TripChild,
    OtherCost
  },
  data(){
    return {
      springboard: '',
      destination: '',
      expenses: '',
      money: '',
      costTime: '',
      schedule:{},
      ruleForm: {
        startTime: '',
        endTime: '',
        duration: '',
        amount: '',
        reason: '',
        category:'',
        state:0,
        staffId:localStorage.getItem("staffId"),
        approvalId:'xz',
        otherconsumes:[],
        schedules:[]
      },
      rules: {
        date1: [
          { type: 'date', required: true, message: '请选择开始时间', trigger: 'change' }
        ],
        date2: [
          { type: 'date', required: true, message: '请选择结束时间', trigger: 'change' }
        ],
        vacateDay: [
          { required: true, message: '请填写出差天数', trigger: 'blur'}
        ],
        cost: [
          { required: true, message: '请填写预计费用', trigger: 'blur'}
        ],
        desc: [
          { required: true, message: '请填写出差原因', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          console.log(this.ruleForm)
          axios.post("http://localhost:8081/Trip/AddTrip",Qs.parse(this.ruleForm))
          .then(res=>{
            if (res.data.status === 200){
              this.$router.push('/tripNotice')
              this.$message.success("申请成功")
            }else{
              this.$message.error(res.data.message)
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs.ruleForm.resetFields()
    },
    schedules(val){
      this.ruleForm.schedules.push(val)
      console.log(this.ruleForm.schedules)
    },
    otherconsume(val){
      this.ruleForm.otherconsumes.push(val)
      console.log(this.ruleForm.otherconsumes)
    }
  },
  watch:{

  }
}
</script>

<style scoped>
p{
  text-align: center;
  font-size: 22px;
  color: darkred;
}
</style>