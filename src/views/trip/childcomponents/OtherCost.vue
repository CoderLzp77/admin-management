<template>
  <div id="other-cost">
    <el-select v-model="value" placeholder="消费种类" class="cost-inline-block">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    <el-input v-model="money" placeholder="金额(元)" class="cost-inline-block"></el-input>
    <el-input v-model="costTime" placeholder="时间(元)" class="cost-inline-block"></el-input>
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
        value: ''
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
</style>