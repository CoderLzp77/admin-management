<template>
  <div id="rei-notice">
    <notification3>
    <div class="vacate-notice-table" slot="notification-reimbursement">
      <p>我的最新的报销信息</p>
      <hr>
      <template>
        <el-table
            :data="tableData"
            border
            style="width: 100%">
          <el-table-column prop="applyTime" label="申请报销时间"  align="center" >
          </el-table-column>
          <el-table-column prop="totalAmount" label="报销金额"  align="center">
          </el-table-column>
          <el-table-column prop="reimId" label="报销科目"  align="center">
          </el-table-column>
          <el-table-column prop="state" label="状态"  align="center">
          </el-table-column>
          <el-table-column label="查看详情"  align="center">
            <template slot-scope="scope">
              <el-button type="warning" @click="handleClick(scope.row)">详情</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block">
          <span class="demonstration">每页显示条数</span>
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :page-sizes="[1, 2, 3, 4, 5]"
              :page-size="3"
              layout="sizes,prev, pager, next"
              :total="30">
          </el-pagination>
        </div>
      </template>
    </div>
    </notification3>
    <el-dialog
        title="详情"
        :visible.sync="dialogVisible"
        width="50%">
      <el-table
          :data="showData.expenseitems"
          style="width: 100%">
        <el-table-column
            prop="consumeTime"
            label="消费时间">
        </el-table-column>
        <el-table-column
            prop="cost"
            label="单笔开销">
        </el-table-column>
        <el-table-column
            prop="remark"
            label="备注">
        </el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
    </el-dialog>
  </div>
</template>

<script>
import Notification3 from "@/components/content/Notification3";
import {get} from "@/network/request";

export default {
  name: "ReiNotice",
  components: {
    Notification3
  },
  data(){
    return {
      tableData: [],
      showData: {
        expenseitems: []
      },
      dialogVisible: false
    }
  },
  methods: {
    async getData(){
       get('/Reimburse/queryReimById',{
         params: {
           id: localStorage.getItem('staffId')
         }
       }).then(res =>{
         console.log(res);
         this.tableData = res.data.data
       })
    },
    handleClick(row){
      console.log(row);
      this.dialogVisible = true
      this.showData = row
      //this.getData()
    },
    handleSizeChange(){

    },
    handleCurrentChange(){

    }
  },
  created() {
    this.getData()
  }
}
</script>

<style scoped>
p{
  text-align: center;
  font-size: 25px;
}
</style>