<template>
  <div id="trip-child">
    <el-input v-model="springboard" placeholder="出发地" class="input-inline-block"></el-input> - <el-input v-model="destination" placeholder="目的地" class="input-inline-block"></el-input>
    <el-select v-model="value" placeholder="交通方式" class="input-inline-block">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    <el-input v-model="expenses" placeholder="费用(元)" class="input-inline-block"></el-input>
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
       value: '选项1',
       label: '出租车'
     }, {
       value: '选项2',
       label: '自驾'
     }, {
       value: '选项3',
       label: '高铁'
     }, {
       value: '选项4',
       label: '火车'
     }, {
       value: '选项5',
       label: '飞机'
     }],
         value: ''
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
</style>