import { default as actions } from './actions';
import { getReportTeaching} from '../../../api/BudgetManagement/budgetManagement'

const getListTuitionReport = (fromDate,toDate,branch) =>{
    return dispatch=>{
        getReportTeaching(fromDate,toDate,branch)
        .then(res=>{
            dispatch(actions.getListTuitionReport(res.data));
        })
    }
}
export default {
    getListTuitionReport
}