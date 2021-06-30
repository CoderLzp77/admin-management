<template>
  <div id="trip">
    <p>出差申请填写</p>
    <el-container>
      <el-aside width="50%" style="border-right: 1px solid  black">
        <div class="trip-left">
        <span>基础信息填写</span>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="开始时间" required>
            <el-form-item prop="date1">
              <el-date-picker type="date" placeholder="请选择日期开始时间" v-model="ruleForm.date1" style="width: 30%;"></el-date-picker>
            </el-form-item>
          </el-form-item>
          <el-form-item label="结束时间" required>
            <el-form-item prop="date1">
              <el-date-picker type="date" placeholder="请选择日期结束时间" v-model="ruleForm.date2" style="width: 30%;"></el-date-picker>
            </el-form-item>
          </el-form-item>
          <el-form-item label="出差天数" prop="vacateDay" required>
            <el-input v-model="ruleForm.vacateDay" style="width: 280px"></el-input>
          </el-form-item>
          <el-form-item label="预计费用" prop="cost" required>
            <el-input v-model="ruleForm.cost" style="width: 280px"></el-input>
          </el-form-item>
          <el-form-item label="出差原因叙述" prop="desc">
            <el-input type="textarea" rows="8" v-model="ruleForm.desc" style="font-size: 18px;width: 500px"></el-input>
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
        <trip-child></trip-child>
        <trip-child></trip-child>
        <trip-child></trip-child>
        <trip-child></trip-child>
        其他消费: <br>
        <other-cost></other-cost>
        <other-cost></other-cost>
      </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import TripChild from "@/views/trip/childcomponents/TripChild";
import OtherCost from "@/views/trip/childcomponents/OtherCost";
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
      ruleForm: {
        date1: '',
        date2: '',
        vacateDay: '',
        cost: '',
        desc: ''
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
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs.ruleForm.resetFields()
    }
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