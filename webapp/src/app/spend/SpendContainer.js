import { connect } from 'react-redux';
import SpendComponent from './SpendComponent';
import { branchOperations } from '../branches/duck'
import {spendOperations} from './duck'
const mapStateToProps = (state) => {
  return {
    listBranch: state.branch.listBranch

  }
};

const mapDispatchToProps = dispatch => {

    const saveSpend = spend => dispatch(spendOperations.saveSpend(spend));
    const getListBranch = (status = '1') => dispatch(branchOperations.getListBranch(status));

    return {
      saveSpend,
      getListBranch
    }
  };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(SpendComponent);