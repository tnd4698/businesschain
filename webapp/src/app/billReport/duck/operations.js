import { default as actions } from './actions';
import { getReportSales} from '../../../api/BudgetManagement/budgetManagement'

const getListBillReport = (fromDate,toDate,branch) =>{
    return dispatch=>{
        getReportSales(fromDate,toDate,branch)
        .then(res=>{
            dispatch(actions.getListBillReport(res.data));
        })
    }
}
export default {
    getListBillReport
}