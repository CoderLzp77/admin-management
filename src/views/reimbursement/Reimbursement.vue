<template>
  <div id="reimbursement">
    <p>报销申请填写</p>
    <div>
      报销科目 ： <el-select v-model="value" placeholder="请选择报销科目">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    </div>
     <div class="reimbursement-main">
       <el-form :inline="true" :model="form" class="demo-form-inline">
         <div v-for="(item,index) in form.formInline" :key="index" class="rei-table">
         <el-form-item label="报销内容：" :prop="'formInline.'+index+ '.content'">
           <el-input v-model="item.content" placeholder="报销内容"></el-input>
         </el-form-item>
         <el-form-item label="报销金额：">
           <el-input v-model="item.reiMon" placeholder="单位/元"></el-input>
         </el-form-item>
         <el-form-item label="消费时间：">
           <el-input v-model="item.reiTime" placeholder=""></el-input>
         </el-form-item>
         <el-form-item label="备注：">
           <el-input v-model="item.remark" placeholder=""></el-input>
         </el-form-item>
         </div>
         <el-button @click="addItem" type="info" style="margin-left: 80%;margin-bottom: 5px">添加报销</el-button>
       </el-form>
     </div>
       报销总额：<input type="text" v-model="total" style="height: 30px" placeholder="单位/元"><br><br>
    <el-button type="primary" @click="onSubmit">提交申请</el-button>
    <el-button type="info" @click="cancel">取消申请</el-button>
  </div>
</template>

<script>
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
      form: {
        formInline: [
          {
          content: '',
          reiMon: '',
          reiTime: '',
          remark: ''
          }
        ]
      },
      total: ''
    }
  },
  methods: {
    addItem(){
      this.form.formInline.push({
        content: '',
        reiMon: '',
        reiTime: '',
        remark: ''
      })
    },
    onSubmit(){

    },
    cancel(){

    }
  }
}
</script>

<style scoped>
.reimbursement-main{
  border: 1px dashed rgba(0,0,0,.5);
  margin-top: 10px;
  margin-bottom: 30px;
}
.rei-table{
  padding-top: 18px;
}
</style>