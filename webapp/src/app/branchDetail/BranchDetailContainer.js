import { connect } from 'react-redux';
import BranchDetailComponent from './BranchDetailComponent';

import { branchDetailOperations} from './duck';
import { employeeOperations } from '../employees/duck';


const mapStateToProps = (state) => {
    return {
        branch : state.branchDetail.branch,
        listEmployee: state.employee.listEmployee,
        curRole: state.home.role,
        curUser: state.home.userInfo
    }
};

const mapDispatchToProps = (dispatch) => {
    
    const getBranch = id => dispatch(branchDetailOperations.viewBranch(id));
    const getListEmployee = (branch='null',role='null',status=1)=>dispatch(employeeOperations.getListEmployee(branch,role,status));
    const updateBranch = branch => dispatch(branchDetailOperations.handleUpdateBranch(branch));
    return {
        getBranch,
        getListEmployee,
        updateBranch
    }
};

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(BranchDetailComponent);