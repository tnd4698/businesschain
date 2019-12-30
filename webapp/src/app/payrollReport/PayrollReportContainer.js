import { connect } from 'react-redux';
import PayrollReportComponent from './PayrollReportComponent';
import {branchOperations} from '../branches/duck';
import {payrollReportOperations} from './duck'

const mapStateToProps = (state) => {
  return {
    listBranch: state.branch.listBranch,
    listPayrollReport: state.payrollReport.listPayrollReport
  }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())   
    const getListPayrollReport = (fromMonth, fromYear, toMonth, toYear,branch) => dispatch(payrollReportOperations.getListPayrollReport(fromMonth, fromYear, toMonth, toYear,branch));
    return {
        getListBranch,
        getListPayrollReport
    }
  };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PayrollReportComponent);