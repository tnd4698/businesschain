import { default as actions } from './actions';
import {
    getPayrolls,
    addPayrolls
} from '../../../api/BudgetManagement/budgetManagement'

const getListPayroll = (month,year,branch='null',role='null')=>{
    return dispatch => {
        getPayrolls(month,year,branch,role)
        .then(res=>{
            dispatch(actions.getListPayroll(res.data));
        })
    }
}

const editPayroll= payroll =>{
    return dispatch=>{
        dispatch(actions.editPayroll(payroll));
    }
}

const savePayroll = listPayroll=>{
    return dispatch=>{
        addPayrolls(listPayroll)
        .then(res=>{
            alert(res.data.returnMessage);
        })
    }
}

const search = (searchContent,month,year,branch,role)=>{
    return dispatch=>{
        getPayrolls(month,year,branch,role)
        .then(res=>{
            dispatch(actions.search(res.data,searchContent));
        })
    }
}

export default {
    getListPayroll,
    editPayroll,
    savePayroll,
    search
}