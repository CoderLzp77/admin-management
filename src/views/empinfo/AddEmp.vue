<template>
  <div id="add-emp">
    <div class="add-emp-header">
      <p><i class="el-icon-user-solid"></i>添加员工信息</p>
    </div>
    <el-form :model="Staff" :rules="rules" ref="ruleForm" label-width="400px" class="demo-Staff" >
      <el-form-item label="姓名：" prop="userName">
        <el-input v-model="Staff.userName"></el-input>
      </el-form-item>
      <el-form-item label="帐号：" prop="staffName">
        <el-input v-model="Staff.staffName"></el-input>
      </el-form-item>
      <el-form-item label="密码：" prop="password">
        <el-input v-model="Staff.password"></el-input>
      </el-form-item>
      <el-form-item label="出生日期：" required width="100px">
        <el-form-item prop="birthday">
          <el-date-picker type="date" placeholder="请选择日期" v-model="Staff.birthday" style="width: 20%;"></el-date-picker>
        </el-form-item>
      </el-form-item>
      <el-form-item label="所属部门：" prop="organizationId">
        <el-select v-model="Staff.organizationId" placeholder="请选择部门">
          <el-option label="技术部" value="1"></el-option>
          <el-option label="销售部" value="2"></el-option>
          <el-option label="传销部" value="3"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="岗位：" prop="jobId">
        <el-select v-model="Staff.jobId" placeholder="请选择岗位">
          <el-option label="总经理" value="1"></el-option>
          <el-option label="项目经理" value="2"></el-option>
          <el-option label="程序员" value="3"></el-option>
          <el-option label="销售经理" value="4"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="直接领导：" prop="directBoss">
        <el-input v-model="Staff.directBoss"></el-input>
      </el-form-item>
      <el-form-item label="电话：" prop="phoneNumber">
        <el-input v-model="Staff.phoneNumber"></el-input>
      </el-form-item>
      <el-form-item label="邮箱：" prop="email">
        <el-input v-model="Staff.email"></el-input>
      </el-form-item>
      <el-form-item label="工作地址：" prop="position">
        <el-input v-model="Staff.position"></el-input>
      </el-form-item>
      <el-form-item label="籍贯：" prop="birthplace">
        <el-input v-model="Staff.birthplace"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('Staff')">提交</el-button>
        <el-button @click="resetForm('Staff')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {post} from "@/network/request";
import Qs from 'qs'
import axios from "axios";
export default {
  name: "AddEmp",
  data(){

    return {
      Staff: {
        staffName:'',
        userName: '',
        password:'',
        birthday: '',
        state:0,
        jobId: '',
        organizationId: '',
        position: '',
        directBoss: '',
        phoneNumber: '',
        email: '',
        gender:'',
        birthplace: '',
        photoUrl:''
      },
      rules: {
        userName: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 2, max: 6, message: '长度在 2 到 6 个字符', trigger: 'blur' }
        ],
        birthday: [
          { required: true, message: '请选择生日', trigger: 'change' }
        ],
        organizationId: [
          { required: true, message: '请选择部门', trigger: 'change' }
        ],
        jobId: [
          { required: true, message: '请选择岗位', trigger: 'change' }
        ],
        phoneNumber: [
          { required: true, message: '请填写电话', trigger: 'blur' },
          {pattern: /^1[0-9]{10}$/ ,message: '请输入11位数字',trigger: 'blur'}
        ],
        email: [
          { required: true, message: '请填写邮箱', trigger: 'blur' },
          {pattern: /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,message: '邮箱格式错误',trigger: 'blur'}
        ],
        position: [
          { required: true, message: '请填写工作地址', trigger: 'blur' }
        ],
        birthplace: [
          { required: true, message: '请填写籍贯', trigger: 'blur' }
        ]
      }
      }
    },
  methods: {
    submitForm(formName) {
      this.$refs.ruleForm.validate((valid) => {
        console.log(this.Staff);
        if (valid) {
          axios.post('http://192.168.1.103:8081/Staff/AddStaff',Qs.parse(this.Staff)
          ).then(res =>{
            if (res.data.status===200){
              this.$message.success("添加成功")
            }else {
              this.$message.error(res.data.message)
            }
          })
        } else {
          this.$message.error('添加失败');
          return false;
        }
      })
    },
    resetForm(formName) {
      this.$refs.ruleForm.resetFields((valid)=>{
        if (valid){
          axios.post("http://192.168.1.103:8081/Staff/AddStaff",{
            data:{
              Staff:this.Staff
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.el-input{
  width: 380px;
}
p{
  height: 40px;
  font-size: 22px;
  line-height: 40px;
}
</style>