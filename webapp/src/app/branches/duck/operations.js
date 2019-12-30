import { default as actions } from './actions'
import { 
    getBranches,
    addBranch
} from '../../../api/BranchManagement/branchMamagenent'

const getListBranch = (status='1') => {
    return dispatch => {
        getBranches(status)
        .then(res=>{
            dispatch(actions.getListBranch(res.data));
        })
    }
}

const saveBranch = branch =>{
    return dispatch=>{
        addBranch(branch)
            .then(res=>{
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}
export default {
    getListBranch,
    saveBranch
}