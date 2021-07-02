<template>
  <div id="view-subordinate-trip">
    <notification2>
      <div class="vacate-table" slot="notification-trip">
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-form-item label="状态：">
            <el-select v-model="formInline.state" placeholder="--所有状态--">
              <el-option label="0" value="0"></el-option>
              <el-option label="1" value="1"></el-option>
              <el-option label="2" value="2"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="出差类别：">
            <el-select v-model="formInline.category" placeholder="--所有类别--">
              <el-option label="业务出差" value="1"></el-option>
              <el-option label="接待出差" value="2"></el-option>
              <el-option label="考察出差" value="2"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="出差天数：">
            <el-input v-model="formInline.tripDays" placeholder="不限"></el-input>
          </el-form-item>
        </el-form>
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-form-item label="申请时间：">
            <div class="block">
              <el-date-picker
                  v-model="formInline.value1"
                  type="date"
                  placeholder="不限">
              </el-date-picker>
            </div>
          </el-form-item>
          <el-form-item label="开始时间：">
            <div class="block">
              <el-date-picker
                  v-model="formInline.value2"
                  type="date"
                  placeholder="不限">
              </el-date-picker>
            </div>
          </el-form-item>
          <el-form-item label="结束时间：">
            <div class="block">
              <el-date-picker
                  v-model="formInline.value3"
                  type="date"
                  placeholder="不限">
              </el-date-picker>
            </div>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
          </el-form-item>
        </el-form>
        <div class="view-subordinate-vacate-table">
          <template>
            <el-table
                :data="tableData"
                border
                style="width: 100%">
              <el-table-column prop="staffName " label="申请人姓名" align="center" >
              </el-table-column>
              <el-table-column prop="dept" label="申请人部门"   align="center">
              </el-table-column>
              <el-table-column prop="startTime" label="申请出差开始时间"   align="center">
              </el-table-column>
              <el-table-column prop="endTime" label="申请出差结束时间"   align="center">
              </el-table-column>
              <el-table-column prop="duration" label="出差天数"   align="center">
              </el-table-column>
              <el-table-column prop="category" label="出差科目"   align="center">
              </el-table-column>
              <el-table-column label="批准"  align="center">
                <template slot-scope="scope">
                  <el-button type="primary" @click="agree(scope.row)">批准</el-button>
                </template>
              </el-table-column>
              <el-table-column label="拒绝"   align="center">
                <template slot-scope="scope">
                  <el-button @click="disAgree(scope.row)">拒绝</el-button>
                </template>
              </el-table-column>
              <el-table-column label="查看详情"  align="center">
                <template slot-scope="scope">
                  <el-button type="warning" @click="handleClick(scope.row)">详情</el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="block" style="margin-top: 20px">
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
          <el-dialog
              title="详情"
              :visible.sync="dialogVisible"
              width="50%">
            <label for="username" class="details">姓名</label>
            <el-input id="username" v-model="showData.askforleave.staffName" disabled></el-input>
            <label for="boss" class="details">上司</label>
            <el-input id="boss" v-model="showData.askforleave.directBoss" disabled></el-input>
            <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
          </el-dialog>
        </div>
      </div>
    </notification2>
  </div>
</template>

<script>
import Notification2 from "@/components/content/Notification2";
export default {
  name: "ViewSubordinateTrip",
  components: {
    Notification2
  },
  data(){
    return {
      formInline: {
        state: '',
        category: '',
        tripDays: '',
        value1: '',
        value2: '',
        value3: ''
      },
      tableData: [],
      showData: {
      },
      pageNum: 1,
      pageSize: 3,
      dialogVisible: false
    }
  },
  methods: {
    onSubmit(){
      console.log('submit');
    },
    disAgree(row){

    },
    agree(row){

    },
    handleClick(row){
      console.log(row)
      this.showDate=row
      this.dialogVisible=true
    },
    handleCurrentChange(val){
      this.pageNum = val
      this.getDate()
    },
    handleSizeChange(val){
      this.pageSize = val
      this.getDate()
    }
  }
}
</script>

<style scoped>

</style>