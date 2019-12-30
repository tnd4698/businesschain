import { default as actions } from './actions';
import {
    getBranch,
    updateBranch
} from '../../../api/BranchManagement/branchMamagenent';

const viewBranch = id => {
    return dispatch => {
        getBranch(id)
            .then(res => {
                dispatch(actions.getBranch(res.data))
            })
    }
}

const handleUpdateBranch = branch => {
    return dispatch => {
        updateBranch(branch.id, branch)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

export default {
    viewBranch,
    handleUpdateBranch
}