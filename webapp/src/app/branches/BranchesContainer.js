import { connect } from 'react-redux';
import BranchesComponent from './BranchesComponent';

import { branchOperations } from './duck';
import { employeeOperations } from '../employees/duck';

const mapStateToProps = (state) => {
    return {
        listBranch: state.branch.listBranch,
        listEmployee: state.employee.listEmployee
    }
};

const mapDispatchToProps = (dispatch) => {
    const getListBranch = (status = 1) =>
        dispatch(branchOperations.getListBranch(status));
    
    const getListEmployee = (branch='null',role='null',status=1)=>dispatch(employeeOperations.getListEmployee(branch,role,status));
    const search = (searchContent,status) => dispatch(branchOperations.search(searchContent,status));
    const saveBranch = branch => dispatch(branchOperations.saveBranch(branch));
    return {
        getListBranch,
        getListEmployee,
        saveBranch,
        search
    }
};

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(BranchesComponent);