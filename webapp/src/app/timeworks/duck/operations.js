import { default as actions } from './actions';
import {
    getNewTimeworks,
    addTimeworks,
    getTimeworkLists,
    getTimeworks,
    updateTimeworks
} from '../../../api/EmployeeManagement/employeeManagement';

const getListNewTimework = (date, branch) => {
    return dispatch => {
        getNewTimeworks(date, branch)
            .then(res => {
                dispatch(actions.getListNewTimework(res.data));
            })
    }
}

const saveTimeworks = timeworks => {
    return dispatch => {
        addTimeworks(timeworks)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

const getListTimeworkList = (fromDate, toDate, branch = 'null') => {
    return dispatch => {
        getTimeworkLists(fromDate, toDate, branch)
            .then(res => {
                dispatch(actions.getTimeworkLists(res.data));
            })
    }
}

const search = (searchContent, fromDate, toDate, branch) => {
    return dispatch => {
        getTimeworkLists(fromDate, toDate, branch)
            .then(res => {
                dispatch(actions.search(res.data, searchContent));
            })
    }
}

const getListTimework = (date,branchId)=>{
    return dispatch=>{
        getTimeworks(date,branchId)
        .then(res=>{
            dispatch(actions.getTimeworks(res.data));
        })
    }
}

const updateListTimeworks = timeworks=>{
    return dispatch=>{
        updateTimeworks(timeworks)
        .then(res => {
            alert(res.data.returnMessage);
            if (res.data.returnCode === '1')
                window.location.reload();
        })
    }
}

export default {
    getListNewTimework,
    saveTimeworks,
    getListTimeworkList,
    search,
    getListTimework,
    updateListTimeworks
}