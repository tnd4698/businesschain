import { default as actions } from './actions'
import {
    getBranches,
    addBranch
} from '../../../api/BranchManagement/branchMamagenent'

const getListBranch = (status = '1') => {
    return dispatch => {
        getBranches(status)
            .then(res => {
                dispatch(actions.getListBranch(res.data));
            })
    }
}

const saveBranch = branch => {
    return dispatch => {
        addBranch(branch)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

const search = (searchContent, status) => {
    return dispatch => {
        getBranches(status)
            .then(res => {
                dispatch(actions.search(res.data, searchContent));
            })
    }
}
export default {
    getListBranch,
    saveBranch,
    search
}