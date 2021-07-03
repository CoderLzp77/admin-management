<template>
  <div id="trip-child">
    <el-input v-model="schedule.departure" placeholder="出发地" class="input-inline-block" :disabled="disabled"></el-input>
    - <el-input v-model="schedule.destination" placeholder="目的地" class="input-inline-block" :disabled="disabled"></el-input>-
    <el-select v-model="schedule.transport" placeholder="交通方式" class="input-inline-block">
      <el-option :disabled="disabled"
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    <el-input v-model="schedule.cost" placeholder="费用(元)" class="input-inline-block" :disabled="disabled"></el-input>
    <el-button type="primary" :disabled="disabled" @click="commit">确定</el-button>
    <br>
  </div>
</template>

<script>
export default {
  name: "TripChild",
  data(){
    return {
      springboard: '',
      destination: '',
      expenses: '',
     options: [{
       value: '出租车',
       label: '出租车'
     }, {
       value: '自驾',
       label: '自驾'
     }, {
       value: '高铁',
       label: '高铁'
     }, {
       value: '火车',
       label: '火车'
     }, {
       value: '飞机',
       label: '飞机'
     }],
         value: '',
      disabled:false,
      schedule:{
        tripId:localStorage.getItem("staffId"),
        departure:'',
        destination:'',
        transport:'',
        cost:''
      }
    }
  },
  methods:{
    commit(){
      this.disabled=true
      this.$emit('schedules',this.schedule)
    }
  }
}
</script>

<style scoped>
.input-inline-block{
  width: 15%;
  display: inline-block;
  margin-left: 25px;
  margin-bottom: 20px;
}
.el-button{
  margin-left: 20px;
}
</style>