import { combineReducers } from 'redux'
import  billReducer  from './app/bill/duck'
import homeReducer from './app/home/duck'
import tuitionReducer from './app/tuition/duck'
import studentReducer from './app/students/duck'
import branchReducer from './app/branches/duck'
import employeeReducer from './app/employees/duck'
import timeworkReducer from './app/timeworks/duck'
import resourceReducer from './app/resources/duck'
import classReducer from './app/classes/duck'
import branchDetailReducer from './app/branchDetail/duck'
import importReducer from './app/import/duck'
import spendReducer from './app/spend/duck'
import payrollReducer from './app/payrolls/duck'
import billReportReducer from './app/billReport/duck'
import tuitionReportReducer from './app/tuitionReport/duck'
import payrollReportReducer from './app/payrollReport/duck'
import profitReportReducer from './app/profitReport/duck'

const rootReducer = combineReducers({
  home: homeReducer,
  bill: billReducer,
  tuition: tuitionReducer,
  student: studentReducer,
  branch: branchReducer,
  employee: employeeReducer,
  timework:timeworkReducer,
  resource: resourceReducer,
  class: classReducer,
  branchDetail: branchDetailReducer,
  import: importReducer,
  spend: spendReducer,
  payroll: payrollReducer,
  billReport: billReportReducer,
  tuitionReport: tuitionReportReducer,
  payrollReport: payrollReportReducer,
  profitReport: profitReportReducer
});

export default rootReducer;