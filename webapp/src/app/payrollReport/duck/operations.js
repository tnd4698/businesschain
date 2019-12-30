import { default as actions } from './actions';
import { getReportSalary} from '../../../api/BudgetManagement/budgetManagement'

const getListPayrollReport = (fromMonth, fromYear, toMonth, toYear,branch) =>{
    return dispatch=>{
        getReportSalary(fromMonth, fromYear, toMonth, toYear,branch)
        .then(res=>{console.log(res)
            dispatch(actions.getListPayrollReport(res.data));
        })
    }
}
export default {
    getListPayrollReport
}