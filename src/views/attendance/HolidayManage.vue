<template>
  <div id="holiday-manage">
    <div class="holiday-manage-header">
      <span>选择放假时间段：</span>
      <div class="block">
        <el-date-picker
            v-model="value1"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
        </el-date-picker>
        <el-button type="success" style="margin-left: 10px"><i class="el-icon-plus" ></i>添加假期</el-button>
      </div>
      <div class="block2">
        <el-date-picker
            v-model="value2"
            type="year"
            placeholder="选择年">
        </el-date-picker>
        <el-button type="primary" @click="viewYearHoliday" style="margin-top: 10px;margin-left: 10px"> <i class="el-icon-search"></i>查看该年假期</el-button>
      </div>
    </div>
    <div class="holiday-manage-table">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="staffId" label="放假开始日期">
        </el-table-column>
        <el-table-column prop="staffName" label="放假结束日期">
        </el-table-column>
        <el-table-column label="">
          <template slot-scope="scope">
            <el-button type="danger" icon="el-icon-user-solid" @click="deleteHoliday(scope.row)"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "HolidayManage",
  data(){
    return {
      value1: '',
      value2: '',
      tableData: []
    }
  },
  methods: {
    viewYearHoliday(){

    },
    deleteHoliday(row){

    }
  }
}
</script>

<style scoped>
.holiday-manage-table{
  margin-top: 20px;
}
</style>