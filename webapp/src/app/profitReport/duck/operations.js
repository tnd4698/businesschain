import { default as actions } from './actions';
import { getReportProfit} from '../../../api/BudgetManagement/budgetManagement'

const getListProfitReport = (fromMonth, fromYear, toMonth, toYear,branch) =>{
    return dispatch=>{
        getReportProfit(fromMonth, fromYear, toMonth, toYear,branch)
        .then(res=>{console.log(res)
            dispatch(actions.getListProfitReport(res.data));
        })
    }
}
export default {
    getListProfitReport
}