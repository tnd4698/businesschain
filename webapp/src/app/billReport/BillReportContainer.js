import { connect } from 'react-redux';
import BillReportComponent from './BillReportComponent';
import {branchOperations} from '../branches/duck';
import {billReportOperations} from './duck'

const mapStateToProps = (state) => {
  return {
    listBranch: state.branch.listBranch,
    listBillReport: state.billReport.listBillReport
  }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())   
    const getListBillReport = (fromDate,toDate,branch) => dispatch(billReportOperations.getListBillReport(fromDate,toDate,branch));
    return {
        getListBranch,
        getListBillReport
    }
  };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(BillReportComponent);