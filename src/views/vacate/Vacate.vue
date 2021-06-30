<template>
  <div id="vacate">
    <p>请假申请信息填写</p><br>
    <hr>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="请假类别" prop="region">
        <el-select v-model="ruleForm.region" placeholder="请选择请假类别">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="开始时间" required width="100px">
          <el-form-item prop="date1">
            <el-date-picker type="date" placeholder="请选择日期开始时间" v-model="ruleForm.date1" style="width: 20%;"></el-date-picker>
          </el-form-item>
      </el-form-item>
      <el-form-item label="结束时间" required>
        <el-form-item prop="date1">
          <el-date-picker type="date" placeholder="请选择结束时间" v-model="ruleForm.date2" style="width: 20%;"></el-date-picker>
        </el-form-item>
      </el-form-item>

      <el-form-item label="请假原因" prop="desc">
        <el-input type="textarea" rows="8" v-model="ruleForm.desc" style="font-size: 18px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交申请</el-button>
        <el-button @click="resetForm('ruleForm')">取消申请</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Vacate",
  data(){
    return {
      ruleForm: {
        region: '',
        date1: '',
        date2: '',
        desc: ''
      },
      rules: {
        region: [
          { required: true, message: '请选择请假类别', trigger: 'change' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择开始时间', trigger: 'change' }
        ],
        date2: [
          { type: 'date', required: true, message: '请选择结束时间', trigger: 'change' }
        ],
        desc: [
          { required: true, message: '请填写请假原因', trigger: 'blur' }
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
  font-size: 25px;
}
</style>