<template>
  <div id="home">
     <div class="home-tar-bar">
        <table width="100%" class="table-style">
          <tr style="background-color: rgba(0,0,0,0.1);line-height: 60px">系统公告</tr>
          <tr style="line-height: 60px">近日即将进行员工考勤工作，请各位员工落实好自己的考勤，报销等工作</tr>
        </table>
       <el-collapse v-model="activeNames" @change="handleChange">
       <el-collapse-item title="最新放假通知" name="1">
         <el-table
             :data="tableData1"
             style="width: 100%"
             :row-class-name="tableRowClassName">
           <el-table-column
               prop="holidayStartTime"
               label="放假开始日期">
           </el-table-column>
           <el-table-column
               prop="holidayEndTime"
               label="放假结束日期">
           </el-table-column>
         </el-table>
       </el-collapse-item>
       <el-collapse-item title="今月考勤总况" name="2">
         <el-table :data="tableData2" style="width: 100%" :row-class-name="tableRowClassName">
           <el-table-column prop="1" label="每月迟到，早退总次数">
           </el-table-column>
           <el-table-column prop="2" label="月请假次数">
           </el-table-column>
           <el-table-column prop="3" label="月出差次数">
           </el-table-column>
           <el-table-column prop="4" label="月放假次数">
           </el-table-column>
           <el-table-column prop="5" label="月准时打卡上下班">
           </el-table-column>
         </el-table>
       </el-collapse-item>
       </el-collapse>
     </div>
<!--   轮播表开始 -->
    <div class="home-carousel">
      <template>
        <el-carousel indicator-position="outside">
          <el-carousel-item>
            <template>
              <p style="color: green">我的最新报销消息</p>
              <hr>
            <el-table
                :data="tableData3"
                style="width: 100%"
                border
                :row-class-name="tableRowClassName">
              <el-table-column
                  prop="applyTime"
                  label="申请报销时间"
              align="center">
              </el-table-column>
              <el-table-column
                  align="center"
                  prop="totalAmount"
                  label="报销金额">
              </el-table-column>
              <el-table-column
                  align="center"
                  prop="subjectId"
                  label="报销科目">
              </el-table-column>
              <el-table-column
                  align="center"
                  prop="state"
                  label="状态">
              </el-table-column>
              <el-table-column label="查看详情"  align="center">
                <template slot-scope="scope">
                  <el-button type="warning" @click="handleClick(scope.row)">详情</el-button>
                </template>
              </el-table-column>
              <el-table-column label="确认收到"  align="center">
                <template slot-scope="scope">
                  <el-button type="info" @click="confirm1">我知道了</el-button>
                </template>
              </el-table-column>
            </el-table>
            </template>
          </el-carousel-item>
          <el-carousel-item>
            <template>
              <p style="color: darkblue">我的最新请假消息</p>
              <hr>
            <el-table
                :data="tableData4"
                style="width: 100%"
                border
                :row-class-name="tableRowClassName">
              <el-table-column prop="startTime" label="申请请假开始时间"  align="center" >
              </el-table-column>
              <el-table-column prop="endTime" label="申请请假结束时间"   align="center">
              </el-table-column>
              <el-table-column prop="duration" label="请假天数"  align="center">
              </el-table-column>
              <el-table-column prop="category" label="请假科目"  align="center">
              </el-table-column>
              <el-table-column prop="state" label="状态"  align="center">
              </el-table-column>
              <el-table-column label="查看详情"  align="center">
                <template slot-scope="scope">
                  <el-button type="warning" @click="handleClick2(scope.row)">详情</el-button>
                </template>
              </el-table-column>
              <el-table-column label="确认收到"  align="center">
                <template slot-scope="scope">
                  <el-button type="info" @click="confirm2">我知道了</el-button>
                </template>
              </el-table-column>
            </el-table>
            </template>
          </el-carousel-item>
          <el-carousel-item>
            <template>
              <p style="color: darkred">我的最新出差消息</p>
              <hr>
            <el-table
                :data="tableData5"
                style="width: 100%"
                border
                :row-class-name="tableRowClassName">
              <el-table-column prop="startTime" label="申请出差开始时间" align="center" >
              </el-table-column>
              <el-table-column prop="endTime" label="申请出差结束时间"   align="center">
              </el-table-column>
              <el-table-column prop="duration" label="出差天数"   align="center">
              </el-table-column>
              <el-table-column prop="category" label="出差科目"  align="center">
              </el-table-column>
              <el-table-column prop="state" label="状态" align="center">
              </el-table-column>
              <el-table-column label="查看详情"  align="center">
                <template slot-scope="scope">
                  <el-button type="warning" @click="handleClick3(scope.row)">详情</el-button>
                </template>
              </el-table-column>
              <el-table-column label="确认收到"  align="center">
                <template slot-scope="scope">
                  <el-button type="info" @click="confirm3">我知道了</el-button>
                </template>
              </el-table-column>
            </el-table>
            </template>
          </el-carousel-item>
        </el-carousel>
      </template>
    </div>
<!-- 轮播结束   -->
  </div>
</template>

<script>
import {getAll,get} from "@/network/request";

export default {
  name: "Home",
  data(){
    return {
      img:'',
      notice: '',
      activeNames: [],
      tableData1: [],
      tableData2: [],
      tableData3: [],
      tableData4: [],
      tableData5: []
    }
  },
  methods: {
    handleChange(){

    },
    tableRowClassName({row,rowIndex}){
      if(rowIndex%2===1){
        return 'warning-row';
      }else {
        return '';
      }
    },
    handleClick(row){

    },
    confirm1(){

    },
    handleClick2(row){

    },
    confirm2(){

    },
    handleClick3(row){

    },
    confirm3(){

    },
    async getData(){
      await getAll('/Holidays/queryHolidayTime').then( res =>{
         /*console.log(res)*/
        this.tableData1 = res.data.data
      })
      await get('/Staff/queryAll',{
                params: {
                  userName: 'xz'
                }
              }
          ).then(res =>{
            /*console.log(res)*/
            this.tableData4 = res.data.data[0].askforleave
          })
      await get('/Trip/queryTripInfoById',{
        params: {
          id: localStorage.getItem("staffId")
        }
      }).then(res => {
            //console.log(res);
            this.tableData5 = res.data.data
          })
      await  getAll('/Reimburse/queryAllReim').then(res =>{
       /* console.log(res);*/
        this.tableData3 = res.data.data
      })
    }
  },
  created() {
    this.getData()
  }
}
</script>

<style scoped>
.el-collapse-item{
  width: 98%;
  border: 1px solid rgba(0,0,0,0.1);
  margin-top: 5px;
  padding-left: 20px;
  border-radius: 4px
}
.el-table .warning-row {
  background: oldlace;
}
.table-style{
  text-indent: 20px;
  font-size: 20px;
  border: 1px solid rgba(0,0,0,0.1);
  border-radius: 4px
}
.el-carousel{
  width: 80%;
  margin-top: 20px;
  margin-left: 160px;
}
p{
  text-align: center;
}
</style>