<template>
  <div id="other-cost">
    <el-select v-model="otherconsumes.consumeType" placeholder="消费种类" class="cost-inline-block" :disabled="disabled">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    <el-input v-model="otherconsumes.cost" placeholder="金额(元)" class="cost-inline-block" :disabled="disabled"></el-input>-
    <el-date-picker type="date" placeholder="请选择日期" v-model="otherconsumes.consumeTime" style="width: 20%;" :disabled="disabled"></el-date-picker>
    <el-button type="primary" @click="commit" :disabled="disabled">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "OtherCost",
  data(){
    return {
      money: '',
      costTime: '',
    options: [{
      value: '1',
      label: '1'
    }, {
      value: '2',
      label: '2'
    }, {
      value: '3',
      label: '3'
    }, {
      value: '4',
      label: '4'
    }, {
      value: '5',
      label: '5'
    }],
        value: '',
      otherconsumes:{
        consumeTime:'',
        consumeType:'',
        cost:''
      },
      disabled:false
    }
  },
  methods:{
    commit(){
      this.disabled=true
      this.$emit('otherconsume',this.otherconsumes)
    }
  }
}
</script>

<style scoped>
.cost-inline-block{
  width: 15%;
  display: inline-block;
  margin-left: 25px;
  margin-bottom: 20px;
}
.el-button{
  margin-left: 20px;
}
</style>