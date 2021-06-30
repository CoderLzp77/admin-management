import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/components/common/Login'
import Index from '@/views/Index'
const Home = () => import('@/views/home/Home')
const EmpNotice = () => import('@/views/empinfo/EmpNotice')
const AddEmp = () => import('@/views/empinfo/AddEmp')
const EmpManage = () => import('@/views/empinfo/EmpManage')
const CompanyOrg =() =>import('@/views/companyorg/CompanyOrg')
const CompanyPos = () => import('@/views/companypos/CompanyPos')
const ViewPersonage = () => import('@/views/attendance/ViewPersonage')
const ViewSubordinate = () => import('@/views/attendance/ViewSubordinate')
const HolidayManage = () => import('@/views/attendance/HolidayManage')
const VacateNotice = () => import('@/views/vacate/VacateNotice')
const Vacate = () => import('@/views/vacate/Vacate')
const VacateManage = () => import('@/views/vacate/VacateManage')
const TripNotice = () => import('@/views/trip/TripNotice')
const Trip = () => import('@/views/trip/Trip')
const TripManage = () => import('@/views/trip/TripManage')
const ReiNotice = () => import('@/views/reimbursement/ReiNotice')
const Reimbursement = () => import('@/views/reimbursement/Reimbursement')
const ReiManage = () => import('@/views/reimbursement/ReiManage')

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/Login',
  },
  {
    path: '/Login',
    component: Login,
    meta: {
      title: '登录'
    }
  },
  {
    path: '/Index',
    component: Index,
    redirect: '/Home',
    meta: {
      title: '首页'
    },
    children: [
      {path:'/Home', component: Home,meta: {title: '首页'}},
      {path:'/EmpNotice', component: EmpNotice,meta: {title: '员工信息-最新通知'}},
      {path:'/AddEmp', component: AddEmp, meta: {title: '员工信息-添加'}},
      {path:'/EmpManage', component: EmpManage,meta: {title: '员工信息-管理'}},
      {path:'/CompanyOrg', component: CompanyOrg,meta: {title: '公司组织'}},
      {path:'/CompanyPos', component: CompanyPos, meta: {title: '公司岗位'}},
      {path:'/ViewPersonage', component: ViewPersonage, meta: {title: '考勤-个人考勤查看'}},
      {path:'/ViewSubordinate', component: ViewSubordinate, meta: {title: '考勤-查看直接下属情况'}},
      {path:'/HolidayManage', component: HolidayManage, meta: {title: '考勤-节假日修改'}},
      {path:'/VacateNotice', component: VacateNotice, meta: {title: '请假-最新通知'}},
      {path:'/Vacate', component: Vacate, meta: {title: '请假-申请请假'}},
      {path:'/VacateManage', component: VacateManage, meta: {title: '请假-请假管理'}},
      {path:'/TripNotice', component: TripNotice, meta: {title: '出差-最新通知'}},
      {path:'/Trip', component: Trip, meta: {title: '出差-申请出差'}},
      {path:'/TripManage', component: TripManage, meta: {title: '出差-出差管理'}},
      {path: '/ReiNotice', component: ReiNotice, meta: {title: '报销-最新通知'}},
      {path: '/Reimbursement', component: Reimbursement, meta: {title: '报销-申请报销'}},
      {path:'/ReiManage', component: ReiManage, meta: {title: '报销-报销管理'}
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

router.beforeEach((to, from, next) => {
  if(to.meta.title){
    window.document.title = to.meta.title
  }
  next()
})
