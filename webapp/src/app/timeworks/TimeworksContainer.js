import { connect } from 'react-redux';
import TimeworksComponent from './TimeworksComponent';

import { timeworkOperations } from './duck';
import { branchOperations } from '../branches/duck'

const mapStateToProps = state => {
    return {
        curUser: state.home.userInfo,
        curRole: state.home.role,
        listBranch: state.branch.listBranch,
        listNewTimework: state.timework.listNewTimework,
        listTimeworkList : state.timework.listTimeworkList,
        listTimework: state.timework.listTimework
    }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())
    const getListNewTimework = (date, branch) => dispatch(timeworkOperations.getListNewTimework(date, branch));
    const saveTimeworks = timeworks => dispatch(timeworkOperations.saveTimeworks(timeworks))
    const getListTimeworkList = (fromDate, toDate, branch = 'null') => dispatch(timeworkOperations.getListTimeworkList(fromDate, toDate, branch))
    const search = (searchContent,fromDate,toDate,branch) => dispatch(timeworkOperations.search(searchContent,fromDate,toDate,branch));
    const getListTimework = (date,branchId)=>dispatch(timeworkOperations.getListTimework(date,branchId));
    const updateTimeworks = timeworks => dispatch(timeworkOperations.updateListTimeworks(timeworks))

    return {
        getListBranch,
        getListNewTimework,
        saveTimeworks,
        getListTimeworkList,
        search,
        getListTimework,
        updateTimeworks
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(TimeworksComponent);